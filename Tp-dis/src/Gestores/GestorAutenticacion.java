/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.Administrador;
import Modelo.Bedel;
import Modelo.ClaveAdministrador;
import Modelo.ClaveBedel;
import Persistencia.AdministradorDAO;
import Persistencia.BedelDAO;
import Persistencia.ClaveDao;

/**
 *
 * @author L. Nudel
 */
public class GestorAutenticacion {
    
    public GestorAutenticacion(){
        
    }
    
    public int autenticarUsuario(String usuario, String pass){
        BedelDAO BDAO = new BedelDAO();
        //ClaveDao CDAO = new ClaveDao();
        AdministradorDAO ADAO = new AdministradorDAO();
        if(BDAO.verificarExistencia(usuario)){
            Bedel b = BDAO.obtenerBedel(usuario);
            ClaveBedel cb=null;
            ClaveBedel cAnterior=null;
            //busco la contraseña mas actual
                    
            for(ClaveBedel c: b.getClaveBedels()){
                if(cb==null){
                    cb=c;
                    cAnterior=c;        
                }else{
                    if(c.getId().getFecha().compareTo(cAnterior.getId().getFecha())>0){
                        cb=c;
                        cAnterior=c;
                    }else cAnterior=c;
                }            
            }
                  
            //verifico si la clave concuerda
            if(cb.getId().getValor().equals(pass) && cb.getId().getBedelUsername().equals(b.getUsername())){
                //ir al menu de bedel
                return 1;    
            }else{
                //mensaje de datos invalidos:
                return 2;
            }
                    
        }else{
            //verifico si el admin existe
            if(ADAO.verificarExistencia(usuario)){
                Administrador a = ADAO.obtenerAdministrador(usuario);
                ClaveAdministrador ca=null;
                ClaveAdministrador cAnt=null;
                
                for(ClaveAdministrador c: a.getClaveAdministradors()){
                    if(ca==null){
                        ca=c;
                        cAnt=c;        
                    }else{
                        if(c.getId().getFecha().compareTo(cAnt.getId().getFecha())>0){
                            ca=c;
                            cAnt=c;
                        }else cAnt=c;
                    }
                }
                
                //verifico si la clave concuerda
                if(ca.getId().getValor().equals(pass) && ca.getId().getAdministradorUsername().equals(a.getUsername())){
                        //ir al menu de admin
                        return 3;
                }else{
                    //mensaje de datos invalidos:
                    return 2;
                }
                        
        }else{
            //mensaje de usuario inexistente:
            return 4;
        }
        }
    }
}
