/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.DiaSemana;
import Modelo.ReservaPeriodica;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ayr_1
 */
public class ReservaPeriodicaDao {

    public ReservaPeriodicaDao() {
    }
    
    
    public void registrar(ReservaPeriodica reserva){
      SessionFactory sesion = NewHibernateUtil.getSessionFactory();
      Session session;
      session = sesion.openSession();
      Transaction tx = session.beginTransaction();
      session.save(reserva);
      tx.commit();
      session.close();        
    }
    
    public int getId(){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createSQLQuery("SELECT AUTO_INCREMENT "+
                                            "FROM information_schema.TABLES " +
                                            "WHERE TABLE_SCHEMA = 'ayrtonco_tp_disenio' " +
                                            "AND TABLE_NAME = 'ReservaPeriodica'");
        List<Object> ids = query.list();
        
        int id = Integer.parseInt(String.valueOf(ids.get(0)));
        session.close();        
        return (id-1);
        
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
