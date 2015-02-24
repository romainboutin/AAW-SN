/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Service.BeanLocal.MessageServiceBeanLocal;
import Service.BeanLocal.UserServiceBeanLocal;
import dao.Entity.MessageEntity;
import dao.Entity.UserEntity;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Moi
 */
@ManagedBean(name = "UserMB")
@SessionScoped
public class UserMB {

    @EJB
    UserServiceBeanLocal us;
    private UserEntity u;
    
    @EJB                 
    MessageServiceBeanLocal msbl;
    
      
    private UserEntity user;
    private String mail;
    private String mdp;
    private String firstname;
    private String lastname;
    
    //message
    private String text;  

    /**
     * Creates a new instance of UserMB
     */
    public UserMB() {
    }
    
    public String login(){
        this.user = us.connect(mail,mdp);
        if(user != null){
            this.mail = user.getMail();
            this.firstname = user.getFirstname();
            this.lastname = user.getLastname();
            return "home.xhtml";
        }
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
    
    public String addFriends(UserEntity f){
        //
        return "";
    }
    
    public String logout(){
        user = null;
        mail = "";
        mdp = "";
        firstname = "";
        lastname = "";
        return "index.xhtml";
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
        
    public String postText(){        
        msbl.PublicMessageText(this.user, this.text, MessageEntity.MsgEnum.TEXT);
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

    public UserServiceBeanLocal getUs() {
        return us;
    }

    public void setUs(UserServiceBeanLocal usbl) {
        this.us = usbl;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public MessageServiceBeanLocal getMs() {
        return msbl;
    }

    public void setMs(MessageServiceBeanLocal msbl) {
        this.msbl = msbl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
