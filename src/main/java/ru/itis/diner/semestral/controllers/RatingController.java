package ru.itis.diner.semestral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.diner.semestral.services.UserService;

import javax.annotation.security.PermitAll;


@Controller
public class RatingController {

    @Autowired
    private UserService userService;


    @PermitAll
    @GetMapping("/rating")
    public String rating(ModelMap map) {
        map.put("topUsers", userService.getTopUsers());
        return "rating";
    }

}
