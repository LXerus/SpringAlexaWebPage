package com.alexaportfolio.AlexaPortfolio.DAO;

import com.alexaportfolio.AlexaPortfolio.models.AlbumPhoto;
import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;
import org.springframework.web.multipart.MultipartFile;

/**
 * This interface will dictate the behavior for the Photo Data Access Object
 * @author crodf
 */
public interface IPhotoDAO {

    /**
     * Saves the photo in the specified directory
     * @param projectPhoto
     * @param file
     * @throws Exception
     */
    void saveProjectPhoto(ProjectPhoto projectPhoto, MultipartFile file) throws Exception;

    /**
     * Saves the photo in the specified directory
     * @param albumPhoto
     * @param file
     * @throws Exception
     */
    void saveAlbumPhoto(AlbumPhoto albumPhoto, MultipartFile file) throws Exception;

    /**
     * Saves the photo information in the data base
     * @param projectPhoto
     */
    void save(ProjectPhoto projectPhoto);

    /**
     * Saves the photo information in the data base
     * @param albumPhoto
     */
    void save(AlbumPhoto albumPhoto);
}
