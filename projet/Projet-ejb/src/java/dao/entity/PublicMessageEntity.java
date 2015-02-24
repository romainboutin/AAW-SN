/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Moi
 */
@Entity
@DiscriminatorValue("PublicMessage")
public class PublicMessageEntity extends MessageEntity{  
    
    public PublicMessageEntity(){
        
    }
    
    public PublicMessageEntity(UserEntity from, String msg, MsgEnum type){
        this.setFrom(from);
        this.setMsg(msg);
        this.setType(type);
        this.setDate(new Date());
    }
}
