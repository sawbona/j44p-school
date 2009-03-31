/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.j44p.school.web.secure;

import java.util.ArrayList;
import java.util.List;
import mx.com.j44p.school.modelo.enumeraciones.Permiso;
import mx.com.j44p.school.modelo.mapped.Usuario;
import mx.com.j44p.school.web.secure.basic.SecureBasePage;
import org.apache.log4j.Logger;

/**
 *
 * @author jaap
 */
public abstract class UsuarioHome extends SecureBasePage {

    /**
     * Logeer de la clase.
     */
    private static Logger logger = Logger.getLogger(UsuarioHome.class);
    
    private static final List<String> permisos = new ArrayList<String>();

    static {
        permisos.add(Permiso.ADMINISTRADOR.name());
        permisos.add(Permiso.USUARIO.name());
    }

    @Override
    public boolean isUserInRole(Usuario usuario) {
        if (usuario == null) {
            logger.debug("El usuario es nulo en: " + UsuarioHome.class);
            return false;
        }
        for (String permiso : usuario.getPermisos()) {
            if (getPermisos().contains(permiso)) {
                return true;
            }
        }
        logger.debug("El usuario es nulo en: " + UsuarioHome.class);
        return false;
    }

    @Override
    public List<String> getPermisos() {
        return permisos;
    }
}
