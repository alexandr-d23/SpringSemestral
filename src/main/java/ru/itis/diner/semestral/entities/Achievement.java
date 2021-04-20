package ru.itis.diner.semestral.entities;

import ru.itis.diner.semestral.model.AchievementTypes;

public class Achievement {
    private int id;
    private AchievementTypes type;
    private int requiredValue;
    private int currentValue;
    private String description;
    private boolean got;
    public Achievement(int id,AchievementTypes type, int value, String description) {
        this.id = id;
        this.type = type;
        this.requiredValue = value;
        this.description = description;
    }


    public Achievement(int id,AchievementTypes type, int requiredValue, int currentValue, String description) {
        this.id = id;
        this.type = type;
        this.requiredValue = requiredValue;
        this.currentValue = currentValue;
        this.description = description;
    }

    public boolean isGot() {
        return got;
    }

    public void setGot(boolean got) {
        this.got = got;
    }

    public int getId() {
        return id;
    }

    public int getRequiredValue() {
        return requiredValue;
    }

    public String getDescription() {
        return description;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public AchievementTypes getType() {
        return type;
    }

    public void setType(AchievementTypes type) {
        this.type = type;
    }

    public void setRequiredValue(int requiredValue) {
        this.requiredValue = requiredValue;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
