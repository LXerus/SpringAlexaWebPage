package com.alexaportfolio.AlexaPortfolio.controllers;


import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class ProjectUploadController {

    @Autowired
    ProjectService projectService;

    @RequestMapping("/projectupload")
    public String projectUploadGet(Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return "projectupload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public  String addNewProject(@RequestParam("project") Project project, @RequestParam("photo")MultipartFile photoFile) throws Exception {
        projectService.create(project, photoFile);
        return "index";
    }
}
