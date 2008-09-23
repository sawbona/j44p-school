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
import mx.com.j44p.school.modelo.mapped.PersonaSimple;
import mx.com.j44p.school.modelo.mapped.UsuarioSimple;
import mx.com.j44p.school.modelo.mapped.Permiso;
import mx.com.j44p.school.modelo.mapped.Persona;
import mx.com.j44p.school.modelo.mapped.Usuario;

/**
 *
 * @author jaap
 */
@Entity
public class Profesor extends AbstractEntidad implements Usuario, Persona{

    /**
     * Persona utilizada para implementar los metodos de la interfaz {@see Persona}.
     */
    private Persona persona = new PersonaSimple();
    
    /**
     * Usuario utilizado para implementar los metodos de la interfaz {@see Usuario}.
     */
    private Usuario usuario = new UsuarioSimple();

   /**
     * Obtiene la persona asociada a este profesor.
     * @return La persona asociada a este profesor.
     */
    @OneToOne(cascade=CascadeType.ALL, targetEntity=PersonaSimple.class)
    public Persona getPersona() {
        return persona;
    }

    /**
     * Fija la persona asociada a este profesor.
     * @param persona La persona a fijar.
     */
    public void setPersona(PersonaSimple persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el usuario asociado a este profesor.
     * @return El usuario asociado a este profesor.
     */
    @OneToOne(cascade=CascadeType.ALL, targetEntity=UsuarioSimple.class)
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Fija el usuario asociado a este profesor.
     * @param usuario
     */
    public void setUsuario(UsuarioSimple usuario) {
        this.usuario = usuario;
    }

    @Transient
    @Override
    public String getEmail() {
        return usuario.getEmail();
    }

    @Override
    public void setEmail(String email) {
        usuario.setEmail(email);
    }

    @Transient
    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    @Override
    public void setUsername(String username) {
        usuario.setUsername(username);
    }

    @Transient
    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public void setPassword(String password) {
        usuario.setPassword(password);
    }

    @Transient
    @Override
    public List<Permiso> getPermisos() {
        return usuario.getPermisos();
    }

    @Override
    public void setPermisos(List<Permiso> permisos) {
        usuario.setPermisos(permisos);
    }

    @Override
    public void addPermiso(Permiso permiso) {
        usuario.addPermiso(permiso);
    }

    @Override
    public void removePermiso(Permiso permiso) {
        usuario.removePermiso(permiso);
    }

    @Transient
    @Override
    public String getNombreCompleto() {
        return persona.getNombreCompleto();
    }

    @Transient
    @Override
    public String getPrimerNombre() {
        return persona.getPrimerNombre();
    }

    @Override
    public void setPrimerNombre(String primerNombre) {
        persona.setPrimerNombre(primerNombre);
    }

    @Transient
    @Override
    public String getSegundoNombre() {
        return persona.getSegundoNombre();
    }

    @Override
    public void setSegundoNombre(String segundoNombre) {
        persona.setSegundoNombre(segundoNombre);
    }

    @Transient
    @Override
    public String getPrimerApellido() {
        return persona.getPrimerApellido();
    }

    @Override
    public void setPrimerApellido(String primerApellido) {
        persona.setPrimerApellido(primerApellido);
    }

    @Transient
    @Override
    public String getSegundoApellido() {
        return persona.getSegundoApellido();
    }

    @Override
    public void setSegundoApellido(String segundoApellido) {
        persona.setSegundoApellido(segundoApellido);
    }

}