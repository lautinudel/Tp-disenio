/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.ActividadUniversitaria;
import Modelo.DiaReservaEsporadica;
import Modelo.ReservaEsporadica;
import Persistencia.ActividadUniversitariaDAO;
import java.util.List;

/**
 *
 * @author L. Nudel
 */
public class GestorListadoReservasParaActividadUniversitaria {
    
    public GestorListadoReservasParaActividadUniversitaria(){
        
    }
    
    public List buscarCursos(String nombre, boolean tipo, int anio){
        
        //buscar cursos segun nombre
        ActividadUniversitariaDAO AUDAO = new ActividadUniversitariaDAO();
        List<ActividadUniversitaria> listaCursos = AUDAO.buscarPorNombre(nombre);
        //segun tipo de reserva, elimino los cursos que no tengan ninguna reserva esporadica o periodica segun el tipo
        if(tipo){
            for(int i=0;i<listaCursos.size();i++){
                if(listaCursos.get(i).getReservaEsporadicas().isEmpty()){
                    listaCursos.remove(i);
                    i--;
                }
                
            }
        }else{
            for(int i=0;i<listaCursos.size();i++){
                if(listaCursos.get(i).getReservaPeriodicas().isEmpty()){
                    listaCursos.remove(i);
                    i--;
                }
            } 
        }
        //verifico el año
        
        //lista de los cursos
        for(int i=0;i<listaCursos.size();i++){
            //reserva esporadicas para cada curso
            for(ReservaEsporadica re: listaCursos.get(i).getReservaEsporadicas()){
                //dias de cada reserva, verificar el año
                for(DiaReservaEsporadica dre : re.getDiaReservaEsporadicas()){
                   // if(dre.getId().getDia().)
                }
            }
        }
        
        
        return listaCursos;
    }
    
    
}
