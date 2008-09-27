/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.web.basic;

import mx.com.j44p.school.modelo.mapped.Usuario;
import org.apache.tapestry.html.BasePage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Clase basica para la aplicacion. Debera tener los estilos para ser manejados por cada una de las
 * paginas que conforman la aplicacion.
 * No se debe tener un usuario asociado para poder visualizar una pagina de este estilo
 * @author jaap
 */
public abstract class SchoolBasePage extends BasePage {

    private static String[] CONTEXTOS = new String[]{
        "schoolModeloApplicationContext.xml",
        "schoolModeloApplicationContext1.xml",
        };
            
    private static ApplicationContext WEB_CONTEXT = new ClassPathXmlApplicationContext(CONTEXTOS);
    
    protected ApplicationContext getApplicationContext(){
        return WEB_CONTEXT;
    }
    
    /**
     * El usuario asoociado a todo el sistema.
     */
    private Usuario usuario;
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}
