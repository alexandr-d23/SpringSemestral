package ru.itis.diner.semestral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.diner.semestral.model.Achievement;
import ru.itis.diner.semestral.model.AchievementTypes;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Builder
public class AchievementDto {
    private Long id;
    private String type;
    private Long requiredValue;
    private String description;

    public static AchievementDto fromAchievement(Achievement achievement) {
        return AchievementDto.builder()
                .description(achievement.getDescription())
                .id(achievement.getId())
                .type(achievement.getType().name())
                .requiredValue(achievement.getRequiredValue())
                .build();
    }
}
