package mx.com.j44p.school.lectura;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mx.com.j44p.school.modelo.Examen;
import mx.com.j44p.school.modelo.Pregunta;
import mx.com.j44p.school.modelo.Seccion;
import mx.com.j44p.school.modelo.enumeraciones.TipoSeccion;

/**
 * Unit test for simple App.
 */
public class XstreamTest
        extends TestCase {

    private XStream parser;
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public XstreamTest(String testName) {
        super(testName);
        parser = new XStream();
        parser.alias("examen", Examen.class);
        parser.alias("seccion", Seccion.class);
        parser.alias("tipo", TipoSeccion.class);
        parser.alias("pregunta", Pregunta.class);
        parser.addImplicitCollection(Examen.class, "secciones");
        parser.addImplicitCollection(Seccion.class, "preguntas");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(XstreamTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testXstream() {

        FileWriter fileWriter = null;
        try {
            /**
             * Creamos el examen de prueba.
             */
            Examen examen = new Examen();
            
            /**
             * Las secciones que conforman el examen.
             */
            Seccion espanol = new Seccion();
            espanol.setTipoSeccion(TipoSeccion.ESPANOL);
            
            Seccion mate = new Seccion();
            mate.setTipoSeccion(TipoSeccion.MATEMATICAS);
            
            List<Seccion> secciones = new ArrayList<Seccion>();
            secciones.add(mate);
            secciones.add(espanol);
            
            /**
             * Asocioiamos las secciones creadas al examen.
             */
            examen.setSecciones(secciones);
            
            /**
             * Creamos las preguntas de prueba de cada seccion.
             */
            /**
             * Para la seccion de mate:
             */
            Pregunta preguntaMatel = new Pregunta();
            preguntaMatel.setInstrucciones("Selecciona una de las opciones");
            preguntaMatel.setPregunta("Cuanto es 1 + 1?");
            List<String> opciones = new ArrayList<String>();
            opciones.add("a) 2");
            opciones.add("b) 4");
            preguntaMatel.setOpciones(opciones);
            preguntaMatel.setRespuesta(0);
            mate.addPregunta(preguntaMatel);
            
            /**
             * Para la seccion de espanol.
             */
            Pregunta preguntaEsp1 = new Pregunta();
            preguntaEsp1.setInstrucciones("Contesta correctamente:");
            preguntaEsp1.setPregunta("Quien es el autor del quijote?");
            opciones = new ArrayList<String>();
            opciones.add("a) Miguel de Cervantes");
            opciones.add("b) Andres de San Agustin.");
            preguntaEsp1.setOpciones(opciones);
            preguntaEsp1.setRespuesta(0);
            espanol.addPregunta(preguntaEsp1);
            
            /**
             * Convertimos el objeto a xml.
             */
            fileWriter = new FileWriter("/home/jaap/examen.xml");
            parser.toXML(examen, fileWriter);

            Examen leido = (Examen) parser.fromXML(new BufferedReader(new FileReader("/home/jaap/examen.xml")));
            for(Pregunta pregunta: leido.getSecciones().get(0).getPreguntas()){
                System.out.println("Pregunta leida: " + pregunta.getPregunta());
            }
            
        } catch (IOException ex) {
            Logger.getLogger(XstreamTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(XstreamTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
