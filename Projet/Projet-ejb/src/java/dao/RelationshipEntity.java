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
    private Long _id;
    
    @Column
    private Long _userId1;
    
    @Column
    private Long _userId2;
    
    @Column
    private RelationshipStatusEnum _relationshipStatusEnum;
    
    //========================================================================//
    //== CONSTRUCTORS ========================================================//
    //========================================================================//
    public RelationshipEntity() {
        _userId1 = null;
        _userId2 = null;
        _relationshipStatusEnum = null;
    }
    
    public RelationshipEntity( Long userId1, Long userId2, RelationshipStatusEnum relationshipStatusEnum ) {
        _userId1 = userId1;
        _userId2 = userId2;
        _relationshipStatusEnum = relationshipStatusEnum;
    }
    
    public RelationshipEntity( UserEntity user1, UserEntity user2, RelationshipStatusEnum relationshipStatusEnum ) {
        _userId1 = user1.getId();
        _userId2 = user2.getId();
        _relationshipStatusEnum = relationshipStatusEnum;
    }
    
    //========================================================================//
    //== GETTERS AND SETTERS =================================================//
    //========================================================================//
    public Long getId() {
        return _id;
    }

    public Long getUserId1() {
        return _userId1;
    }

    public void setUserId1(Long _userId1) {
        this._userId1 = _userId1;
    }

    public Long getUserId2() {
        return _userId2;
    }

    public void setUserId2(Long _userId2) {
        this._userId2 = _userId2;
    }

    public RelationshipStatusEnum getRelationshipStatusEnum() {
        return _relationshipStatusEnum;
    }

    public void setRelationshipStatusEnum(RelationshipStatusEnum _relationshipStatusEnum) {
        this._relationshipStatusEnum = _relationshipStatusEnum;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelationshipEntity)) {
            return false;
        }
        RelationshipEntity other = (RelationshipEntity) object;
        if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.FriendEntity[ id=" + _id + " ]";
    }
    
}
