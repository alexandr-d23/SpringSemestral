package ru.itis.diner.semestral.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StartPageController {

    @GetMapping
    public String getStartPage(){
        return "start";
    }
}
