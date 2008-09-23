/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo.mapped;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Implementacion basica de un {@see Usuario} utiilizada para realizar composicion para
 * otro tipo de usuarios como:
 * <lo>
 *  <li>{@see Alumno}</li>
 *  <li>{@see Profesor}</li>
 *  <li>{@see Padre}</li>
 * </lo>
 * @author jaap
 */
@Entity
@Table(name="usuario")
public final class UsuarioSimple extends AbstractEntidad implements Usuario{

    /**
     * Email del usuario.
     */
    private String email;
    
    /**
     * username del usuario.
     */
    private String username;
    
    /**
     * password del usuario/
     */
    private String password;
    
     /**
      * Lista de permisos.
      */
    private List<Permiso> permisos;
    
    /**
     * {@inheritsDoc}
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * {@inheritsDoc}
     */
    @Column(nullable=false, unique=true)
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * {@inheritsDoc}
     */
    @Column(nullable=false)
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * {@inheritsDoc}
     */
    @ManyToMany(cascade=CascadeType.ALL)
    @Override
    public List<Permiso> getPermisos() {
        if(permisos == null){
            permisos = new ArrayList<Permiso>();
        }
        return permisos;
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void addPermiso(Permiso permiso) {
        getPermisos().add(permiso);
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void removePermiso(Permiso permiso) {
        getPermisos().remove(permiso);
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public String toString() {
        return getUsername();
    }
}
