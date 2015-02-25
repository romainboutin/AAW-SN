/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Bean;

import Service.BeanLocal.NotificationServiceBeanLocal;
import dao.Entity.NotificationEntity;
import dao.Entity.UserEntity;
import dao.SessionBeanLocal.NotificationSessionBeanLocal;
import dao.Utils.NotificationTypeEnum;
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
    private NotificationSessionBeanLocal nsbl;

    @Override
    public void addNotification(UserEntity user, UserEntity friend, NotificationTypeEnum notifType, String notifText) {
        ne = new NotificationEntity(user, friend, notifType, notifText);
        nsbl.save(ne);
    }

    @Override
    public List<NotificationEntity> getAllNotification(UserEntity user) {
        return user.getNotifications();
    }
}


