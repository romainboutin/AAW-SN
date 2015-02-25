/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.BeanLocal;

import dao.Entity.PublicMessageEntity;
import dao.Entity.UserEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
@Local
public interface UserServiceBeanLocal {    
    public boolean newUser(String login, String password, String mail, String firstname, String lastname);
    public UserEntity connect(String login, String password);
    public UserEntity reload(String login);
    public List<UserEntity> find(String str);
    public List<PublicMessageEntity> getWall(UserEntity u);
}
