/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.j44p.school.modelo.mapped;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author jaap
 */
@Entity
@Table(name="persona")
public final class PersonaSimple implements Entidad, Persona {

    private Integer id;
    
    private String primerNombre;
    
    private String segundoNombre;
    
    private String primerApellido;
    
    private String segundoApellido;

    @Transient
    @Override
    public String getNombreCompleto() {
        return getPrimerNombre() +" "
                + getSegundoNombre() + " "
                + getPrimerApellido() + " "
                + getSegundoApellido();
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

    @Id
    @GeneratedValue
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
