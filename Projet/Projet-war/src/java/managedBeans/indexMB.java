package managedBeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Moi
 */
@ManagedBean(name = "indexMB")
@SessionScoped
public class indexMB {

    private String mail;
    private String mdp;

    /**
     * Creates a new instance of indexMB
     */
    public indexMB() {
    }
    
    public String login(){
        if(this.mail.equals("ok"))
            return "home.xhtml";
        else 
            return "index.xhtml";
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
    
}
