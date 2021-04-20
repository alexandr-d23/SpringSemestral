package ru.itis.diner.semestral.servlet.project;

import ru.itis.diner.semestral.dto.UserForm;

import java.sql.SQLException;
import java.util.Map;

public interface ValidatorService{
    Answer validate(UserForm userForm) throws SQLException;
}
