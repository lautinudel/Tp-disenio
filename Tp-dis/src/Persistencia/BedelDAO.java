/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Bedel;
import Modelo.ClaveBedel;
import Modelo.TurnoEnum;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


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
    public List<Bedel> buscarPorApellido (String apellido){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        List<Bedel> lista = session.createCriteria(Bedel.class).add(Restrictions.like("apellido", "%"+apellido+"%") ).list();
        tx.commit();
        session.close();
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getActivo()==0){
                lista.remove(i);
                i--;
            }
            
        }
        for(int i=0;i<lista.size();i++){
            for(int j=0;j<lista.size();j++){
                if(j!=i){
                if(lista.get(i).getUsername().equals(lista.get(j).getUsername())){
                    lista.remove(j);
                    j--;
                }}
            }}
        return lista; 
  
    }
    public List<Bedel> buscarPorTurno (TurnoEnum turno){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        List<Bedel> lista = session.createCriteria(Bedel.class).add(Restrictions.like("turnoTrabaja", turno) ).list();
        tx.commit();
        session.close();
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getActivo()==0){
                lista.remove(i);
                i--;
            }
            
        }
        for(int i=0;i<lista.size();i++){
            for(int j=0;j<lista.size();j++){
                if(j!=i){
                if(lista.get(i).getUsername().equals(lista.get(j).getUsername())){
                    lista.remove(j);
                    j--;
                }}
            }}
        return lista;
    }
    
    
    public List<Bedel> buscarBedelApellidoyTurno(String Apellido, TurnoEnum turno){
        List<Bedel> lista1 = this.buscarPorApellido(Apellido);
        List<Bedel> lista2= this.buscarPorTurno(turno);
        List<Bedel> lista=new ArrayList();
        for(int i=0;i<lista1.size();i++){
            for(int j=0;j<lista2.size();j++){
                if(lista2.get(j).getUsername().equals(lista1.get(i).getUsername())){
                    lista.add(lista1.get(i));
                }
            }
        }
        return lista;
        
        
    }
    
}
