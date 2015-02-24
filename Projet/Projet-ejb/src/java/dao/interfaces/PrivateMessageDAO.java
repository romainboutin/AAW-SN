/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import dao.entity.PrivateMessageEntity;
import dao.entity.UserEntity;
import java.util.List;

/**
 *
 * @author Moi
 */
public interface PrivateMessageDAO {
    
    public void save(PrivateMessageEntity pm);
    public void update(PrivateMessageEntity pm);
    public void delete(PrivateMessageEntity pm);
    
    public List<PrivateMessageEntity> findByDiscus(UserEntity from, UserEntity to);
}
