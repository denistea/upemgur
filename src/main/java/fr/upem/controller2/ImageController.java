/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller2;

import fr.upem.dao.ImageDAO;
import fr.upem.entity.Image;
import fr.upem.entity.Users;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
//@Named("imageController")
//@SessionScoped
public class ImageController implements Serializable{
    @EJB
    private ImageDAO imageDAO;
    
    public Image getImageById(long id) {
        return imageDAO.find(id);
    }
    
    public List<Image> getAllImages() {
        return imageDAO.findAll();
    }
    
    public List<Image> getImagesByUser(Users user) {
        return imageDAO.findByUsers(user);
    }
    
    public List<Image> searchImagesByTitle(String title) {
        return imageDAO.findLikeTitle(title);
    }
    
    public List<Image> getTimeRangeImages(Timestamp time, int max) {
        return imageDAO.findByTimeRange(time, max);
    }
    
    public List<Image> getImages(int max) {
        return imageDAO.findLimit(max);
    }
    
    public void removeImage(Image image) {
        try {
            Files.deleteIfExists(Paths.get(image.getPath()));
        } catch (IOException ex) {
        }
        imageDAO.delete(image);
    }  
}
