package ru.itis.diner.semestral.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public enum BoostTypes {
    mult("mult"),
    add("add");

    private String title;
    BoostTypes(String title){
        this.title = title;
    }

}
