/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Bean;

import Service.BeanLocal.UserServiceBeanLocal;
import dao.Entity.MessageEntity;
import dao.Entity.PublicMessageEntity;
import dao.Entity.RelationshipEntity;
import dao.Entity.UserEntity;
import dao.SessionBeanLocal.RelationshipSessionBeanLocal;
import dao.SessionBeanLocal.UserSessionBeanLocal;
import dao.Utils.RelationshipStatusEnum;
import java.util.ArrayList;
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
public class UserServiceBean implements UserServiceBeanLocal{

    private UserEntity user;
    private List<UserEntity> users;
    
    @EJB
    private UserSessionBeanLocal usbl;
    
    @EJB
    private RelationshipSessionBeanLocal rusbl;
    
    @Override
    public boolean newUser(String login, String password, String mail, String firstname, String lastname) {
        user = new UserEntity(login, password, mail, firstname, lastname);
        usbl.save(user);
        return true;
    }

    @Override
    public UserEntity connect(String login, String password) {
        user = usbl.findByMail(login);
        if(user != null){
            if(user.getPassword().equals(password))
                return user;
            else 
                return null;
        }
        else return null;
    }

    @Override
    public UserEntity reload(String login) {
        user = usbl.findByMail(login);
        if(user != null)
            return user;
        else return null;
    }
    
    @Override
    public List<UserEntity> find(String str) {
         users = usbl.findAll();
         List <UserEntity> ff = new ArrayList<UserEntity>();
         if(users != null && !users.isEmpty()){
             for(UserEntity u : users){
                 if(u.getFirstname().contains(str) || u.getLastname().contains(str))
                     ff.add(u);
             }
         }
         return ff;
    }    

    @Override
    public List<PublicMessageEntity> getWall(UserEntity u) {
        List<PublicMessageEntity> wall = u.getPublicMsgList();
       
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
        for(UserEntity f : friends){
            wall.addAll(f.getPublicMsgList());
        }        
          
        Collections.sort(wall, new Comparator<PublicMessageEntity>(){ 
            @Override public int compare(PublicMessageEntity o1, PublicMessageEntity o2) { 
                return -(o1.getDate().compareTo(o2.getDate())); 
            } 
        });
        
        return wall;
    }
}


