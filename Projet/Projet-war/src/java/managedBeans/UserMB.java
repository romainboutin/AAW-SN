/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Service.BeanLocal.MessageServiceBeanLocal;
import Service.BeanLocal.RelationshipServiceBeanLocal;
import Service.BeanLocal.UserServiceBeanLocal;
import dao.Entity.MessageEntity;
import dao.Entity.PublicMessageEntity;
import dao.Entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
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
    UserServiceBeanLocal usbl;
    
    @EJB                 
    MessageServiceBeanLocal msbl;
    
    @EJB                 
    RelationshipServiceBeanLocal rsbl;
    
    private List<PublicMessageEntity> publicMessages;
    private List<UserEntity> search;
    private List<UserEntity> friends;
    
    private UserEntity user;
    private String mail;
    private String mdp;
    private String firstname;
    private String lastname;
    
    private String searchtext;
    
    //message
    private String text;  
    private String videoText;  
    private String imgText;   
    private String linkText;  

    /**
     * Creates a new instance of UserMB
     */
    public UserMB() {
    }
    
    public String login(){
        this.user = usbl.connect(mail,mdp);
           
        if(user != null){
            this.publicMessages = usbl.getWall(user);
            this.mail = user.getMail();
            this.firstname = user.getFirstname();
            this.lastname = user.getLastname();
            return "home.xhtml";
        }
        else 
            return "index.xhtml";
    }
    
    public void init(){
        //test user !=null
        this.user = usbl.reload(mail);
        this.publicMessages = usbl.getWall(user);
    }

    public String newAccount(){
        return "account.xhtml";
    }
    
    public String create(){    
        usbl.newUser(mail, mdp, mail, firstname, lastname);
        return "home.xhtml";
    }
    
    public String friends(){
        this.friends = rsbl.getAllFriends(user);
        return "friends.xhtml";
    }
      
    public String find(){
        this.search = usbl.find(searchtext);
        return "find.xhtml";
    }
        
    public String addFriends(UserEntity f){
        rsbl.addFriend(user, f);
        return "home.xhtml";
    }
    
    public String pm(UserEntity f){
        return "privatemessage.xhtml";
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
        msbl.PublicMessage(this.user, this.text, MessageEntity.MsgEnum.TEXT);
        this.text="";
        return "home.xhtml";
    }
    
    public String postVideo(){        
        msbl.PublicMessage(this.user, this.videoText, MessageEntity.MsgEnum.VIDEO);
        this.videoText="";
        return "home.xhtml";
    }
    
    public String postLink(){        
        msbl.PublicMessage(this.user, this.linkText, MessageEntity.MsgEnum.LINK);
        this.linkText="";
        return "home.xhtml";
    }
    
    public String postImg(){        
        msbl.PublicMessage(this.user, this.imgText, MessageEntity.MsgEnum.PICTURE);
        this.imgText="";
        return "home.xhtml";
    }
    
    //////////////////////////////////////////////////////////////////////////////
    
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
        return usbl;
    }

    public void setUs(UserServiceBeanLocal usbl) {
        this.usbl = usbl;
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

    public String getVideoText() {
        return videoText;
    }

    public void setVideoText(String videoText) {
        this.videoText = videoText;
    }

    public String getImgText() {
        return imgText;
    }

    public void setImgText(String imgText) {
        this.imgText = imgText;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public List<UserEntity> getSearch() {
        return search;
    }

    public void setSearch(List<UserEntity> search) {
        this.search = search;
    }

    public String getSearchtext() {
        return searchtext;
    }

    public void setSearchtext(String searchtext) {
        this.searchtext = searchtext;
    }

    public RelationshipServiceBeanLocal getRsbl() {
        return rsbl;
    }

    public void setRsbl(RelationshipServiceBeanLocal rsbl) {
        this.rsbl = rsbl;
    }

    public List<UserEntity> getFriends() {
        return friends;
    }

    public void setFriends(List<UserEntity> friends) {
        this.friends = friends;
    }

    
    public UserServiceBeanLocal getUsbl() {
        return usbl;
    }

    public void setUsbl(UserServiceBeanLocal usbl) {
        this.usbl = usbl;
    }

    public MessageServiceBeanLocal getMsbl() {
        return msbl;
    }

    public void setMsbl(MessageServiceBeanLocal msbl) {
        this.msbl = msbl;
    }

    public List<PublicMessageEntity> getPublicMessages() {
        return publicMessages;
    }

    public void setPublicMessages(List<PublicMessageEntity> publicMessages) {
        this.publicMessages = publicMessages;
    }
    
    
    
}
