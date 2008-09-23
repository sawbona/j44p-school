/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.logica;

import java.util.List;
import mx.com.j44p.school.modelo.Alumno;
import mx.com.j44p.school.modelo.PermisoBasico;
import mx.com.j44p.school.modelo.Profesor;
import mx.com.j44p.school.modelo.mapped.Permiso;
import mx.com.j44p.school.modelo.mapped.Usuario;
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
        Profesor profesor = new Profesor();
        profesor.setPrimerNombre("Carlos");
        profesor.setSegundoNombre("Jacob");
        profesor.setPrimerApellido("Lobaco");
        profesor.setSegundoApellido("Beltran");
        profesor.setUsername("jaap");
        profesor.setPassword("ch3c4357");
        profesor.addPermiso(PermisoBasico.ADMINISTRADOR);
        profesor.setEmail("sawbona@gmail.com");
        template.save(profesor);
        Profesor busca = new Profesor();
        profesor.setPrimerNombre("Carlos");
        System.out.println("Usuario guardado exitosamente <---------------" +
                "------------------------" +
                " Buscando por usuario:");
        for(Usuario usuario : (List<Usuario>)template.findByExample(busca.getUsuario())){
            System.out.println(usuario);
        }
        
    }
}
