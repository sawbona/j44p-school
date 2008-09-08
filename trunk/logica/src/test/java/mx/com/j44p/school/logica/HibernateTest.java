/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.logica;

import mx.com.j44p.school.modelo.Usuario;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author jaap
 */
public class HibernateTest extends SchoolBaseTest{

    /**
     * Template para hacer las pruebas.
     */
    private HibernateTemplate template;

    /**
     * Contexto de spring que utilizaremos para trabajar.
     */
    private ApplicationContext contexto;
    
    public HibernateTest(String name){
        super(name);
        contexto = SCHOOL_APPLICATION_CONTEXT;
        template = (HibernateTemplate) contexto.getBean("hibernateTemplate");
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testHibernate(){
        Usuario usuario = new Usuario();
        usuario.setPrimerNombre("Carlos");
        usuario.setSegundoNombre("Jacob");
        usuario.setPrimerApellido("Lobaco");
        usuario.setSegundoApellido("Beltran");
        usuario.setEmail("sawbona@gmail.com");
        usuario.setPassword("password");
        template.saveOrUpdate(usuario);
        System.out.println("Usuario guardado exitosamente <---------------------------------------");
        assertTrue(true);
    }
}
