package ru.itis.diner.semestral.controllers;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.diner.semestral.security.details.UserDetailsImpl;
import ru.itis.diner.semestral.services.GameService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public String getGamePage() {
        return "game";
    }

    @PutMapping
    public ResponseEntity<Long> putScore(
            @RequestParam Long value,
            HttpServletRequest request,
            @AuthenticationPrincipal UserDetailsImpl user
    ) {
        Long id = user.getUser().getId();
        gameService.click(id, value);
        Long score = gameService.getUserScoreById(id);
        Long clickPower = gameService.getClickPowerById(id);
        request.getSession().setAttribute("score", score);
        return ResponseEntity.ok(clickPower);
    }
}
