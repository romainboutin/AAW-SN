/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Bean;

import Service.BeanLocal.NotificationServiceBeanLocal;
import dao.Entities.MessageEntity;
import dao.Entities.NotificationEntity;
import dao.Entities.UserEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author William
 */
@Stateless
public class NotificationServiceBean implements NotificationServiceBeanLocal {
    
    private NotificationEntity ne;
    
    @EJB
    private NotificationServiceBeanLocal nsbl;

    @Override
    public void addNotification(UserEntity user, MessageEntity msg) {
        ne = new NotificationEntity();
        //nsbl.save(ne);
    }

    @Override
    public List<NotificationEntity> getAllNotification(UserEntity user) {
        ne = new NotificationEntity();
        //nsbl.save(ne);
        return null;
    }
}


