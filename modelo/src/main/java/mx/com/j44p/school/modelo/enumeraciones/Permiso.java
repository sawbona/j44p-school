/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo.enumeraciones;

import mx.com.j44p.school.modelo.mapped.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author jaap
 */

@Entity
public enum Permiso implements Entidad{

    ADMINISTRADOR,
    ALUMNO,
    TUTOR,
    PROFESOR,
    ESCRITURA,
    LECTURA,
    USUARIO,
    EXECUCION;
    
    private Integer id;
    
    @Override
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    
    
}