package Modelo;
// Generated 03/11/2017 21:00:49 by Hibernate Tools 4.3.1


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
     private TipoAula tipoAula;
     private Set diaReservaEsporadicas = new HashSet(0);
     

    public ReservaEsporadica() {
    }

	
    public ReservaEsporadica(ActividadUniversitaria actividadUniversitaria, Bedel bedel, Docente docente) {
        this.actividadUniversitaria = actividadUniversitaria;
        this.bedel = bedel;
        this.docente = docente;
    }
    public ReservaEsporadica(ActividadUniversitaria actividadUniversitaria, Bedel bedel, Docente docente, Integer cantidadAlumnos, Set diaReservaEsporadicas, TipoAula tipo) {
       this.actividadUniversitaria = actividadUniversitaria;
       this.bedel = bedel;
       this.docente = docente;
       this.cantidadAlumnos = cantidadAlumnos;
       this.diaReservaEsporadicas = diaReservaEsporadicas;
       this.tipoAula = tipo;
    }

    public TipoAula getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(TipoAula tipoAula) {
        this.tipoAula = tipoAula;
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
    public Set<DiaReservaEsporadica> getDiaReservaEsporadicas() {
        return this.diaReservaEsporadicas;
    }
    
    public void removerElementos (Set<DiaReservaEsporadica> lista){
        this.diaReservaEsporadicas.removeAll(lista);
    }
    
    
    public void setDiaReservaEsporadicas(Set diaReservaEsporadicas) {
        this.diaReservaEsporadicas = diaReservaEsporadicas;
    }




}


