package com.alexaportfolio.AlexaPortfolio.controllers;


import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;
import com.alexaportfolio.AlexaPortfolio.models.Skill;
import com.alexaportfolio.AlexaPortfolio.services.ProjectService;
import com.alexaportfolio.AlexaPortfolio.services.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * View Controller for the /projectupload end point
 * @author crodf
 *
 */
@Controller
public class ProjectUploadController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProjectService projectService;

    @Autowired
    SkillService skillService;

    /**
     * Returns the view /projectupload and adds the project attribute to the form
     * @return
     */
    @RequestMapping(value = "/projectupload", method = RequestMethod.GET)
    public ModelAndView projectUploadGet(){
        ModelAndView modelAndView = new ModelAndView();
        List skillList = skillService.findAllSkills();
        modelAndView.addObject("project", new Project());
        modelAndView.addObject("newSkill",new Skill());
        modelAndView.addObject("skills", skillList);
        modelAndView.setViewName("projectupload");
        return modelAndView;
    }

    /**
     * Saves the skill information in the data base and refreshses the page
     * @param skillIcon
     * @param skill
     * @return
     */
    @RequestMapping(value = "/saveskillproject", method = RequestMethod.POST)
    public String saveNewSkill(@RequestParam("skillIcon") MultipartFile skillIcon, Skill skill){
        try {
            skillService.saveSkill(skill, skillIcon);
        } catch (Exception e) {
            String errorMesage = "unable to save skill";
            log.error(errorMesage);
            e.printStackTrace();
        }
        return "redirect:/project_and_skill";
    }



    /**
     * Saves the project information in the data base
     * @param imageFile
     * @param project
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
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
        projectPhoto.setProject(project);

        try{
            projectService.saveProjectPhoto(projectPhoto, imageFile);
        }catch (Exception ex){
            String errorMesage = "unable to save the photo";
            ex.printStackTrace();
            log.error(errorMesage, ex);
            return "error";
        }

        return "projectupload_success";
    }


}
