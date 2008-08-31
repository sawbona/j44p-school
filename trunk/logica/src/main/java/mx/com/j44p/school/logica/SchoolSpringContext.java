/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.logica;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jaap
 */
public class SchoolSpringContext {

    private static final String[] CONTEXTOS = {"schoolModeloApplicationContext.xml",
        "schoolLogicaApplicationContext.xml"};
    
    public static final ApplicationContext SCHOOL_SPRING_CONTEXT =
            new ClassPathXmlApplicationContext(CONTEXTOS);
    
}
