/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import dao.entity.PublicMessageEntity;
import dao.entity.UserEntity;
import java.util.List;

/**
 *
 * @author Moi
 */
public interface PublicMessageDAO {
    public void save(PublicMessageEntity pm);
    public void update(PublicMessageEntity pm);
    public void delete(PublicMessageEntity pm);
    
    public List<PublicMessageEntity> findByUser(UserEntity u);
}
