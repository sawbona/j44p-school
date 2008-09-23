/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo;

import mx.com.j44p.school.modelo.mapped.Entidad;
import mx.com.j44p.school.modelo.mapped.Permiso;

/**
 * Enumeracion para los permisos de cada pagina.
 * @author jaap
 */
public enum PermisoBasico implements Permiso, Entidad{

    ADMINISTRADOR,
    ALUMNO,
    TUTOR,
    PROFESOR,
    ESCRITURA,
    LECTURA,
    EXECUCION;
    
    private String nombre = this.toString();
    
    private Integer id;
    

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
