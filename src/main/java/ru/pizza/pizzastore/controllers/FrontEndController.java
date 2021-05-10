package ru.pizza.pizzastore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FrontEndController {
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
