package Modelo;
// Generated 03/11/2017 21:00:49 by Hibernate Tools 4.3.1


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
     private PeriodoEnum periodo;
     private TipoAula tipoAula;
     private Set diaReservaPeriodicas = new HashSet(0);
     private Byte activo;
     

    public ReservaPeriodica() {
    }

	
    public ReservaPeriodica(ActividadUniversitaria actividadUniversitaria, Bedel bedel, Docente docente) {
        this.actividadUniversitaria = actividadUniversitaria;
        this.bedel = bedel;
        this.docente = docente;
    }
    public ReservaPeriodica(ActividadUniversitaria actividadUniversitaria, Bedel bedel, Docente docente, Integer cantidadAlumnos, PeriodoEnum periodo, Set diaReservaPeriodicas, TipoAula tipo, Byte activo) {
       this.actividadUniversitaria = actividadUniversitaria;
       this.bedel = bedel;
       this.docente = docente;
       this.cantidadAlumnos = cantidadAlumnos;
       this.periodo = periodo;
       this.diaReservaPeriodicas = diaReservaPeriodicas;
       this.tipoAula=tipo;
       this.activo=activo;
    }

    public Byte getActivo() {
        return activo;
    }

    public void setActivo(Byte activo) {
        this.activo = activo;
    }

    public TipoAula getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(TipoAula tipoAula) {
        this.tipoAula = tipoAula;
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
    public PeriodoEnum getPeriodo() {
        return this.periodo;
    }
    
    public void setPeriodo(PeriodoEnum periodo) {
        this.periodo = periodo;
    }
    public Set<DiaReservaPeriodica> getDiaReservaPeriodicas() {
        return this.diaReservaPeriodicas;
    }
    
    public void setDiaReservaPeriodicas(Set diaReservaPeriodicas) {
        this.diaReservaPeriodicas = diaReservaPeriodicas;
    }

    public void removerElementos(Set lista) {
        this.diaReservaPeriodicas.removeAll(lista);
    }




}


