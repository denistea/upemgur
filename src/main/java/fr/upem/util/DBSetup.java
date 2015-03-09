/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.util;

import fr.upem.dao.UserDAO;
import fr.upem.entity.User;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

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
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        User admin = new User("admin", "admin", "admin@upemgur.com", new Timestamp(now.getTime()), true);
        userDAO.create(admin);
    }
}
