/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.entity.PrivateMessageEntity;
import dao.entity.UserEntity;
import dao.interfaces.PrivateMessageDAO;
import dao.interfaces.PublicMessageDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Moi
 */
@Stateless
public class PrivateMessageDAOImpl implements PrivateMessageDAO{

    @PersistenceContext(unitName = "Projet-ejbPU")
    private EntityManager em;
    
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void save(PrivateMessageEntity pm) {        
        em.persist(pm);
    }

    @Override
    public void update(PrivateMessageEntity pm) {
        em.merge(pm);
    }

    @Override
    public void delete(PrivateMessageEntity pm) {        
        em.remove(em.merge(pm));
    }

    @Override
    public List<PrivateMessageEntity> findByDiscus(UserEntity from, UserEntity to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
