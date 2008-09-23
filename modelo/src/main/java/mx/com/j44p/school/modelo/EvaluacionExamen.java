/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import mx.com.j44p.school.modelo.mapped.AbstractEntidad;

/**
 * Esta es la unica clase que creamos cuando aplicamos un examen.
 * Cada una de los objetos que conforman esta clase es creado cuando se inyecta el examen a
 * evaluar.
 * 
 * Los getter y setter de cada uno de los elementos que conforman a EvaluacionExamen debe ser
 * utilizado cuidadosamente.
 * 
 * Clase para representar la evaluacion de un alumno.
 * Los ingredientes para crear un objeto (es decir para inyectarlos al crear este objeto):
 * <lo>
 *  <li>Alumno</li>
 *  <li>Examen.</li>
 * </lo>
 * 
 * List"EvaluacionExamen" no es necesaria crearla, ya que cuando se inyecta el examen, estas son
 * creadas a partir de las secciones a evaluar del examen.
 * La clase consta de evaluaciones de las secciones que corresponden a cada seccion del examen
 * realizado.
 * @author jaap
 */
@Entity
public class EvaluacionExamen extends AbstractEntidad{

    /**
     * El alumno a ser evaluado en esta aplicacion de examen.
     */
    private Alumno alumno;
    
    /**
     * Una lista de EvaluacionSeccion que es cada una de las secciones en las que el alumno es
     * evaluado.
     */
    private List<EvaluacionSeccion> evaluacionSecciones;

    /**
     * El examen el cual sera aplicado.
     */
    private Examen examen;

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
        /**
         * Creamos la lista de EvaluacionSeccion para la EvaluacionExamen. 
         */
        evaluacionSecciones = new ArrayList<EvaluacionSeccion>(examen.getSecciones().size());
        /**
         * Por cada una de las secciones del examen, creamos una nueva EvaluacionSeccion que
         * agregaremos a la lista de EvaluacionSeccion creada en la linea anterior.
         */
        for(Seccion seccion : examen.getSecciones()){
            /**
             * La nueva EvaluacionSeccion a agregar a la lista.
             */
            EvaluacionSeccion evaluacionSeccion = new EvaluacionSeccion();
            /**
             * Cada nueva EvaluacionSeccion necesita una nueva lista de EvaluacionPregunta.
             * Creamos esta lista con cada una de las secciones que conforman al examen.
             */
            List<EvaluacionPregunta> evaluacionPreguntas = new ArrayList<EvaluacionPregunta>(
                    seccion.getPreguntas().size());
            /**
             * Cada EvaluacionPregunta necesita una pregunta que sera evaluada.
             * Obtenemos cada pregunta de cada seccion y creamos una nueva EvaluacionPregunta
             * a partir de dicha pregunta.
             */
            for(Pregunta pregunta: seccion.getPreguntas()){
                EvaluacionPregunta evaluacionPregunta = new EvaluacionPregunta();
                evaluacionPregunta.setPregunta(pregunta);
                evaluacionPreguntas.add(evaluacionPregunta);
            }
            evaluacionSeccion.setEvaluacionPreguntas(evaluacionPreguntas);
            evaluacionSecciones.add(evaluacionSeccion);
        }
    }
    
    /**
     * El alumno asociada a esta evaluacion.
     * @return El alumno asociado a esta evaluacion.
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Fija el alumno a ser evaluado.
     * @param alumno El alumno a ser evaluado.
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Cada una de las secciones que conforman esta evaluacion.
     * @return Las secciones que conforman esta evaluacion.
     */
    @OneToMany
    public List<EvaluacionSeccion> getEvaluacionSecciones() {
        return evaluacionSecciones;
    }

    /**
     * Fija la evaluacion de secciones a esta evaluacion de examen.
     * Requerido por Hibernate.
     * @param evaluacionSecciones
     */
    public void setEvaluacionSecciones(List<EvaluacionSeccion> evaluacionSecciones) {
        this.evaluacionSecciones = evaluacionSecciones;
    }
    
    /**
     * Calcula la media del total de las EvaluacionSeccion que conforman a este objeto.
     * @return
     */
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
