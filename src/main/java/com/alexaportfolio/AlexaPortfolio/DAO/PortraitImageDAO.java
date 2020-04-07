package com.alexaportfolio.AlexaPortfolio.DAO;

import com.alexaportfolio.AlexaPortfolio.DAO.interfaces.IPortraitImageDAO;
import com.alexaportfolio.AlexaPortfolio.models.PortraitImage;
import com.alexaportfolio.AlexaPortfolio.repositories.PortraitImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * PortraitImageDAO implement the CRUD methods from the PortraitImageRepository
 * @author crodf
 */

@Component
public class PortraitImageDAO implements IPortraitImageDAO {

    @Autowired
    PortraitImageRepository portraitImageRepository;

    /**
     * Returns a list with all the images available
     * @return
     */
    @Override
    public List<PortraitImage> findAllPortraitImages() {
        return (List<PortraitImage>) portraitImageRepository.findAll();
    }

    /**
     * Saves a new PortraitImage in the data base
     * @param portraitImage
     */
    @Override
    public void savePortraitImage(PortraitImage portraitImage) {
        portraitImageRepository.save(portraitImage);
    }

    /**
     * Modifies a PortraitImage entity
     * @param portraitImageId
     * @param updatedImage
     */
    @Override
    public void updatePortraitImage(int portraitImageId, PortraitImage updatedImage) {
        PortraitImage existingImage = portraitImageRepository.findByPortraitImageId(portraitImageId);
        existingImage.setName(updatedImage.getName());
        portraitImageRepository.save(existingImage);
    }

    /**
     * Returns a specific PortraitImage
     * @param id
     * @return
     */
    public PortraitImage getPortraitImage(int id){
       return portraitImageRepository.findById(id).get();
    }

    /**
     * Removes a PortraitImage from the data base
     * @param portraitImageId
     */
    @Override
    public void deletePortraitImage(int portraitImageId) {
        portraitImageRepository.deleteById(portraitImageId);
    }
}
