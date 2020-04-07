package com.alexaportfolio.AlexaPortfolio.DAO.interfaces;

import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * IProjectPhotoDAO dictates the behavior of the ProjectPhoto data access object
 * @author crodf
 */

public interface IProjectPhotoDAO {

    /**
     * Saves the photo in the specified directory
     * @param projectPhoto
     * @param file
     * @throws Exception
     */
    void saveProjectPhoto(ProjectPhoto projectPhoto, MultipartFile file) throws Exception;



    /**
     * Saves the photo information in the data base
     * @param projectPhoto
     */
    void save(ProjectPhoto projectPhoto);


}
