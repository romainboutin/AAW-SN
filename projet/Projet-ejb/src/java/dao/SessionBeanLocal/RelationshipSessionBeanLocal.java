/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.SessionBeanLocal;

import dao.Entity.RelationshipEntity;
import dao.Entity.UserEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
@Local
public interface RelationshipSessionBeanLocal {
    public void save(RelationshipEntity r);
    public void update(RelationshipEntity r);
    public void delete(RelationshipEntity r);
    
    public RelationshipEntity find(UserEntity user, UserEntity friend);
    public List<RelationshipEntity> findAll();
}
