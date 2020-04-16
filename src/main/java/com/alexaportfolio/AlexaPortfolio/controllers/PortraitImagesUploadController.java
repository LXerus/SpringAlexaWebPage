package com.alexaportfolio.AlexaPortfolio.controllers;

import com.alexaportfolio.AlexaPortfolio.models.PortraitImage;
import com.alexaportfolio.AlexaPortfolio.services.PortraitImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * View Controller for the /portrait_image_upload_form end point
 * @author crodf
 */

@Controller
public class PortraitImagesUploadController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PortraitImageService portraitImageService;

    @RequestMapping(value = "/portraitimageupload", method = RequestMethod.GET)
    public ModelAndView getPortraitImageForm(){
        ModelAndView  modelAndView = new ModelAndView();
        List<PortraitImage> portraitImageList = portraitImageService.getAllPortraitImages();
        modelAndView.addObject("portraitImage", new PortraitImage());
        modelAndView.addObject("portraitImageList", portraitImageList);
        modelAndView.addObject("listSize", portraitImageList.size());
        modelAndView.setViewName("portrait_image_upload_form");
        return modelAndView;
    }

    @GetMapping("/findPortraitImage")
    @ResponseBody
    public PortraitImage findPortraitImage(Integer id){
        PortraitImage existingPortraitImage = portraitImageService.findPortraitImage(id);
        return existingPortraitImage;
    }

    @RequestMapping(value = "/savePortraitImage", method = RequestMethod.POST)
    public String savePortraitImage(@RequestParam("portraitImageFile")MultipartFile multipartFile){
        try{
            portraitImageService.savePortraitImage(multipartFile, new PortraitImage());
        }catch (Exception ex){
            ex.printStackTrace();
            return "error";
        }
        return "redirect:/portraitimageupload";
    }

    @RequestMapping(value = "/updatePortraitImage", method = RequestMethod.POST)
    public String updatePortraitImage(@RequestParam("newPortraitImage")MultipartFile newPortraitImage, PortraitImage selectedPortraitImage){
        try{
            portraitImageService.updatePortraitImage(newPortraitImage, selectedPortraitImage);
        }catch (Exception ex){
            ex.printStackTrace();
            return "error";
        }
        return "redirect:/portraitimageupload";
    }
}
