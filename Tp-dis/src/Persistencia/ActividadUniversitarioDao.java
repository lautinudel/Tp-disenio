/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.ActividadUniversitaria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ayr_1
 */
public class ActividadUniversitarioDao {

    public ActividadUniversitarioDao() {
    }
    public boolean verificarExistencia(String actividad){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery("SELECT a " +
                                          "FROM ActividadUniversitaria a "+
                                          "WHERE a.nombre = :variableActividad ");
        query.setParameter("variableActividad", actividad);
        //Si la lista no esta vacia y solo tiene un solo elemento
        if (!query.list().isEmpty() && query.list().size() == 1){
            session.close();
            return true;
        }else{
            return true;
        }
    }
}
