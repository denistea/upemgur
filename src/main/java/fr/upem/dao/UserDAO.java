/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import fr.upem.entity.Users;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        return em.createNamedQuery("Users.findByUserName", Users.class) 
                  .setParameter("userName", userName) 
                  .getSingleResult();
    }
    
    public Users findByEmail(String email) {
        return em.createNamedQuery("Users.findByEmail", Users.class) 
                  .setParameter("email", email) 
                  .getSingleResult();
    }
}
