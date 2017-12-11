/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;


import Modelo.ReservaEsporadica;
import Modelo.ReservaPeriodica;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Temp
 */
public class GestorReserva {

    public GestorReserva() {
    }
    
    
    public Boolean reservaEsporadicaActiva(int idReservaEsporadica){
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
    
    public Boolean reservaPeriodicaActiva(int idReservaPeriodica){
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
