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
 * Clase para representar la evaluacion de un alumno.
 * 
 * La clase consta de evaluaciones de las secciones que corresponden a cada seccion del examen
 * realizado.
 * @author jaap
 */
@Entity
public class EvaluacionExamen extends AbstractEntidad{

    private Alumno alumno;
    
    private List<EvaluacionSeccion> evaluacionSecciones;

    private Examen examen;

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
    
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @OneToMany
    public List<EvaluacionSeccion> getEvaluacionSecciones() {
        return evaluacionSecciones;
    }

    public void setEvaluacionSecciones(List<EvaluacionSeccion> evaluacionSecciones) {
        this.evaluacionSecciones = evaluacionSecciones;
    }
    
    @Transient
    public Double getEvaluacion(){
        double sumaTotal = 0;
        int numeroTotalSecciones = evaluacionSecciones.size();
        for(EvaluacionSeccion evaluacionSeccion : evaluacionSecciones){
            sumaTotal += evaluacionSeccion.getEvaluacion();
        }
        return sumaTotal / numeroTotalSecciones;
    }
}
