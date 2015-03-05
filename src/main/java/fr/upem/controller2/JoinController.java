/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller2;

import fr.upem.dao.UserDAO;
import fr.upem.entity.Users;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
//@Named("")
//@RequestScoped
public class JoinController {
    @EJB
    private UserDAO userDAO;
    private Users user;
    
    public JoinController() {
        user = new Users();
    }

    public Users getUser() {
       return user;
    }
    
    public String join() {
        user.setUserName(user.getUserName().toUpperCase());
        user.setEmail(user.getEmail().toUpperCase());
        userDAO.create(user);
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .put("userSession", user);
        
        return null;
    } 
}
