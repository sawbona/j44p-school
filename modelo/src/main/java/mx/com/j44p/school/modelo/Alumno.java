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
import mx.com.j44p.school.modelo.enumeraciones.Permiso;
import mx.com.j44p.school.modelo.mapped.Persona;
import mx.com.j44p.school.modelo.mapped.PersonaSimple;
import mx.com.j44p.school.modelo.mapped.Usuario;
import mx.com.j44p.school.modelo.mapped.UsuarioSimple;

/**
 * Clase utilizada para modelar a un alumno del sistema.
 * 
 * Un Alumno es una Persona y un usuario por separado, es por eso que implementa ambas interfaces.
 * Para implementar los metodos de cada interfaz utilizamos las implementaciones simples de dichas
 * interfaces.
 * @author jaap
 */
@Entity
public class Alumno extends AbstractEntidad implements Usuario, Persona {

    /**
     * El usuario utilizado para implementar los metodos de la interfaz {@see Usuario}
     */
    private Usuario usuario = new UsuarioSimple();
    
    /**
     * La persona utilizada para implementar los metodos de la interfaz {@see Persona}
     */
    private Persona persona = new PersonaSimple();
    
    /**
     * Escuela a la que pertenece el alumno.
     */
    private String escuela;

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
     * Obtiene la escuela asociada al alumno.
     * @return La escuela asociada al alumno.
     */
    public String getEscuela() {
        return escuela;
    }

    /**
     * Fija la escuela asociada al alumno.
     * @param escuela La escuela a asociar.
     */
    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    @Override
    public void setUsername(String username) {
        usuario.setUsername(username);
    }

    @Override
    public void setPermisos(List<String> permisos) {
        usuario.setPermisos(permisos);
    }

    @Override
    public void setPassword(String password) {
        usuario.setPassword(password);
    }

    @Override
    public void setEmail(String email) {
        usuario.setEmail(email);
    }

    @Override
    public void removePermiso(String permiso) {
        usuario.removePermiso(permiso);
    }

    @Transient
    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    @Transient
    @Override
    public List<String> getPermisos() {
        return usuario.getPermisos();
    }

    @Transient
    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Transient
    @Override
    public String getEmail() {
        return usuario.getEmail();
    }

    @Override
    public void addPermiso(String permiso) {
        usuario.addPermiso(permiso);
    }

    @Override
    public void setSegundoNombre(String segundoNombre) {
        persona.setSegundoNombre(segundoNombre);
    }

    @Override
    public void setSegundoApellido(String segundoApellido) {
        persona.setSegundoApellido(segundoApellido);
    }

    @Override
    public void setPrimerNombre(String primerNombre) {
        persona.setPrimerNombre(primerNombre);
    }

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

    @Override
    public String toString() {
        return getNombreCompleto();
    }
    
}