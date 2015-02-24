/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.SessionBeanLocal;

import dao.Entities.PrivateMessageEntity;
import dao.Entities.UserEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author William
 */
@Local
public interface PrivateMessageSessionBeanLocal {
    public void save(PrivateMessageEntity pm);
    public void update(PrivateMessageEntity pm);
    public void delete(PrivateMessageEntity pm);
    
    public List<PrivateMessageEntity> findByDiscus(UserEntity from, UserEntity to);
}
