/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.DiaSemana;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ayr_1
 */
public class ReservaPeriodicaDao {

    public ReservaPeriodicaDao() {
    }
    
    public boolean unicaReserva(Date dia, Date horaInicio){
        //Transformo los date en algo comparable con la bd
        java.sql.Time sqlHoraInicio = new java.sql.Time(horaInicio.getTime());
        
        //De Date a String para el nombre del Día
        String diaString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dia);
        DiaSemana diaEnum = null;
        switch(diaString){
            case "lunes":
                diaEnum = DiaSemana.Lunes;
                break;
            case "martes":
                diaEnum = DiaSemana.Martes;
                break;
            case "miércoles":
                diaEnum = DiaSemana.Miercoles;
                break;
            case "jueves":
                diaEnum = DiaSemana.Jueves;
                break;
            case "viernes":
                diaEnum = DiaSemana.Viernes;
                break;
            case "sábado":
                diaEnum = DiaSemana.Sabado;
                break;
        }
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery("SELECT d.id.dia, d.id.horaInicio " +
                                          "FROM DiaReservaPeriodica d "+
                                          "WHERE d.id.dia = :variableDia AND "+
                                                "d.id.horaInicio = :variablehoraInicio");
        query.setParameter("variableDia", diaEnum);
        query.setParameter("variablehoraInicio", horaInicio);
        if(!query.list().isEmpty()){
            session.close();
            return false;
        }else{
            session.close();
            return true;
        }
    }
}