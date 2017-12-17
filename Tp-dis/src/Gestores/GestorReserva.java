/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.Docente;
 import Modelo.ActividadUniversitaria;
 
import Modelo.ReservaEsporadica;
import Modelo.ReservaPeriodica;
import Persistencia.ActividadUniversitariaDAO;
import Persistencia.DocenteDao;
import Persistencia.NewHibernateUtil;
import Persistencia.ReservaEsporadicaDao;
import Persistencia.ReservaPeriodicaDao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.ArrayList; 
import java.util.Date;

/**
 *
 * @author Temp
 */
public class GestorReserva {

    public GestorReserva() {
    }
    /*
    public boolean validarUnicidad(Date fechaAValidar, Date horaAValidar){
        GestorValidacion gestorVal = new GestorValidacion();
 
        return gestorVal.valUnicidad(fechaAValidar, horaAValidar);
 
    }*/
    
    
    public boolean validarUnicidad(String fechaAValidar, String horaAValidar, ArrayList<String> fechas, ArrayList<String> horariosInicio){
 
        GestorValidacion gestorVal = new GestorValidacion();
 
        return gestorVal.valUnicidad(fechaAValidar, horaAValidar, fechas, horariosInicio);
 
    }
    
    public void registrarReserva(ReservaEsporadica reserva){
        ReservaEsporadicaDao reservaDao = new ReservaEsporadicaDao();
        reservaDao.registrar(reserva);
        
    }
    
    public void registrarReserva(ReservaPeriodica reserva){
        ReservaPeriodicaDao reservaDao = new ReservaPeriodicaDao();
        reservaDao.registrar(reserva);
        
    }
            
            
            
    public int validarTipoDeDatos(String docenteApellido, String docenteNombre, String catedraDato, String emailDato){
        GestorValidacion gestorVal = new GestorValidacion();
        GestorDocente gestorDocente = new GestorDocente();
        GestorActividad gestorActividad = new GestorActividad();
        
 
        boolean actUniv = gestorActividad.verificarExistencia(catedraDato); 
        //Si el nombre y el apellido son solo texto, si existe el docente y la actividad universitaria devuelvo 0 (caso de exito)
        boolean encontrado=false;
 
        /*for(ActividadUniversitaria au : listaDocente.get(0).getActividadUniversitarias()){
 
            if(au.getNombre().equals(catedraDato)) encontrado=true;
 
        }*/
        
        if(gestorVal.validarNombre(docenteNombre) && gestorVal.validarApellido(docenteApellido)){ //valido campo nombre y apellido del docente
            boolean existeDocente = gestorDocente.verificarExistencia(docenteApellido, docenteNombre, emailDato);
            if(existeDocente){
                if(actUniv){
                    Docente d = gestorDocente.obtenerDocente(docenteApellido, docenteNombre, emailDato);
                    for(ActividadUniversitaria au: d.getActividadUniversitarias()){
                        if(au.getNombre().equals(catedraDato)) encontrado=true;
                    }
                    if(encontrado)return 0;
                    else return 4;
                }else{
                    return 3;
                }
            }else{
                return 2;
            }
        }else{
           return 1; 
        } 
        
        
        /*if(encontrado){
 
           if(gestorVal.validarNombre(docenteNombre) && gestorVal.validarApellido(docenteApellido) && !listaDocente.isEmpty() && actUniv){
 
 
                return 0;
            }else{
            //Si los campos nombre o apellido contienen más que letras o no empiezan con mayuscula inicial
            if(!gestorVal.validarStringNombreyApellido(docenteNombre) || !gestorVal.validarStringNombreyApellido(docenteApellido)){
                return 1;
            }
            //Si no existe el docente( la lista que devuelve está vacia o no contiene un unico elemento)
            if(listaDocente.isEmpty() || listaDocente.size()  != 1){
                return 2;
            }
            //Si no existe la actividad
            if(!actUniv){
 
                return 3;
            }
            }
        }else return 4;*/
 
        
 
    }
    
    public boolean validarStringSoloConNumeros(String cadena){
        GestorValidacion gestorVal = new GestorValidacion();
        return gestorVal.validarStringSoloConNumeros(cadena);
    }
    
    
    public boolean validarDiasPosterioresAlActual(Date fecha){
 
        GestorValidacion gestorVal = new GestorValidacion();
 
        return gestorVal.validarDias(fecha);
 
    }
 
    
    public boolean reservaEsporadicaActiva(int idReservaEsporadica){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery("SELECT r FROM ReservaEsporadica r WHERE idReservaEsporadica = :id AND activo = 0");
        query.setParameter("id", idReservaEsporadica);
        List<ReservaEsporadica> listaReserva = query.list();
        if(listaReserva.isEmpty())
            return false;
        else
            return true;
    }
    
    public boolean reservaPeriodicaActiva(int idReservaPeriodica){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery("SELECT r FROM ReservaPeriodica r WHERE idReservaEsporadica = :id AND activo = 0");
        query.setParameter("id", idReservaPeriodica);
        List<ReservaPeriodica> listaReserva = query.list();
        if(listaReserva.isEmpty())
            return false;
        else
            return true;
    }
}

