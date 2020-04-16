package com.alexaportfolio.AlexaPortfolio.services;

import com.alexaportfolio.AlexaPortfolio.DAO.SkillDAO;
import com.alexaportfolio.AlexaPortfolio.models.Skill;
import com.alexaportfolio.AlexaPortfolio.repositories.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * SkillService will execute all the Crud functions for the Skill entity
 * @author crodf
 */
@Service
public class SkillService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SkillDAO skillDAO;

    /**
     * Saves a new skill in the skills table and places the image in the icons directory
     * @param skill
     * @param imageFile
     * @throws Exception
     */
    public void saveSkill(Skill skill, MultipartFile imageFile) throws Exception {
        skillDAO.saveSkill(skill, imageFile);
    }

    public List<Skill> findAllSkills(){
        return skillDAO.findAll();
    }

}
