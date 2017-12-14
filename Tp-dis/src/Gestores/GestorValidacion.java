/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author Temp
 */
public class GestorValidacion {

    public GestorValidacion() {
    }
    
    public boolean validarFormatoFecha(String textoFecha){
        Date fechaDato;
        String formato = "\\d{4}/\\d{2}/\\d{2}";
        //Si cumplen con el patron sigo con las comprobaciones de los numeros
        if(Pattern.matches(formato, textoFecha)){
            //Convierto en date al texto fecha ingresada
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            try {
                fechaDato = sdf.parse(textoFecha);
            } catch (ParseException ex) {
                return false;
            }
            //Convierto en String el date recién creado
            String textoConvertido = sdf.format(fechaDato);
            /*Si los dos String son iguales está bien la fecha
            Cuando se convierte a Date en String "32/05/2017" lo convierte como "01/06/2017" por lo tanto 
            Si los dos String no son iguales hay un error en los datos ingresados*/
            if(textoConvertido.equals(textoFecha)){
                return true;
            }else{
              return false;
            }                  
        }else{  //Si no cumple el formato devuelvo false
            return false;
        }
    }
    
    
    public boolean validarStringSoloConNumeros(String cantidad){
            try {
		Integer.parseInt(cantidad);
		return true;
            } catch (NumberFormatException e){
                return false;
            }
    }
    
    
    
    public boolean validarFormatoHora(String textoHora){
        String hora = textoHora.substring(0, 2);//El indice de fin no lo incluye
        String minutos = textoHora.substring(3);
        Date horaDato;
        String formato = "\\d{2}:\\d{2}";
        //Si cumplen con el patron sigo con las comprobaciones de los numeros
        if(Pattern.matches(formato, textoHora)){
            int hh = Integer.parseInt(hora);
            int mm = Integer.parseInt(minutos);
            System.out.println("hh: "+hh+" hora: "+hora+" minutos: "+minutos+" mm: "+mm+
                    " textoHora posicion 0: "+textoHora.charAt(0)+
                    " textoHora posicion 1: "+textoHora.charAt(1)+" textoHora posicion 2: "+textoHora.charAt(2)+
                    " textoHora posicion 3: "+textoHora.charAt(3)+" textoHora posicion 4: "+textoHora.charAt(4));
            //Si la hora esta dentro de las 0-23 y los minutos entre 0-59
            if(hh>=0 && hh<24 && mm>=0 && mm<60){
                return true;               
            }else{
                return false;
            }                 
        }else{  //Si no cumple el formato devuelvo false
            return false;
        }
    }
   
    public int[] validarCamposBedel(String nombre, String apellido, String usuario){
        //Utilizo un array para saber cuales campos estan correctos
        //(0=incorrecto; 1=correcto)
        
        int[] retorno = new int[3];
        retorno[0]=1;
        retorno[1]=1;
        retorno[2]=1;
        
        if(nombre.length()<2 || nombre.length()>32 || nombre.matches(".*\\d.*") || nombre.matches("[\\p{Punct}]"))
            retorno[0]=0;
        
        if(apellido.length()<2 || apellido.length()>32 || apellido.matches(".*\\d.*") || apellido.matches("[\\p{Punct}]"))
            retorno[1]=0;
        
        if(usuario.length()<6 || usuario.length()>32 || usuario.matches(".*\\d.*") || usuario.matches("[\\p{Punct}]"))
            retorno[2]=0;
        
       return retorno; 
    }
    
    public boolean validarApellido (String apellido){
        
        if(apellido.length()<2 || apellido.length()>32 || apellido.matches(".*\\d.*") || apellido.matches("[\\p{Punct}]") || apellido.matches("(.*)[%+-](.*)"))
            return false;
        else return true;
        
    }
    
    public boolean validarNombre(String nombre){
        if(nombre.length()<2 || nombre.length()>32 || nombre.matches(".*\\d.*") || nombre.matches("[\\p{Punct}]"))
            return false;
        else return true;
    }
    
}
