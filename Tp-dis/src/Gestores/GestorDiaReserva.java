/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.DiaReservaEsporadica;
import Modelo.DiaReservaPeriodica;
import Persistencia.DiaReservaDAO;

/**
 *
 * @author ayr_1
 */
public class GestorDiaReserva {

    public GestorDiaReserva() {
    }
    
    public void registrarDias(DiaReservaPeriodica dia){
        DiaReservaDAO diaReserva = new DiaReservaDAO();
        diaReserva.registrar(dia);
    }
    
    public void registrarDias(DiaReservaEsporadica dia){
        DiaReservaDAO diaReserva = new DiaReservaDAO();
        diaReserva.registrar(dia);
    }
}
