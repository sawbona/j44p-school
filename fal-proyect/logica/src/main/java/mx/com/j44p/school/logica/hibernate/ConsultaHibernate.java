/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.logica.hibernate;

import java.util.List;
import mx.com.j44p.school.logica.Consulta;
import mx.com.j44p.school.modelo.mapped.Usuario;
import mx.com.j44p.school.modelo.mapped.UsuarioSimple;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Una implementacion de {@see Consulta} hecha con un template de hibernate provisto por Spring.
 * @author jaap
 */
public class ConsultaHibernate implements Consulta{

    /**
     * Usuario utilizado para realizar las busquedas por ejemplo.
     */
    private static Usuario usuario = new UsuarioSimple();
    
    /**
     * Template de hibernate utilizado para hacer las cosultas a la base de datos.
     */
    private HibernateTemplate template;
    
    /**
     * Obtiene el template de hibernate.
     * @return El template de hibernate.
     */
    public HibernateTemplate getHibernateTemplate() {
        return template;
    }

    /**
     * Fija el template de hibernate a este objeto.
     * @param template El template de hibernate a fijar.
     */
    public void setHibernateTemplate(HibernateTemplate template) {
        this.template = template;
    }

    /**
     * Encuentra un usuario dado un username. Si no existe dicho usuario regresara <code>null</code>
     * 
     * @param username El nombre de usuario por el que vamos a buscar.
     * @return El usuario asociado por el que estamos buscando. <code>null</code> en caso
     * de no encontrar dicho usuario.
     */
    @Override
    public Usuario findByUsername(String username) {
        usuario.setUsername(username);
        List<Usuario> usuarios = template.findByExample(usuario);
        if(usuarios == null || (usuarios.size() == 0)){
            return null;
        }
        return usuarios.get(0);
    }

    /**
     * Verifica que dado un nombre de usuario y un password correspondan a los almacenados en la
     * base de datos.
     * @param username El nombre de usuario a validar.
     * @param password El password a validar.
     * @return Un booleano que indica si los parametros coinciden con los guardados en la base
     * de datos.
     */
    @Override
    public boolean valida(String username, String password) {
        usuario.setUsername(username);
        List<Usuario> usuarios = template.findByExample(usuario);
        if(usuarios == null || (usuarios.size() == 0)){
            return false;
        }
        if(usuarios.get(0).getPassword().compareTo(password) == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean save(Usuario usuario) {
        if(findByUsername(usuario.getUsername()) != null){
            return false;
        }
        try {
            template.save(usuario);
        } catch (DataAccessException dataAccessException) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Usuario usuario) {
        try {
            template.delete(usuario);
        } catch (DataAccessException dataAccessException) {
            return false;
        }
        return true;
    }

}
