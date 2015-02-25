/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Entity;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Moi
 */
@Entity
@DiscriminatorValue("PrivateMessage")
public class PrivateMessageEntity extends MessageEntity {
  
    @ManyToOne
    @JoinColumn(name="userto_fk")
    private UserEntity to;
        
    public PrivateMessageEntity(){
        
    }
    
    public PrivateMessageEntity(UserEntity from, UserEntity to, String msg, MsgEnum type){
        this.setFrom(from);
        this.setMsg(msg);
        this.setType(type);
        this.setDate(new Date());
        this.to = to;
    }

    public UserEntity getTo() {
        return to;
    }

    public void setTo(UserEntity to) {
        this.to = to;
    }
}
