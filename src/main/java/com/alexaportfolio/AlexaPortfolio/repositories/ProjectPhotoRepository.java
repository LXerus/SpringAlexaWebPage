package com.alexaportfolio.AlexaPortfolio.repositories;

import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    /**
     * This method will return a list of ProjectPhotos based on the foreing key for projectID
     * @param projectID
     * @return
     */
    Set<ProjectPhoto> findByProjectId(int projectID);
}
