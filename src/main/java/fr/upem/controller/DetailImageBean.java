/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.ImageDAO;
import fr.upem.entity.Image;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("detailImageBean")
@SessionScoped
public class DetailImageBean implements Serializable{
    @EJB
    private ImageDAO imageDAO;
    
    private Image image;
    private Long imageId;
    
    public DetailImageBean() {
        image = new Image();
    }
    
    public void init() {
        image = imageDAO.find(imageId);
    }
    
    public Image getImage() {
        return image;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
