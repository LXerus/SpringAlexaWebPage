package com.alexaportfolio.AlexaPortfolio.DAO.interfaces;

import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public interface IProjectDAO {
    public void save(Project project) throws Exception;
}
