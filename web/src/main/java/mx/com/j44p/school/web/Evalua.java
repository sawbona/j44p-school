/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.web;

import org.apache.tapestry.IPage;
import org.apache.tapestry.IRequestCycle;
import org.apache.tapestry.html.BasePage;

/**
 * Clase para representar el momento en que un alumno esta contestanto un examen.
 * @author jaap
 */
public abstract class Evalua extends BasePage{
    
    private int preguntaContestando;

    public int getPreguntaContestando() {
        return preguntaContestando + 1;
    }

    public void setPreguntaContestando(int preguntaContestando) {
        this.preguntaContestando = preguntaContestando;
    }
    
    /**
     * Accion realizada cuando un alumno ha seleccionado contestar una siguiente pregunta.
     */
    public IPage onSiguiente(IRequestCycle cycle){
        Evalua siguiente = (Evalua) cycle.getPage("Evalua");
        siguiente.setPreguntaContestando(preguntaContestando + 1);
        return siguiente;
    }
    
    /**
     * Accion realizada cuando un alumno ha selecciondo contestar una pregunta anterior.
     * @return
     */
    public IPage onAnterior(IRequestCycle cycle){
        Evalua siguiente = (Evalua) cycle.getPage("Evalua");
        if(preguntaContestando - 1 != 0){
            siguiente.setPreguntaContestando(preguntaContestando - 2);
        }else{
            siguiente.setPreguntaContestando(preguntaContestando - 1);
        }
        return siguiente;
    }
}
