/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import fr.upem.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

/**
 *
 * @author Denis
 */
@Stateless
public class UserDAO extends DAO<User> {
    
    @Inject
    private EntityManager em;
    
    public UserDAO() {
        super(User.class);
    }
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    public User findByUserName(String userName) {
        List<User> users = em.createNamedQuery("User.findByUserName", User.class) 
                  .setParameter("userName", userName) 
                  .getResultList();
        
        if(users.isEmpty()) {
            return null;
        }
        
        return users.get(0);
    }
    
    public User findByEmail(String email) {
        List<User> users = em.createNamedQuery("User.findByEmail", User.class) 
                  .setParameter("email", email) 
                  .getResultList();
        
        if(users.isEmpty()) {
            return null;
        }
        
        return users.get(0);
    }
    
    public List<User> findBeginUserName(String userName) {
        return em.createNamedQuery("User.findBeginUserName", User.class) 
                  .setParameter("userName", userName+"%") 
                  .getResultList();
    }
    
    public List<User> findAllSortedBy(int maxResult, String...attrs) { 
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> users = query.from(User.class);
        query.select(users);
        
        //Users_.email
        for(String attr : attrs) {
            Order order = builder.desc(users.get(attr));
            query.getOrderList().add(order);
        }
        
        return em.createQuery(query).setMaxResults(maxResult).getResultList();
        //sm=em.createQuery("select m from MasterScrip m where m.type = :type order by m.totalTradedVolume").setParameter("type", type).setMaxResults(2).getResultList()
    }
}
