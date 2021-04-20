package ru.itis.diner.semestral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.diner.semestral.model.AchievementTypes;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@Builder
public class UserAchievementDto {
    private Long id;
    private int requiredValue;
    private int currentValue;
    private String description;
    private boolean got;

    public boolean isGot() {
        return currentValue>=requiredValue;
    }
}
