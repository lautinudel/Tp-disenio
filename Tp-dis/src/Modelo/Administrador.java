package Modelo;
// Generated 03/11/2017 21:00:49 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Administrador generated by hbm2java
 */
public class Administrador  implements java.io.Serializable {


     private String username;
     private String apelido;
     private String nombre;
     private Byte activo;
     private Set claveAdministradors = new HashSet(0);

    public Administrador() {
    }

	
    public Administrador(String username, String apelido, String nombre) {
        this.username = username;
        this.apelido = apelido;
        this.nombre = nombre;
    }
    public Administrador(String username, String apelido, String nombre, Byte activo, Set claveAdministradors) {
       this.username = username;
       this.apelido = apelido;
       this.nombre = nombre;
       this.activo = activo;
       this.claveAdministradors = claveAdministradors;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getApelido() {
        return this.apelido;
    }
    
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Byte getActivo() {
        return this.activo;
    }
    
    public void setActivo(Byte activo) {
        this.activo = activo;
    }
    public Set<ClaveAdministrador> getClaveAdministradors() {
        return this.claveAdministradors;
    }
    
    public void setClaveAdministradors(Set claveAdministradors) {
        this.claveAdministradors = claveAdministradors;
    }




}


