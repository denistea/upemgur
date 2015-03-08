/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.ImageDAO;
import fr.upem.entity.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named("searchImageController")
@SessionScoped
public class SearchImageController implements Serializable {
    
    @EJB
    private ImageDAO imageDAO;
    
    private List<Image> images;
    private String criteria;
    private String value;
    
    public SearchImageController() {
        images = new ArrayList<>();
        criteria = "all";
    }
    
    public void search() {
        switch(criteria) {
            case "all":
                images = imageDAO.findAll();
                break;
            case "title":
                images = imageDAO.findLikeTitle(value);
                break;
            case "description":
                images = imageDAO.findLikeDescription(value);
                break;
        }
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
