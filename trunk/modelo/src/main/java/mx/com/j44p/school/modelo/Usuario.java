/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo;

import mx.com.j44p.school.modelo.mapped.AbstractPersona;
import javax.persistence.Entity;

/**
 * Clase que representa a un usuario del sistema.
 * @author jaap
 */
@Entity
public class Usuario extends AbstractPersona {
    
    /**
     * serialVersionUID para la interfaz Serializable
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Email del usuario.
     */
    private String email;
    
    /**
     * Password del usuario.
     */
    private String password;
    
    @Override
    public String toString() {
        return getNombreCompleto();
    }
    
    /**
     * Obtiene el email del usuario.
     * @return El email del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Fija el email del usuario.
     * @param email El email del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el id del usuario.
     * @return El id del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Fija el id del usuario.
     * @param password EL id del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}