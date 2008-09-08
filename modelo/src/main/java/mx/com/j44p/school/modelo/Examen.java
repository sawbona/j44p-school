/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo;

import mx.com.j44p.school.modelo.mapped.AbstractEntidad;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * Clase utilizada para modelar un examen.
 * @author jaap
 */
@Entity
public class Examen extends AbstractEntidad{

    /**
     * Las secciones que conforman este examen.
     */
    List<Seccion> secciones;

    /**
     * Obtiene las diferentes secciones que conforman a este examen.
     * @return Las diferentes secciones que conforman a este examen.
     */
    @ManyToMany
    public List<Seccion> getSecciones() {
        return secciones;
    }

    /**
     * Fija las diferentes secciones de un examen.
     * @param secciones Las secciones que conformaran a este examen.
     */
    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }
    
}