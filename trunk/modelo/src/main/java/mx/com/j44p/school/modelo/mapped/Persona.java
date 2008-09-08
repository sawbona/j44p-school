/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo.mapped;

/**
 * Clase para modelar a una persona. Esta clase debe ser extendida por todas las entidades que
 * "personas", que intervengan en el sistema.
 * @author jaap
 */
public interface Persona {

    /**
     * Obtiene el nombre completo de la persona.
     * @return El nombre completo de la persona, compuesto por primer nombre,..., segundo Apellido.
     */
    String getNombreCompleto();
    
    /**
     * Obtiene el primer nombre de la persona.
     * @return El primer nombre de la persona.
     */
    String getPrimerNombre();

    /**
     * Fija el primer nombre de la persona.
     * @param primerNombre El primer nombre a fijar.
     */
    void setPrimerNombre(String primerNombre);
    
    /**
     * Obtiene el segundo nombre de la persona.
     * @return El segundo nombre de la persona.
     */
    String getSegundoNombre();
    
    /**
     * Fija el segundo nombre de la persona.
     * @param segundoNombre El segundo nombre de la persona.
     */
    void setSegundoNombre(String segundoNombre);
    
    /**
     * Obtiene el primer apellido de la persona.
     * @return El primer apellido de la persona.
     */
    String getPrimerApellido();
    
    /**
     * Fija el primer apellido de la persona.
     * @param primerApellido El primer apellido de la persona.
     */
    void setPrimerApellido(String primerApellido);
    
    /**
     * Obtiene el segundo apellido de la persona.
     * @return El segundo apellido de la persona.
     */
    String getSegundoApellido();
    
    /**
     * Fija el segundo apellido de la persona.
     * @param segundoApellido El segundo apellido de la persona.
     */
    void setSegundoApellido(String segundoApellido);
}