/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.BeanLocal;

import dao.Entity.MessageEntity;
import dao.Entity.NotificationEntity;
import dao.Entity.UserEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author William
 */
@Local
public interface NotificationServiceBeanLocal {
    public void addNotification(UserEntity user, MessageEntity msg);
    public List<NotificationEntity> getAllNotification(UserEntity user);
}
