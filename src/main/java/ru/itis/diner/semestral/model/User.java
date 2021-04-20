package ru.itis.diner.semestral.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
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
    private String gender;
    private String country;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private BigInteger score;
    private BigInteger clickPower;  

    @OneToMany(mappedBy = "actor")
    private List<Action> actions;

    @ManyToMany(mappedBy = "users")
    private List<Product> products;

    @ManyToMany(mappedBy = "users")
    private List<Achievement> achievements;

    public enum Role{
        USER,
        ADMIN
    }

    public enum State{
        ACTIVE,
        BANNED
    }

    public boolean isActive(){
        return this.state == State.ACTIVE;
    }

    public boolean isBanned(){
        return this.state == State.BANNED;
    }

    public boolean isAdmin(){
        return this.role == Role.ADMIN;
    }
}
