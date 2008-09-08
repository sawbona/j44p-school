/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo;

import mx.com.j44p.school.modelo.mapped.AbstractEntidad;
import java.util.List;
import javax.persistence.Entity;
import org.hibernate.annotations.CollectionOfElements;

/**
 * Clase utilizada para modelar una pregunta.
 * @author jaap
 */
@Entity
public class Pregunta extends AbstractEntidad{

    /**
     * Instrucciones asociadas a la pregunta.
     */
    private String instrucciones;
    
    /**
     * La pregunta a contestar.
     */
    private String pregunta;
    
    /**
     * Posibles opciones de respuesta a la pregunta.
     */
    private List<String> opciones;

    /**
     * La opcion correcta.
     */
    private int respuesta;

    /**
     * Optiene la respuesta correcta asociada a la pregunta.
     * @return La respuesta correcta.
     */
    public int getRespuesta() {
        return respuesta;
    }

    /**
     * Fija la respesta correcta.
     * @param respuesta La respuesta correcta.
     */
    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
    
    /**
     * Una cadena que representa las instrucciones para la pregunta.
     * @return Una cadena que representa las instrucciones de la pregunta.
     */
    public String getInstrucciones() {
        return instrucciones;
    }

    /**
     * Fija las instrucciones de la pregunta.
     * @param instrucciones
     */
    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    /**
     * Posibles opciones de la pregunta.
     * @return Una lista de opciones.
     */
    @CollectionOfElements
    public List<String> getOpciones() {
        return opciones;
    }

    /**
     * Fija las opciones de la pregunta.
     * @param opciones Las opciones de la pregunta.
     */
    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    /**
     * Obtiene la pregunta que debe ser contestada.
     * @return La pregunta a ser contestada.
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * Fija la pregunta a ser contestada.
     * @param pregunta La pregunta a ser contestada.
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
