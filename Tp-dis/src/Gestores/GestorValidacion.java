/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;


import Modelo.TipoAula;
import Persistencia.ReservaEsporadicaDao;
import Persistencia.ReservaPeriodicaDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.regexp.joni.Matcher;

/**
 *
 * @author Temp
 */
public class GestorValidacion {

    public GestorValidacion() {
    }
    
    
    
    public boolean validarFormatoFecha(String textoFecha){
        Date fechaDato;
        String formato = "\\d{4}-\\d{2}-\\d{2}";
 
        //Si cumplen con el patron sigo con las comprobaciones de los numeros
        if(Pattern.matches(formato, textoFecha)){
            //Convierto en date al texto fecha ingresada
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 
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
    
    public boolean validarStringNombreyApellido(String nombre){
        Pattern pat = Pattern.compile("[A-Z][a-z]*");
        java.util.regex.Matcher mat = pat.matcher(nombre);
        if (mat.matches()) {
            return true;
        } else {
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
    
     public Boolean validarDias(Date fecha){
 
        java.util.Date fechaActual = new Date();
 
        //compareTo devuelve 0 si son iguales, un numero menor a 0 si fecha>fechaActual y un numero mayor a 0 si fecha<fechaActual
 
        if (fechaActual.compareTo(fecha)<0){
 
            return true;
 
        }else{
 
            return false;
 
        }
 
        
 
    }
 /*
    public boolean valUnicidad(Date fechaAValidar, Date horaAValidar){
        ReservaPeriodicaDao reservaPeriodicaDao = new ReservaPeriodicaDao();
        ReservaEsporadicaDao reservaEsporadicaDao = new ReservaEsporadicaDao();
        
        //Comprueb unicidad  en las reservas -- Si ambas me devuelven true (no hay solapamiento) se manda true en cualquier otro caso se manda false
        return (reservaEsporadicaDao.unicaReserva(fechaAValidar,  horaAValidar) && 
                reservaPeriodicaDao.unicaReserva(fechaAValidar,  horaAValidar));
        
    }*/
 
    public Boolean valUnicidad(String fechaAValidar, String horaAValidar, ArrayList<String> fechas, ArrayList<String> horariosInicio, TipoAula tipo, ArrayList<TipoAula> tiposAula){
 
        boolean esUnico = false;
 
        //Validar que las listas no estén vacias
 
        //Si las fechas están vacias los horarios también tendrían que estar vacias (lo pongo por las dudas)
 
        //Si los array están vacios es unico
 
        if(!fechas.isEmpty() && !horariosInicio.isEmpty() && !tiposAula.isEmpty()){
 
            //Si no contiene a la fecha es unico 
 
            if (!fechas.contains(fechaAValidar)){
 
                //esUnico = true;
 
                return true;
 
            }else{
 
                //Sino si el horario inicio es diferente es unico
 
                //Necesito el indice para validar el horario
 
                int fila = -1;
 
                int i=0;
 
                while (fila == -1 && i < fechas.size()){
 
                    if(fechas.get(i).equalsIgnoreCase(fechaAValidar)){
 
                        fila = i;
 
                    }
 
                }
 
                if(!horariosInicio.get(fila).equalsIgnoreCase(horaAValidar)){
 
                    //esUnico = true;
 
                    return true;
 
                }else{
                    if(horariosInicio.get(fila).equalsIgnoreCase(horaAValidar) && (!tiposAula.get(fila).equals(tipo))){
                        return true;
                    }
                }
 
            }
 
        }else{
 
            return true;
 
        }
 
    
 
        return esUnico;
 
    }
 
    
    public boolean validarFormatoHora(String textoHora){
        if(textoHora.length() == 5){
            String hora = textoHora.substring(0, 2);//El indice de fin no lo incluye
            String minutos = textoHora.substring(3);
        
            String formato = "\\d{2}:\\d{2}";
            //Si cumplen con el patron sigo con las comprobaciones de los numeros
            if(Pattern.matches(formato, textoHora)){
                int hh = Integer.parseInt(hora);
                int mm = Integer.parseInt(minutos);
                //Si la hora esta dentro de las 0-23 y los minutos entre 0-59
                if(hh>=0 && hh<24 && mm>=0 && mm<60){
                    return true;               
                }else{
                    return false;
                }                 
            }else{  //Si no cumple el formato devuelvo false
                return false;
            }
        }else{
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
        
        if(nombre.length()<2 || nombre.length()>32 || nombre.matches(".*\\d.*") || nombre.matches("[\\p{Punct}]") || this.caracteres(nombre)/*nombre.matches("(.*)[%+-;&$=*#!¡](.*)")*/)
            retorno[0]=0;
        
        if(apellido.length()<2 || apellido.length()>32 || apellido.matches(".*\\d.*") || apellido.matches("[\\p{Punct}]") || this.caracteres(apellido)/*apellido.matches("(.*)[%+-;&$=*#!¡](.*)")*/)
            retorno[1]=0;
        
        if(usuario.length()<6 || usuario.length()>32 || usuario.matches(".*\\d.*") || usuario.matches("[\\p{Punct}]") || this.caracteres(usuario)/*usuario.matches("(.*)[%+-;&$=*#!¡](.*)")*/)
            retorno[2]=0;
        
       return retorno; 
    }
    private boolean caracteres(String password){
       char clave;
       int i=0;
       boolean tiene_carac = false;
       while (i < password.length() && tiene_carac== false){
            clave = password.charAt(i);
            String passValue = String.valueOf(clave);
            /*\\p{Punct}	Punctuation: One of !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~*/
            if (passValue.matches("\\p{Punct}")) {
                    tiene_carac = true;
            }
            i++;
       }
       return tiene_carac;
    }
    
    public boolean validarApellido (String apellido){
        
        if(apellido.length()<2 || apellido.length()>32 || apellido.matches(".*\\d.*") || apellido.matches("[\\p{Punct}]") || this.caracteres(apellido)/*apellido.matches("(.*)[%+-;&$=*#!¡](.*)")*/)
            return false;
        else return true;
        
    }
    
    public boolean validarApellidoCaracEspeciales (String apellido){
        
        if(/*apellido.length()<2 || */apellido.length()>32 || apellido.matches(".*\\d.*") || apellido.matches("[\\p{Punct}]") || /*apellido.matches("(.*)[%+-;&$=*#!¡](.*)")*/this.caracteres(apellido))
            return false;
        else return true;
        
    }
    
    public boolean validarNombre(String nombre){
        if(nombre.length()<2 || nombre.length()>32 || nombre.matches(".*\\d.*") || nombre.matches("[\\p{Punct}]") ||/* nombre.matches("(.*)[%+-;&$=*#!¡](.*)")*/this.caracteres(nombre))
            return false;
        else return true;
    }
    
}
