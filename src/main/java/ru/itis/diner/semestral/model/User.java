package ru.itis.diner.semestral.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String hashPassword;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private Long score;
    private Long clickPower;


    private String confirmCode;

    @OneToMany(mappedBy = "actor")
    private List<Action> actions;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_users",
            joinColumns = {@JoinColumn(
                    name = "account_id",
                    referencedColumnName = "id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id"
            )})
    private List<Product> products;

    @ManyToMany
    @JoinTable(name = "achievement_users",
            joinColumns = @JoinColumn(
                    name = "account_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "achievement_id",
                    referencedColumnName = "id"
            )
    )
    private List<Achievement> achievements;

    public enum EmailState{
        CONFIRMED, NOT_CONFIRMED
    }

    public enum Role {
        USER,
        ADMIN
    }

    public enum State {
        ACTIVE,
        BANNED
    }

    public Long getClickPower() {
        calculateClickPower();
        return clickPower;
    }

    @PreUpdate
    @PrePersist
    @PostLoad
    private void calculateClickPower(){
        if(clickPower==1 && products != null) {
            for (Product product : products) {
                if (product.getType().equals(BoostTypes.mult)) clickPower *= product.getValue();
            }
            for (Product product : products) {
                if (product.getType().equals(BoostTypes.add)) clickPower += product.getValue();
            }
        }
    }

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public boolean isBanned() {
        return this.state == State.BANNED;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }
}
