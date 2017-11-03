/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;


import Modelo.PoliticaClave;
import Persistencia.PoliticaDAO;
/**
 *
 * @author L. Nudel
 */
public class GestorPoliticas {
    
    
     public Boolean validarPoliticas(String pass){
        Boolean r=false;
        int id_politica = 1;
        PoliticaDAO poli = new PoliticaDAO();
        PoliticaClave politica = poli.buscarPolitica(id_politica);
        /*Valido la contraseña*/
        if (politica.getLongitudMin() <= pass.length() && politica.getLongitudMax() >= pass.length()){
            switch (politica.getNumeros()){
		case 0: if(!numeros(pass)){
                            r=true;
                            break;
			}else{
                            return false;
			}
		case 1: if(numeros(pass)){
                            r=true;
                            break;
			}else{
                            return false;
			}
            }
            switch (politica.getMayusculas()){
		case 0: if(!mayusculas(pass)){
                            r=true;
                            break;
			}else{
                            return false;
			}
		case 1: if(mayusculas(pass)){
                            r=true;
                            break;
			}else{
                            return false;
			}
            }
            switch (politica.getMinusculas()){
		case 0: if(!minusculas(pass)){
                            r=true;
                            break;
			}else{
                            return false;
			}
		case 1: if(minusculas(pass)){
                            r=true;
                            break;
                        }else{
                            return false;
			}
            }
            switch (politica.getCararcteresEsp()){
                case 0: if(!caracteres(pass)){
                            r=true;
                            break;
			}else{
                            return false;
			}
		case 1: if(caracteres(pass)){
                            r=true;
                            break;
			}else{
                            return false;
			}
            } 
        }else{
            return false;
        }
        return r;
    }
    
    private boolean minusculas(String password){
       char clave;
       int i=0;
       boolean tiene_min = false;
       while (i < password.length() && tiene_min == false){
            clave = password.charAt(i);
            String passValue = String.valueOf(clave);
            if (passValue.matches("[a-z]")) {
                    tiene_min = true;
            }
            i++;
       }
       return tiene_min;
    }
    
    private boolean mayusculas(String password){
       char clave;
       int i=0;
       boolean tiene_max = false;
       while (i < password.length() && tiene_max == false){
            clave = password.charAt(i);
            String passValue = String.valueOf(clave);
            if (passValue.matches("[A-Z]")) {
                    tiene_max = true;
            }
            i++;
       }
       return tiene_max;
    }
     
    private boolean numeros(String password){
       char clave;
       int i=0;
       boolean tiene_num = false;
       while (i < password.length() && tiene_num== false){
            clave = password.charAt(i);
            String passValue = String.valueOf(clave);
            if (passValue.matches("[0-9]")) {
                    tiene_num = true;
            }
            i++;
       }
       return tiene_num;
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
    public GestorPoliticas() {
    }
}
