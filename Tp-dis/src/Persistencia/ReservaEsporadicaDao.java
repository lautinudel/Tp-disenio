/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.DiaReservaEsporadica;
import Modelo.ReservaEsporadica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ayr_1
 */
public class ReservaEsporadicaDao {

    public ReservaEsporadicaDao() {
    }
  
    public void registrar(ReservaEsporadica reserva){
      SessionFactory sesion = NewHibernateUtil.getSessionFactory();
      Session session;
      session = sesion.openSession();
      Transaction tx = session.beginTransaction();
      session.save(reserva);
      tx.commit();
      session.close();        
    }
            
    
    public boolean unicaReserva(Date dia, Date horaInicio){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery("SELECT d.id.dia, d.id.horaInicio " +
                                          "FROM DiaReservaEsporadica d "+
                                          "WHERE d.id.dia = :variableDia AND "+
                                                "d.id.horaInicio = :variablehoraInicio");
        query.setParameter("variableDia", dia);
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
