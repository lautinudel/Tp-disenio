package Modelo;
// Generated 26/10/2017 14:37:37 by Hibernate Tools 4.3.1



/**
 * PoliticaClave generated by hbm2java
 */
public class PoliticaClave  implements java.io.Serializable {


     private int idPolitica;
     private String nombrePolitica;
     private Integer longitudMin;
     private Integer longitadMax;
     private Byte numeros;
     private Byte letras;
     private Byte cararcteresEsp;
     private Byte minusculas;
     private Byte mayusculas;

    public PoliticaClave() {
    }

	
    public PoliticaClave(int idPolitica) {
        this.idPolitica = idPolitica;
    }
    public PoliticaClave(int idPolitica, String nombrePolitica, Integer longitudMin, Integer longitadMax, Byte numeros, Byte letras, Byte cararcteresEsp, Byte minusculas, Byte mayusculas) {
       this.idPolitica = idPolitica;
       this.nombrePolitica = nombrePolitica;
       this.longitudMin = longitudMin;
       this.longitadMax = longitadMax;
       this.numeros = numeros;
       this.letras = letras;
       this.cararcteresEsp = cararcteresEsp;
       this.minusculas = minusculas;
       this.mayusculas = mayusculas;
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
    public Integer getLongitadMax() {
        return this.longitadMax;
    }
    
    public void setLongitadMax(Integer longitadMax) {
        this.longitadMax = longitadMax;
    }
    public Byte getNumeros() {
        return this.numeros;
    }
    
    public void setNumeros(Byte numeros) {
        this.numeros = numeros;
    }
    public Byte getLetras() {
        return this.letras;
    }
    
    public void setLetras(Byte letras) {
        this.letras = letras;
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




}


