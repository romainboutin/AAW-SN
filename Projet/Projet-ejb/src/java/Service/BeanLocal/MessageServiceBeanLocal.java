/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.BeanLocal;

import dao.Entity.MessageEntity.MsgEnum;
import dao.Entity.UserEntity;
import javax.ejb.Local;

/**
 *
 * @author Moi
 */
@Local
public interface MessageServiceBeanLocal {
    public void PublicMessage(UserEntity u, String txt, MsgEnum e);
    public void PrivateMessage(UserEntity from, UserEntity to, String txt, MsgEnum e);
}
