package ru.itis.diner.semestral.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.diner.semestral.dto.AchievementForm;
import ru.itis.diner.semestral.model.AchievementTypes;
import ru.itis.diner.semestral.model.Achievement;
import ru.itis.diner.semestral.repositories.AchievementRepository;

import java.util.List;

public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementRepository repository;

    @Override
    public void deleteAchievement(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void addAchievement(AchievementForm form) {
        repository.save(Achievement.builder()
                .id(form.getId())
                .description(form.getDescription())
                .type(AchievementTypes.valueOf(form.getType()))
                .requiredValue(form.getValue())
                .build());
    }

    @Override
    public List<Achievement> getAchievements() {
        return repository.findAll();
    }

}
