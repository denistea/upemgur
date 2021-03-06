/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

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
public class ImageDAO extends DAO<Image>{
    
    @Inject
    private EntityManager em;

    public ImageDAO() {
        super(Image.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public List<Image> findByUsers(User user) {
        return em.createNamedQuery("Image.findByUsers", Image.class) 
                  .setParameter("user", user) 
                  .getResultList();
    }
    
    public List<Image> findLikeTitle(String title) {
        return em.createNamedQuery("Image.findLikeTitle", Image.class)
                 .setParameter("title", "%"+title+"%")
                 .getResultList();
    }
    
    public List<Image> findLikeDescription(String description) {
        return em.createNamedQuery("Image.findLikeDescription", Image.class)
                 .setParameter("description", "%"+description+"%")
                 .getResultList();
    }
    
    public List<Image> findByTimeRange(Timestamp time, int max) {
        return em.createNamedQuery("Image.findByTimeRange", Image.class)
                 .setMaxResults(max)
                 .setParameter("time", time)
                 .getResultList();           
    }
    
    public List<Image> findById(Long id) {
        return em.createNamedQuery("Image.findById", Image.class)
                 .setParameter("id", id)
                 .getResultList();           
    }
    
    public List<Image> findLimit(int max) {
        return em.createNamedQuery("Image.findAll", Image.class)
                 .setMaxResults(max)
                 .getResultList();  
    }
}
