/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import fr.upem.entity.Comment;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Denis
 */
public class CommentDAO extends DAO<Comment>{
    
    @Inject
    private EntityManager em;

    public CommentDAO(Class<Comment> entityClass) {
        super(entityClass);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    
    
}
