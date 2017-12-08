/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.ActividadUniversitaria;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author L. Nudel
 */
public class ActividadUniversitariaDAO {
    public ActividadUniversitariaDAO(){
        
    }
    public List<ActividadUniversitaria> buscarPorNombre(String nombreCurso){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        List lista = session.createCriteria(ActividadUniversitaria.class).add(Restrictions.like("nombre", "%"+nombreCurso+"%") ).list();
        tx.commit();
        session.close();
        return lista; 
    }
}
