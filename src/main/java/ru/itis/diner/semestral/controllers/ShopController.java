package ru.itis.diner.semestral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.diner.semestral.dto.ProductForm;
import ru.itis.diner.semestral.util.Answer;
import ru.itis.diner.semestral.security.details.UserDetailsImpl;
import ru.itis.diner.semestral.services.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping()
    public String shop(ModelMap map, @RequestParam("bought") Optional<String> bought) {
        map.put("items", shopService.getProducts());
        if(bought.isPresent())map.put("bought", bought.get());
        return "shop";
    }

    @PostMapping
    public String buyProduct(
            ProductForm form,
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            ModelMap modelMap,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Answer answer = shopService.buyProduct(userDetails.getUser().getId(), form);
        if (answer.isSuccessful()) {
            Long score = shopService.getUserScoreById(userDetails.getUser().getId());
            userDetails.getUser().setScore(score);
            request.getSession().setAttribute("score", score);
            return "redirect:/shop?bought="+"Predmet successful bought";
        }
        else {
            log.print("Предмет не куплен " + answer.getDescription());
            modelMap.put("description", answer.getDescription());
            modelMap.put("items", shopService.getProducts());
            return "/shop";
        }
    }

}
