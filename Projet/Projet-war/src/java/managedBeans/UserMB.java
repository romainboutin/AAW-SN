/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import services.UserService;

/**
 *
 * @author Moi
 */
@ManagedBean(name = "UserMB")
@SessionScoped
public class UserMB {

    @EJB 
    UserService us;
    
    private String mail;
    private String mdp;
    private String firstname;
    private String lastname;

    /**
     * Creates a new instance of UserMB
     */
    public UserMB() {
    }
    
    public String login(){
        if(this.mail.equals("ok"))
            return "home.xhtml";
        else 
            return "index.xhtml";
    }

    public String newAccount(){
        return "account.xhtml";
    }
    
    public String create(){        
        
        us.newUser(mail, lastname, mail, firstname, lastname);
        return "home.xhtml";
    }
    
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
    
    
}
