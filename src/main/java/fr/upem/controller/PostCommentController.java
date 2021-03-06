/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.CommentDAO;
import fr.upem.entity.Comment;
import fr.upem.entity.Image;
import fr.upem.entity.User;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("postCommentController")
@RequestScoped
public class PostCommentController {
    @EJB
    private CommentDAO commentDAO;
    
    private Comment comment;
    
    public PostCommentController() {
        comment = new Comment();
    }
    
    public String postComment(User user, Image image) {
        comment.setImage(image);
        comment.setUser(user);
        
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        comment.setTime(new Timestamp(now.getTime()));

        commentDAO.create(comment);
        comment = new Comment();
        return "image.xhtml?faces-redirect=true&includeViewParams=true&img_id="+image.getId();
    }

    public Comment getComment() {
        return comment;
    }
}
