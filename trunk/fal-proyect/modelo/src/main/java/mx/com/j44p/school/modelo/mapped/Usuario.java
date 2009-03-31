/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.j44p.school.modelo.mapped;

import java.util.List;

/**
 * Interfaz que representa a un usuario del sistema.
 * Todo aquel que vaya a usar el sistema es un usuario. Por ejemplo
 * <lo>
 *  <li>
 *      {@see Alumno} es un usuario.
 *  </li>
 *  <li>
 *      {@see Maestro} es un usuario.
 *  </li>
 *  <li>
 *      {@see UsuarioAnomimo} es un usuario.
 *  </li>
 *  <li>
 *      {@see Escuela} podria ser un usuario.
 *  </li>
 * </lo>
 * @author jaap
 */
public interface Usuario {
    
    /**
     * Obtiene el email del usuario.
     * @return El email del usuario.
     */
    String getEmail();

    /**
     * Fija el email del usuario.
     * @param email El email del usuario.
     */
    void setEmail(String email);

    /**
     * El nombre de usuario utilizado para loggearse dentro del sistema.
     * @return El nombre de usuario asociado a este usuario dentro del sistema.
     */
    String getUsername();
    
    /**
     * Fija el nombre de usuario.
     */
    void setUsername(String username);
    
    /**
     * Obtiene el id del usuario.
     * @return El id del usuario.
     */
    String getPassword();

    /**
     * Fija el id del usuario.
     * @param password EL id del usuario.
     */
    void setPassword(String password);
    
    /**
     * Devuelve una lista de los roles a los que pertenece el Usuario.
     * Un rol sirve para manejar los permisos que tendra el usuario dentro del sistema.
     * @return
     */
    List<String> getPermisos();

    void setPermisos(List<String> permisos);
    
    /**
     * Agrega un rol al usuario.
     * @param rol
     */
    void addPermiso(String permiso);
    
    /**
     * Remueve un rol del usuario.
     * @param rol
     */
    void removePermiso(String permiso); 
}
