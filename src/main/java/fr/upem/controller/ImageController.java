/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.ImageDAO;
import fr.upem.entity.Image;
import fr.upem.entity.Users;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
    
    public List<Image> getImagesByUser(Users user) {
        Objects.requireNonNull(user);
        
        return imageDAO.findByUsers(user);
    }
    
    public void removeImages(Image image) {
        imageDAO.delete(image);
    }
    
}
