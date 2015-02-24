/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
@Stateless
public class UserDAOImpl implements UserDAO{

    @PersistenceContext(unitName = "Projet-ejbPU")
    private EntityManager em;
    
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void save(UserEntity u) {
        em.persist(u);
    }

    @Override
    public void update(UserEntity u) {
        em.merge(u);
    }

    @Override
    public void delete(UserEntity u) {
        em.remove(em.merge(u));
    }

    @Override
    public UserEntity findByMail(String mail) {
       Query q = em.createQuery("select u from UserEntity u where u.mail = '"+ mail+"'");
        List <UserEntity> l = q.getResultList();
        Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, l.toString());
                 
        if(!l.isEmpty())
            return l.get(0);
        else 
            return null;
    }
    
}
