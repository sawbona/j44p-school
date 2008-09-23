/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo.mapped;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author jaap
 */
@Entity
public interface Permiso {

    @Id
    @GeneratedValue
    Integer getId();
    
    void setId(Integer id);
    
    String getNombre();
    
    void setNombre(String nombre);
    
}
