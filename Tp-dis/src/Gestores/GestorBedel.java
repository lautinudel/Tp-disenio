/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.*;
import Persistencia.BedelDAO;
import java.util.ArrayList;

/**
 *
 * @author Temp
 */
public class GestorBedel {
    
    public int registrarBedel(String nombre, String apellido, 
            String turno, String username, String pass, String passConfirmado){
   
       GestorPoliticas g = new GestorPoliticas();
       BedelDAO bedeldao = new BedelDAO();
       
       if(bedeldao.verificarExistencia(username)){
           
            if (g.validarPoliticas(pass)){
                
                if(compararPassword(pass, passConfirmado)){
                     //
                     //CREAR LA INSTANCIA DE LA CLAVE, ASOCIARLA AL BEDEL Y GUARDARLA//
                     //
                    Bedel nuevo = new Bedel(username, nombre, apellido, turno); 
                    bedeldao.guardarBedel(nuevo);
                     
                }else{
                    return 2;
                }
            }else{
               return 1;
            }
       }else{
           return 3;
       }
       
       return 0;
    }
    
    public Boolean compararPassword(String pass, String passConfirmado){
        return pass.equals(passConfirmado);
    }
        
}
