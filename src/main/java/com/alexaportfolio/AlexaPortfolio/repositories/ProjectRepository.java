package com.alexaportfolio.AlexaPortfolio.repositories;


import com.alexaportfolio.AlexaPortfolio.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Holads a repository of projects
 * @author crodf
 */

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
