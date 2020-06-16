package com.isanbirdin.weatherservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String getMainPage() {

        return "main";
    }

    @PostMapping
    public String getSelectedServicePage(@RequestParam("service") String service) {
        if (service.equals("weatherstack")) {
            return "redirect:weatherstack";
        }
        else if (service.equals("weatherapi")) {
            return "redirect:weatherapi";
        }
        return "redirect:404";
    }
}
