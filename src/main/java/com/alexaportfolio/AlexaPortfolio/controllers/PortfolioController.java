package com.alexaportfolio.AlexaPortfolio.controllers;

import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;
import com.alexaportfolio.AlexaPortfolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

@Controller
public class PortfolioController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/loadProjects", method = RequestMethod.GET)
    public String showProjects(Model model){
        List<Project> projects = projectService.findAll();
        for (Project project : projects){
            Set<ProjectPhoto> projectPhotos = projectService.findProjectPhotos(project.getProjectId());
            project.setProjectPhotos(projectPhotos);
        }

        model.addAttribute("projects", projects);
        return "portfoliotest";
    }
}
