/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Modelo.*;
/**
 *
 * @author L. Nudel
 */
public class ClaveDao {

    public ClaveDao() {
    }
    /*public Boolean verificarExistencia(Bedel b){
        Boolean r;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        if(session.get(ClaveBedel.class, b)!=null) r=true; 
        else r=false;
        tx.commit();
        session.close();
        return r;
    }*/
    
    public Boolean verificarExistencia(String pass){
        Boolean r;
        ClaveBedelId c=new ClaveBedelId(pass);
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        if(session.get(ClaveBedel.class, c)!=null) r=true; 
        else r=false;
        tx.commit();
        session.close();
        return r;
    }
    public ClaveBedelId obtenerClaveBedel ( String pass){
        ClaveBedelId clave ;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        clave=(ClaveBedelId)session.get(ClaveBedelId.class, pass);
        tx.commit();
        session.close();
        return clave;
    }
    public void guardarClaveBedel(ClaveBedel c) {
      SessionFactory sesion = NewHibernateUtil.getSessionFactory();
      Session session;
      session = sesion.openSession();
      Transaction tx = session.beginTransaction();
      session.save(c);
      tx.commit();
      session.close(); 
    }
    public void guardarClaveAdministrador(ClaveAdministrador c) {
      SessionFactory sesion = NewHibernateUtil.getSessionFactory();
      Session session;
      session = sesion.openSession();
      Transaction tx = session.beginTransaction();
      session.save(c);
      tx.commit();
      session.close(); 
    }
}
