package ru.itis.diner.semestral.entities;

import ru.itis.diner.semestral.model.BoostTypes;

import java.math.BigInteger;

public interface ShopBooster {
    int getId();
    int getCost();
    String getDescription();
    int getValue();
    int getProductId();
    BigInteger boost(BigInteger clickPower);
    BoostTypes getBoostType();
}
