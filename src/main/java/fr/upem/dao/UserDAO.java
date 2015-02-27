/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import fr.upem.entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Denis
 */
@Stateless
public class UserDAO extends DAO<Users> {
    
    @Inject
    private EntityManager em;
    
    public UserDAO() {
        super(Users.class);
    }
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    public Users findByUserName(String userName) {
        List<Users> users = em.createNamedQuery("Users.findByUserName", Users.class) 
                  .setParameter("userName", userName) 
                  .getResultList();
        
        if(users.isEmpty()) {
            return null;
        }
        
        return users.get(0);
    }
    
    public Users findByEmail(String email) {
        List<Users> users = em.createNamedQuery("Users.findByEmail", Users.class) 
                  .setParameter("email", email) 
                  .getResultList();
        
        if(users.isEmpty()) {
            return null;
        }
        
        return users.get(0);
    }
}
