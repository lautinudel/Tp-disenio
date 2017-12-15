/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Bedel;
import Modelo.FechasPeriodo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ayr_1
 */
public class FechaPeriodoDAO {

    public FechaPeriodoDAO() {
    }
 
    public List<FechasPeriodo> getFechasPeriodos(){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery("SELECT f FROM FechasPeriodo f");
        List<FechasPeriodo> lista = query.list();
        session.close();
        return lista;
 
    }
}
