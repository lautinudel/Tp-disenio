/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.ActividadUniversitaria;
import Modelo.DiaReservaEsporadica;
import Modelo.DiaReservaPeriodica;
import Modelo.ReservaEsporadica;
import Modelo.ReservaPeriodica;
import Persistencia.ActividadUniversitariaDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                //elimino los cursos que no tengan reservas
                if(listaCursos.get(i).getReservaEsporadicas().isEmpty()){
                    listaCursos.remove(i);
                    i--;
                }
                //elimino los cursos que no sean exactamente el nombre buscado
                if(!listaCursos.get(i).getNombre().equals(nombre)) {
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
             //elimino los cursos que no sean exactamente el nombre buscado
                if(!listaCursos.get(i).getNombre().equals(nombre)) {
                    listaCursos.remove(i);
                    i--;
                }   
            } 
        }
        //elimino los duplicados
        for(int i=0;i<listaCursos.size();i++){
                for(int j=0;j<listaCursos.size();j++){
                    if(j!=i){
                        if(listaCursos.get(j).getIdActividad()==listaCursos.get(i).getIdActividad())
                         listaCursos.remove(j);
                        j--;
                    }
                }}
        //verifico el año
        Set listaARemoverDia = new HashSet(0);
        Set listaARemoverR = new HashSet(0);
        if(tipo){
            //lista de los cursos
            for(int i=0;i<listaCursos.size();i++){
                //reserva esporadicas para cada curso
                for(ReservaEsporadica re: listaCursos.get(i).getReservaEsporadicas()){
                    //dias de cada reserva, verificar el año
                     for(DiaReservaEsporadica dre : re.getDiaReservaEsporadicas()){
                         if(this.obtenerAnio(dre.getId().getDia())!=anio)
                          listaARemoverDia.add(dre);
                   
                        }
                     re.removerElementos(listaARemoverDia);
                    if(re.getDiaReservaEsporadicas().isEmpty()){
                    listaARemoverR.add(re);
                    }
                }
                listaCursos.get(i).removerReservaEsporadica(listaARemoverR);
                if(listaCursos.get(i).getReservaEsporadicas().isEmpty()){
                listaCursos.remove(i);
                i--;
                }
            }
        }else{
          
            //lista de los cursos
            for(int i=0;i<listaCursos.size();i++){
                //reserva esporadicas para cada curso
                for(ReservaPeriodica rp: listaCursos.get(i).getReservaPeriodicas()){
                    //dias de cada reserva, verificar el año
                     for(DiaReservaPeriodica drp : rp.getDiaReservaPeriodicas()){
                           System.out.println(drp.getId().getAnio()+"--"+anio);
                         if(drp.getId().getAnio()!=anio)
                          listaARemoverDia.add(drp);
                   
                        }
                     rp.removerElementos(listaARemoverDia);
                    if(rp.getDiaReservaPeriodicas().isEmpty()){
                    listaARemoverR.add(rp);
                    }
                }
                listaCursos.get(i).removerReservaPeriodica(listaARemoverR);
                if(listaCursos.get(i).getReservaPeriodicas().isEmpty()){
                listaCursos.remove(i);
                i--;
                }
            }
            System.out.println(listaCursos.size());
            for(int i=0;i<listaCursos.size();i++){
                System.out.println(listaCursos.get(i).getReservaPeriodicas().size());
                 for(ReservaPeriodica rp: listaCursos.get(i).getReservaPeriodicas()){
                     System.out.println(rp.getDiaReservaPeriodicas().size());
                 }
            }
            
            
        }
        
        
        
        return listaCursos;
    }
    
    
    public int obtenerAnio(Date date){

        if (null == date){

            return 0;

        }
        else{

            String formato="yyyy";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));

        }

    }
    
}
