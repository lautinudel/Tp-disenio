/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Docente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ayr_1
 */
public class DocenteDao {

    public DocenteDao() {
    }
    
    public List<Docente> verificarExistencia(String apellido, String nombre, String email){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery("SELECT d " +
                                          "FROM Docente d "+
                                          "WHERE d.id.apellido  = :variableApellido AND "+
                                                "d.nombre = :variableNombre AND d.email = :variableEmail");
        query.setParameter("variableApellido", apellido);
        query.setParameter("variableNombre", nombre);
        query.setParameter("variableEmail", email);
        
        List<Docente> retorno = query.list();
        session.close();
        return retorno;
    }
    
    
    
    
    
    
}
