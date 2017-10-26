/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.PoliticaClave;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ayr_1
 */
public class PoliticaDAO {

    public PoliticaDAO() {
    }
    
    public PoliticaClave buscarPolitica(int id_politica){
        /*Lo defino como arraylist porque La consulta siempre te devuelve un List*/
        ArrayList <PoliticaClave> politica = new ArrayList();
        //Conección a la BD y consulta
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session s = sesion.openSession();;
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery("from PoliticaClave PC where PC.idPolitica = "+id_politica+"");
        /*Convierto la consulta en una lista - siempre en esta consulta voy a tener una sola respuesta (id_politica es PK)*/
        politica = (ArrayList<PoliticaClave>) q.list();
        tx.commit();
        s.close();
        /*Devuelvo el único elemento de mi ArrayList*/
        return politica.get(0);
    }
}
