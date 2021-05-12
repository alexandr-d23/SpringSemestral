package ru.itis.diner.semestral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.diner.semestral.dto.AchievementForm;
import ru.itis.diner.semestral.dto.UserAchievementDto;
import ru.itis.diner.semestral.model.AchievementTypes;
import ru.itis.diner.semestral.model.Achievement;
import ru.itis.diner.semestral.model.Action;
import ru.itis.diner.semestral.model.User;
import ru.itis.diner.semestral.repositories.AchievementRepository;
import ru.itis.diner.semestral.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteAchievement(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void addAchievement(AchievementForm form) {
        repository.save(Achievement.builder()
                .id(form.getId())
                .description(form.getDescription())
                .type(form.getType())
                //.type(AchievementTypes.valueOf(form.getType()))
                .requiredValue(form.getValue())
                .build());
    }

    @Override
    public List<Achievement> getAchievements() {
        return repository.findAll();
    }

    @Override
    public List<Achievement> getUserAchievements(Long userId) {
        return userRepository.findById(userId).get().getAchievements();
    }

    @Override
    public List<UserAchievementDto> getAchievementsWithProgress(Long userId) {
        User user = userRepository.findById(userId).get();
        List<Achievement> list = new ArrayList<>();
        List<UserAchievementDto> result = repository.findAll().stream().map(achievement ->
                { Long userValue = getActionCount(user, achievement.getType());
                    if(userValue>= achievement.getRequiredValue())list.add(achievement);
                    return UserAchievementDto.builder()
                            .description(achievement.getDescription())
                            .id(achievement.getId())
                            .currentValue(userValue)
                            .requiredValue(achievement.getRequiredValue())
                            .type(achievement.getType())
                            .build(); }
        ).collect(Collectors.toList());
        user.setAchievements(list);
        userRepository.save(user);
        return result;
    }

    private Long getActionCount(User user, AchievementTypes type){
        Optional<Action> userAction = user.getActions()
                .stream()
                .filter(action -> action.getType().equals(type)).findFirst();
        if(userAction.isPresent())return userAction.get().getValue();
        return 0L;
    }

}
