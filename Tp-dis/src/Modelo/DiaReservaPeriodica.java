package Modelo;
// Generated 26/10/2017 14:37:37 by Hibernate Tools 4.3.1



/**
 * DiaReservaPeriodica generated by hbm2java
 */
public class DiaReservaPeriodica  implements java.io.Serializable {


     private DiaReservaPeriodicaId id;
     private Aula aula;
     private ReservaPeriodica reservaPeriodica;

    public DiaReservaPeriodica() {
    }

    public DiaReservaPeriodica(DiaReservaPeriodicaId id, Aula aula, ReservaPeriodica reservaPeriodica) {
       this.id = id;
       this.aula = aula;
       this.reservaPeriodica = reservaPeriodica;
    }
   
    public DiaReservaPeriodicaId getId() {
        return this.id;
    }
    
    public void setId(DiaReservaPeriodicaId id) {
        this.id = id;
    }
    public Aula getAula() {
        return this.aula;
    }
    
    public void setAula(Aula aula) {
        this.aula = aula;
    }
    public ReservaPeriodica getReservaPeriodica() {
        return this.reservaPeriodica;
    }
    
    public void setReservaPeriodica(ReservaPeriodica reservaPeriodica) {
        this.reservaPeriodica = reservaPeriodica;
    }




}


