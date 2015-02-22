/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Denis
 */
public abstract class DAO<T> {   
    private Class<T> entityClass;
    
    @PersistenceContext(unitName = "upemgurPU")
    EntityManager em;
    
    public DAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
          
    public void create(T t) {
        em.persist(t);
    }
    
    public void update(T t) {
        em.merge(t);
    }
    
    public void delete(T t) {
        em.remove(t);
    }
    
    public T find(Object primaryKey) {
        return em.find(entityClass, primaryKey);
    }
    
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
}
