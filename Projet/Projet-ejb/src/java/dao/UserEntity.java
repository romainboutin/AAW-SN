/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
@Entity
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //========================================================================//
    //== PROPERTIES ==========================================================//
    //========================================================================//
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    
    @Column
    private String _login;

    @Column
    private String _password;
    
    @Column
    private String _mail;

    @Column
    private String _firstname;

    @Column
    private String _lastname;

    //========================================================================//
    //== CONSTRUCTORS ========================================================//
    //========================================================================//
    public UserEntity() {
        _login = null;
        _password = null;
        _mail = null;
        _firstname = null;
        _lastname = null;
    }
    
    public UserEntity(String login, String password, String mail) {
        _login = login;
        _password = password;
        _mail = mail;
    }
    
    //========================================================================//
    //== GETTERS AND SETTERS =================================================//
    //========================================================================//
    public Long getId() {
        return _id;
    }
    
    public String getLogin() {
        return _login;
    }
    
    public void setLogin(String login) {
        _login = login;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        this._password = password;
    }
    
    public String getMail() {
        return _mail;
    }

    public void setMail(String mail) {
        this._mail = mail;
    }

    public String getFirstname() {
        return _firstname;
    }

    public void setFirstname(String firstname) {
        this._firstname = firstname;
    }

    public String getLastname() {
        return _lastname;
    }

    public void setLastname(String lastname) {
        this._lastname = lastname;
    }

    //========================================================================//
    //== CLASS METHODS =======================================================//
    //========================================================================//
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (_id != null ? _id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the _id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.UserEntity[ id=" + _id + " ]";
    }
}
