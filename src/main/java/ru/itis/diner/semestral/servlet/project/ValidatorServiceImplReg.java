package ru.itis.diner.semestral.servlet.project;

import ru.itis.diner.semestral.dto.UserForm;
import ru.itis.diner.semestral.entities.User;

import java.sql.SQLException;
import java.util.Map;

public class ValidatorServiceImplReg implements ValidatorService {
    private final StringBuilder description = new StringBuilder();
    @Override
    public Answer validate(UserForm userForm) throws SQLException {
        String email = userForm.getEmail();
        if(checkRegex(userForm)){
            //@TODO
            UserService<User> service = ServiceLocator.getUserService();
            if(service.getUser(email)!=null){
                return new Answer(false, "User with this email already exists");
            }
            return new Answer(true);
        }
        else {
            return new Answer(false, description.toString());
        }
    }

    public boolean checkRegex(UserForm userForm){
        String email = userForm.getEmail();
        String password = userForm.getPassword();
        String name = userForm.getName();
        boolean corrected = true;
        if(email == null || !email.matches("^[A-Za-z\\-_.0-9]{2,20}@[A-Za-z]{2,10}\\.[a-z]{2,5}$")){
            description.append("Invalid email input format. <br>");
            corrected = false;
        }
        if(name == null || name.length()< 4){
            description.append("The name must have at least 4 characters.<br>");
            corrected = false;
        }
        if(password == null || password.length()<8){
            description.append("Password must contain at least 8 characters.<br>");
            corrected = false;
        }
        return corrected;
    }
}
