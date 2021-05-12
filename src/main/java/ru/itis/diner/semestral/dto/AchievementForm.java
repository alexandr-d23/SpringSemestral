package ru.itis.diner.semestral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.diner.semestral.model.Achievement;
import ru.itis.diner.semestral.model.AchievementTypes;

@Data
public class AchievementForm {

    private Long id;
    private AchievementTypes type;
    private Long value;
    private String description;

}
