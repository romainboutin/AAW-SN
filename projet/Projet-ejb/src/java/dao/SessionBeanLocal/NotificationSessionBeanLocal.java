/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.SessionBeanLocal;

import dao.entity.NotificationEntity;
import javax.ejb.Local;

/**
 *
 * @author William
 */
@Local
public interface NotificationSessionBeanLocal {
    public void save(NotificationEntity n);
    public void update(NotificationEntity n);
    public void delete(NotificationEntity n);
}
