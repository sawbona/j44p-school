/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo.mapped;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Clase asbtracta que implementa a Entidad.
 * Esta clase es la encargada de sobre escribir los metodos necesarios para evitar ataques
 * por reflection.
 * <p/>
 * Las entidades que no tengan que extender a otra clase deben extender a esta
 * clase por seguridad.
 * @author jaap
 */
@MappedSuperclass
public abstract class AbstractEntidad implements Entidad{

    /**
     * El id de la entidad.
     */
    private Integer id;
    
    /**
     * {@inheritsDoc}
     */
    @Id
    @GeneratedValue
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * {@inheritsDoc}
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}
