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
    private Long requiredValue;
    private Long currentValue;
    private AchievementTypes type;
    private String description;
    private Boolean got;

    public Boolean getGot() {
        if(currentValue==null || requiredValue == null)return false;
        return currentValue>=requiredValue;
    }
}
