package com.alexaportfolio.AlexaPortfolio.DAO;

import com.alexaportfolio.AlexaPortfolio.DAO.interfaces.IProjectPhotoDAO;
import com.alexaportfolio.AlexaPortfolio.models.Project;
import com.alexaportfolio.AlexaPortfolio.models.ProjectPhoto;
import com.alexaportfolio.AlexaPortfolio.repositories.ProjectPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class to implement the methods from the ProjectPhotoRepository
 * @author crodf
 */
@Component
public class ProjectPhotoDAO implements IProjectPhotoDAO {

    @Autowired
    private ProjectPhotoRepository projectPhotoRepository;

    /**
     * This method will save the photo in the disk
     * @param projectPhoto
     * @param imageFile
     * @throws Exception
     */
    @Override
    public void saveProjectPhoto(ProjectPhoto projectPhoto, MultipartFile imageFile) throws Exception {
        Path currentPath = Paths.get("."); // this gets us to src/main/resources without knowing the full path
        Path absolutePath = currentPath.toAbsolutePath();
        projectPhoto.setPath(absolutePath + "/src/main/resources/static/photos/");
        byte[] bytes = imageFile.getBytes();
        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        Path path = Paths.get(projectPhoto.getPath() + fileName);
        Files.write(path, bytes);
    }

    /**
     * This method will save the photo information in the data base
     * @param projectPhoto
     */
    @Override
    public void save(ProjectPhoto projectPhoto) {
        projectPhotoRepository.save(projectPhoto);
    }

}
