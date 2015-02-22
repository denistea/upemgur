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
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("JoinBean")
@RequestScoped
public class JoinBean implements Serializable{
    
    @EJB
    private UserDAO dao;
    private Users user;
    
    public JoinBean() {
        user = new Users();
    }

    public Users getUser() {
       return user;
    }
    
    public void join() {
        dao.create(user);
    }
}
