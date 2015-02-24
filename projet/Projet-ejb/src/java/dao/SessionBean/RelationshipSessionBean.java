/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.SessionBean;

import dao.SessionBeanLocal.RelationshipSessionBeanLocal;
import dao.Entities.RelationshipEntity;
import dao.Entities.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author William
 */
@Stateless
public class RelationshipSessionBean implements RelationshipSessionBeanLocal {
    //========================================================================//
    //== PROPERTIES ==========================================================//
    //========================================================================//
    @PersistenceContext(unitName="Projet-ejbPU",type=PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    //========================================================================//
    //== CONSTRUCTORS ========================================================//
    //========================================================================//
    public RelationshipSessionBean() {}
    
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
    public void save(RelationshipEntity r) {
        r = em.merge(r);
        em.persist(r);
    }

    @Override
    public void update(RelationshipEntity r) {
        em.merge(r);
    }

    @Override
    public void delete(RelationshipEntity r) {
        r = em.merge(r);
        em.remove(r);
    }

    @Override
    public RelationshipEntity find(UserEntity user, UserEntity friend) {
        List<RelationshipEntity> listRelationship = user.getRelationships();
        for(RelationshipEntity re : listRelationship) {
            if(re.getUserId2().equals(friend)) {
                return re;
            }
        }
        return null;
    }
}
