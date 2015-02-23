package managedBeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Moi
 */
@ManagedBean(name = "indexMB")
@RequestScoped
public class indexMB {

    /**
     * Creates a new instance of indexMB
     */
    public indexMB() {
    }
    
    public String login(){
        return "home.xhtml";
    }
    
}
