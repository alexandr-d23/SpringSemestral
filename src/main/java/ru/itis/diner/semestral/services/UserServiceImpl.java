package ru.itis.diner.semestral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.diner.semestral.model.User;
import ru.itis.diner.semestral.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getTopUsers() {
        return repository.getTopUsers();
    }
}
