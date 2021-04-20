package ru.itis.diner.semestral.model;

public enum AchievementTypes {
    CLICK("CLICK"),
    BUY_ITEM("BUY_ITEM"),
    GET_ACHIEVEMENT("GET_ACHIEVEMENT"),
    SPEND_MONEY("SPEND_MONEY");

    private String name;

    AchievementTypes(String name){
        this.name = name;
    }

}
