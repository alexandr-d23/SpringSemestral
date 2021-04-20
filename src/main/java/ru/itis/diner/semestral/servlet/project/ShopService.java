package ru.itis.diner.semestral.servlet.project;

import ru.itis.diner.semestral.entities.ShopBooster;

import java.sql.SQLException;
import java.util.Collection;

public interface ShopService{
    <K extends ShopBooster> Answer buyBooster(int userId, int itemId) throws SQLException;
    <K extends ShopBooster>Collection<K> getItems() throws SQLException;
    <K extends ShopBooster>ShopBooster getItemById(int itemId) throws SQLException;
}
