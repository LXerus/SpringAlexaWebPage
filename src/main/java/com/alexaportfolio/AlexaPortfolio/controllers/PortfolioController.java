package com.alexaportfolio.AlexaPortfolio.controllers;

import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class PortfolioController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/loadProjects", method = RequestMethod.GET)
    public String showProjects(Model model){
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);

        return "portfoliotest";
    }
}
