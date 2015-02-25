/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Entity;

import dao.Utils.NotificationTypeEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
@Entity
@Table(name = "T_NOTIFICATION")
public class NotificationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //========================================================================//
    //== PROPERTIES ==========================================================//
    //========================================================================//
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_fk")
    private UserEntity user;
    
    @OneToOne
    @JoinColumn(name = "friend_user_fk")
    private UserEntity friend;
    
    @Column
    private NotificationTypeEnum notifType;
    
    @Column
    private String notifText;
    
    @Column
    private boolean read;

    //========================================================================//
    //== CONSTRUCTORS ========================================================//
    //========================================================================//
    public NotificationEntity() {
        this.user = null;
        this.friend = null;
        this.notifType = null;
        this.notifText = "";
        this.read = false;
    }
    
    public NotificationEntity(UserEntity user, UserEntity friend, NotificationTypeEnum notifType, String notifText) {
        this.user = user;
        this.friend = friend;
        this.notifType = notifType;
        this.notifText = notifText;
        this.read = false;
    }
    
    //========================================================================//
    //== GETTERS AND SETTERS =================================================//
    //========================================================================//
    public Long getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserEntity getFriend() {
        return friend;
    }

    public void setFriend(UserEntity friend) {
        this.friend = friend;
    }

    public NotificationTypeEnum getNotifType() {
        return notifType;
    }

    public void setNotifType(NotificationTypeEnum notifType) {
        this.notifType = notifType;
    }

    public String getNotifText() {
        return notifText;
    }

    public void setNotifText(String notifText) {
        this.notifText = notifText;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
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
        if (!(object instanceof NotificationEntity)) {
            return false;
        }
        NotificationEntity other = (NotificationEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.UpdateEntity[ id=" + id + " ]";
    }
}


