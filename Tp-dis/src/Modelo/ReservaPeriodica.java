package Modelo;
// Generated 27/10/2017 22:11:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ReservaPeriodica generated by hbm2java
 */
public class ReservaPeriodica  implements java.io.Serializable {


     private Integer idReservaPeriodica;
     private ActividadUniversitaria actividadUniversitaria;
     private Bedel bedel;
     private Docente docente;
     private Integer cantidadAlumnos;
     private String periodo;
     private Set diaReservaPeriodicas = new HashSet(0);

    public ReservaPeriodica() {
    }

	
    public ReservaPeriodica(ActividadUniversitaria actividadUniversitaria, Bedel bedel, Docente docente) {
        this.actividadUniversitaria = actividadUniversitaria;
        this.bedel = bedel;
        this.docente = docente;
    }
    public ReservaPeriodica(ActividadUniversitaria actividadUniversitaria, Bedel bedel, Docente docente, Integer cantidadAlumnos, String periodo, Set diaReservaPeriodicas) {
       this.actividadUniversitaria = actividadUniversitaria;
       this.bedel = bedel;
       this.docente = docente;
       this.cantidadAlumnos = cantidadAlumnos;
       this.periodo = periodo;
       this.diaReservaPeriodicas = diaReservaPeriodicas;
    }
   
    public Integer getIdReservaPeriodica() {
        return this.idReservaPeriodica;
    }
    
    public void setIdReservaPeriodica(Integer idReservaPeriodica) {
        this.idReservaPeriodica = idReservaPeriodica;
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
    public String getPeriodo() {
        return this.periodo;
    }
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public Set getDiaReservaPeriodicas() {
        return this.diaReservaPeriodicas;
    }
    
    public void setDiaReservaPeriodicas(Set diaReservaPeriodicas) {
        this.diaReservaPeriodicas = diaReservaPeriodicas;
    }




}

