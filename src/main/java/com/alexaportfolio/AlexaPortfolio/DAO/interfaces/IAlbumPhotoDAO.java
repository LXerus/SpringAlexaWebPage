package com.alexaportfolio.AlexaPortfolio.DAO.interfaces;

import com.alexaportfolio.AlexaPortfolio.models.Album;
import com.alexaportfolio.AlexaPortfolio.models.AlbumPhoto;
import org.springframework.web.multipart.MultipartFile;

/**
 * This interface will dictate the behavior for the AlbumPhoto Data Access Object
 * @author crodf
 */

public interface IAlbumPhotoDAO {

    /**
     * Saves the photo in the specified directory
     * @param albumPhoto
     * @param file
     * @throws Exception
     */
    void saveAlbumPhoto(AlbumPhoto albumPhoto, MultipartFile file) throws Exception;

    /**
     * Saves the photo information in the data base
     * @param album
     * @param albumPhoto
     */
    void save(Album album, AlbumPhoto albumPhoto);
}
