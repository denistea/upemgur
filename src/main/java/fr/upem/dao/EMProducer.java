/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Denis
 */
@Startup
@Singleton
public class EMProducer {
    @Produces
    @PersistenceContext(unitName = "upemgurPU")
    private EntityManager em;
}
