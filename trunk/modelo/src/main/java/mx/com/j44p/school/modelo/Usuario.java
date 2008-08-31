/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author jaap
 */
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String _idUsario;
    
    private String _nombre1;
    
    private String _nombre2;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String email;
    
    private Integer id;
    
    private String password;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (_idUsario != null ? _idUsario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this._idUsario == null && other._idUsario != null) || (this._idUsario != null && !this._idUsario.equals(other._idUsario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return _idUsario;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_USUARIO")
    @GenericGenerator(name = "SEQ_ID_USUARIO", strategy = "sequence",
    parameters = {@Parameter(name = "sequence", value = "SEQ_ID_USUARIO")})
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * 
     * @param idUsuario
     */
    @Column(nullable=false, unique=true)
    public void setIdUsuario(String idUsuario){
        _idUsario= idUsuario;
    }
    
    @Column(unique=true)
    public String getIdUsuario(){
        return _idUsario;
    }
    
    public void setNombre1(String nombre1){
        _nombre1 = nombre1;
    }

    public String getNombre1(){
        return _nombre1;
    }

    public void setNombre2(String nombre2){
        _nombre2 = nombre2;
    }

    public String getNombre2(){
        return _nombre2;
    }
    
    public void setApellidoPaterno(String _apellidoPaterno){
        apellidoPaterno = _apellidoPaterno;
    }
    
    public String getApellidoPaterno(){
        return apellidoPaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno){
        this.apellidoMaterno = apellidoMaterno;
    }
    
    public String getApellidoMaterno(){
        return apellidoMaterno;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}