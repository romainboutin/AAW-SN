/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Bean;

import Service.BeanLocal.UserServiceBeanLocal;
import dao.Entity.UserEntity;
import dao.SessionBeanLocal.RelationshipSessionBeanLocal;
import dao.SessionBeanLocal.UserSessionBeanLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Moi
 */
@Stateless
public class UserServiceBean implements UserServiceBeanLocal{

    private UserEntity user;
    private List<UserEntity> users;
    
    @EJB
    private UserSessionBeanLocal usbl;
    
    @EJB
    private RelationshipSessionBeanLocal rsbl;

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
    public List<UserEntity> findMyFriend(UserEntity u) {
        //rsbl.getAllFriends(u);
        return null;
    }
    
  
    
}
