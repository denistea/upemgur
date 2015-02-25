/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Denis
 */
public abstract class DAO<T> {   
    private Class<T> entityClass;
    
    public abstract EntityManager getEntityManager();
    
    public DAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
          
    public void create(T t) {
        getEntityManager().persist(t);
    }
    
    public void update(T t) {
        getEntityManager().merge(t);
    }
    
    public void delete(T t) {
        getEntityManager().remove(t);
    }
    
    public T find(Object primaryKey) {
        return getEntityManager().find(entityClass, primaryKey);
    }
    
    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
