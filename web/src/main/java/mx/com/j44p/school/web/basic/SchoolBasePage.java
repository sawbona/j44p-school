/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.web.basic;

import org.apache.log4j.Logger;
import mx.com.j44p.school.modelo.mapped.Usuario;
import mx.com.j44p.school.web.Home;
import mx.com.j44p.school.web.secure.AdministraUsuarios;
import mx.com.j44p.school.web.secure.Evalua;
import mx.com.j44p.school.web.secure.UsuarioHome;
import org.apache.tapestry.IPage;
import org.apache.tapestry.annotations.InjectPage;
import org.apache.tapestry.event.PageDetachListener;
import org.apache.tapestry.event.PageEvent;
import org.apache.tapestry.html.BasePage;

/**
 * Clase basica para la aplicacion. Debera tener los estilos para ser manejados por cada una de las
 * paginas que conforman la aplicacion.
 * No se debe tener un usuario asociado para poder visualizar una pagina de este estilo
 * @author jaap
 */
public abstract class SchoolBasePage extends BasePage implements PageDetachListener {
    
    /**
     * Logger de la clase.
     */
    private static Logger logger;
    
    /**
     * Referencia a la pagina Home
     * @return Una referencia a la pagina Home.
     */
    @InjectPage("Home")
    public abstract Home getHomePage();

    /**
     * Referencia a la pagina de evaluacion.
     * @return Una referencia a la pagina.
     */
    @InjectPage("secure/Evalua")
    public abstract Evalua getEvaluaPage();
    
    /**
     * Referencia a la pagina de administracion de usuarios.
     * @return Una referencia a la pagina.
     */
    @InjectPage("secure/AdministraUsuarios")
    public abstract AdministraUsuarios getAdministraUsuariosPage();
 
    /**
     * Referencia a la pgina Home del Usuario.
     * @return Referencia al Home del usuario.
     */
    @InjectPage("secure/UsuarioHome")
    public abstract UsuarioHome getUsuarioHomePage();
    
    /**
     * El usuario asoociado a todo el sistema.
     */
    private Usuario usuario;
    
    /**
     * Obtiene el usuario de la aplicacion..
     * @return El usuario de la aplicacion.
     */
    public Usuario getUsuario(){
        return usuario;
    }
    
    /**
     * Fija el usuario a la aplicacion.
     * @param usuario El nuevo usuario de la aplicacion.
     */
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    /**
     * Metodo llamado cuando la pagina regresa al pool de tapestry.
     * @param pageEvent
     */
    @Override
    public void pageDetached(PageEvent pageEvent) {
    }
    
    /**
     * Metodo llamado cuando se preciosa el link Home en la pagina html.
     * @return Una referencia a la pagina Home
     */
    public IPage onHomeDirectLink(){
        Home home = getHomePage();
        if(getUsuario() == null){
            logger.debug("El usuario en la pagina es nulo: ");
        }
        home.setUsername(getUsuario().getUsername());
        home.setUsuario(getUsuario());
        return home;
    }
    
    /**
     * Metodo llamado cuando se preciosa el link Home en la pagina html.
     * @return Una referencia a la pagina Home
     */
    public IPage onEvaluaDirectLink(){
        Evalua evalua = getEvaluaPage();
        if(getUsuario() == null){
            logger.debug("El usuario en la pagina es nulo: ");
        }
        evalua.setUsuario(getUsuario());
        return evalua;
    }
    
    /**
            System.out.println("El usuario en la pagina es nulo: ");
     * Link ejecutado cuando se da click en el link de administracion.
     * @return La pagina de administracion.
     */
    public IPage onAdministraUsuariosDirectLink(){
        AdministraUsuarios administraUsuarios = getAdministraUsuariosPage();
        if(getUsuario() == null){
            logger.debug("El usuario en la pagina es nulo: ");
        }
        administraUsuarios.setUsuario(getUsuario());
        return administraUsuarios;
    }
    
    /**
     * Link ejecutado cuando se da click en el link de home para el usuario.
     * @return La pagina home del usuario.
     */
    public IPage onUsuarioHomeDirectLink(){
        UsuarioHome usuarioHome = getUsuarioHomePage();
        if(getUsuario() == null){
            logger.debug("El usuario en la pagina es nulo: ");
            System.out.println("El usuario en la pagina es nulo: ");
        }
        usuarioHome.setUsuario(getUsuario());
        return usuarioHome;
    }
    
    /**
     * Link para cuando se sale de la aplicacion.
     * @return Referencia a la pagina de Home ya sin usuario.
     */
    public IPage onLogoutDirectLink(){
        Home home = getHomePage();
        home.setUsuario(null);
        home.setUsername(null);
        return home;
    }
}