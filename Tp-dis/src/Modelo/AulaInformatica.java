package Modelo;
// Generated 26/10/2017 14:37:37 by Hibernate Tools 4.3.1



/**
 * AulaInformatica generated by hbm2java
 */
public class AulaInformatica  implements java.io.Serializable {


     private int aulaNumeroAula;
     private Aula aula;
     private int cantidadPc;
     private byte canion;

    public AulaInformatica() {
    }

    public AulaInformatica(Aula aula, int cantidadPc, byte canion) {
       this.aula = aula;
       this.cantidadPc = cantidadPc;
       this.canion = canion;
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
    public int getCantidadPc() {
        return this.cantidadPc;
    }
    
    public void setCantidadPc(int cantidadPc) {
        this.cantidadPc = cantidadPc;
    }
    public byte getCanion() {
        return this.canion;
    }
    
    public void setCanion(byte canion) {
        this.canion = canion;
    }




}


