/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.SessionBeanLocal;

import dao.entity.UserEntity;
import javax.ejb.Local;

/**
 *
 * @author William
 */
@Local
public interface UserSessionBeanLocal {
    public void save(UserEntity u);
    public void update(UserEntity u);
    public void delete(UserEntity u);
    
    public UserEntity findByMail(String mail);
}
