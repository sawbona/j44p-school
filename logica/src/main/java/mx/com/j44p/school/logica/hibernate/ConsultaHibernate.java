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
    public Usuario findByUsername(String username) {
        usuario.setUsername(username);
        List<Usuario> usuarios = template.findByExample(usuario);
        if(usuarios == null || (usuarios.size() == 0)){
            return null;
        }
        return usuarios.get(0);
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
