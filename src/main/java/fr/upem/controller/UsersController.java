/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.UserDAO;
import fr.upem.entity.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("usersController")
@SessionScoped
public class UsersController implements Serializable {
    @EJB
    private UserDAO userDAO;
    
    private User user;
    
    public UsersController() {
        user = new User();
    }
    
    public void updateUser(User user) {
        userDAO.update(user);
        user.setEdit(false);
    }
    
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
    
    public void removeUser(User user) {
        userDAO.delete(user);
    } 
    
    public List<User> searchUsers(String userName) {
        return userDAO.findBeginUserName(userName);
    }
    
    public User getUserByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
