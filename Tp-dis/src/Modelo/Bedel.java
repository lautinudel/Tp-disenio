package Modelo;
// Generated 27/10/2017 22:11:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Bedel generated by hbm2java
 */
public class Bedel  implements java.io.Serializable {


     private String username;
     private String apellido;
     private String nombre;
     private String turnoTrabaja;
     private Byte activo;
     private Set reservaPeriodicas = new HashSet(0);
     private Set claveBedels = new HashSet(0);
     private Set reservaEsporadicas = new HashSet(0);

    public Bedel() {
    }

	
    public Bedel(String username, String apellido, String nombre, String turnoTabaja) {
        this.username = username;
        this.apellido = apellido;
        this.nombre = nombre;
        this.turnoTrabaja = turnoTabaja;
    }
    public Bedel(String username, String apellido, String nombre, String turnoTabaja, Byte activo, Set reservaPeriodicas, Set claveBedels, Set reservaEsporadicas) {
       this.username = username;
       this.apellido = apellido;
       this.nombre = nombre;
       this.turnoTrabaja = turnoTabaja;
       this.activo = activo;
       this.reservaPeriodicas = reservaPeriodicas;
       this.claveBedels = claveBedels;
       this.reservaEsporadicas = reservaEsporadicas;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTurnoTabaja() {
        return this.turnoTrabaja;
    }
    
    public void setTurnoTabaja(String turnoTabaja) {
        this.turnoTrabaja = turnoTabaja;
    }
    public Byte getActivo() {
        return this.activo;
    }
    
    public void setActivo(Byte activo) {
        this.activo = activo;
    }
    public Set getReservaPeriodicas() {
        return this.reservaPeriodicas;
    }
    
    public void setReservaPeriodicas(Set reservaPeriodicas) {
        this.reservaPeriodicas = reservaPeriodicas;
    }
    public Set getClaveBedels() {
        return this.claveBedels;
    }
    
    public void setClaveBedels(Set claveBedels) {
        this.claveBedels = claveBedels;
    }
    public Set getReservaEsporadicas() {
        return this.reservaEsporadicas;
    }
    
    public void setReservaEsporadicas(Set reservaEsporadicas) {
        this.reservaEsporadicas = reservaEsporadicas;
    }




}


