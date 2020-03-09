package com.alexaportfolio.AlexaPortfolio.DAO;

import com.alexaportfolio.AlexaPortfolio.DAO.interfaces.IProjectDAO;
import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class will implement the CRUD methods from the ProjectRepository
 * @author crodf
 */
@Component
public class ProjectDAO implements IProjectDAO {

    @Autowired
    ProjectRepository projectRepository;

    /**
     * Will save the project in the data base
     * @param project
     * @throws Exception
     */
    @Override
    public void save(Project project) throws Exception {
        projectRepository.save(project);
    }
}
