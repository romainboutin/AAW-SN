/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.SessionBean;

import dao.Entity.UserEntity;
import dao.SessionBeanLocal.UserSessionBeanLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author William
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {
    //========================================================================//
    //== PROPERTIES ==========================================================//
    //========================================================================//
    @PersistenceContext(unitName="Projet-ejbPU",type=PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    //========================================================================//
    //== CONSTRUCTORS ========================================================//
    //========================================================================//
    public UserSessionBean() {}
    
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
    public void save(UserEntity u) {
        u = em.merge(u);
        em.persist(u);
    }

    @Override
    public void update(UserEntity u) {
        em.merge(u);
    }

    @Override
    public void delete(UserEntity u) {
        u = em.merge(u);
        em.remove(u);
    }
    
    @Override
    public UserEntity findByMail(String mail) {
        Query q = em.createQuery("select u from UserEntity u where u.mail = '"+ mail +"'");
        List <UserEntity> l = q.getResultList();
                 
        if(!l.isEmpty()) {
            return l.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<UserEntity> findAll() {
        Query q = em.createQuery("select u from UserEntity u ");
        List <UserEntity> l = q.getResultList();
        return l;
    }
}
