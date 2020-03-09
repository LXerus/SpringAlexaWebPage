package com.alexaportfolio.AlexaPortfolio.controllers;


import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;
import com.alexaportfolio.AlexaPortfolio.services.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProjectUploadController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/newproject", method = RequestMethod.GET)
    public String projectUploadGet(Model model){
        model.addAttribute("project", new Project());
        return "newproject";
    }

    @PostMapping(value = "/upload")
    public  String addNewProject(@RequestParam("imageFile") MultipartFile imageFile, Project project){
        try{
            projectService.saveProject(project);
        }catch (Exception ex){
            String errorMesage = "unable to save project";
            log.error(errorMesage);
            ex.printStackTrace();
            return "error";
        }

        ProjectPhoto projectPhoto = new ProjectPhoto();
        projectPhoto.setName(imageFile.getOriginalFilename());
        projectPhoto.setPath("/images/");
        projectPhoto.setProject(project);

        try{
            projectService.saveProjectPhoto(projectPhoto, imageFile);
        }catch (Exception ex){
            String errorMesage = "unable to save the photo";
            ex.printStackTrace();
            log.error(errorMesage, ex);
            return "error";
        }

        return "newproject";
    }
}
