/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.ActividadUniversitaria;
import Persistencia.ActividadUniversitariaDAO;

/**
 *
 * @author ayr_1
 */
public class GestorActividad {

    public GestorActividad() {
    }
  
    public ActividadUniversitaria obtenerIdActividad(String nombreActividad){
        ActividadUniversitariaDAO actividadDao = new ActividadUniversitariaDAO();
        return actividadDao.obtenerActividad(nombreActividad);
    }
    
    public Boolean verificarExistencia(String nombreActividad){
        ActividadUniversitariaDAO actividadDao = new ActividadUniversitariaDAO();
        return actividadDao.verificarExistencia(nombreActividad);
    }
}
