package ru.itis.diner.semestral.servlet.project;

import ru.itis.diner.semestral.model.AchievementTypes;
import ru.itis.diner.semestral.entities.Action;
import ru.itis.diner.semestral.entities.ShopBooster;
import ru.itis.diner.semestral.entities.User;

import java.sql.SQLException;

public class GameServiceImpl<T extends User> implements GameService<T> {

    @Override
    public void click(int userId,int value) throws SQLException {
        UserService<User> service = ServiceLocator.getUserService();
        AchievementService achievementService = ServiceLocator.getAchievementService();
        achievementService.addAction(userId, new Action(AchievementTypes.CLICK,value));
        service.addScore(userId,value);
    }

    @Override
    public <K extends ShopBooster> Answer buyBooster(int userId, int itemId) throws SQLException {
        ShopService shopService = ServiceLocator.getShopService();
        AchievementService achievementService = ServiceLocator.getAchievementService();
        achievementService.addAction(userId, new Action(AchievementTypes.BUY_ITEM,1));
        achievementService.addAction(userId,new Action(AchievementTypes.SPEND_MONEY,  shopService.getItemById(itemId).getCost()));
        return shopService.buyBooster(userId,itemId);
    }


}
