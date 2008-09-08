/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo;

import javax.persistence.Entity;
import mx.com.j44p.school.modelo.mapped.AbstractEntidad;

/**
 * Clase para representar la evaluacion de una pregunta.
 * @author jaap
 */
@Entity
public class EvaluacionPregunta extends AbstractEntidad{

    private Pregunta pregunta;
    
    private Integer seleccionada;
    
    private Boolean correcto;

    public Boolean getCorrecto() {
        return correcto;
    }

    public void setCorrecto(Boolean correcto) {
        this.correcto = correcto;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Integer getSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(Integer seleccionada) {
        this.seleccionada = seleccionada;
    }
    
}
