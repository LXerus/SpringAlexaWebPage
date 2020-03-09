package com.alexaportfolio.AlexaPortfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String showError(Model model){
        model.addAttribute("errorMesage", "Something went wrong");
        return "error";
    }
}
