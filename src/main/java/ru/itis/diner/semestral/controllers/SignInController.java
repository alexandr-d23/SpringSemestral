package ru.itis.diner.semestral.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.diner.semestral.annotations.Logable;

@Controller
public class SignInController {

    @Logable
    @GetMapping("/signIn")
    public String getSignInPage(){
        return "sign_in_page";
    }
}
