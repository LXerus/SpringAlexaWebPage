package com.alexaportfolio.AlexaPortfolio.controllers;

import com.alexaportfolio.AlexaPortfolio.models.Skill;
import com.alexaportfolio.AlexaPortfolio.services.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * View Controller for the /skillupload end point
 * @author crodf
 */
@Controller
public class SkillUploadController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SkillService skillService;

    /**
     * Returns the view  /skillupload and adds the skill attribute
     * @return
     */
    @RequestMapping(value = "/skillupload", method = RequestMethod.GET)
    public ModelAndView skillUploadGet(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("skill", new Skill());
        modelAndView.setViewName("skillupload");
        return modelAndView;
    }

    @RequestMapping(value = "/skillupload_success", method = RequestMethod.GET)
    public ModelAndView skillUploadSucess(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skillupload_success");
        return  modelAndView;
    }

    /**
     * Retrieves the form information and post it to the data base
     * @param skillIcon
     * @param skill
     * @return
     */
    @RequestMapping(value = "/saveskill", method = RequestMethod.POST)
    public String addNewSkill(@RequestParam("skillIcon") MultipartFile skillIcon, Skill skill){
        try{
            skillService.saveSkill(skill, skillIcon);
            return "skillupload_success";
        } catch (Exception e) {
            String errorMesage = "unable to save skill";
            log.error(errorMesage);
            e.printStackTrace();
            return "error";
        }
    }

}
