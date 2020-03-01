package com.alexaportfolio.AlexaPortfolio.repositories;

import com.alexaportfolio.AlexaPortfolio.models.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Holds a repository of Photos
 * @author crodf
 */

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer> {

    /**
     * This method will return a list of photos based on their name
     * @param name
     * @return
     */
    public List<Photo> findByName(String name);
}
