/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo.mapped;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    private List<String> permisos;
    
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
    @CollectionOfElements
    @Override
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<String> getPermisos() {
        if(permisos == null){
            permisos = new ArrayList<String>();
        }
        return permisos;
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setPermisos(List<String> permisos) {
        this.permisos = permisos;
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void addPermiso(String permiso) {
        getPermisos().add(permiso);
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void removePermiso(String permiso) {
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
