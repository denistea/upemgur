/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.UserDAO;
import fr.upem.entity.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("usersController1")
@RequestScoped
public class UsersController {
    @EJB
    UserDAO userDAO;
    
    public void updateUser(Users user) {
        
    }
    
    public void changeAccountSetting(Users user) {
        
    }
    
    public void changePassword(Users user) {
        
    }
    
    public List<Users> getAllUsers() {
        return null;
    }
    
    public void removeUser(Users user) {
        
    }
}
