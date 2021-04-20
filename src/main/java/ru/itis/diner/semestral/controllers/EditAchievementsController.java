package ru.itis.diner.semestral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.diner.semestral.dto.AchievementForm;
import ru.itis.diner.semestral.services.AchievementService;

import javax.annotation.security.PermitAll;

@Controller
@RequestMapping("/edit")
public class EditAchievementsController {

    @Autowired
    private AchievementService service;

    @GetMapping()
    public String getAchievementPage(ModelMap map){
        map.put("achievements", service.getAchievements());
        return "admin_achievements";
    }

    @PostMapping(params = "delete")
    public String deleteAchievement(AchievementForm form){
        service.deleteAchievement(form.getId());
        return "redirect:/edit";
    }

    @PostMapping(params = "change")
    public String changeAchievement(AchievementForm form){
        service.addAchievement(form);
        return "redirect:/edit";
    }

    @PostMapping(params = "add")
    public String addAchievement(AchievementForm form){
        service.addAchievement(form);
        return "redirect:/edit";
    }

}
