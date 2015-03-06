/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.util;

import fr.upem.controller.JoinController;
import fr.upem.dao.UserDAO;
import fr.upem.entity.Users;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author Denis
 */
@Startup
@Singleton
public class DBSetup {
    @EJB
    UserDAO userDAO;
    
    @PostConstruct
    public void initDB() {
        userDAO.create(new Users("DENIS", "denis", "DENIS@FREE.FR"));
    }
}
