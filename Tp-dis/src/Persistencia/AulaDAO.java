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
import java.util.Date;
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
        Query query = session.createQuery("SELECT a FROM Aula a WHERE capacidad >= :cantAlumnos");
        query.setParameter("cantAlumnos", cantAlumnos);
        List<Aula> listaAulas = query.list();
        session.close();
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
    
    public ArrayList<Aula> getAulas(List<Object>nroAulas){
        ArrayList<Aula> retorno = new ArrayList<>();
        List<Aula> listaAulas;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        for(Object n : nroAulas){
            Query query = session.createQuery("SELECT a FROM Aula a WHERE numeroAula = :nro");
            query.setParameter("nro", Integer.parseInt(String.valueOf(n)));
            listaAulas = query.list();
            retorno.addAll(listaAulas);
        }
        session.close();
        return retorno;
    }
    
    public List<Aula> consultaObtenerDisponibilidadEsporadica(Date dia, Date horaInicio, Date horaFin, int capacidad, TipoAula tipoAula){
        
        java.sql.Date sqlDia = new java.sql.Date(dia.getTime());
        java.sql.Time sqlHoraInicio = new java.sql.Time(horaInicio.getTime());
        java.sql.Time sqlHoraFin = new java.sql.Time(horaFin.getTime());
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery(
                    "SELECT DISTINCT a "+
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
                    "WHERE a.activo=1 AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica AND "+
                    "(((r.activo = 1) AND "+
                    "(d.id.dia != :variableDia OR (d.id.dia = :variableDia AND "+
                    "(:variableHoraInicio >= d.id.horaFin OR d.id.horaInicio >= :variableHoraFin)))) OR "+
                    "(r.activo = 0)) "+
                    "AND a.capacidad >= :variableCapacidad "+
                    "AND r.tipoAula = :variableTipoAula");
        query.setParameter("variableDia", sqlDia);
        query.setParameter("variableHoraInicio", sqlHoraInicio);
        query.setParameter("variableHoraFin", sqlHoraFin);
        query.setParameter("variableCapacidad", capacidad);
        query.setParameter("variableTipoAula", tipoAula);
        List<Aula> retorno = query.list();
        session.close();
        return retorno;
    }
    
    public List<Aula> consultaObtenerDisponibilidadSinReservas(){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query queryAulaSinReservas = session.createSQLQuery(
            "SELECT a.numeroAula " +
            "FROM Aula a, (SELECT a.numeroAula " +
            "				FROM Aula a " +
            "                where a.numeroAula NOT IN( " +
            "						(SELECT DISTINCT e.Aula_numeroAula " +
            "						 FROM  DiaReservaEsporadica e " +
            "					 UNION DISTINCT " +
            "						SELECT DISTINCT p.Aula_numeroAula " +
            "						FROM DiaReservaPeriodica p) " +
            "				)) t " +
            "WHERE t.numeroAula = a.numeroAula; ");
        
        List<Object> numerosAulasSinReserva = queryAulaSinReservas.list();
        session.close();
        return this.getAulas(numerosAulasSinReserva);
    }
}
