package Modelo;
// Generated 27/10/2017 22:11:40 by Hibernate Tools 4.3.1



/**
 * AulaSinRecursosAdicionales generated by hbm2java
 */
public class AulaSinRecursosAdicionales  implements java.io.Serializable {


     private int aulaNumeroAula;
     private Aula aula;
     private byte ventiladores;

    public AulaSinRecursosAdicionales() {
    }

    public AulaSinRecursosAdicionales(Aula aula, byte ventiladores) {
       this.aula = aula;
       this.ventiladores = ventiladores;
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
    public byte getVentiladores() {
        return this.ventiladores;
    }
    
    public void setVentiladores(byte ventiladores) {
        this.ventiladores = ventiladores;
    }




}

