/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller2;

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
//@Named("")
//@RequestScoped
public class PostCommentController {
    @EJB
    private CommentDAO commentDAO;
    
    private Comment comment;
    
    public PostCommentController() {
        comment = new Comment();
    }
    
    public String postComment(Users users, Image image) {
        comment.setImage(image);
        comment.setUsers(users);
        
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        comment.setTime(new Timestamp(now.getTime()));

        commentDAO.create(comment);
        comment = new Comment();
        return "image.xhtml?img_id="+image.getId();
    }

    public Comment getComment() {
        return comment;
    }
}
