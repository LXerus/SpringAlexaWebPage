package com.alexaportfolio.AlexaPortfolio.DAO;

import com.alexaportfolio.AlexaPortfolio.DAO.interfaces.ISkillDAO;
import com.alexaportfolio.AlexaPortfolio.models.Skill;
import com.alexaportfolio.AlexaPortfolio.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * SkillDAO implement the CRUD methods from the SkillRepository
 * @author crodf
 */
@Component
public class SkillDAO implements ISkillDAO {

    @Autowired
    private SkillRepository skillRepository;

    /**
     * saveSkill saves the image in the directory
     * @param skill
     * @param imageFile
     * @throws Exception
     */
    @Override
    public void saveSkill(Skill skill, MultipartFile imageFile) throws Exception {
        Path currentPath = Paths.get("."); // this gets us to src/main/resources without knowing the full path
        Path absolutePath = currentPath.toAbsolutePath();
        byte[] bytes = imageFile.getBytes();
        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        skill.setIconPath(absolutePath + "/src/main/resources/static/icons/");
        skill.setIconName(fileName);
        Path path = Paths.get(skill.getIconPath() + fileName);
        Files.write(path, bytes);
        save(skill);
    }

    /**
     * Saves the Skill in the skills table
     * @param skill
     */
    @Override
    public void save(Skill skill) {
        skillRepository.save(skill);
    }

    /**
     * Returns all of the skills available in the data base
     * @return
     */
    public List<Skill> findAll(){
        return (List<Skill>) skillRepository.findAll();
    }
}
