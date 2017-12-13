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
import java.util.List;

/**
 *
 * @author Temp
 */
public class GestorBedel {
    
    public int registrarBedel(String nombre, String apellido, 
            String turno, String username, String pass, String passConfirmado){
   
       GestorPoliticas g = new GestorPoliticas();
       BedelDAO bedeldao = new BedelDAO();
       //ClaveDao clavedao = new ClaveDao();
       
       TurnoEnum turnoT = null;
       
       switch (turno){
           case "Mañana": turnoT = TurnoEnum.Maniana;break;
           case "Tarde": turnoT = TurnoEnum.Tarde;break;
           case "Noche": turnoT = TurnoEnum.Noche;break;
       }

       
       if(!(bedeldao.verificarExistencia(username))){
           
            if (compararPassword(pass, passConfirmado)){

                if(g.validarPoliticas(pass)){
                                        
                    ClaveBedelId clave = new ClaveBedelId(pass,username,new Date());
                    
                    Bedel nuevo = new Bedel(username, nombre, apellido, turnoT); 
                    
                    ClaveBedel claveBedel = new ClaveBedel(clave,nuevo);
                    
                    nuevo.getClaveBedels().add(claveBedel);
                    
                    bedeldao.guardarBedel(nuevo,claveBedel);
                     
                }else{
                    return 1;
                }
            }else{
               return 2;
            }
       }else{
           return 3;
       }
       
       return 0;
    }
    
    public Boolean compararPassword(String pass, String passConfirmado){
        return pass.equals(passConfirmado);
    }
    public int modificarBedel(String nombre, String apellido, String username, String turno, String pass, String passConfirmado, Bedel b){
        GestorPoliticas g = new GestorPoliticas();
        BedelDAO bedeldao = new BedelDAO();
        
        b.setApellido(apellido);
        b.setNombre(nombre);
        switch (turno){
           case "Mañana": b.setTurnoTrabaja(TurnoEnum.Maniana);break;
           case "Tarde": b.setTurnoTrabaja(TurnoEnum.Tarde);break;
           case "Noche": b.setTurnoTrabaja(TurnoEnum.Noche);break;
       }
        
        if(this.compararPassword(pass, passConfirmado)){
          if(g.validarPoliticas(pass)){
              ClaveBedelId clave = new ClaveBedelId(pass,username,new Date());
               ClaveBedel claveBedel = new ClaveBedel(clave,b);
               
          }else return 1;
            bedeldao.modificarBedel(nombre, apellido, username, turno);
        }else return 2;
        
        
        return 0;
    }
    
    public List<Bedel> buscarBedelApellido (String apellido){
        BedelDAO BDAO = new BedelDAO();
        List<Bedel> bedeles = BDAO.buscarPorApellido(apellido);
        
        return bedeles;
        
    } 
    
    public List<Bedel> buscarBedelTurno(TurnoEnum turno){
       BedelDAO BDAO = new BedelDAO();
       List<Bedel> bedeles = BDAO.buscarPorTurno(turno);
       return bedeles;
    }
    
    public List<Bedel> buscarBedelApellidoyTurno(String Apellido, TurnoEnum turno){
        BedelDAO BDAO = new BedelDAO();
       List<Bedel> bedeles = BDAO.buscarBedelApellidoyTurno(Apellido, turno);
       return bedeles;
    }
        
}
