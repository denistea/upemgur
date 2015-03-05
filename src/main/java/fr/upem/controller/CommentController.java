/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.CommentDAO;
import fr.upem.entity.Comment;
import fr.upem.entity.Image;
import fr.upem.entity.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("commentController1")
@RequestScoped
public class CommentController {
    @EJB
    private CommentDAO commentDAO;
    
    public List<Comment> getCommentsByUser(Users users) {
        return commentDAO.findByUsers(users);
    }
    
    public List<Comment> getCommentsByImage(Image image) {
        return commentDAO.findByImage(image);
    }
}
