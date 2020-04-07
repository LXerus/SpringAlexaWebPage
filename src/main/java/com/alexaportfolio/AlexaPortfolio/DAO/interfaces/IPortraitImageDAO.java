package com.alexaportfolio.AlexaPortfolio.DAO.interfaces;

import com.alexaportfolio.AlexaPortfolio.models.PortraitImage;

import java.util.List;
import java.util.Optional;

/**
 * IPortraitImageDAO dictates the behavior of the PortraitImage data access object
 * @author crodf
 */
public interface IPortraitImageDAO {

    public List<PortraitImage> findAllPortraitImages();

    public void savePortraitImage(PortraitImage portraitImage);

    public void updatePortraitImage(int portraitImageId, PortraitImage updatedImage);

    public void deletePortraitImage(int portraitImageId);
}
