package com.alexaportfolio.AlexaPortfolio.repositories;


import com.alexaportfolio.AlexaPortfolio.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Holads a repository of projects
 * @author crodf
 */

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
