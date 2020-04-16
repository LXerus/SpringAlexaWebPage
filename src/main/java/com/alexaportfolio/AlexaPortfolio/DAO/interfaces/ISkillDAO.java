package com.alexaportfolio.AlexaPortfolio.DAO.interfaces;

import com.alexaportfolio.AlexaPortfolio.models.Skill;
import org.springframework.web.multipart.MultipartFile;

/**
 * ISkillDAO dictates the behavior of the Skill data access object
 * @author crodf
 */

public interface ISkillDAO {

    /**
     * Saves the icon in the specified directory
     * @param file
     * @throws Exception
     */
    void saveSkill(Skill skill, MultipartFile file) throws Exception;



    /**
     * Saves the skill information in the data base
     * @param skill
     */
    void save(Skill skill);
}
