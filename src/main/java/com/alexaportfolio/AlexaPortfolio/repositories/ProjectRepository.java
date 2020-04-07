package com.alexaportfolio.AlexaPortfolio.repositories;


import java.util.List;

import org.hibernate.mapping.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;

/**
 * Holds a repository of projects
 * @author crodf
 */

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
