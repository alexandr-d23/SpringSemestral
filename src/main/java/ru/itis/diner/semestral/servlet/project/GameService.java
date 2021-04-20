package ru.itis.diner.semestral.servlet.project;

import ru.itis.diner.semestral.entities.ShopBooster;
import ru.itis.diner.semestral.entities.User;

import java.sql.SQLException;

public interface GameService<T extends User>  {
    
    void click(int userId,int value) throws SQLException;
    <K extends ShopBooster>Answer buyBooster(int userId, int itemId) throws SQLException;

}
