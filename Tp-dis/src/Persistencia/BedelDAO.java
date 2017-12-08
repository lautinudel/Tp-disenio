/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Bedel;
import Modelo.ClaveBedel;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author Temp
 */
public class BedelDAO {
    
    public BedelDAO() {
    }
    
    
    public Boolean verificarExistencia(String username){
        Boolean r;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        if(session.get(Bedel.class, username)!=null) r=true; 
        else r=false;
        tx.commit();
        session.close();
        return r;
    }
    public Bedel obtenerBedel ( String username){
        Bedel b ;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        b=(Bedel)session.get(Bedel.class, username);
        tx.commit();
        session.close();
        return b;
    }
    
    public void guardarBedel(Bedel b, ClaveBedel claveBedel) {
      
      SessionFactory sesion = NewHibernateUtil.getSessionFactory();
      Session session;
      session = sesion.openSession();
      Transaction tx = session.beginTransaction();
      session.save(b);
      tx.commit();
      session.close();
      ClaveDao clavedao = new ClaveDao();
      clavedao.guardarClaveBedel(claveBedel);
        
        
    }

    
}
