/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.web.secure.basic;

import java.util.List;
import mx.com.j44p.school.modelo.enumeraciones.Permiso;
import mx.com.j44p.school.modelo.mapped.Usuario;
import mx.com.j44p.school.web.basic.SchoolBasePage;
import org.apache.tapestry.PageRedirectException;
import org.apache.tapestry.event.PageBeginRenderListener;
import org.apache.tapestry.event.PageEvent;

/**
 * Una pagina segura que debe tener un usuario asociado para poder ser visualizada.
 * @author jaap
 */
public abstract class SecureBasePage extends SchoolBasePage implements PageBeginRenderListener{
    
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
    public abstract List<String> getPermisos();
    
    /**
     * Las paginas deben poder agregar un permiso a su lista de permisos.
     * @param permiso El nuevo permiso que una pagina puede aceptar.
     */
    public final void addPermiso(String permiso){
        getPermisos().add(permiso);
    }
    
    /**
     * Remueve un permiso de la lista aceptada de permisos.
     * @param permiso El permiso a eliminar.
     */
    public final void removePermiso(Permiso permiso){
        getPermisos().remove(permiso);
    }

    @Override
    public void pageBeginRender(PageEvent pageEvent) {
        if(!isUserInRole(getUsuario())){
            throw new PageRedirectException(getHomePage());
        }
    }
}
