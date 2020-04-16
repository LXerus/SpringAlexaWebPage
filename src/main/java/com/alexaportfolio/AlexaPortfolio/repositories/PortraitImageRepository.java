package com.alexaportfolio.AlexaPortfolio.repositories;

import com.alexaportfolio.AlexaPortfolio.models.PortraitImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Holds a repository of portrait images
 * @author crodf
 */

@Repository
public interface PortraitImageRepository extends CrudRepository <PortraitImage, Integer>{

    public PortraitImage findByPortraitImageId(int portraitImageId);
}
