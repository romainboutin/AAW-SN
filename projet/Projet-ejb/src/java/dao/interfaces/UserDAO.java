/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import dao.entity.UserEntity;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
public interface UserDAO {
    public void save(UserEntity u);
    public void update(UserEntity u);
    public void delete(UserEntity u);
    public UserEntity findByMail(String mail);
}
