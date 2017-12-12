/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import java.util.ArrayList;

/**
 *
 * @author Temp
 */
public class GestorValidacion {

    public GestorValidacion() {
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
}
