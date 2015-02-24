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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
@Entity
public class RelationshipEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //========================================================================//
    //== PROPERTIES ==========================================================//
    //========================================================================//
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    @JoinColumn(name="user_fk1")
    private UserEntity user1;
    
    @OneToOne
    @JoinColumn(name="user_fk2")
    private UserEntity user2;
    
    @Column
    private RelationshipStatusEnum relationshipStatusEnum;
    
    //========================================================================//
    //== CONSTRUCTORS ========================================================//
    //========================================================================//
    public RelationshipEntity() {
        this.user1 = null;
        this.user2 = null;
        this.relationshipStatusEnum = null;
    }
    
    public RelationshipEntity( UserEntity user1, UserEntity user2, RelationshipStatusEnum relationshipStatusEnum ) {
        this.user1 = user1;
        this.user2 = user2;
        this.relationshipStatusEnum = relationshipStatusEnum;
    }
    
    //========================================================================//
    //== GETTERS AND SETTERS =================================================//
    //========================================================================//
    public Long getId() {
        return id;
    }

    public UserEntity getUserId1() {
        return user1;
    }

    public void setUserId1(UserEntity user1) {
        this.user1 = user1;
    }

    public UserEntity getUserId2() {
        return user2;
    }

    public void setUserId2(UserEntity user2) {
        this.user2 = user2;
    }

    public RelationshipStatusEnum getRelationshipStatusEnum() {
        return relationshipStatusEnum;
    }

    public void setRelationshipStatusEnum(RelationshipStatusEnum relationshipStatusEnum) {
        this.relationshipStatusEnum = relationshipStatusEnum;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelationshipEntity)) {
            return false;
        }
        RelationshipEntity other = (RelationshipEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.FriendEntity[ id=" + id + " ]";
    }
    
}
