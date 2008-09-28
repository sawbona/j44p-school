/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.web;

import mx.com.j44p.school.logica.Consulta;
import mx.com.j44p.school.modelo.enumeraciones.Permiso;
import mx.com.j44p.school.modelo.mapped.Usuario;
import mx.com.j44p.school.web.secure.Evalua;
import mx.com.j44p.school.web.basic.SchoolBasePage;
import mx.com.j44p.school.web.secure.AdministraUsuarios;
import org.apache.tapestry.IPage;
import org.apache.tapestry.annotations.InitialValue;
import com.javaforge.tapestry.spring.annotations.InjectSpring;

/**
 * Pagina Home.
 * @author jaap
 */
public abstract class Home extends SchoolBasePage{
    
    @InjectSpring("consultaHibernate")
    public abstract Consulta getConsulta();
    
    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    @InitialValue(value="literal:nombre de usuario")
    public abstract String getUsername();
    
    /**
     * Fija el nombre del usuario.
     * @param username El nombre a fijar.
     */
    public abstract void setUsername(String username);
    
    /**
     * Obtiene el password de la pagina.
     * @return El password asociado a esta pagina.
     */
    public abstract String getPassword();
    
    /**
     * Listener de la pagina home. Este metodo es llamado cuando se envia la forma asociada a esta
     * pagina.
     */
    public IPage onInicia(){
        Consulta consulta = getConsulta();
        if (!consulta.valida(getUsername(), getPassword())) {
            setUsuario(null);
            return null;
        }
        Usuario usuario = consulta.findByUsername(getUsername());
        for(String permiso: usuario.getPermisos()){
            if(permiso.equals(Permiso.ADMINISTRADOR.name())){
                AdministraUsuarios administraUsuarios = getAdministraUsuariosPage();
                administraUsuarios.setUsuario(usuario);
                return administraUsuarios;
            }
        }
        Evalua evalua = getEvaluaPage();
        evalua.setUsuario(usuario);
        return evalua;
    }
}