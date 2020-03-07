package com.alexaportfolio.AlexaPortfolio.services;

import com.alexaportfolio.AlexaPortfolio.models.Project;
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
    private ProjectRepository projectRepository;

    @Autowired
    private PhotoService photoService;

    /**
     * Creates a new project in the data base
     * @param project
     * @return
     */
    public Project create(Project project, MultipartFile photoFile) throws Exception {
        project.getProjectPhotoList().get(0).setPath("/images/");
        photoService.saveProjectPhoto(project.getProjectPhotoList().get(0), photoFile);
        photoService.save(project.getProjectPhotoList().get(0));
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
