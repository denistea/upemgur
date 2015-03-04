/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import fr.upem.entity.Users;
import fr.upem.entity.Users_;
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
    
    public List<Users> findBeginUserName(String userName) {
        return em.createNamedQuery("Users.findBeginUserName", Users.class) 
                  .setParameter("userName", userName+"%") 
                  .getResultList();
    }
    
    public List<Users> findAllSortedBy(int maxResult, String...attrs) { 
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root<Users> users = query.from(Users.class);
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
