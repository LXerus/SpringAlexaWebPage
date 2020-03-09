package com.alexaportfolio.AlexaPortfolio.repositories;


import com.alexaportfolio.AlexaPortfolio.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Holads a repository of projects
 * @author crodf
 */

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
