package com.alexaportfolio.AlexaPortfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * View Controller for the /projectmenu end point
 * @author crodf
 */
@Controller
public class ProjectMenuController {

    @RequestMapping(value = "/projectmenu", method = RequestMethod.GET)
    public String showProjectMenu(){
        return "projectmenu";
    }
}
