/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Bean;

import Service.BeanLocal.MessageServiceBeanLocal;
import dao.Entity.MessageEntity;
import dao.Entity.PrivateMessageEntity;
import dao.Entity.PublicMessageEntity;
import dao.Entity.UserEntity;
import dao.SessionBeanLocal.PrivateMessageSessionBeanLocal;
import dao.SessionBeanLocal.PublicMessageSessionBeanLocal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
@Stateless
public class MessageServiceBean implements MessageServiceBeanLocal{
    
    private PublicMessageEntity pm;
    private PrivateMessageEntity pvm;
    
    @EJB
    private PublicMessageSessionBeanLocal pmsbl;
    
    @EJB
    private PrivateMessageSessionBeanLocal pvmsbl;

    @Override
    public void PublicMessage(UserEntity u, String txt, MessageEntity.MsgEnum e) {
       pm =  new PublicMessageEntity(u, txt, e);
       pmsbl.save(pm);
    }

    @Override
    public void PrivateMessage(UserEntity from, UserEntity to, String txt, MessageEntity.MsgEnum e) {
        pvm = new PrivateMessageEntity(from, to, txt, e);
        pvmsbl.save(pvm);
    }

    @Override
    public List<PrivateMessageEntity> getPM(UserEntity from, UserEntity to) {
        List<PrivateMessageEntity> pm = pvmsbl.findByDiscus(from, to);
        Collections.sort(pm, new Comparator<PrivateMessageEntity>(){ 
            @Override public int compare(PrivateMessageEntity o1, PrivateMessageEntity o2) { 
                return -(o1.getDate().compareTo(o2.getDate())); 
            } 
        });
        
        return pm;
    }
    
    
}
