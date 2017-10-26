/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Bedel;
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
        Boolean r=true;
        Bedel b=null;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        b=(Bedel)session.get(Bedel.class, username);
        tx.commit();
        session.close();
        if(b==null) r=false;
        return r;
    }
    
    public void guardarBedel(Bedel b) {
      SessionFactory sesion = NewHibernateUtil.getSessionFactory();
      Session session;
      session = sesion.openSession();
      Transaction tx = session.beginTransaction();
      session.save(b);
      tx.commit();
      session.close();
      
      
      JOptionPane.showMessageDialog(null,"Insertado Correctamente"); //mensaje por pantalla, se puede quitar
        
        
    }

    
}
