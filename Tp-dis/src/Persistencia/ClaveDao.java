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
