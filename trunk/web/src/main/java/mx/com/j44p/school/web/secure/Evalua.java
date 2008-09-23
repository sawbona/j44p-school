/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.web.secure;

import mx.com.j44p.school.web.secure.basic.SecureBasePage;
import java.util.ArrayList;
import java.util.List;
import mx.com.j44p.school.lectura.ExamenFileReader;
import mx.com.j44p.school.logica.EvaluaExamen;
import mx.com.j44p.school.modelo.Alumno;
import mx.com.j44p.school.modelo.EvaluacionExamen;
import mx.com.j44p.school.modelo.Examen;
import mx.com.j44p.school.modelo.PermisoBasico;
import mx.com.j44p.school.modelo.Pregunta;
import mx.com.j44p.school.modelo.mapped.Permiso;
import mx.com.j44p.school.modelo.mapped.Usuario;
import mx.com.j44p.school.web.Home;
import org.apache.tapestry.IPage;
import org.apache.tapestry.annotations.InjectPage;
import org.apache.tapestry.event.PageDetachListener;
import org.apache.tapestry.event.PageEvent;

/**
 * Clase para representar el momento en que un alumno esta contestanto un examen.
 * @author jaap
 */
public abstract class Evalua extends SecureBasePage implements PageDetachListener{

    /**
     * Lista de permisos de la pagina.
     */
    private static final List<Permiso> permisos = new ArrayList<Permiso>();
    
    static{
        permisos.add(PermisoBasico.ADMINISTRADOR);
        permisos.add(PermisoBasico.ALUMNO);
    }
    
    @InjectPage("Home")
    @Override
    public abstract Home getHomePage();
    
    @InjectPage("secure/Evalua")
    public abstract Evalua getEvaluaPage();
    
    /**
     * Entero que sirve para llevar la cuenta de que pregunta se esta contestanto.
     * <p/>
     * El indice debe cumplir que:
     * <code>0 <= preguntaContestando < examen.length</code>
     */
    private int preguntaContestando;

    private Integer opcionSeleccionada = 0;
    
    /**
     * La logica detras de evaluar un examen.
     */
    private EvaluaExamen evaluaExamen;
    
    /**
     * Metodo que sirve para que tapestry obtenga el indice de la pregunta que se esta contestando.
     * Debido a que se considera : <code>0 <= preguntaContestando < examen.length</code>
     * a fin de mostrar los indices desde 1, se le suma un 1 al indice actual.
     * @return
     */
    public int getPreguntaContestando() {
        return preguntaContestando + 1;
    }
    
    /**
     * Este metodo sirve para cuando se incrementa la pregunta que se esta contestando.
     * @param preguntaContestando
     */
    public void setPreguntaContestando(int preguntaContestando) {
        this.preguntaContestando = preguntaContestando;
    }

    /**
     * Obtiene la pregunta leida desde el examen.
     * @param index El indice de la pregunta que se esta contestando.
     * @return La pregunta asociada con el indice de la pregunta correspondiente en el examen.
     */
    public Pregunta getPregunta(){
        return evaluaExamen.getPreguntaEvaluando(preguntaContestando);
    }
    
    /**
     * Obtiene el total de pregunta a contestar.
     * Es una propiedad de tapestry.
     * @return El numero total de preguntas que conforman el examen.
     */
    public int getTotalPreguntas(){
        return evaluaExamen.getTotalPreguntasEvaluar();
    }

    /**
     * Este metodo es utilizado para generar la opcion seleccionada por el usuario al momento de
     * generar la pagina.
     * @return Un entero asociado a la opcion que el usuario va a introducir.
     */
    public int getOpcionSeleccionada() {
        return ++ opcionSeleccionada;
    }

    /**
     * Este metodo es utilizado por tapestry para fijar la opcion seleccionada por el usuario
     * antes de enviar la forma.
     * @param opcionSeleccionada
     */
    public void setOpcionSeleccionada(Integer opcionSeleccionada) {
        /**
         * El usuario no respondio la pregunta.
         */
        if(opcionSeleccionada == null){
            throw new IllegalArgumentException();
        }
        evaluaExamen.responde(preguntaContestando, opcionSeleccionada);
        this.opcionSeleccionada = opcionSeleccionada;
    }
    
    
    
    public Usuario getNombre(){
        return getUsuario();
    }
    
    /**
     * Metodo llamado cuando la pagina regresa al pool de tapestry.
     * @param pageEvent
     */
    @Override
    public void pageDetached(PageEvent pageEvent) {
    }

    @Override
    public boolean isUserInRole(Usuario usuario) {
        if(usuario == null){
            return false;
        }
        for(Permiso permiso : usuario.getPermisos()){
            if(getPermisos().contains(permiso)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public List<Permiso> getPermisos(){
        return permisos;
    }
    
    /**
     * Metodo llamado una unica vez cuando se carga por primera vez la pagina.
     */
    @Override
    protected void finishLoad(){
        super.finishLoad();
        /**
         * Inicializamos los elementos que necesitamos.
         * Empezamos por EvaluaExamen.
         */
        evaluaExamen = new EvaluaExamen();
        
        /**
         * Necesitamos un objeto EvaluacionExamen al que se le inyectan el examen y el alumno.
         */
        EvaluacionExamen evaluacionExamen = new  EvaluacionExamen();
        /**
         * El examen que estamos aplicando.
         */
        Examen examen = ExamenFileReader.readExamen();
        
        /**
         * El alumno que estamos evaluando.
         */
        Alumno alumno = new Alumno();
        alumno.setPrimerNombre("Carlos");
        alumno.setSegundoNombre("Jacob");
        alumno.setPrimerApellido("Lobaco");
        alumno.setSegundoApellido("Beltran");
        
        evaluacionExamen.setAlumno(alumno);
        evaluacionExamen.setExamen(examen);
        
        evaluaExamen.setEvaluacionExamen(evaluacionExamen);
    }
    
    /**
     * Metodo llamado cuando se preciosa el link Home en la pagina html.
     * @return Una referencia a la pagina Home
     */
    public IPage onHomeDirectLink(){
        Home home = getHomePage();
        home.setUsername(evaluaExamen.getEvaluacionExamen().getAlumno().toString());
        home.setUsuario(getUsuario());
        return getHomePage();
    }
    
    /**
     * Accion realizada cuando un alumno ha seleccionado contestar una siguiente pregunta.
     */
    public IPage onSiguiente(){
        Evalua siguiente = getEvaluaPage();
        if(getUsuario() == null){
            throw new IllegalArgumentException();
        }
        siguiente.setUsuario(getUsuario());
        if(preguntaContestando + 1 < getTotalPreguntas()){
            siguiente.setPreguntaContestando(preguntaContestando + 1);
        }
        return siguiente;
    }
    
    /**
     * Accion realizada cuando un alumno ha selecciondo contestar una pregunta anterior.
     * @return
     */
    public IPage onAnterior(){
        Evalua siguiente = getEvaluaPage();
        siguiente.setUsuario(getUsuario());
        if(preguntaContestando - 1 != -1){
            siguiente.setPreguntaContestando(preguntaContestando - 2);
        }else{
            siguiente.setPreguntaContestando(preguntaContestando - 1);
        }
        return siguiente;
    }
}