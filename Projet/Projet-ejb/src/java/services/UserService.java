/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Local;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
@Local
public interface UserService {    
    public boolean newUser(String login, String password, String mail, String firstname, String lastname);
}