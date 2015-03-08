/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import fr.upem.entity.Comment;
import fr.upem.entity.Image;
import fr.upem.entity.User;
import java.sql.Timestamp;
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
    
    public List<Comment> findByUser(User user) {
        return em.createNamedQuery("Comment.findByUser", Comment.class) 
                  .setParameter("user", user) 
                  .getResultList();
    }
   
    public List<Comment> findByImage(Image image) {
        return em.createNamedQuery("Comment.findByImage", Comment.class) 
                  .setParameter("image", image)
                  .getResultList();
    }
    
    public List<Comment> findByImageUsers(Image image, User user) {
        return em.createNamedQuery("Comment.findByImageUser", Comment.class) 
                  .setParameter("image", image)
                  .setParameter("users", user)
                  .getResultList();
    }
    
    public List<Comment> findLikeContent(String content) {
        return em.createNamedQuery("Comment.findLikeContent", Comment.class)
                 .setParameter("content", "%"+content+"%")
                 .getResultList();
    }
    
    public List<Comment> findByTimeRange(Timestamp time, int max) {
        return em.createNamedQuery("Comment.findByTimeRange", Comment.class) 
                 .setMaxResults(max)
                 .setParameter("time", time)
                 .getResultList();
    }
    
}
