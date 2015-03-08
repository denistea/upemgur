/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.UserDAO;
import fr.upem.entity.User;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {
    @EJB
    private UserDAO userDAO;
    
    private User user;
    private Long userId;
    
    public UserBean() {
        user = new User();
    }
    public void init() {
        user = userDAO.find(userId);
    }

    public User getUser() {
        return user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
