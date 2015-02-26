/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.UserDAO;
import fr.upem.entity.Users;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("authenticateBean")
@RequestScoped
public class AuthenticateBean implements Serializable{
    
    private Users user;
    
    @EJB
    private UserDAO userDAO;
    
    public AuthenticateBean() {
        user = new Users();
    }
    
    public Users getUser() {
        return user;
    }
    
    public boolean isLogin() {
       return FacesContext.getCurrentInstance().getExternalContext()
               .getSessionMap().get("userSession") != null;
    }
    
    public String login() {
        //Find User in Database
        Users userDB = userDAO.findByUserName(user.getUserName());
        
        
        //Test if userName exist
        if(userDB == null) {
            return null;
        }

        //Compare the password
        if(!user.getPassword().equals(userDB.getPassword())) {
            return null;
        }
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .put("userSession", userDB);
        return "index";
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .remove("userSession");
        return null;
    }
}
