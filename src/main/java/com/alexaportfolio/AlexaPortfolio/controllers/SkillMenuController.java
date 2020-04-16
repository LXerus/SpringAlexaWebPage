package com.alexaportfolio.AlexaPortfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * View Controller for the /skillsmenu end point
 * @author crodf
 */

@Controller
public class SkillMenuController {

    /**
     * Returns the view  /skillsmenu and adds the skill attribute
     * @return
     */
    @RequestMapping(value = "/skillsmenu", method = RequestMethod.GET)
    public String skillMenuGet(){
        return "skillsmenu";
    }

}
