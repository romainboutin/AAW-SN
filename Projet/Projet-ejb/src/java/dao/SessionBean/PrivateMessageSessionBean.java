/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.SessionBean;

import dao.Entity.PrivateMessageEntity;
import dao.Entity.UserEntity;
import dao.SessionBeanLocal.PrivateMessageSessionBeanLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
@Stateless
public class PrivateMessageSessionBean implements PrivateMessageSessionBeanLocal {

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
        Query q = em.createQuery("SELECT pm FROM PrivateMessageEntity pm WHERE (pm.from.id="+from.getId() + " AND pm.to.id=" +to.getId()+") OR (pm.from.id="+to.getId() + " AND pm.to.id=" +from.getId()+")" );
        return q.getResultList();
    }
}
