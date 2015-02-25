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
public interface UserSessionBeanLocal {
    public void save(UserEntity u);
    public void update(UserEntity u);
    public void delete(UserEntity u);
    
    public UserEntity findByMail(String mail);
    public List<UserEntity> findAll();
}
