/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.j44p.school.logica;

import mx.com.j44p.school.modelo.EvaluacionExamen;
import mx.com.j44p.school.modelo.EvaluacionPregunta;
import mx.com.j44p.school.modelo.EvaluacionSeccion;
import mx.com.j44p.school.modelo.Pregunta;

/**
 * Logica detras de resolver un examen.
 * <p/>
 * Para crear un objeto de este tipo, antes debe ser creada
 * una nueva tabla {@see EvaluacionExamen} a guardar en la base de datos e inyectarla a este objeto.
 * Para crear la EvaluacionExamen es necesario crear antes un objeto {@see Alumno} y un
 * {@see Examen} e inyectarlos a este objeto.
 * 
 * @author jaap
 */
public class EvaluaExamen {

    /**
     * Miembro del modelo que representa una tabla dentro de nuestro esquema de base de datos
     * asociado a una evaluacion de un alumno cuando se realiza un examen.
     */
    private EvaluacionExamen evaluacionExamen;

    /**
     * La tabla asociada a la evaluacion de un examen.
     * @return La tabla de evaluacion asociada con resolver un examen.
     */
    public EvaluacionExamen getEvaluacionExamen() {
        return evaluacionExamen;
    }

    /**
     * Fija la tabla de evaluacion asociada a resolver un examen por parte del alumno.
     * @param evaluacionExamen La tabla asociada a resolver un examen.
     */
    public void setEvaluacionExamen(EvaluacionExamen evaluacionExamen) {
        this.evaluacionExamen = evaluacionExamen;
    }

    /**
     * Metodo utilizado para asociar una pregunta con la opcion seleccionada por el usuario.
     * @param pregunta
     * @param opcionSeleccionada
     */
    public void responde(Integer pregunta, Integer opcionSeleccionada){
        if(opcionSeleccionada == null){
            return;
        }
        EvaluacionPregunta evaluacionPregunta = getEvaluacionPregunta(pregunta);
        if(evaluacionPregunta.getPregunta().getRespuesta() == opcionSeleccionada){
            evaluacionPregunta.setCorrecto(true);
        }
    }
    
    /**
     * Obtiene la pregunta que se esta evaluando del examen relacionado a EvaluacionExamen.
     * @param index Indice de la pregunta que debe cumplir:
     * <code>0 <= index < totalPreguntasAEvaluar</code>
     * <p/>
     * Es decir que el indice de las preguntas se toman de 0 a examen.length - 1;
     * @return
     */
    private EvaluacionPregunta getEvaluacionPregunta(Integer index){
        if (!((0 <= index) && (index < getTotalPreguntasEvaluar()))) {
            throw new ArrayIndexOutOfBoundsException("Ooops... Error al acceder un indice en: " +
                    EvaluaExamen.class + ". Indice buscado: " + index);
        }
        /**
         * |    S0       |    |    S1            |   S3
         * |    S0       |    *    S1            |   S3
         * |-|-|-|-|-|-|-|-|-|-|- |- |- |- |- |- |- |- |- |
         * |0|1|2|3|4|5|6|0|1|2|3 |4 |5 |6 |7 |8 |9 |10|11|
         * |0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|
         */
        int limiteInferior = 0;
        int seccion = 0;
        int pregunta = 0;
        for (EvaluacionSeccion evaluacionSeccion : evaluacionExamen.getEvaluacionSecciones()) {
            int limiteSuperior = limiteInferior +
                    evaluacionSeccion.getEvaluacionPreguntas().size() - 1;
            if ((limiteInferior <= index) && (index <= limiteSuperior)) {
                pregunta = index - limiteInferior;
                break;
            }
            limiteInferior += limiteSuperior + 1;
            ++seccion;
        }
        return evaluacionExamen.getEvaluacionSecciones().get(seccion).getEvaluacionPreguntas().
                get(pregunta);
    }
    
    /**
     * Obtiene la pregunta que se esta evaluando del examen relacionado a EvaluacionExamen.
     * @param index Indice de la pregunta que debe cumplir:
     * <code>0 <= index < totalPreguntasAEvaluar</code>
     * <p/>
     * Es decir que el indice de las preguntas se toman de 0 a examen.length - 1;
     * @return
     */
    public Pregunta getPreguntaEvaluando(int index) {
        return getEvaluacionPregunta(index).getPregunta();
    }

    public int getTotalPreguntasEvaluar() {
        int total = 0;
        for (EvaluacionSeccion evaluacionSeccion : evaluacionExamen.getEvaluacionSecciones()) {
            total += evaluacionSeccion.getEvaluacionPreguntas().size();
        }
        return total;
    }
}
