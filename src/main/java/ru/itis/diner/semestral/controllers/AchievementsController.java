package ru.itis.diner.semestral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.diner.semestral.dto.AchievementDto;
import ru.itis.diner.semestral.dto.AchievementForm;
import ru.itis.diner.semestral.security.details.UserDetailsImpl;
import ru.itis.diner.semestral.services.AchievementService;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/achievements")
public class AchievementsController {

    @Autowired
    private AchievementService service;

    @GetMapping
    public String getAchievementsPage(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            ModelMap map
    ) {
        map.put("achievements", service.getAchievementsWithProgress(userDetails.getUser().getId()));
        return "achievements";
    }

}
