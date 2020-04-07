package com.alexaportfolio.AlexaPortfolio.DAO.interfaces;

import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * IProjectDAO dictates the behavior of the Project data access object
 * @author crodf
 */

public interface IProjectDAO {
    public void save(Project project) throws Exception;
}
