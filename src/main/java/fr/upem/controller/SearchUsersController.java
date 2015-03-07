/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.UserDAO;
import fr.upem.entity.User;
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
@Named("searchUsersController")
@SessionScoped
public class SearchUsersController implements Serializable {
    @EJB
    private UserDAO userDAO;
    
    private List<User> users;
    private String criteria;
    private String value;
    
    public SearchUsersController() {
        users = new ArrayList<>();
    }
    
    public void search() {
        switch(criteria) {
            case "email":
                users = userDAO.findBeginEmail(value);
                break;
            case "userName":
                users = userDAO.findBeginUserName(value);
                break;
            case "all":
                users = userDAO.findAll();
                break;
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
