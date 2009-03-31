/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo;

import mx.com.j44p.school.modelo.mapped.AbstractEntidad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import mx.com.j44p.school.modelo.enumeraciones.TipoSeccion;

/**
 * Secciones que conforman a un examen.
 * @author jaap
 */
@Entity
public class Seccion extends AbstractEntidad{

    /**
     * Tipo de seccion.
     */
    private TipoSeccion tipoSeccion;

    /**
     * Preguntas.
     */
    private List<Pregunta> preguntas = new ArrayList<Pregunta>(10);

    public void addPregunta(Pregunta pregunta){
        preguntas.add(pregunta);
    }
    
    /**
     * Obtiene el tipo de seccion a la que pertenece.
     * @return El tipo de seccion al que pertenece.
     */
    public TipoSeccion getTipoSeccion() {
        return tipoSeccion;
    }

    /**
     * Fija el tipo de seccion al que pertenece.
     * @param tipoSeccion El tipo de seccion al que pertenece.
     */
    public void setTipoSeccion(TipoSeccion tipoSeccion) {
        this.tipoSeccion = tipoSeccion;
    }
    
    /**
     * Obtiene las preguntas.
     * @return
     */
    @OneToMany
    public List<Pregunta> getPreguntas(){
        return preguntas;
    }
    
    /**
     * Fija las preguntas.
     * @param preguntas
     */
    public void setPreguntas(List<Pregunta> preguntas){
        this.preguntas = preguntas;
    }
}
