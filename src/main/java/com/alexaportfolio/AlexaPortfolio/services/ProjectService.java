package com.alexaportfolio.AlexaPortfolio.services;

import com.alexaportfolio.AlexaPortfolio.DAO.interfaces.IProjectDAO;
import com.alexaportfolio.AlexaPortfolio.DAO.interfaces.IProjectPhotoDAO;
import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;
import com.alexaportfolio.AlexaPortfolio.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Handles the upload services for the projects
 * @author crodf
 */

@Service
public class ProjectService {

    @Autowired
    IProjectPhotoDAO projectPhotoDAO;

    @Autowired
    IProjectDAO projectDAO;

    @Autowired
    private ProjectRepository projectRepository;

    /**
     * Creates a new project in the data base
     * @param project
     * @return
     */
    public void saveProject(Project project) throws Exception {
        projectDAO.save(project);
    }

    public void saveProjectPhoto(ProjectPhoto projectPhoto, MultipartFile imageFile) throws Exception {
        projectPhotoDAO.saveProjectPhoto(projectPhoto, imageFile);
        projectPhotoDAO.save(projectPhoto);
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
