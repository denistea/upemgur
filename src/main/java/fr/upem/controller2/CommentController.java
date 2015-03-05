/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller2;

import fr.upem.dao.CommentDAO;
import fr.upem.entity.Comment;
import fr.upem.entity.Image;
import fr.upem.entity.Users;
import java.io.Serializable;
import java.sql.Timestamp;
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
public class CommentController implements Serializable {
    
    @EJB
    private CommentDAO commentDAO;
    
    public List<Comment> getComments(Users users) {
        return commentDAO.findByUsers(users);
    }
    
    public List<Comment> getComments(Image image) {
        return commentDAO.findByImage(image);
    }  
    
    public List<Comment> getComments(Image image, Users user) {
        return commentDAO.findByImageUsers(image, user);
    }
    
    public List<Comment> getTimeRangeComments(Timestamp time, int max) {
        return commentDAO.findByTimeRange(time, max);
    }
    
    public void removeComment(Comment comment) {
        commentDAO.delete(comment);
    }
}
