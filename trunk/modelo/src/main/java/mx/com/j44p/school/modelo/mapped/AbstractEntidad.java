/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo.mapped;

import mx.com.j44p.school.modelo.*;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author jaap
 */
@MappedSuperclass
public abstract class AbstractEntidad implements Entidad{

    private Integer id;
    
    /**
     * Obtiene el id asociado a la entidad.
     * @return El id asociado a la entidad.
     */
    @Id
    @Override
    public Integer getId(){
        return id;
    }
    
    /**
     * Fija el id asociado a la entidad.
     * @param id
     */
    public void setId(Integer id){
        this.id = id;
    }
    
}
