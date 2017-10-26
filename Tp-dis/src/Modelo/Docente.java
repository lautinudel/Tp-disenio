package Modelo;
// Generated 26/10/2017 14:37:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Docente generated by hbm2java
 */
public class Docente  implements java.io.Serializable {


     private DocenteId id;
     private String nombre;
     private String email;
     private String especialidad;
     private Byte activo;
     private Set actividadUniversitarias = new HashSet(0);
     private Set reservaEsporadicas = new HashSet(0);
     private Set reservaPeriodicas = new HashSet(0);

    public Docente() {
    }

	
    public Docente(DocenteId id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
    public Docente(DocenteId id, String nombre, String email, String especialidad, Byte activo, Set actividadUniversitarias, Set reservaEsporadicas, Set reservaPeriodicas) {
       this.id = id;
       this.nombre = nombre;
       this.email = email;
       this.especialidad = especialidad;
       this.activo = activo;
       this.actividadUniversitarias = actividadUniversitarias;
       this.reservaEsporadicas = reservaEsporadicas;
       this.reservaPeriodicas = reservaPeriodicas;
    }
   
    public DocenteId getId() {
        return this.id;
    }
    
    public void setId(DocenteId id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEspecialidad() {
        return this.especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public Byte getActivo() {
        return this.activo;
    }
    
    public void setActivo(Byte activo) {
        this.activo = activo;
    }
    public Set getActividadUniversitarias() {
        return this.actividadUniversitarias;
    }
    
    public void setActividadUniversitarias(Set actividadUniversitarias) {
        this.actividadUniversitarias = actividadUniversitarias;
    }
    public Set getReservaEsporadicas() {
        return this.reservaEsporadicas;
    }
    
    public void setReservaEsporadicas(Set reservaEsporadicas) {
        this.reservaEsporadicas = reservaEsporadicas;
    }
    public Set getReservaPeriodicas() {
        return this.reservaPeriodicas;
    }
    
    public void setReservaPeriodicas(Set reservaPeriodicas) {
        this.reservaPeriodicas = reservaPeriodicas;
    }




}


