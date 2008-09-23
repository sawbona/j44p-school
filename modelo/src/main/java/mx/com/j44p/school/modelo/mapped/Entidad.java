/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo.mapped;

import java.io.Serializable;

/**
 * Cualquier entidad del sistema debe implementar ya sea directamente (implementando directamente
 * esta interfaz) o extendiendo a la clase asbtracta {@see AbstractEntidad}.
 * <p/>
 * En caso que se implemente directamente esta interfaz, deberan ser sobre-escritos los metodos
 * necesarios para evitar ataques por reflection o la duplicacion de entidades por medio de la
 * serializacion de objetos.
 * @author jaap
 */
public interface Entidad extends Serializable{

    /**
     * Integer utilizado como identificador de la entidad.
     * @return El id de la entidad.
     */
    Integer getId();
    
    /**
     * Fija el identificador de la entidad.
     * @param id El nuevo identificador de la entidad.
     */
    void setId(Integer id);
}
