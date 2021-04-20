package ru.itis.diner.semestral.services;

import ru.itis.diner.semestral.dto.AchievementForm;
import ru.itis.diner.semestral.model.Achievement;

import java.util.List;

public interface AchievementService {

    void deleteAchievement(Long id);

    void addAchievement(AchievementForm form);

    List<Achievement> getAchievements();

}
