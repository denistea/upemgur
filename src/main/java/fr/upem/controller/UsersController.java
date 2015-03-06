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
    UserDAO userDAO;
    
    public void updateUser(User user) {
        user.setUserName(user.getUserName().toUpperCase());
        user.setEmail(user.getEmail().toUpperCase());
        
        userDAO.update(user);
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
    
}
