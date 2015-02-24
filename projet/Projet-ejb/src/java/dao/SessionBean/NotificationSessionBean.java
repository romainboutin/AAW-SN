/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.SessionBean;

import dao.Entities.NotificationEntity;
import dao.SessionBeanLocal.NotificationSessionBeanLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author William
 */
@Stateless
public class NotificationSessionBean implements NotificationSessionBeanLocal {
    //========================================================================//
    //== PROPERTIES ==========================================================//
    //========================================================================//
    @PersistenceContext(unitName="Projet-ejbPU",type=PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    //========================================================================//
    //== CONSTRUCTORS ========================================================//
    //========================================================================//
    public NotificationSessionBean() {}
    
    //========================================================================//
    //== GETTERS AND SETTERS =================================================//
    //========================================================================//
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    //========================================================================//
    //== CLASS METHODS =======================================================//
    //========================================================================//
    @Override
    public void save(NotificationEntity n) {
        n = em.merge(n);
        em.persist(n);
    }

    @Override
    public void update(NotificationEntity n) {
        em.merge(n);
    }

    @Override
    public void delete(NotificationEntity n) {
        n = em.merge(n);
        em.remove(n);
    }
}
