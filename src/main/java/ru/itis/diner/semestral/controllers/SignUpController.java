package ru.itis.diner.semestral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.diner.semestral.dto.UserForm;
import ru.itis.diner.semestral.services.SignUpService;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping
    public String getSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping
    public String signUp(UserForm form){
        signUpService.signUp(form);
        return "redirect:/signIn";
    }
}
