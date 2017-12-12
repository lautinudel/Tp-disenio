/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.Aula;
import Modelo.DiaReservaEsporadica;
import Modelo.PeriodoEnum;
import Modelo.TipoAula;
import Modelo.TipoReserva;
import Persistencia.AulaDAO;
import Persistencia.NewHibernateUtil;
import java.sql.Time;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Temp
 */
public class GestorAula {
    
    
    public ArrayList<ArrayList<Aula>> obtenerDisponibilidadDeAula(
            TipoReserva tipoReserva, ArrayList<Date> dias, ArrayList<Date> horaInicio,
            ArrayList<Date> horaFin, PeriodoEnum periodo,
            int cantAlumnos, TipoAula tipoAula){
        
        ArrayList<ArrayList<Aula>> aulas = new ArrayList();
        ArrayList<Aula> copia;
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        /*
        Format formatterDia = new SimpleDateFormat("yyyy-MM-dd");
        Format formatterHora = new SimpleDateFormat("hh:mm:ss");
        String diaString, horaInicioString, horaFinString;
        */
        
        for(int i=0; i<dias.size(); i++){
            /*
            diaString = formatterDia.format(dias.get(i));
            horaInicioString = formatterHora.format(horaInicio.get(i));
            horaFinString = formatterHora.format(horaFin.get(i));
            */
            
            Query query = session.createQuery(
                    "SELECT DISTINCT a "+
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
                    "WHERE a.activo=1 AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica AND "+
                    "(((r.activo = 1) AND "+
                    "(d.id.dia != :variableDia OR (d.id.dia = :variableDia AND "+
                    "NOT(d.id.horaInicio >= :variableHoraInicio AND d.id.horaFin <= :variableHoraFin) AND "+
                    "((d.id.horaInicio < :variableHoraInicio AND d.id.horaInicio > :variableHoraFin) OR "+
                    "(d.id.horaInicio > :variableHoraInicio AND d.id.horaFin < :variableHoraInicio)))))) OR "+
                    "(r.activo = 0)");
            query.setParameter("variableDia", dias.get(i));
            query.setParameter("variableHoraInicio", horaInicio.get(i));
            query.setParameter("variableHoraFin", horaFin.get(i));
            List<Aula> listaAulas = query.list();
            copia = new ArrayList<>(listaAulas);
            aulas.add(i, copia);
            listaAulas.clear();
        }
        
        //Couslta aulas sin reserva:
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
               
        AulaDAO aulaDao = new AulaDAO();
        ArrayList<Aula> aulasSinReserva = aulaDao.getAulas(numerosAulasSinReserva);
        List<Aula> aulasCapacidadTipo = aulaDao.obtenerListaDeAulas(tipoAula, cantAlumnos);
        
        //Aulas sin reserva
        for(int h=0; h<aulas.size(); h++)
            aulas.get(h).addAll(aulasSinReserva);
        
        //Verificacion de capacidad y tipo de aula:
        boolean bandera = false;
        Iterator<Aula> iter;
        for(int j=0; j<aulas.size(); j++){
            iter = aulas.get(j).iterator();
            while (iter.hasNext()){
                Aula a = iter.next();
                    for (Aula b: aulasCapacidadTipo){
                        bandera = false;
                        if(b.getNumeroAula()==a.getNumeroAula()){
                            bandera = true;
                            break;
                        }                        
                    }
                    if(!bandera){
                        iter.remove();
                    }
            } 
        }
        
        return aulas;
    }
}
