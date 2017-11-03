package Modelo;
// Generated 27/10/2017 22:11:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ReservaEsporadica generated by hbm2java
 */
public class ReservaEsporadica  implements java.io.Serializable {


     private Integer idReservaEsporadica;
     private ActividadUniversitaria actividadUniversitaria;
     private Bedel bedel;
     private Docente docente;
     private Integer cantidadAlumnos;
     private Set diaReservaEsporadicas = new HashSet(0);

    public ReservaEsporadica() {
    }

	
    public ReservaEsporadica(ActividadUniversitaria actividadUniversitaria, Bedel bedel, Docente docente) {
        this.actividadUniversitaria = actividadUniversitaria;
        this.bedel = bedel;
        this.docente = docente;
    }
    public ReservaEsporadica(ActividadUniversitaria actividadUniversitaria, Bedel bedel, Docente docente, Integer cantidadAlumnos, Set diaReservaEsporadicas) {
       this.actividadUniversitaria = actividadUniversitaria;
       this.bedel = bedel;
       this.docente = docente;
       this.cantidadAlumnos = cantidadAlumnos;
       this.diaReservaEsporadicas = diaReservaEsporadicas;
    }
   
    public Integer getIdReservaEsporadica() {
        return this.idReservaEsporadica;
    }
    
    public void setIdReservaEsporadica(Integer idReservaEsporadica) {
        this.idReservaEsporadica = idReservaEsporadica;
    }
    public ActividadUniversitaria getActividadUniversitaria() {
        return this.actividadUniversitaria;
    }
    
    public void setActividadUniversitaria(ActividadUniversitaria actividadUniversitaria) {
        this.actividadUniversitaria = actividadUniversitaria;
    }
    public Bedel getBedel() {
        return this.bedel;
    }
    
    public void setBedel(Bedel bedel) {
        this.bedel = bedel;
    }
    public Docente getDocente() {
        return this.docente;
    }
    
    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    public Integer getCantidadAlumnos() {
        return this.cantidadAlumnos;
    }
    
    public void setCantidadAlumnos(Integer cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }
    public Set getDiaReservaEsporadicas() {
        return this.diaReservaEsporadicas;
    }
    
    public void setDiaReservaEsporadicas(Set diaReservaEsporadicas) {
        this.diaReservaEsporadicas = diaReservaEsporadicas;
    }




}

