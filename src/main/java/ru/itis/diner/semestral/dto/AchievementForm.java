package ru.itis.diner.semestral.dto;

import lombok.Data;

@Data
public class AchievementForm {

    private Long id;
    private String type;
    private int value;
    private String description;
}
