/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import fr.upem.entity.Users;
import javax.ejb.Stateless;

/**
 *
 * @author Denis
 */
@Stateless
public class UserDAO extends DAO<Users> {
    
    public UserDAO() {
        super(Users.class);
    }
}
