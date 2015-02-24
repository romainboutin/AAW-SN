/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.BeanLocal;

import dao.Entities.UserEntity;
import dao.Utils.RelationshipStatusEnum;
import javax.ejb.Local;

/**
 *
 * @author William
 */
@Local
public interface RelationshipServiceBeanLocal {
    public void addFriend(UserEntity user, UserEntity friendToAdd);
    public void addRelationship(UserEntity user, UserEntity friend, RelationshipStatusEnum relationshipStatus);
    public void setRelationPending(UserEntity user, UserEntity friend);
    public void setRelationAccepted(UserEntity user, UserEntity friend);
    public void setRelationDeclined(UserEntity user, UserEntity friend);
    public void setRelationBlocked(UserEntity user, UserEntity friend);
}
