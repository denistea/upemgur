/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.CommentDAO;
import fr.upem.entity.Comment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("searchCommentController")
@SessionScoped
public class SearchCommentController implements Serializable {
    @EJB
    private CommentDAO commentDAO;
    
    private List<Comment> comments;
    private String criteria;
    private String value;
    
    public SearchCommentController() {
        comments = new ArrayList<>();
        criteria = "all";
    }
    
    public void search() {
        switch(criteria) {
            case "content":
                comments = commentDAO.findLikeContent(value);
                break;
            
            case "all":
                comments = commentDAO.findAll();
                break;
        }
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getCriteria() {
        return criteria;
    }

    public String getValue() {
        return value;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public void setValue(String value) {
        this.value = value;
    }    
    
}
