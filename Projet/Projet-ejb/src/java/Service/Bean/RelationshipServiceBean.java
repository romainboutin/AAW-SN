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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author William
 */
@Stateless
public class RelationshipServiceBean implements RelationshipServiceBeanLocal {
    
    private RelationshipEntity re1;
    private RelationshipEntity re2;
    
    @EJB
    private RelationshipSessionBeanLocal rsbl;

    @Override
    public void addFriend(UserEntity user, UserEntity friendToAdd) {
        re1 = new RelationshipEntity();
        re1.setUserId1(user);
        re1.setUserId2(friendToAdd);
        re1.setRelationshipStatusEnum(RelationshipStatusEnum.PENDING);
        
        re2 = new RelationshipEntity();
        re2.setUserId2(user);
        re2.setUserId1(friendToAdd);
        re2.setRelationshipStatusEnum(RelationshipStatusEnum.PENDING);
        rsbl.save(re1);
        rsbl.save(re2);
    }

    @Override
    public void addRelationship(UserEntity user, UserEntity friend, RelationshipStatusEnum relationshipStatus) {
        re1 = new RelationshipEntity();
        re1.setUserId1(user);
        re1.setUserId2(friend);
        re1.setRelationshipStatusEnum(relationshipStatus);
        
        re2 = new RelationshipEntity();
        re2.setUserId2(user);
        re2.setUserId1(friend);
        re2.setRelationshipStatusEnum(relationshipStatus);
        
        rsbl.save(re1);
        rsbl.save(re2);
    }

 

    @Override
    public void setRelationAccepted(UserEntity user, UserEntity friend) {
        List<RelationshipEntity> listRelationship = user.getRelationships();
        for(RelationshipEntity re : listRelationship) {
            if(re.getUserId2().equals(friend) && re.getUserId1().equals(user) || re.getUserId1().equals(friend) && re.getUserId2().equals(user)) {
                re.setRelationshipStatusEnum(RelationshipStatusEnum.ACCEPTED);
                rsbl.update(re);
            }
        }
       
    }


    @Override
    public List<RelationshipEntity> getAllRelationship(UserEntity user) {
        return user.getRelationships();
    }

    @Override
    public List<UserEntity> getAllFriends(UserEntity user) {
        List<UserEntity> friends = new ArrayList<>();
        List<RelationshipEntity> relationships = user.getRelationships();
        for(RelationshipEntity relationship : relationships) {
            if(relationship.getRelationshipStatusEnum().equals(RelationshipStatusEnum.ACCEPTED)) {
                if(user.equals(relationship.getUserId1()))
                    friends.add(relationship.getUserId2());
                else
                    friends.add(relationship.getUserId1());
            }
        }
        return friends;
    }

    @Override
    public void setRelationPending(UserEntity user, UserEntity friend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRelationDeclined(UserEntity user, UserEntity friend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRelationBlocked(UserEntity user, UserEntity friend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
