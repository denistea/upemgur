/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import fr.upem.entity.Image;
import fr.upem.entity.Users;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Denis
 */
public class ImageDAO extends DAO<Image>{
    
    @Inject
    private EntityManager em;

    public ImageDAO(Class<Image> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public List<Image> findByUser(Users users) {
        return em.createNamedQuery("Image.findByUsers", Image.class) 
                  .setParameter("users", users) 
                  .getResultList();
    }
    
}
