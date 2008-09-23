/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.web.secure.basic;

import java.util.List;
import mx.com.j44p.school.modelo.mapped.Permiso;
import mx.com.j44p.school.modelo.mapped.Usuario;
import mx.com.j44p.school.web.Home;
import mx.com.j44p.school.web.basic.SchoolBasePage;
import org.apache.tapestry.PageRedirectException;
import org.apache.tapestry.annotations.InjectPage;

/**
 * Una pagina segura que debe tener un usuario asociado para poder ser visualizada.
 * @author jaap
 */
public abstract class SecureBasePage extends SchoolBasePage{

    /**
     * Referencia a la pagina Home
     * @return Una referencia a la pagina Home.
     */
    @InjectPage("Home")
    public abstract Home getHomePage();
    
    /**
     * Metodo que todas las paginas seguras deben implementar.
     * @param usuario El usuario del que comprobaran sus permisos.
     * @return Un booleano que indica si el usuario tiene los permisos adecuados para visualizar
     * la pagina.
     */
    public abstract boolean isUserInRole(Usuario usuario);

    /**
     * Obtiene la lista de permisos aceptada por una pagina.
     * @return Una lista de permisos aceptada por la pagina.
     */
    public abstract List<Permiso> getPermisos();
    
    /**
     * Las paginas deben poder agregar un permiso a su lista de permisos.
     * @param permiso El nuevo permiso que una pagina puede aceptar.
     */
    public final void addPermiso(Permiso permiso){
        getPermisos().add(permiso);
    }
    
    /**
     * Remueve un permiso de la lista aceptada de permisos.
     * @param permiso El permiso a eliminar.
     */
    public final void removePermiso(Permiso permiso){
        getPermisos().remove(permiso);
    }
    
    /**
     * Las posteriores llamadas para hacer render de esta pagina se manda a llamar a este metodo.
     * {@inheritsDoc}
     */
    @Override
    public void beginPageRender() {
        if(!isUserInRole(getUsuario())){
            throw new PageRedirectException(getHomePage());
        }
        super.beginPageRender();
    }

    /**
     * La primera vez que hace render de la pagina se manda a llamar a este metodo.
     * {@inheritsDoc}
     */    
    @Override
    protected void firePageBeginRender() {
        if(!isUserInRole(getUsuario())){
            throw new PageRedirectException(getHomePage());
        }
        super.firePageBeginRender();
    }
}
