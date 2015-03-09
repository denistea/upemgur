/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.UserDAO;
import fr.upem.entity.User;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("joinController")
@RequestScoped
public class JoinController {
    @EJB
    private UserDAO userDAO;
    private User user;
    
    public JoinController() {
        user = new User();
    }

    public User getUser() {
       return user;
    }
    
    public String join() {
        user.setUserName(user.getUserName());
        user.setEmail(user.getEmail());
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        user.setTime(new Timestamp(now.getTime()));
        userDAO.create(user);
        user.setIsAdmin(false);
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .put("userSession", user);
        
        return null;
    } 
}
