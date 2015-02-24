/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.interfaces.UserDAO;
import dao.entity.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public List<UserEntity> findName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
