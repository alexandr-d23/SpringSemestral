package ru.itis.diner.semestral.servlet.project;

import ru.itis.diner.semestral.dto.UserForm;
import ru.itis.diner.semestral.entities.User;

import java.sql.SQLException;
import java.util.Map;

public class ValidatorServiceImplAuth implements ValidatorService {

    @Override
    public Answer validate(UserForm userForm) throws SQLException {
        String email = userForm.getEmail();
        String password = userForm.getPassword();
        UserService<User> service = ServiceLocator.getUserService();
        User user = service.getUser(email);
        if(user !=null){
            if(user.getPassword().equals(password)){
                Answer<User> answer = new Answer<>(true);
                answer.setResource(user);
                return answer;
            }
            else{
                return new Answer(false,"Wrong password");
            }
        }
        else {
            return new Answer(false, "User with this email not found");
        }
    }
}
