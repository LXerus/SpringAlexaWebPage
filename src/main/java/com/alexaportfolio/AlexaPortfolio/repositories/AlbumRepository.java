package com.alexaportfolio.AlexaPortfolio.repositories;

import com.alexaportfolio.AlexaPortfolio.models.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface to define the base operations for the Albums
 * @author crodf
 */

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {
    /**
     * The method will return a list of Albums based on their names
     * @param name
     * @return
     */
    public List<Album> findByName(String name);
}
