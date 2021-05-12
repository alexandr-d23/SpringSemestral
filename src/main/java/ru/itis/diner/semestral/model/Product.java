package ru.itis.diner.semestral.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cost;
    @Enumerated(value = EnumType.STRING)
    private BoostTypes type;
    private Long value;
    private String description;

    @ManyToMany(mappedBy = "products")
    private List<User> users;
}
