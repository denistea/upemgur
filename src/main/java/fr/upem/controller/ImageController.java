/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.ImageDAO;
import fr.upem.entity.Image;
import fr.upem.entity.Users;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("imageController")
@RequestScoped
public class ImageController implements Serializable {
    
    @EJB
    private ImageDAO imageDAO;
    
    public Image getImageById(long id) {
        return imageDAO.find(id);
    }
    
    public List<Image> getAllImage() {
        return imageDAO.findAll();
    }
    
    public List<Image> getImagesByUser(Users user) {
        Objects.requireNonNull(user);
        
        return imageDAO.findByUsers(user);
    }
    
    public List<Image> getImagesByTitle(String title) {
        return imageDAO.findByTitle(title);
    }
    
    public void removeImage(Image image) {
        try {
            Files.deleteIfExists(Paths.get(image.getPath()));
        } catch (IOException ex) {
        }
        imageDAO.delete(image);
    }
    
}
