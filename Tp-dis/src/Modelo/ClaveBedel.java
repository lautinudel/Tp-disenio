package Modelo;
// Generated 26/10/2017 14:37:37 by Hibernate Tools 4.3.1



/**
 * ClaveBedel generated by hbm2java
 */
public class ClaveBedel  implements java.io.Serializable {


     private ClaveBedelId id;
     private Bedel bedel;

    public ClaveBedel() {
    }

    public ClaveBedel(ClaveBedelId id, Bedel bedel) {
       this.id = id;
       this.bedel = bedel;
    }
   
    public ClaveBedelId getId() {
        return this.id;
    }
    
    public void setId(ClaveBedelId id) {
        this.id = id;
    }
    public Bedel getBedel() {
        return this.bedel;
    }
    
    public void setBedel(Bedel bedel) {
        this.bedel = bedel;
    }




}


