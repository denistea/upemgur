/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.util;

import fr.upem.dao.CommentDAO;
import fr.upem.dao.ImageDAO;
import fr.upem.dao.UserDAO;
import fr.upem.entity.Comment;
import fr.upem.entity.Image;
import fr.upem.entity.Users;
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
    
    @EJB
    ImageDAO imageDAO;
    
    @EJB
    CommentDAO commentDAO;
    
    @PostConstruct
    public void initDB() {
        /*Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        Users admin = new Users("ADMIN", "admin", "ADMIN@UPEMGUR.FR");
        userDAO.create(admin);
        Image image = new Image("4183327685581831868.jpg", "C:\\var\\webapp\\images\\4183327685581831868.jpg", "title", "description", new Timestamp(now.getTime()), 1917L, 1007L, 0L, admin);
        imageDAO.create(image);
        Comment comment = new Comment("test", new Timestamp(now.getTime()), admin, image);
        commentDAO.create(comment);
        
        commentDAO.delete(comment);
        imageDAO.delete(image);*/
    }
}
