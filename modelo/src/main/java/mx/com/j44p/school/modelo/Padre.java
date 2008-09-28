/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import mx.com.j44p.school.modelo.mapped.AbstractEntidad;
import mx.com.j44p.school.modelo.mapped.Persona;
import mx.com.j44p.school.modelo.mapped.PersonaSimple;
import mx.com.j44p.school.modelo.mapped.Usuario;
import mx.com.j44p.school.modelo.mapped.UsuarioSimple;

/**
 *
 * @author jaap
 */
@Entity
public class Padre extends AbstractEntidad implements Usuario, Persona{

    /**
     * El usuario utilizado para implementar los metodos de la interfaz {@see Usuario}
     */
    private Usuario usuario = new UsuarioSimple();
    
    /**
     * La persona utilizada para implementar los metodos de la interfaz {@see Persona}
     */
    private Persona persona = new PersonaSimple();
    /**
     * Obtiene la persona asociada a este alumno.
     * @return La persona asociada a este alumno.
     */
    @OneToOne(cascade=CascadeType.ALL, targetEntity=PersonaSimple.class)
    public Persona getPersona() {
        return persona;
    }

    /**
     * Fija la persona asociada a este alumno.
     * @param persona La persona a fijar.
     */
    public void setPersona(PersonaSimple persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el usuario asociado a este alumno.
     * @return El usuario asociado a este alumno.
     */
    @OneToOne(cascade=CascadeType.ALL, targetEntity=UsuarioSimple.class)
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Fija el usuario asociado a este alumno.
     * @param usuario
     */
    public void setUsuario(UsuarioSimple usuario) {
        this.usuario = usuario;
    }
    
    /**
     * {@inheritsDoc}
     */
    @Override
    public void setUsername(String username) {
        usuario.setUsername(username);
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setPermisos(List<String> permisos) {
        usuario.setPermisos(permisos);
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setPassword(String password) {
        usuario.setPassword(password);
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setEmail(String email) {
        usuario.setEmail(email);
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void removePermiso(String permiso) {
        usuario.removePermiso(permiso);
    }

    /**
     * {@inheritsDoc}
     */
    @Transient
    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    /**
     * {@inheritsDoc}
     */
    @Transient
    @Override
    public List<String> getPermisos() {
        return usuario.getPermisos();
    }

    /**
     * {@inheritsDoc}
     */
    @Transient
    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    /**
     * {@inheritsDoc}
     */
    @Transient
    @Override
    public String getEmail() {
        return usuario.getEmail();
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void addPermiso(String permiso) {
        usuario.addPermiso(permiso);
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setSegundoNombre(String segundoNombre) {
        persona.setSegundoNombre(segundoNombre);
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setSegundoApellido(String segundoApellido) {
        persona.setSegundoApellido(segundoApellido);
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setPrimerNombre(String primerNombre) {
        persona.setPrimerNombre(primerNombre);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrimerApellido(String primerApellido) {
        persona.setPrimerApellido(primerApellido);
    }

    @Transient
    @Override
    public String getSegundoNombre() {
        return persona.getSegundoNombre();
    }

    @Transient
    @Override
    public String getSegundoApellido() {
        return persona.getSegundoApellido();
    }

    @Transient
    @Override
    public String getPrimerNombre() {
        return persona.getPrimerNombre();
    }

    @Transient
    @Override
    public String getPrimerApellido() {
        return persona.getPrimerApellido();
    }

    @Transient
    @Override
    public String getNombreCompleto() {
        return persona.getNombreCompleto();
    }
 
}
