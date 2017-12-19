/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.FechasPeriodo;
import Persistencia.FechaPeriodoDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ayr_1
 */
public class GestorPeriodo {

    public GestorPeriodo() {
    }
    
    public FechasPeriodo getPeriodo( ){
        FechaPeriodoDAO fechaDao = new FechaPeriodoDAO();
        
        List<FechasPeriodo> listaFechas = fechaDao.getFechasPeriodos();
        FechasPeriodo retorno = null;
        
        Date today = new Date(); // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int year = cal.get(Calendar.YEAR);
        
        for(FechasPeriodo f: listaFechas){
            if(f.getAnio()==year)
                retorno=f;
        }
        return retorno;
    }
    
    public List<FechasPeriodo> fechasPeriodoActualYSiguiente(){
        List<FechasPeriodo> lista = new ArrayList<>();
        FechasPeriodo actual = this.getPeriodo();
        lista.add(actual);
        
        FechaPeriodoDAO fechaDao = new FechaPeriodoDAO();
        
        List<FechasPeriodo> listaFechas = fechaDao.getFechasPeriodos();
        
        for(FechasPeriodo f: listaFechas){
            if(f.getAnio()==actual.getAnio()+1){
                lista.add(f);
                break;
            }
        }
        
        return lista;
    }
    
    public int validarAnioReservaPeriodica(){
        Date date = new Date(); // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int yearActual = cal.get(Calendar.YEAR);
        
        FechaPeriodoDAO fechaDao = new FechaPeriodoDAO();        
        List<FechasPeriodo> listaFechas = fechaDao.getFechasPeriodos();
        
        for(FechasPeriodo f: listaFechas){
            if(f.getAnio()==yearActual){
                if(f.getFinSegundoCuatrimestre().compareTo(date)<0){
                    return yearActual+1;
                }else{
                    return yearActual;
                }
            }
        }
                
        return 0;
    }
}
