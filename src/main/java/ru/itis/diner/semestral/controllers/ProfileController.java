package ru.itis.diner.semestral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.diner.semestral.annotations.Logable;
import ru.itis.diner.semestral.security.details.UserDetailsImpl;
import ru.itis.diner.semestral.services.ProfileService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Logable
    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl user, ModelMap map, HttpServletRequest request) {
        map.put("User", user.getUser());
        map.put("products", profileService.getProductsByUserId(user.getUser().getId()));
        request.getSession().setAttribute("score", user.getUser().getScore());
        return "profile";
    }

}
