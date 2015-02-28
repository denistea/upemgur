/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import fr.upem.entity.Comment;
import fr.upem.entity.Image;
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
public class CommentDAO extends DAO<Comment>{
    
    @Inject
    private EntityManager em;

    public CommentDAO() {
        super(Comment.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public List<Comment> findByUsers(Users users) {
        return em.createNamedQuery("Comment.findByUsers", Comment.class) 
                  .setParameter("users", users) 
                  .getResultList();
    }
   
    public List<Comment> findByImage(Image image) {
        return em.createNamedQuery("Comment.findByImage", Comment.class) 
                  .setParameter("image", image)
                  .getResultList();
    }
    
}
