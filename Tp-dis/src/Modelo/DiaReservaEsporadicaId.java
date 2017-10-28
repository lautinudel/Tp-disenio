package Modelo;
// Generated 27/10/2017 22:11:40 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * DiaReservaEsporadicaId generated by hbm2java
 */
public class DiaReservaEsporadicaId  implements java.io.Serializable {


     private int reservaEsporadicaIdReservaEsporadica;
     private int aulaNumeroAula;
     private Date dia;
     private Date horaInicio;
     private Date horaFin;

    public DiaReservaEsporadicaId() {
    }

    public DiaReservaEsporadicaId(int reservaEsporadicaIdReservaEsporadica, int aulaNumeroAula, Date dia, Date horaInicio, Date horaFin) {
       this.reservaEsporadicaIdReservaEsporadica = reservaEsporadicaIdReservaEsporadica;
       this.aulaNumeroAula = aulaNumeroAula;
       this.dia = dia;
       this.horaInicio = horaInicio;
       this.horaFin = horaFin;
    }
   
    public int getReservaEsporadicaIdReservaEsporadica() {
        return this.reservaEsporadicaIdReservaEsporadica;
    }
    
    public void setReservaEsporadicaIdReservaEsporadica(int reservaEsporadicaIdReservaEsporadica) {
        this.reservaEsporadicaIdReservaEsporadica = reservaEsporadicaIdReservaEsporadica;
    }
    public int getAulaNumeroAula() {
        return this.aulaNumeroAula;
    }
    
    public void setAulaNumeroAula(int aulaNumeroAula) {
        this.aulaNumeroAula = aulaNumeroAula;
    }
    public Date getDia() {
        return this.dia;
    }
    
    public void setDia(Date dia) {
        this.dia = dia;
    }
    public Date getHoraInicio() {
        return this.horaInicio;
    }
    
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }
    public Date getHoraFin() {
        return this.horaFin;
    }
    
    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DiaReservaEsporadicaId) ) return false;
		 DiaReservaEsporadicaId castOther = ( DiaReservaEsporadicaId ) other; 
         
		 return (this.getReservaEsporadicaIdReservaEsporadica()==castOther.getReservaEsporadicaIdReservaEsporadica())
 && (this.getAulaNumeroAula()==castOther.getAulaNumeroAula())
 && ( (this.getDia()==castOther.getDia()) || ( this.getDia()!=null && castOther.getDia()!=null && this.getDia().equals(castOther.getDia()) ) )
 && ( (this.getHoraInicio()==castOther.getHoraInicio()) || ( this.getHoraInicio()!=null && castOther.getHoraInicio()!=null && this.getHoraInicio().equals(castOther.getHoraInicio()) ) )
 && ( (this.getHoraFin()==castOther.getHoraFin()) || ( this.getHoraFin()!=null && castOther.getHoraFin()!=null && this.getHoraFin().equals(castOther.getHoraFin()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getReservaEsporadicaIdReservaEsporadica();
         result = 37 * result + this.getAulaNumeroAula();
         result = 37 * result + ( getDia() == null ? 0 : this.getDia().hashCode() );
         result = 37 * result + ( getHoraInicio() == null ? 0 : this.getHoraInicio().hashCode() );
         result = 37 * result + ( getHoraFin() == null ? 0 : this.getHoraFin().hashCode() );
         return result;
   }   


}


