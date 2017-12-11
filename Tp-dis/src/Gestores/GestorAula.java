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
import java.util.ArrayList;
import java.util.Date;
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
            TipoReserva tipoReserva, ArrayList<String> dias, ArrayList<Time> horaInicio,
            ArrayList<Time> horaFin, PeriodoEnum periodo,
            int cantAlumnos, TipoAula tipoAula){
        
        ArrayList<ArrayList<Aula>> aulas = new ArrayList();
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        for(int i=0; i<dias.size(); i++){
            Query query = session.createQuery(
                    "SELECT a "+
                    "FROM Aula a, DiaReservaPeriodica d, ReservaPeriodica r "+
                    "WHERE a.numeroAula = d.Aula_numeroAula AND "+
                    "d.ReservaPeriodica_id_reservaPeriodica = r.id_reservaPeriodica AND "+
                    "r.activo = 1 AND "+
                    "(d.dia != :variable_dia OR (d.dia = :variable_dia AND "+
                    "NOT(d.horaInicio > :variable_horaInicio AND d.horaFIN < :variable_horaFin) AND "+
                    "((d.horaInicio < :variable_horaInicio AND d.horaInicio > :variable_horaFin) OR "+
                    "(d.horaInicio > :variable_horaInicio AND d.horaFin < :variable_horaInicio))))");
            query.setParameter("variable_dia", dias.get(i));
            query.setParameter("variable_horaInicio", horaInicio.get(i));
            query.setParameter("variable_horaFin", horaFin.get(i));
            List<Aula> listaAulas = query.list();
            aulas.add(i, (ArrayList<Aula>) listaAulas);
            listaAulas.clear();
        }
        
        AulaDAO aulaDao = new AulaDAO();
        List<Aula> aulasCapacidadTipo = aulaDao.obtenerListaDeAulas(tipoAula, cantAlumnos);
        
        
        
        return aulas;
    }
}
