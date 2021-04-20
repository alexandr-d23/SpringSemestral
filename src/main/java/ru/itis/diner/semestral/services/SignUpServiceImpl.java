package ru.itis.diner.semestral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.diner.semestral.dto.UserForm;
import ru.itis.diner.semestral.model.User;
import ru.itis.diner.semestral.model.User.*;
import ru.itis.diner.semestral.repositories.UserRepository;

import java.math.BigInteger;

public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .name(form.getName())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .role(Role.USER)
                .state(State.ACTIVE)
                .gender(form.getGender())
                .country(form.getCountry())
                .clickPower(BigInteger.ONE)
                .score(BigInteger.ONE)
                .build();
        userRepository.save(user);
    }
}
