/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.entity.MessageEntity.MsgEnum;
import dao.entity.UserEntity;
import javax.ejb.Local;

/**
 *
 * @author Moi
 */
@Local
public interface MessageService {
    public void PublicMessageText(UserEntity u, String txt, MsgEnum e);
}
