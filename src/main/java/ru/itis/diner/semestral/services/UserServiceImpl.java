package ru.itis.diner.semestral.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.diner.semestral.model.User;
import ru.itis.diner.semestral.repositories.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getTopUsers() {
        return repository.getTopUsers();
    }
}
