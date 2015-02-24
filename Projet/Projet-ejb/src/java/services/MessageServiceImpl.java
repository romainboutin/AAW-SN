/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.entity.MessageEntity;
import dao.entity.PublicMessageEntity;
import dao.entity.UserEntity;
import dao.interfaces.PublicMessageDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Moi
 */
@Stateless
public class MessageServiceImpl implements MessageService{
    
    private PublicMessageEntity pm;
    
    @EJB
    private PublicMessageDAO pmd;

    @Override
    public void PublicMessageText(UserEntity u, String txt, MessageEntity.MsgEnum e) {
       pm =  new PublicMessageEntity(u, txt, e);
       pmd.save(pm);
    }
}
