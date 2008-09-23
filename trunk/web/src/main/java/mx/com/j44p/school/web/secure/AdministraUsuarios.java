/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.j44p.school.web.secure;

import mx.com.j44p.school.web.secure.basic.SecureBasePage;
import java.util.ArrayList;
import java.util.List;
import mx.com.j44p.school.modelo.PermisoBasico;
import mx.com.j44p.school.modelo.mapped.Permiso;
import mx.com.j44p.school.modelo.mapped.Usuario;


/**
 * Pagina para la administracion de usuarios del sistema.
 * @author jaap
 */
public abstract class AdministraUsuarios extends SecureBasePage {

    /**
     * Lista de permisos aceptada por esta pagina.
     */
    private static final List<Permiso> permisos = new ArrayList<Permiso>();
    
    static{
        /**
         * Permiso basico ADMINISTRADOR es aceptado por esta pagina.
         */
        permisos.add(PermisoBasico.ADMINISTRADOR);
    }
    
    /**
     * Verificacion basica para esta pagina.
     * @param usuario El usuario al que se le verificaran los permisos.
     * @return <code>true</code> si el usuario puede acceder a esta pagina.
     * <code>false</code> en caso contrario.
     */
    @Override
    public boolean isUserInRole(Usuario usuario) {
        if(usuario == null){
            return false;
        }
        for(Permiso permiso : usuario.getPermisos()){
            if(getPermisos().contains(permiso)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public List<Permiso> getPermisos(){
        return permisos;
    }
    
}
