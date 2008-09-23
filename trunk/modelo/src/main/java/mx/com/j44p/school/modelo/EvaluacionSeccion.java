/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import mx.com.j44p.school.modelo.mapped.AbstractEntidad;

/**
 * Clase que representa la evaluacion de una seccion. Cada evaluacion de una seccion se compone
 * de una lista de evaluaciones de preguntas.
 * Ingredientes necesarios para crear este objeto:
 * List"EvaluacionPregunta"
 * @author jaap
 */
@Entity
public class EvaluacionSeccion extends AbstractEntidad{

    private List<EvaluacionPregunta> evaluacionPreguntas;

    @OneToMany
    public List<EvaluacionPregunta> getEvaluacionPreguntas() {
        return evaluacionPreguntas;
    }

    public void setEvaluacionPreguntas(List<EvaluacionPregunta> evaluacionPreguntas) {
        this.evaluacionPreguntas = evaluacionPreguntas;
    }
    
    @Transient
    public Double getEvaluacion(){
        int numeroCorrectas = 0;
        double numeroTotales = evaluacionPreguntas.size();
        for(EvaluacionPregunta evaluacionPregunta : evaluacionPreguntas){
            boolean correcto = evaluacionPregunta.getCorrecto();
            if(correcto){
                ++ numeroCorrectas;
            }
        }
        return numeroCorrectas / numeroTotales;
    }
}
