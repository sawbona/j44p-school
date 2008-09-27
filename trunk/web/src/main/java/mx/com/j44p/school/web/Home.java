/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.web;

import mx.com.j44p.school.logica.Consulta;
import mx.com.j44p.school.modelo.Alumno;
import mx.com.j44p.school.modelo.PermisoBasico;
import mx.com.j44p.school.modelo.mapped.Permiso;
import mx.com.j44p.school.web.secure.Evalua;
import mx.com.j44p.school.web.basic.SchoolBasePage;
import mx.com.j44p.school.web.secure.AdministraUsuarios;
import org.apache.tapestry.IPage;
import org.apache.tapestry.annotations.InitialValue;
import org.apache.tapestry.annotations.InjectPage;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Pagina Home.
 * @author jaap
 */
public abstract class Home extends SchoolBasePage{

    /**
     * Referencia a la pagina Evalua.
     * @return
     */
    @InjectPage("secure/Evalua")
    public abstract Evalua getEvaluaPage();
    
    @InjectPage("secure/AdministraUsuarios")
    public abstract AdministraUsuarios getAdministraUsuariosPage();
    
    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    @InitialValue(value="literal:nombre de usuario")
    public abstract String getUsername();
    
    /**
     * Fija el nombre del usuario.
     * @param username El nombre a fijar.
     */
    public abstract void setUsername(String username);
    
    /**
     * Obtiene el password de la pagina.
     * @return El password asociado a esta pagina.
     */
    public abstract String getPassword();
    
    /**
     * Listener de la pagina home. Este metodo es llamado cuando se envia la forma asociada a esta
     * pagina.
     */
    public IPage onInicia(){
        Evalua evalua = getEvaluaPage();
        
        Alumno usuario = new Alumno();
        usuario.setPrimerNombre("Carlos");
        usuario.setSegundoNombre("Jacob");
        usuario.setPrimerApellido("Lobaco");
        usuario.setSegundoApellido("Beltran");
        usuario.setEmail("sawbona@gmail.com");
        usuario.setPassword("password");
        
        Permiso permiso = PermisoBasico.ADMINISTRADOR;
        usuario.addPermiso(permiso);
        HibernateTemplate template = (HibernateTemplate) getApplicationContext().getBean("hibernateTemplate");
        for(String nombre: getApplicationContext().getBeanDefinitionNames()){
            System.out.println(nombre);
        }
        Consulta consulta = (Consulta) getApplicationContext().getBean("consultaHibernate");
        template.saveOrUpdate(usuario);
        evalua.setUsuario(usuario);
        return getEvaluaPage();
    }
    
    public IPage onAdministraUsuariosDirectLink(){
        AdministraUsuarios administraUsuarios = getAdministraUsuariosPage();
        administraUsuarios.setUsuario(getUsuario());
        return administraUsuarios;
    }
}