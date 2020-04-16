package com.alexaportfolio.AlexaPortfolio.repositories;

import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

}
