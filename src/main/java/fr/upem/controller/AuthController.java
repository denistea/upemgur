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
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("authController")
@RequestScoped
public class AuthController {
    private String login;
    private String password;
    
    @EJB
    private UserDAO userDAO;
    
    public boolean isSignedIn() {
       return FacesContext.getCurrentInstance().getExternalContext()
               .getSessionMap().get("userSession") != null;
    }
    
    public String signIn() {
        //Find User in Database
        User userDB = userDAO.findByUserName(login);
        
        
        //Test if userName exist
        if(userDB == null) {
            userDB = userDAO.findByEmail(login);
            
            if(userDB == null) {
                return null;
            }
        }

        //Compare the password
        if(!password.equals(userDB.getPassword())) {
            return null;
        }
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .put("userSession", userDB);
        return null;
    }
    
    public String signOut() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .remove("userSession");
        return null;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
