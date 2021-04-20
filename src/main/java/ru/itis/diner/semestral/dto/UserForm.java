package ru.itis.diner.semestral.dto;

import lombok.Data;

@Data
public class UserForm {
    private String email;
    private String name;
    private String password;
    private String gender;
    private String country;
}
