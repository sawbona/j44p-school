package mx.com.j44p.school.logica;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class SchoolBaseTest
        extends TestCase {

    /**
     * Archivos del contexto de Spring.
     */
    private static final String[] CONTEXTOS = {
        "schoolModeloApplicationContext.xml",
        "schoolModeloApplicationContext1.xml"};
    
    /**
     * El contexto de Spring.
     */
    public static final ApplicationContext SCHOOL_APPLICATION_CONTEXT =
            new ClassPathXmlApplicationContext(CONTEXTOS);
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SchoolBaseTest(String testName) {
        super(testName);
    }

    /**
     * Rigourous Test :-)
     */
    public void testDummy() {
        assertTrue(true);
    }
}
