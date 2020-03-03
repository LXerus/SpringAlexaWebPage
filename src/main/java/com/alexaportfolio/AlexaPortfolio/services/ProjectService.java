package com.alexaportfolio.AlexaPortfolio.services;

import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

/**
 * Handles the upload services for the projects
 * @author crodf
 */

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    /**
     * Creates a new project in the data base
     * @param project
     * @return
     */
    public Project create(Project project) throws IOException {
        return projectRepository.save(project);
    }

    /**
     * Updates an existing project in the data base
     * @param project
     * @return
     */
    public Project update(Project project){
        Project existingProject = projectRepository.findById(project.getProjectId()).orElse(null);
        existingProject.setTitle(project.getTitle());
        existingProject.setDescription(project.getDescription());
        return projectRepository.save(existingProject);
    }

    /**
     * Deletes an existing project from the data base
     * @param project
     */
    public void delete(Project project){
        projectRepository.delete(project);
    }

    /**
     * Returns all of the existing projects in the data base
     * @return
     */
    public List<Project> findAll(){
        return(List<Project>) projectRepository.findAll();
    }
}
