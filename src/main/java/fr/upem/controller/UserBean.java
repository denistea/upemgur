/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.UserDAO;
import fr.upem.entity.User;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("userBean")
@RequestScoped
public class UserBean {
    
    @EJB
    private UserDAO userDAO;
    private Long userId;
    private User user;
    
    public UserBean() {
        user = new User();
    }
    
    public void init() {
        user = userDAO.find(userId);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
