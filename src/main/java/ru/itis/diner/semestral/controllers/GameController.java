package ru.itis.diner.semestral.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/game")
public class GameController {

    @GetMapping
    public String getGamePage(){
        System.out.println("GET GAME");
        return "game";
    }

    @PutMapping
    public void putScore(@RequestParam Long value, HttpServletRequest request){
       // request.getSession().setAttribute();
        System.out.println("PUT METHOD " + value);
    }
}
