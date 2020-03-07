package com.alexaportfolio.AlexaPortfolio.repositories;

import com.alexaportfolio.AlexaPortfolio.models.AlbumPhoto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Holds a repository of Photos for the Albums in specific
 * @author crodf
 */

@Repository
public interface AlbumPhotoRepository extends CrudRepository<AlbumPhoto, Integer> {

    /**
     * This method will return a list of photos based on their name
     * @param name
     * @return
     */
    public List<AlbumPhoto> findByName(String name);
}
