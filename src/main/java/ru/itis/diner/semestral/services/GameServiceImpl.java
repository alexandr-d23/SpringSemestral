package ru.itis.diner.semestral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.diner.semestral.model.AchievementTypes;
import ru.itis.diner.semestral.model.User;
import ru.itis.diner.semestral.repositories.ActionRepository;
import ru.itis.diner.semestral.repositories.UserRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Logger logger;

    @Autowired
    private ActionRepository actionRepository;

    @Override
    public void click(Long userId, Long countClick) {
        User user = userRepository.findById(userId).get();
        try {
            userRepository.addScoreByUserId(userId, countClick * user.getClickPower());
            ActionManager.saveAction(user, AchievementTypes.CLICK, countClick, actionRepository);
        }
        catch (Exception e){
            logger.log(Level.INFO, GameServiceImpl.class.getName()+ "click() :", e );
        }
    }

    @Override
    public Long getUserScoreById(Long id) {
        try{
            return userRepository.getUserScoreById(id);
        }
        catch (Exception e){
            logger.log(Level.INFO, GameServiceImpl.class.getName()+ "getUserScoreById() :", e );
            return 0L;
        }
    }

    @Override
    public Long getClickPowerById(Long id) {
        try{
            return userRepository.findById(id).get().getClickPower();
        }
        catch (Exception e){
            logger.log(Level.INFO, GameServiceImpl.class.getName()+ "getClickPowerById() :", e );
            return 0L;
        }
    }


}
