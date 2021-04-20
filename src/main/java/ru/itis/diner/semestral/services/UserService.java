package ru.itis.diner.semestral.services;

import ru.itis.diner.semestral.model.User;

import java.util.List;

public interface UserService {
    List<User> getTopUsers();
}
