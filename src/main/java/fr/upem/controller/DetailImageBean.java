/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.ImageDAO;
import fr.upem.entity.Image;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("detailImageBean")
@RequestScoped
public class DetailImageBean {
    @EJB
    private ImageDAO imageDAO;
    
    private Image image;
    private Long imageId;
    
    public void init() {
        if (imageId == null) {
            return;
        }
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

}
