/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Temp
 */
public class FechasPeriodo {
    private int anio;
    private Date inicioPrimerCuatrimestre;
    private Date finPrimerCuatrimestre;
    private Date inicioSegundoCuatrimestre;
    private Date finSegundoCuatrimestre;

    public FechasPeriodo() {
    }

    public FechasPeriodo(int anio, Date inicioPrimerCuatrimestre, Date finPrimerCuatrimestre, Date inicioSegundoCuatrimestre, Date finSegundoCuatrimestre) {
        this.anio = anio;
        this.inicioPrimerCuatrimestre = inicioPrimerCuatrimestre;
        this.finPrimerCuatrimestre = finPrimerCuatrimestre;
        this.inicioSegundoCuatrimestre = inicioSegundoCuatrimestre;
        this.finSegundoCuatrimestre = finSegundoCuatrimestre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Date getInicioPrimerCuatrimestre() {
        return inicioPrimerCuatrimestre;
    }

    public void setInicioPrimerCuatrimestre(Date inicioPrimerCuatrimestre) {
        this.inicioPrimerCuatrimestre = inicioPrimerCuatrimestre;
    }

    public Date getFinPrimerCuatrimestre() {
        return finPrimerCuatrimestre;
    }

    public void setFinPrimerCuatrimestre(Date finPrimerCuatrimestre) {
        this.finPrimerCuatrimestre = finPrimerCuatrimestre;
    }

    public Date getInicioSegundoCuatrimestre() {
        return inicioSegundoCuatrimestre;
    }

    public void setInicioSegundoCuatrimestre(Date inicioSegundoCuatrimestre) {
        this.inicioSegundoCuatrimestre = inicioSegundoCuatrimestre;
    }

    public Date getFinSegundoCuatrimestre() {
        return finSegundoCuatrimestre;
    }

    public void setFinSegundoCuatrimestre(Date finSegundoCuatrimestre) {
        this.finSegundoCuatrimestre = finSegundoCuatrimestre;
    }
    
    
}
