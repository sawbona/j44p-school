/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.logica;

import mx.com.j44p.school.modelo.mapped.Usuario;

/**
 * Interfaz utilizada para definir las consultas que seran hechas por el sistema.
 * @author jaap
 */
public interface Consulta {

    /**
     * Guarda un usuario a la base de datos.
     * @param usuario El usuario a guardar en la base.
     * @return Un boolean que indica si la operacion se llevo a cabo con exito o no.
     */
    boolean save(Usuario usuario);
    
    /**
     * Elimina un usuario de la base de datos.
     * @param usuario El usuario a borrar de la base de datos.
     * @return Un boolean que indica si la operacion se llevo a cabo con exito o no.
     */
    boolean delete(Usuario usuario);
    
    /**
     * Verifica que, dados el nombre de usuario y el password, estos correspondan a los guardados
     * en la base de datos.
     * @param username El username introducido a la aplicacion. 
     * @param password El password qe estamos validando,
     * @return Un boolean que indica si la operacion se llevo a cabo con exito o no.
     */
    boolean valida(String username, String password);

    /**
     * Busca un usuario por username
     * @param username El username del usuario a buscar.
     * @return El usuario asociado a dicho username. <code>null</code> en caso que el username
     * buscado no concuerde con ningun usuario.
     */
    Usuario findByUsername(String username);
}
