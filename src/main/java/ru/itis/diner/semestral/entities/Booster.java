package ru.itis.diner.semestral.entities;

import ru.itis.diner.semestral.model.BoostTypes;

import java.math.BigInteger;

public class Booster implements ShopBooster {
    private int cost;
    private int id;
    private BoostTypes type;
    private int value;
    private String description;
    private int productId;

    public Booster(int id,int cost, BoostTypes type, int value, String description, int productId) {
        this.id = id;
        this.cost = cost;
        this.type = type;
        this.value = value;
        this.description = description;
        this.productId = productId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public BigInteger boost(BigInteger clickPower) {
        if(type.equals(BoostTypes.mult))return clickPower.multiply(BigInteger.valueOf(value));
        if(type.equals(BoostTypes.add))return clickPower.add(BigInteger.valueOf(value));;
        return clickPower;
    }

    @Override
    public BoostTypes getBoostType() {
        return type;
    }
}
