package com.alexaportfolio.AlexaPortfolio.services;

import com.alexaportfolio.AlexaPortfolio.DAO.PortraitImageDAO;
import com.alexaportfolio.AlexaPortfolio.models.PortraitImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * PortraitImageService will execute all the Crud functions for the PortraitImage entity
 * @author crodf
 */

@Service
public class PortraitImageService {

    @Autowired
    PortraitImageDAO portraitImageDAO;

    /**
     * Saves the PortraitImage in the data base
     * @param portraitImage
     */
    public void saveNewPortraitImage(PortraitImage portraitImage){
        portraitImageDAO.savePortraitImage(portraitImage);
    }

    /**
     * Returns a PortraitImage with the same id
     * @param id
     * @return
     */
    public PortraitImage findPortraitImage(int id){
        return portraitImageDAO.getPortraitImage(id);
    }

    /**
     * Returns a list with all the portrait images in the data base
     * @return
     */
    public List<PortraitImage> getAllPortraitImages(){
        return portraitImageDAO.findAllPortraitImages();
    }

    /**
     * Saves the bytes from MultipartFile in the directory
     * @param portraitImageFile
     * @param portraitImage
     * @throws IOException
     */
    public void savePortraitImage(MultipartFile portraitImageFile, PortraitImage portraitImage) throws IOException {
        Path currentPath = Paths.get("."); // this gets us to src/main/resources without knowing the full path
        Path absolutePath = currentPath.toAbsolutePath();
        byte[] bytes = portraitImageFile.getBytes();
        String fileName = StringUtils.cleanPath(portraitImageFile.getOriginalFilename());
        portraitImage.setImagePath(absolutePath + "/src/main/resources/static/portraitImages/");
        portraitImage.setName(fileName);
        Path path = Paths.get(portraitImage.getImagePath() + fileName);
        Files.write(path, bytes);
        saveNewPortraitImage(portraitImage);
    }

    /**
     * Overwrites the existing image
     * @param portraitImageFile
     * @param portraitImage
     * @throws IOException
     */
    public void updatePortraitImage(MultipartFile portraitImageFile, PortraitImage portraitImage){

        try {
            //Removes the previous image from the directory
            Path currentPath = Paths.get(".");
            Path absolutePath = currentPath.toAbsolutePath();
            portraitImage.setImagePath(absolutePath + "/src/main/resources/static/portraitImages/");
            Path path = Paths.get(portraitImage.getImagePath() + portraitImage.getName());
            Files.delete(path);

            portraitImage.setName(StringUtils.cleanPath(portraitImageFile.getOriginalFilename()));
            portraitImageDAO.savePortraitImage(portraitImage);
            path = Paths.get(portraitImage.getImagePath() + portraitImage.getName());
            byte[] bytes = portraitImageFile.getBytes();
            Files.write(path, bytes);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    
}
