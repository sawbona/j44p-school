/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.j44p.school.lectura;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.j44p.school.modelo.Examen;
import mx.com.j44p.school.modelo.Pregunta;
import mx.com.j44p.school.modelo.Seccion;
import mx.com.j44p.school.modelo.util.TipoSeccion;

/**
 *
 * @author jaap
 */
public class ExamenFileReader {

    private static XStream parser = new XStream();
    
    static{
        parser.alias("examen", Examen.class);
        parser.alias("seccion", Seccion.class);
        parser.alias("tipo", TipoSeccion.class);
        parser.alias("pregunta", Pregunta.class);
        parser.addImplicitCollection(Examen.class, "secciones");
        parser.addImplicitCollection(Seccion.class, "preguntas");
    }

    public static Examen readExamen() {
        Examen leido = null;
        try {
            leido = (Examen) parser.fromXML(new BufferedReader(new FileReader("/home/jaap/examen.xml")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExamenFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leido;
    }

    private ExamenFileReader() {

    }
}
