/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Moi
 */
@Entity
@DiscriminatorValue("PrivateMessage")
public class PrivateMessageEntity extends MessageEntity {
  
    public PrivateMessageEntity(){
        
    }
    
}
