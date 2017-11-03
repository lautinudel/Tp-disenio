/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.*;
import Persistencia.BedelDAO;
import Persistencia.ClaveDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Temp
 */
public class GestorBedel {
    
    public int registrarBedel(String nombre, String apellido, 
            String turno, String username, String pass, String passConfirmado){
   
       GestorPoliticas g = new GestorPoliticas();
       BedelDAO bedeldao = new BedelDAO();
       ClaveDao clavedao = new ClaveDao();
       /*TurnoTrabaja turnoT = null;
       
       switch (turno){
           case "Mañana": turnoT = TurnoTrabaja.MANIANA;break;
           case "Tarde": turnoT = TurnoTrabaja.TARDE;break;
           case "Noche": turnoT = TurnoTrabaja.NOCHE;break;
       }*/

       
       //if(bedeldao.verificarExistencia(username)){
           
            if (g.validarPoliticas(pass)){

                if(compararPassword(pass, passConfirmado)){
                     //
                     //CREAR LA INSTANCIA DE LA CLAVE, ASOCIARLA AL BEDEL Y GUARDARLA//
                    ClaveBedelId clave = new ClaveBedelId(pass,username,new Date());
                    
                    Bedel nuevo = new Bedel(username, nombre, apellido, turno); 
                    
                    ClaveBedel claveBedel = new ClaveBedel(clave,nuevo);
                    
                    nuevo.getClaveBedels().add(claveBedel);
                    
                    bedeldao.guardarBedel(nuevo);
                    
                    clavedao.guardarClaveBedel(claveBedel);
                     
                }else{
                    return 2;
                }
            }else{
               return 1;
            }
       /*}else{
           return 3;
       }*/
       
       return 0;
    }
    
    public Boolean compararPassword(String pass, String passConfirmado){
        return pass.equals(passConfirmado);
    }
        
}
