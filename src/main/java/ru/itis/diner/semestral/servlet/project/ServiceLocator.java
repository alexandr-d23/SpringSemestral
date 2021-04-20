package ru.itis.diner.semestral.servlet.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.diner.semestral.entities.User;
import ru.itis.diner.semestral.entities.UserParametersService;
import ru.itis.diner.semestral.entities.ValidatedUserParameters;

@Component
public class ServiceLocator {

    @Autowired
    private static UserService userService;

    public static <T extends User> UserService<T> getUserService(){
        return userService;
    }

    public static<T extends User> GameService<T> getGameService(){
        return new GameServiceImpl<>();
    }

    public static<T extends User> ShopService getShopService(){
        return new ShopServiceImplDb();
    }

    public static ValidatorService getRegValidatorService(){
        return new ValidatorServiceImplReg();
    }

    public static ValidatorService getAuthValidatorService(){
        return new ValidatorServiceImplAuth();
    }
    
    public static UserParametersService getUserParametersService(){
        return new ValidatedUserParameters();
    }

    public static AchievementService getAchievementService(){
        return new AchievementServiceImplDb();
    }

}
