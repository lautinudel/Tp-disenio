package Modelo;
// Generated 03/11/2017 21:00:49 by Hibernate Tools 4.3.1



/**
 * DiaReservaPeriodica generated by hbm2java
 */
public class DiaReservaPeriodica  implements java.io.Serializable {


     private DiaReservaPeriodicaId id;
     private Aula aula;
     private ReservaPeriodica reservaPeriodica;
     private DiaSemana dia;

    public DiaReservaPeriodica() {
    }

    public DiaReservaPeriodica(DiaReservaPeriodicaId id, Aula aula, ReservaPeriodica reservaPeriodica, DiaSemana dia) {
       this.id = id;
       this.aula = aula;
       this.reservaPeriodica = reservaPeriodica;
       this.dia = dia;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
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


