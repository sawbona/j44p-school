/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo.mapped;

import javax.persistence.GeneratedValue;
import mx.com.j44p.school.modelo.*;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Clase abstracta que implementa la interfaz Persona.
 * @author jaap
 */
@MappedSuperclass
public abstract class AbstractPersona implements Entidad, Persona{
    
    /**
     * Id del usuario.
     */
    private Integer id;
    
    /**
     * Primer nombre de la persona.
     */
    private String primerNombre;
    
    /**
     * Segundo nombre de la persona.
     */
    private String segundoNombre;
    
    /**
     * Primer apellido de la persona.
     */
    private String primerApellido;
    
    /**
     * Segundo apellido de la persona.
     */
    private String segundoApellido;

    /**
     * Obtiene el id del usuario.
     * @return El id del usuario.
     */
    @Id
    @GeneratedValue
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Fija el id del usuario.
     * @param id El id del usuario.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Transient
    @Override
    public String getNombreCompleto() {
        return getPrimerNombre() + " " +
                getSegundoNombre() + " " +
                getPrimerApellido() + " " +
                getSegundoApellido();
    }
    
    @Override
    public String getPrimerNombre() {
        return primerNombre;
    }

    @Override
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    @Override
    public String getSegundoNombre() {
        return segundoNombre;
    }

    @Override
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    @Override
    public String getPrimerApellido() {
        return primerApellido;
    }

    @Override
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Override
    public String getSegundoApellido() {
        return segundoApellido;
    }

    @Override
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

}
