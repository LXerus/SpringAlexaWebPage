package com.alexaportfolio.AlexaPortfolio.controllers;

import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;
import com.alexaportfolio.AlexaPortfolio.services.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
public class PortfolioController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/loadProjects", method = RequestMethod.GET)
    public ModelAndView showProjects(){
        List<Project> projects = projectService.findAll();
        for(Project project : projects){
            for(ProjectPhoto photo : project.getProjectPhotos()){
                System.out.println(photo.getName());
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portfoliotest");
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }
}
