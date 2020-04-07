package com.alexaportfolio.AlexaPortfolio.controllers;

import com.alexaportfolio.AlexaPortfolio.models.EmailForm;
import com.alexaportfolio.AlexaPortfolio.models.Skill;
import com.alexaportfolio.AlexaPortfolio.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    SkillService skillService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView();
        List<Skill> skillList = skillService.findAllSkills();
        modelAndView.addObject("skills", skillList);
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
