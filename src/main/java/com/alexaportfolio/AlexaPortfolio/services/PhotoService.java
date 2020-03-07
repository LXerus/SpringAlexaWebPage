package com.alexaportfolio.AlexaPortfolio.services;

import com.alexaportfolio.AlexaPortfolio.DAO.IPhotoDAO;
import com.alexaportfolio.AlexaPortfolio.models.AlbumPhoto;
import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;
import com.alexaportfolio.AlexaPortfolio.repositories.AlbumPhotoRepository;
import com.alexaportfolio.AlexaPortfolio.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The PhotoService class is in charge of saving the photos to the disk and the data base
 * @author crodf
 */

public class PhotoService implements IPhotoDAO {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private AlbumPhotoRepository albumPhotoRepository;

    @Override
    public void saveProjectPhoto(ProjectPhoto projectPhoto, MultipartFile imageFile) throws Exception {
        Path currentPath = Paths.get("."); // this gets us to src/main/resources without knowing the full path
        Path absolutePath = currentPath.toAbsolutePath();
        projectPhoto.setPath(absolutePath + "/src/main/resource/static/images/");
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(projectPhoto.getPath() + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

    @Override
    public void save(ProjectPhoto projectPhoto) {
        photoRepository.save(projectPhoto);
    }

    @Override
    public void saveAlbumPhoto(AlbumPhoto albumPhoto, MultipartFile imageFile) throws Exception {
        Path currentPath = Paths.get("."); // this gets us to src/main/resources without knowing the full path
        Path absolutePath = currentPath.toAbsolutePath();
        albumPhoto.setPath(absolutePath + "/src/main/resource/static/images/");
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(albumPhoto.getPath() + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

    @Override
    public void save(AlbumPhoto albumPhoto) {
        albumPhotoRepository.save(albumPhoto);
    }
}
