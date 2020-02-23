package com.alexaportfolio.AlexaPortfolio.controllers;

import com.alexaportfolio.AlexaPortfolio.models.EmailForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.validation.Valid;

@Controller
public class IndexController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/emailsent").setViewName("emailsent");
    }

    @GetMapping("/home")
    public String showHome(EmailForm emailForm){
        return "index";
    }

    @PostMapping("/home")
    public String submitEmail(@Valid EmailForm emailForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "index";
        }
        return "emailsent";
    } 
}
