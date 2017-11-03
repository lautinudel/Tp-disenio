package Modelo;
// Generated 27/10/2017 22:11:40 by Hibernate Tools 4.3.1



/**
 * AulaMultimedio generated by hbm2java
 */
public class AulaMultimedio  implements java.io.Serializable {


     private int aulaNumeroAula;
     private Aula aula;
     private Byte dvd;
     private Byte computadora;
     private Byte canion;
     private Byte televisor;

    public AulaMultimedio() {
    }

	
    public AulaMultimedio(Aula aula) {
        this.aula = aula;
    }
    public AulaMultimedio(Aula aula, Byte dvd, Byte computadora, Byte canion, Byte televisor) {
       this.aula = aula;
       this.dvd = dvd;
       this.computadora = computadora;
       this.canion = canion;
       this.televisor = televisor;
    }
   
    public int getAulaNumeroAula() {
        return this.aulaNumeroAula;
    }
    
    public void setAulaNumeroAula(int aulaNumeroAula) {
        this.aulaNumeroAula = aulaNumeroAula;
    }
    public Aula getAula() {
        return this.aula;
    }
    
    public void setAula(Aula aula) {
        this.aula = aula;
    }
    public Byte getDvd() {
        return this.dvd;
    }
    
    public void setDvd(Byte dvd) {
        this.dvd = dvd;
    }
    public Byte getComputadora() {
        return this.computadora;
    }
    
    public void setComputadora(Byte computadora) {
        this.computadora = computadora;
    }
    public Byte getCanion() {
        return this.canion;
    }
    
    public void setCanion(Byte canion) {
        this.canion = canion;
    }
    public Byte getTelevisor() {
        return this.televisor;
    }
    
    public void setTelevisor(Byte televisor) {
        this.televisor = televisor;
    }




}

