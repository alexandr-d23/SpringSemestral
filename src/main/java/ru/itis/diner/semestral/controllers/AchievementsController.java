package ru.itis.diner.semestral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.diner.semestral.services.AchievementService;

@Controller
@RequestMapping("/achievements")
public class AchievementsController {

    @Autowired
    private AchievementService service;

    @GetMapping
    public String getAchievementsPage(ModelMap map){
        map.put("achievements", service.getAchievements());
        return "achievements";
    }

}
