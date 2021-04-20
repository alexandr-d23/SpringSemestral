package ru.itis.diner.semestral.servlet.project;

import ru.itis.diner.semestral.entities.ShopBooster;
import ru.itis.diner.semestral.entities.User;

import java.sql.SQLException;
import java.util.Collection;

public interface UserService<T extends User>{
    void deleteUser(int userID) throws SQLException;
    void addUser(T user) throws SQLException;
    void addUsers(Collection<T> users) throws SQLException;
    T getUser(String email) throws SQLException;
    Collection<T> getUsers() throws SQLException;
    Collection<T> getTopUsers() throws SQLException;
    T getUser(int id)throws SQLException;

    void addScore(int id,int value) throws SQLException;
    <K extends ShopBooster>void addBooster(T user, K item) throws SQLException;
}
