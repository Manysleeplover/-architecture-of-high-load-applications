package ru.romanov.lab1.lab1.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.romanov.lab1.lab1.models.Greeting;


@Controller
public class MainController {
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        if (greeting.getName().equals("") && greeting.getName().isBlank()) {
            greeting = new Greeting("%username%");
        }
        model.addAttribute("greeting", greeting);
        return "result";
    }

}
