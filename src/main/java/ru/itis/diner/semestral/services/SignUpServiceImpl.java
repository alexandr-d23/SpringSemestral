package ru.itis.diner.semestral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.diner.semestral.dto.UserForm;
import ru.itis.diner.semestral.model.User;
import ru.itis.diner.semestral.model.User.*;
import ru.itis.diner.semestral.repositories.UserRepository;
import ru.itis.diner.semestral.util.Answer;
import ru.itis.diner.semestral.util.EmailUtil;
import ru.itis.diner.semestral.util.MailGenerator;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailGenerator mailGenerator;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private SmsService smsService;

    @Value("${server.url}")
    private String serverUrl;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public Answer signUp(UserForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .name(form.getName())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .confirmCode(UUID.randomUUID().toString())
                .role(Role.USER)
                .state(State.ACTIVE)
                .clickPower(1L)
                .score(1L)
                .build();
        Optional<User> optionalUser = userRepository.findByEmail(form.getEmail());
        if (optionalUser.isPresent()) return new Answer(false, "User already exists");
        userRepository.save(user);
        String confirmMail = mailGenerator.getMailForConfirm(serverUrl, user.getConfirmCode());
        emailUtil.send(user.getEmail(), "Подтверждение", from, confirmMail);
    //    smsService.sendSms(form.getPhone(), "Вы зарегистрированы в игре clicker");
        return Answer.builder()
                .isSuccessful(true)
                .build();
    }
}
