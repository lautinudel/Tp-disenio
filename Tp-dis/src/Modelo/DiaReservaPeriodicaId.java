package Modelo;
// Generated 03/11/2017 21:00:49 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * DiaReservaPeriodicaId generated by hbm2java
 */
public class DiaReservaPeriodicaId  implements java.io.Serializable {


     private int reservaPeriodicaIdReservaPeriodica;
     private int aulaNumeroAula;
     private DiaSemana dia;
     private Date horaInicio;
     private Date horaFin;
     private int anio;

    public DiaReservaPeriodicaId() {
    }

    public DiaReservaPeriodicaId(int reservaPeriodicaIdReservaPeriodica, int aulaNumeroAula, DiaSemana dia, Date horaInicio, Date horaFin, int anio) {
       this.reservaPeriodicaIdReservaPeriodica = reservaPeriodicaIdReservaPeriodica;
       this.aulaNumeroAula = aulaNumeroAula;
       this.dia = dia;
       this.horaInicio = horaInicio;
       this.horaFin = horaFin;
       this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
   
    public int getReservaPeriodicaIdReservaPeriodica() {
        return this.reservaPeriodicaIdReservaPeriodica;
    }
    
    public void setReservaPeriodicaIdReservaPeriodica(int reservaPeriodicaIdReservaPeriodica) {
        this.reservaPeriodicaIdReservaPeriodica = reservaPeriodicaIdReservaPeriodica;
    }
    public int getAulaNumeroAula() {
        return this.aulaNumeroAula;
    }
    
    public void setAulaNumeroAula(int aulaNumeroAula) {
        this.aulaNumeroAula = aulaNumeroAula;
    }
    public DiaSemana getDia() {
        return this.dia;
    }
    
    public void setDia(DiaSemana dia) {
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
		 if ( !(other instanceof DiaReservaPeriodicaId) ) return false;
		 DiaReservaPeriodicaId castOther = ( DiaReservaPeriodicaId ) other; 
         
		 return (this.getReservaPeriodicaIdReservaPeriodica()==castOther.getReservaPeriodicaIdReservaPeriodica())
 && (this.getAulaNumeroAula()==castOther.getAulaNumeroAula())
 && ( (this.getDia()==castOther.getDia()) || ( this.getDia()!=null && castOther.getDia()!=null && this.getDia().equals(castOther.getDia()) ) )
 && ( (this.getHoraInicio()==castOther.getHoraInicio()) || ( this.getHoraInicio()!=null && castOther.getHoraInicio()!=null && this.getHoraInicio().equals(castOther.getHoraInicio()) ) )
 && ( (this.getHoraFin()==castOther.getHoraFin()) || ( this.getHoraFin()!=null && castOther.getHoraFin()!=null && this.getHoraFin().equals(castOther.getHoraFin()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getReservaPeriodicaIdReservaPeriodica();
         result = 37 * result + this.getAulaNumeroAula();
         result = 37 * result + ( getDia() == null ? 0 : this.getDia().hashCode() );
         result = 37 * result + ( getHoraInicio() == null ? 0 : this.getHoraInicio().hashCode() );
         result = 37 * result + ( getHoraFin() == null ? 0 : this.getHoraFin().hashCode() );
         return result;
   }   


}


