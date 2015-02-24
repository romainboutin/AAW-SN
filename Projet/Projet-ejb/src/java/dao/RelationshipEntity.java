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
public class RelationshipEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //========================================================================//
    //== PROPERTIES ==========================================================//
    //========================================================================//
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private Long userId1;
    
    @Column
    private Long userId2;
    
    @Column
    private RelationshipStatusEnum relationshipStatusEnum;
    
    //========================================================================//
    //== CONSTRUCTORS ========================================================//
    //========================================================================//
    public RelationshipEntity() {
        userId1 = null;
        userId2 = null;
        relationshipStatusEnum = null;
    }
    
    public RelationshipEntity( Long userId1, Long userId2, RelationshipStatusEnum relationshipStatusEnum ) {
        userId1 = userId1;
        userId2 = userId2;
        relationshipStatusEnum = relationshipStatusEnum;
    }
    
    public RelationshipEntity( UserEntity user1, UserEntity user2, RelationshipStatusEnum relationshipStatusEnum ) {
        userId1 = user1.getId();
        userId2 = user2.getId();
        relationshipStatusEnum = relationshipStatusEnum;
    }
    
    //========================================================================//
    //== GETTERS AND SETTERS =================================================//
    //========================================================================//
    public Long getId() {
        return id;
    }

    public Long getUserId1() {
        return userId1;
    }

    public void setUserId1(Long userId1) {
        this.userId1 = userId1;
    }

    public Long getUserId2() {
        return userId2;
    }

    public void setUserId2(Long userId2) {
        this.userId2 = userId2;
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
