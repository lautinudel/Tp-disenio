package Modelo;
// Generated 03/11/2017 21:00:49 by Hibernate Tools 4.3.1



/**
 * PoliticaClave generated by hbm2java
 */
public class PoliticaClave  implements java.io.Serializable {


     private int idPolitica;
     private String nombrePolitica;
     private Integer longitudMin;
     private Integer longitudMax;
     private Byte numeros;
     private Byte cararcteresEsp;
     private Byte minusculas;
     private Byte mayusculas;
     private Byte vigente;

    public PoliticaClave() {
    }

	
    public PoliticaClave(int idPolitica) {
        this.idPolitica = idPolitica;
    }
    public PoliticaClave(int idPolitica, String nombrePolitica, Integer longitudMin, Integer longitudMax, Byte numeros, Byte cararcteresEsp, Byte minusculas, Byte mayusculas, Byte vigente) {
       this.idPolitica = idPolitica;
       this.nombrePolitica = nombrePolitica;
       this.longitudMin = longitudMin;
       this.longitudMax = longitudMax;
       this.numeros = numeros;
       this.cararcteresEsp = cararcteresEsp;
       this.minusculas = minusculas;
       this.mayusculas = mayusculas;
       this.vigente = vigente;
    }
   
    public int getIdPolitica() {
        return this.idPolitica;
    }
    
    public void setIdPolitica(int idPolitica) {
        this.idPolitica = idPolitica;
    }
    public String getNombrePolitica() {
        return this.nombrePolitica;
    }
    
    public void setNombrePolitica(String nombrePolitica) {
        this.nombrePolitica = nombrePolitica;
    }
    public Integer getLongitudMin() {
        return this.longitudMin;
    }
    
    public void setLongitudMin(Integer longitudMin) {
        this.longitudMin = longitudMin;
    }
    public Integer getLongitudMax() {
        return this.longitudMax;
    }
    
    public void setLongitudMax(Integer longitudMax) {
        this.longitudMax = longitudMax;
    }
    public Byte getNumeros() {
        return this.numeros;
    }
    
    public void setNumeros(Byte numeros) {
        this.numeros = numeros;
    }
    public Byte getCararcteresEsp() {
        return this.cararcteresEsp;
    }
    
    public void setCararcteresEsp(Byte cararcteresEsp) {
        this.cararcteresEsp = cararcteresEsp;
    }
    public Byte getMinusculas() {
        return this.minusculas;
    }
    
    public void setMinusculas(Byte minusculas) {
        this.minusculas = minusculas;
    }
    public Byte getMayusculas() {
        return this.mayusculas;
    }
    
    public void setMayusculas(Byte mayusculas) {
        this.mayusculas = mayusculas;
    }
    public Byte getVigente() {
        return this.vigente;
    }
    
    public void setVigente(Byte vigente) {
        this.vigente = vigente;
    }




}


