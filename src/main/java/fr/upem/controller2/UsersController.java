/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller2;

import fr.upem.dao.UserDAO;
import fr.upem.entity.Users;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
//@Named("")
//@SessionScoped
public class UsersController implements Serializable {
    @EJB
    UserDAO userDAO;
    
    public void updateUser(Users user) {
        userDAO.update(user);
    }
    
    public List<Users> getAllUsers() {
        return userDAO.findAll();
    }
    
    public void removeUser(Users user) {
        userDAO.delete(user);
    } 
    
    public List<Users> searchUsers(String userName) {
        return userDAO.findBeginUserName(userName);
    }
    
}
