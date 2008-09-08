/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.web;

import org.apache.tapestry.html.BasePage;
import org.apache.tapestry.annotations.InitialValue;

/**
 *
 * @author jaap
 */
public abstract class Home extends BasePage{

    @InitialValue(value="literal:nombre de usuario")
    public abstract String getUsername();
    
    public abstract String getPassword();
    
    /**
     * Listener de la pagina home.
     * @param cycle
     */
    public String onInicia(){
        return "Evalua";
    }
}
