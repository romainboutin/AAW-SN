/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Moi
 */
@Entity
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String mail;
    
    @Column
    private String mdp;
    /*
    private List<String> amis;
    
    private List<String> demmandeAmis;
    
    private List<String> attenteConfiramtion;
*/
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
/*
    public List<String> getAmis() {
        return amis;
    }

    public void setAmis(List<String> amis) {
        this.amis = amis;
    }

    public List<String> getDemmandeAmis() {
        return demmandeAmis;
    }

    public void setDemmandeAmis(List<String> demmandeAmis) {
        this.demmandeAmis = demmandeAmis;
    }

    public List<String> getAttenteConfiramtion() {
        return attenteConfiramtion;
    }

    public void setAttenteConfiramtion(List<String> attenteConfiramtion) {
        this.attenteConfiramtion = attenteConfiramtion;
    } 
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mail != null ? mail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.mail == null && other.mail != null) || (this.mail != null && !this.mail.equals(other.mail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.UserEntity[ mail=" + mail + " ]";
    }
    
    /*
    public void addAmis(UserEntity u){
        this.amis.add(u);
    }
    
    public void removeAmis(UserEntity u){
        this.amis.remove(u);
    }
    */
}
