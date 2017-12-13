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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;
import org.hibernate.Query;
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
        /*Transaction tx = session.beginTransaction();
        if(session.get(Bedel.class, username)!=null) r=true; 
        else r=false;
        tx.commit();*/
        Query query = session.createQuery("FROM Bedel WHERE username = :username");
        query.setParameter("username", username);
        List<Bedel> lista = query.list();
        if(!lista.isEmpty()) r=true;
        else r=false;
        session.close();
        return r;
    }
    public Bedel obtenerBedel ( String username){
        Bedel b ;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        /*Transaction tx = session.beginTransaction();
        b=(Bedel)session.get(Bedel.class, username);
        tx.commit();*/
        Query query = session.createQuery("FROM Bedel WHERE username = :username");
        query.setParameter("username", username);
        List<Bedel> lista = query.list();
        b=lista.get(0);
        int temp = b.getClaveBedels().size();
        session.close();
        return b;
    }
    
    
    //existe en hql?
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
    //solo modifica si no se cambia la clave
    public void modificarBedel(String nombre, String apellido, String username, String turno){
      SessionFactory sesion = NewHibernateUtil.getSessionFactory();
      Session session;
      session = sesion.openSession();
      int query = session.createQuery("update Bedel b set b.nombre = :nombre, b.apellido = :apellido,  b.turnoTrabaja = :turno where b.username = :username").setString("nombre", nombre).setString("apellido", apellido).setString("username", username).setString("turno", turno).executeUpdate();
      session.close();    
    }
   
    public List<Bedel> buscarPorApellido (String apellido){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        //Transaction tx = session.beginTransaction();
        //List<Bedel> lista = session.createCriteria(Bedel.class).add(Restrictions.like("apellido", "%"+apellido+"%") ).list();
         Query query = session.createQuery("FROM Bedel WHERE apellido = :apellido");
        query.setParameter("apellido", apellido);
        List<Bedel> lista = query.list();
       // tx.commit();
       int temp;
        for(int i=0;i<lista.size();i++){
            
            temp=lista.get(i).getClaveBedels().size();
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
        session.close();
        return lista; 
  
    }
    public List<Bedel> buscarPorTurno (TurnoEnum turno){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        //Transaction tx = session.beginTransaction();
        //List<Bedel> lista = session.createCriteria(Bedel.class).add(Restrictions.like("turnoTrabaja", turno) ).list();
        //tx.commit();
         Query query = session.createQuery("FROM Bedel WHERE turnoTrabaja = :turno");
         
         if(turno.equals(TurnoEnum.Maniana))query.setParameter("turno", TurnoEnum.Maniana);
         else if(turno.equals(TurnoEnum.Tarde))query.setParameter("turno", TurnoEnum.Tarde);
         else if(turno.equals(TurnoEnum.Noche))query.setParameter("turno", TurnoEnum.Noche);
        
        List<Bedel> lista = query.list();
        
        int temp;
        for(int i=0;i<lista.size();i++){
            temp=lista.get(i).getClaveBedels().size();
            lista.get(i).getClaveBedels();
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
        session.close();
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
