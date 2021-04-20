package ru.itis.diner.semestral.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.diner.semestral.model.BoostTypes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
public class User {
    private int id;
    private String email;
    private String name;
    private String password;
    private String gender;
    private String country;
    private boolean role;
    private BigInteger score;
    private BigInteger clickPower;
    private Collection<ShopBooster> collection;

    public User(String email, String name, String password, String gender, String country) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.country = country;
        this.score = BigInteger.valueOf(0);
        this.clickPower = BigInteger.ONE;
        collection = new ArrayList<>();
    }

    public User(int id, String email, String name, String password, String gender, String country, BigInteger score, BigInteger clickPower, Collection<ShopBooster> collection) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.country = country;
        this.score = score;
        this.clickPower = clickPower;
        this.collection = collection;
    }

    public Collection<ShopBooster> getBoosters() {
        return collection;
    }

    public void activateBoosters(){
        clickPower = BigInteger.ONE;
        for(ShopBooster b : collection){
            if(b.getBoostType().equals(BoostTypes.mult))clickPower = b.boost(clickPower);
        }
        for(ShopBooster b : collection){
            if(b.getBoostType().equals(BoostTypes.add))clickPower = b.boost(clickPower);
        }
    }

    public void addBooster(ShopBooster booster){
        collection.add(booster);
        activateBoosters();
    }
}
