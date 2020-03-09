package com.alexaportfolio.AlexaPortfolio.repositories;

import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Holds a repository of Photos
 * @author crodf
 */

@Repository
public interface ProjectPhotoRepository extends CrudRepository<ProjectPhoto, Integer> {

    /**
     * This method will return a list of photos based on their name
     * @param name
     * @return
     */
    public List<ProjectPhoto> findByName(String name);
}
