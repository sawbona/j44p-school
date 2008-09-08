/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo;

import javax.persistence.Entity;
import mx.com.j44p.school.modelo.mapped.AbstractPersona;

/**
 *
 * @author jaap
 */
@Entity
public class Alumno extends AbstractPersona{

    private String escuela;

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
}
