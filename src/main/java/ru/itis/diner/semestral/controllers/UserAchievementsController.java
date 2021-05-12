package ru.itis.diner.semestral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.diner.semestral.security.details.UserDetailsImpl;
import ru.itis.diner.semestral.services.AchievementService;

@Controller
@RequestMapping("/myAchievements")
public class UserAchievementsController {

    @Autowired
    private AchievementService service;

    @GetMapping
    public String getAchievementPage(@AuthenticationPrincipal UserDetailsImpl user, ModelMap map){
        map.put("achievements",service.getUserAchievements(user.getUser().getId()));
        return "user_achievements";
    }
}
