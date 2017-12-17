/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.DiaReservaEsporadica;
import Modelo.DiaReservaPeriodica;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ayr_1
 */
public class DiaReservaDAO {

    public DiaReservaDAO() {
    }
     
    public void registrar(DiaReservaPeriodica diaReserva){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(diaReserva);
        tx.commit();
        session.close();
       
    }
    
    public void registrar(DiaReservaEsporadica diaReserva){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(diaReserva);
        tx.commit();
        session.close();
    }
}
