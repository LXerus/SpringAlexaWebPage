package com.alexaportfolio.AlexaPortfolio.DAO;

import com.alexaportfolio.AlexaPortfolio.DAO.interfaces.IAlbumPhotoDAO;
import com.alexaportfolio.AlexaPortfolio.models.Album;
import com.alexaportfolio.AlexaPortfolio.models.AlbumPhoto;
import com.alexaportfolio.AlexaPortfolio.repositories.AlbumPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * AlbumPhotoDAO implement the CRUD methods from the AlbumPhotoRepository
 * @author crodf
 */
@Component
public class AlbumPhotoDAO implements IAlbumPhotoDAO {

    @Autowired
    private AlbumPhotoRepository albumPhotoRepository;

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
    public void save(Album album, AlbumPhoto albumPhoto) {
        albumPhoto.setAlbum(album);
        albumPhotoRepository.save(albumPhoto);
    }

}
