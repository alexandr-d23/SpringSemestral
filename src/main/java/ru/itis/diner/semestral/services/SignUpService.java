package ru.itis.diner.semestral.services;

import ru.itis.diner.semestral.dto.UserForm;
import ru.itis.diner.semestral.util.Answer;

public interface SignUpService {
    Answer signUp(UserForm form);
}
