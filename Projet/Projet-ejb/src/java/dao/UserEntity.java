/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    private Long id;
    
    @Column
    private String login;

    @Column
    private String password;
    
    @Column
    private String mail;

    @Column
    private String firstname;

    @Column
    private String lastname;
    
    @OneToMany
    private List<RelationshipEntity> relationships;

    //========================================================================//
    //== CONSTRUCTORS ========================================================//
    //========================================================================//
    public UserEntity() {
        this.login = "";
        this.password = "";
        this.mail = "";
        this.firstname = "";
        this.lastname = "";
        this.relationships = new ArrayList<>();
    }
    
    public UserEntity(String login, String password, String mail) {
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.firstname = "";
        this.lastname = "";
        this.relationships = new ArrayList<>();
    }
    
    public UserEntity(String login, String password, String mail, String firstname, String lastname) {
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.firstname = firstname;
        this.lastname = lastname;
        this.relationships = new ArrayList<>();
    }
    
    //========================================================================//
    //== GETTERS AND SETTERS =================================================//
    //========================================================================//
    public Long getId() {
        return id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public List<RelationshipEntity> getRelationships() {
        return this.relationships;
    }
    
    public void setRelationship(List<RelationshipEntity> relationships) {
        this.relationships = relationships;
    }
    
    public boolean addRelationship(RelationshipEntity relationship) {
        return this.relationships.add(relationship);
    }
    
    public boolean removeRelationship(RelationshipEntity relationship) {
        return this.relationships.remove(relationship);
    }

    //========================================================================//
    //== CLASS METHODS =======================================================//
    //========================================================================//
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the _id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.UserEntity[ id=" + id + " ]";
    }
}
