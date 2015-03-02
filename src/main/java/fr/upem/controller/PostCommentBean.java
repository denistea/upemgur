/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.CommentDAO;
import fr.upem.dao.ImageDAO;
import fr.upem.entity.Comment;
import fr.upem.entity.Image;
import fr.upem.entity.Users;
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
@Named("postCommentBean")
@RequestScoped
public class PostCommentBean {
    @EJB
    private CommentDAO commentDAO;
    
    @EJB
    private ImageDAO imageDAO;
    
    private Comment comment;
    
    public PostCommentBean() {
        comment = new Comment();
    }
    
    public String postComment(Users users, Image image) {
        comment.setImage(image);
        //comment.setImage(imageDAO.find(2L));
        comment.setUsers(users);
        
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        comment.setTime(new Timestamp(now.getTime()));

        commentDAO.create(comment);
        
        return null;
    }

    public Comment getComment() {
        return comment;
    }
    
    
}
