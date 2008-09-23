/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.web.spring;

import mx.com.j44p.school.logica.Consulta;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Clase que contiene el ApplicationContext de Spring para trabajar con el.
 * @author jaap
 */
public class SchoolSpringContext {

    /**
     * Los nombres de los archivos que son cargados por Spring.
     */
    private static final String[] CONTEXTOS = {"schoolModeloApplicationContext.xml",
        "schoolLogicaApplicationContext.xml"};
    
    /**
     * El contexto de Spring de la logica.
     */
    public static final ApplicationContext SCHOOL_SPRING_CONTEXT =
            new ClassPathXmlApplicationContext(CONTEXTOS);
    
    public static final Consulta CONSULTA = (Consulta) SCHOOL_SPRING_CONTEXT.getBean("consultaHibernate");
    
}
