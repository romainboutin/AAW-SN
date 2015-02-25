/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.BeanLocal;

import dao.Entity.RelationshipEntity;
import dao.Entity.UserEntity;
import dao.Utils.RelationshipStatusEnum;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
@Local
public interface RelationshipServiceBeanLocal {
    public void addFriend(UserEntity user, UserEntity friendToAdd);
    public void addRelationship(UserEntity user, UserEntity friend, RelationshipStatusEnum relationshipStatus);
    public void setRelationPending(UserEntity user, UserEntity friend);
    public void setRelationAccepted(UserEntity user, UserEntity friend);
    public void setRelationDeclined(UserEntity user, UserEntity friend);
    public void setRelationBlocked(UserEntity user, UserEntity friend);
    public List<RelationshipEntity> getAllRelationship(UserEntity user);
    public List<UserEntity> getAllFriends(UserEntity user);
}
