/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Bean;

import Service.BeanLocal.MessageServiceBeanLocal;
import dao.Entity.MessageEntity;
import dao.Entity.PublicMessageEntity;
import dao.Entity.UserEntity;
import dao.SessionBeanLocal.PublicMessageSessionBeanLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Moi
 */
@Stateless
public class MessageServiceBean implements MessageServiceBeanLocal{
    
    private PublicMessageEntity pm;
    
    @EJB
    private PublicMessageSessionBeanLocal pmsbl;

    @Override
    public void PublicMessage(UserEntity u, String txt, MessageEntity.MsgEnum e) {
       pm =  new PublicMessageEntity(u, txt, e);
       pmsbl.save(pm);
    }
}
