/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Bean;

import Service.BeanLocal.RelationshipServiceBeanLocal;
import dao.Entity.UserEntity;
import dao.Entity.RelationshipEntity;
import dao.SessionBeanLocal.RelationshipSessionBeanLocal;
import dao.Utils.RelationshipStatusEnum;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author William
 */
@Stateless
public class RelationshipServiceBean implements RelationshipServiceBeanLocal {
    
    private RelationshipEntity re;
    
    @EJB
    private RelationshipSessionBeanLocal rsbl;

    @Override
    public void addFriend(UserEntity user, UserEntity friendToAdd) {
        re = new RelationshipEntity();
        re.setUserId1(user);
        re.setUserId2(friendToAdd);
        re.setRelationshipStatusEnum(RelationshipStatusEnum.PENDING);
        rsbl.save(re);
    }

    @Override
    public void addRelationship(UserEntity user, UserEntity friend, RelationshipStatusEnum relationshipStatus) {
        re = new RelationshipEntity();
        re.setUserId1(user);
        re.setUserId2(friend);
        re.setRelationshipStatusEnum(relationshipStatus);
        rsbl.save(re);
    }

    @Override
    public void setRelationPending(UserEntity user, UserEntity friend) {
        List<RelationshipEntity> listRelationship = user.getRelationships();
        for(RelationshipEntity re : listRelationship) {
            if(re.getUserId2().equals(friend)) {
                re.setRelationshipStatusEnum(RelationshipStatusEnum.PENDING);
            }
        }
    }

    @Override
    public void setRelationAccepted(UserEntity user, UserEntity friend) {
        List<RelationshipEntity> listRelationship = user.getRelationships();
        for(RelationshipEntity re : listRelationship) {
            if(re.getUserId2().equals(friend)) {
                re.setRelationshipStatusEnum(RelationshipStatusEnum.ACCEPTED);
            }
        }
    }

    @Override
    public void setRelationDeclined(UserEntity user, UserEntity friend) {
        List<RelationshipEntity> listRelationship = user.getRelationships();
        for(RelationshipEntity re : listRelationship) {
            if(re.getUserId2().equals(friend)) {
                re.setRelationshipStatusEnum(RelationshipStatusEnum.DECLINED);
            }
        }
    }

    @Override
    public void setRelationBlocked(UserEntity user, UserEntity friend) {
        List<RelationshipEntity> listRelationship = user.getRelationships();
        for(RelationshipEntity re : listRelationship) {
            if(re.getUserId2().equals(friend)) {
                re.setRelationshipStatusEnum(RelationshipStatusEnum.BLOCKED);
            }
        }
    }
    
}
