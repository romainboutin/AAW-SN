/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.entity.PublicMessageEntity;
import dao.entity.UserEntity;
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
public class PublicMessageDAOImpl implements PublicMessageDAO{

    @PersistenceContext(unitName = "Projet-ejbPU")
    private EntityManager em;
    
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void save(PublicMessageEntity pm) {        
        em.persist(pm);
    }

    @Override
    public void update(PublicMessageEntity pm) {
        em.merge(pm);
    }

    @Override
    public void delete(PublicMessageEntity pm) {        
        em.remove(em.merge(pm));
    }

    @Override
    public List<PublicMessageEntity> findByUser(UserEntity u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
