package ru.itis.diner.semestral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.diner.semestral.dto.UserForm;
import ru.itis.diner.semestral.services.SignUpService;
import ru.itis.diner.semestral.services.SmsService;
import ru.itis.diner.semestral.util.Answer;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private SmsService smsService;

    @GetMapping
    public String getSignUpPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "sign_up_page";
    }

    @PostMapping
    public String signUp(
            @Valid UserForm form,
            BindingResult bindingResult,
            Model model
    ) {
        if (!bindingResult.hasErrors()) {
            Answer answer = signUpService.signUp(form);
            if (answer.isSuccessful()) return "redirect:/signIn";
            model.addAttribute("userExists", answer.getDescription());
        } else {
            model.addAttribute("userForm", form);
        }
        return "sign_up_page";
    }
}
