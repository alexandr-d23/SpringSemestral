package ru.itis.diner.semestral.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.diner.semestral.validation.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserForm {
    @Email(message = "{errors.incorrect.email}")
    @NotEmpty(message = "{errors.incorrect.email}")
    private String email;
    @NotEmpty(message = "{errors.incorrect.name}")
    private String name;
    @ValidPassword(message = "{errors.incorrect.password}")
    private String password;
    private String phone;
}
