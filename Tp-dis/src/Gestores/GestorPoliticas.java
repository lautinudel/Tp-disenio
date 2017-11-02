/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;


import Modelo.PoliticaClave;
import Persistencia.PoliticaDAO;
import javax.management.Query;
import javax.swing.JOptionPane;
import javax.transaction.Transaction;
import org.hibernate.SessionFactory;

/**
 *
 * @author L. Nudel
 */
public class GestorPoliticas {
    
    
    public Boolean validarPoliticas(String pass){
        Boolean r=false;
        int id_politica = 1;
        PoliticaDAO p = new PoliticaDAO();
        PoliticaClave politica = p.buscarPolitica(id_politica);
        /*Valido la contraseña*/
        if (politica.getLongitudMin() <= pass.length() && politica.getLongitudMax() >= pass.length()){
            switch (politica.getNumeros()){
		case 0: if(!pass.matches("\\d"/*"[0-9]"*/)){
                            r=true;
                            break;
			}else{
                            JOptionPane.showMessageDialog(null,"La contraseña no debe tener números");
                            return false;
			}
		case 1: if(pass.matches("\\d"/*"[0-9]"*/)){
                            r=true;
                            break;
			}else{
                            JOptionPane.showMessageDialog(null,"La contraseña debe tener números");
                            return false;
			}
            }
            switch (politica.getMayusculas()){
		case 0: if(!pass.matches("\\p{Upper}"/*"[A-Z]"*/)){
                            r=true;
                            break;
			}else{
                            JOptionPane.showMessageDialog(null,"La contraseña no debe tener mayusculas");
                            return false;
			}
		case 1: if(pass.matches("\\p{Upper}"/*"[A-Z]"*/)){
                            r=true;
                            break;
			}else{
                            JOptionPane.showMessageDialog(null,"La contraseña  debe tener mayusculas");
                            return false;
			}
            }
            switch (politica.getMinusculas()){
		case 0: if(!pass.matches("\\p{Lower}"/*"[a-z]"*/)){
                            r=true;
                            break;
			}else{
                            JOptionPane.showMessageDialog(null,"La contraseña no debe tener minusculas");
                            return false;
			}
		case 1: if(pass.matches("\\p{Lower}"/*"[a-z]"*/)){
                            r=true;
                            break;
			}else{
                            JOptionPane.showMessageDialog(null,"La contraseña debe tener minusculas");
                            return false;
			}
		}
            switch (politica.getCararcteresEsp()){
                case 0: if(!pass.matches("\\p{Punct}")){
                            r=true;
                            break;
			}else{
                            JOptionPane.showMessageDialog(null,"La contraseña no debe tener caracteres especiales");
                            return false;
			}
		case 1: if(pass.matches("\\p{Punct}")){
                            r=true;
                            break;
			}else{
                            JOptionPane.showMessageDialog(null,"La contraseña  debe tener caracteres especiales");
                            return false;
			}
            }                                                  
        }else{
            return false;
        }
        return r;
    }

    public GestorPoliticas() {
    }
}
