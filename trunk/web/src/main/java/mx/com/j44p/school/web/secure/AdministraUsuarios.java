/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.j44p.school.web.secure;

import org.apache.log4j.Logger;
import mx.com.j44p.school.web.secure.basic.SecureBasePage;
import mx.com.j44p.school.modelo.enumeraciones.Permiso;
import mx.com.j44p.school.modelo.mapped.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Pagina para la administracion de usuarios del sistema.
 * @author jaap
 */
public abstract class AdministraUsuarios extends SecureBasePage {

    private static Logger logger = Logger.getLogger(AdministraUsuarios.class);
    
    /**
     * Lista de permisos aceptada por esta pagina.
     */
    private static final List<String> permisos = new ArrayList<String>();

    static {
        /**
         * Permiso basico ADMINISTRADOR es aceptado por esta pagina.
         */
        permisos.add(Permiso.ADMINISTRADOR.name());
    }

    /**
     * Verificacion basica para esta pagina.
     * @param usuario El usuario al que se le verificaran los permisos.
     * @return <code>true</code> si el usuario puede acceder a esta pagina.
     * <code>false</code> en caso contrario.
     */
    @Override
    public boolean isUserInRole(Usuario usuario) {
        if (usuario == null) {
            logger.debug("El usuario es nulo en: " + AdministraUsuarios.class);
            return false;
        }
        for (String permiso : usuario.getPermisos()) {
            if (getPermisos().contains(permiso)) {
                return true;
            }
        }
        logger.debug("El usuario es nulo en: " + AdministraUsuarios.class);
        return false;
    }

    @Override
    public List<String> getPermisos() {
        return permisos;
    }
}
