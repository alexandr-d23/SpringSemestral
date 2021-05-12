package ru.itis.diner.semestral.services;

import ru.itis.diner.semestral.model.AchievementTypes;
import ru.itis.diner.semestral.model.Action;
import ru.itis.diner.semestral.model.User;
import ru.itis.diner.semestral.repositories.ActionRepository;

import java.util.Optional;

public class ActionManager {
    public static Action addAction(User user, Action action) {
        Optional<Action> optional = user.getActions()
                .stream()
                .filter(userAction -> userAction.getType() == action.getType())
                .findFirst();
        if (optional.isPresent()) {
            optional.get().setValue(optional.get().getValue() + action.getValue());
            return optional.get();
        } else {
            user.getActions().add(action);
            return action;
        }
    }

    public static void saveAction(
            User user,
            AchievementTypes type,
            Long value,
            ActionRepository actionRepository
    ) {
        Action action = ActionManager.addAction(user, Action.builder()
                .actor(user)
                .value(value)
                .type(type)
                .build());
        actionRepository.save(action);
    }


}
