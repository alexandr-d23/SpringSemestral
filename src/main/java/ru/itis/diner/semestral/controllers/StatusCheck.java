package ru.itis.diner.semestral.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatusCheck {

    @GetMapping("/status404")
    public String getStatusPage404(){
        return "status: 404";
    }

    @GetMapping("/status423")
    public String getStatusPage423(){
        return "status: 423";
    }

    @GetMapping("/status500")
    public String getStatusPage500(){
        return "status: 500";
    }

    @GetMapping("/status")
    public String getStatusPage(){
        return "status: 501";
    }


}
