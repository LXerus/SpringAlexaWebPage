package com.alexaportfolio.AlexaPortfolio.controllers;

import com.alexaportfolio.AlexaPortfolio.models.EmailForm;
import com.alexaportfolio.AlexaPortfolio.services.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ContactController {
    private Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String showHome(EmailForm emailForm){
        return "contact";
    }

    @PostMapping("/contact")
    public String submitEmail(@Valid EmailForm emailForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "contact";
        }

        try{
            contactService.sendEmail(emailForm);
        }catch (MailException ex){
            logger.info(ex.getMessage());
        }
            return "emailsent";
    }
}
