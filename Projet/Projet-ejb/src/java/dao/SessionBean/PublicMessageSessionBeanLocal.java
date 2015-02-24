/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.SessionBean;

import dao.Entities.PublicMessageEntity;
import dao.Entities.UserEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author William
 */
@Local
public interface PublicMessageSessionBeanLocal {
    public void save(PublicMessageEntity pm);
    public void update(PublicMessageEntity pm);
    public void delete(PublicMessageEntity pm);
    
    public List<PublicMessageEntity> findByUser(UserEntity u);
}
