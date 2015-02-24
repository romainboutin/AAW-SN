/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Bean;

import Service.BeanLocal.UserServiceBeanLocal;
import dao.Entities.UserEntity;
import dao.SessionBeanLocal.UserSessionBeanLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Moi
 */
@Stateless
public class UserServiceBean implements UserServiceBeanLocal{

    private UserEntity user;
    
    @EJB
    private UserSessionBeanLocal usbl;

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
    
  
    
}
