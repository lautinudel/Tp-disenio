/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Aula;
import Modelo.AulaInformatica;
import Modelo.AulaMultimedio;
import Modelo.AulaSinRecursosAdicionales;
import Modelo.TipoAula;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Temp
 */
public class AulaDAO {
    
    public AulaDAO(){
        
    }
    
    public List<Aula> obtenerListaDeAulas(TipoAula tipoAula, int cantAlumnos){
        //recupero las aulas
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery("SELECT a FROM Aula a WHERE capacidad > :cantAlumnos");
        query.setParameter("cantAlumnos", cantAlumnos);
        List<Aula> listaAulas = query.list();
        
        ArrayList<Aula> retorno = new ArrayList<>();
        for(Aula a : listaAulas){
            switch (tipoAula){
                case Informatica:
                    if(a.getAulaInformatica() != null)
                        retorno.add(a);
                    break;
                case Multimedios:
                    if(a.getAulaMultimedio() != null)
                        retorno.add(a);
                    break;
                case SinRecursos:
                    if(a.getAulaSinRecursosAdicionales() != null)
                        retorno.add(a);
                    break;
            }
        }
        
        return retorno;
    }
}
