/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import dao.Entity.UserEntity;
import dao.SessionBeanLocal.UserSessionBeanLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Moi
 */
@Stateless
public class UserServiceImpl implements UserService{

    private UserEntity user;
    
    @EJB
    private UserSessionBeanLocal usb;

    @Override
    public boolean newUser(String login, String password, String mail, String firstname, String lastname) {
        user = new UserEntity(login, password, mail, firstname, lastname);
        usb.save(user);
        return true;
    }

    @Override
    public UserEntity connect(String login, String password) {
        user = usb.findByMail(login);
        if(user != null){
            if(user.getPassword().equals(password))
                return user;
            else 
                return null;
        }
        else return null;
    }
    
  
    
}
