/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Administrador;
import Modelo.ClaveAdministrador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author L. Nudel
 */
public class AdministradorDAO {
    
    public AdministradorDAO(){
        
    }
    public Boolean verificarExistencia(String username){
        Boolean r;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        if(session.get(Administrador.class, username)!=null) r=true; 
        else r=false;
        tx.commit();
        session.close();
        return r;
    }
    public Administrador obtenerAdministrador ( String username){
        Administrador b ;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        b=(Administrador)session.get(Administrador.class, username);
        tx.commit();
        session.close();
        return b;
    }
    
    
    
}
