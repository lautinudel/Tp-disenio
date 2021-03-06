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
import Modelo.DiaSemana;
import Modelo.PeriodoEnum;
import Modelo.TipoAula;
import Modelo.TipoReserva;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
    
    /*
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
    }*/
    
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
    /*public List<Aula> consultaReservas(Date dia, Date horaInicio, Date horaFin, int capacidad, TipoAula tipoAula, PeriodoEnum periodo){
        
        java.sql.Date sqlDia = new java.sql.Date(dia.getTime());
        java.sql.Time sqlHoraInicio = new java.sql.Time(horaInicio.getTime());
        java.sql.Time sqlHoraFin = new java.sql.Time(horaFin.getTime());
        
        String diaString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dia);
        DiaSemana diaEnum = null;
        switch(diaString){
            case "lunes":
                diaEnum = DiaSemana.Lunes;
                break;
            case "martes":
                diaEnum = DiaSemana.Martes;
                break;
            case "miércoles":
                diaEnum = DiaSemana.Miercoles;
                break;
            case "jueves":
                diaEnum = DiaSemana.Jueves;
                break;
            case "viernes":
                diaEnum = DiaSemana.Viernes;
                break;
            case "sábado":
                diaEnum = DiaSemana.Sabado;
                break;
        }
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createSQLQuery("SELECT a.numeroAula "+
                                            "FROM Aula a, (SELECT DISTINCT a.numeroAula "+
                                                "FROM Aula a, DiaReservaPeriodica d, ReservaPeriodica r "+
                                                "WHERE a.activo=1 AND a.numeroAula = d.Aula_numeroAula AND "+
                                                "d.ReservaPeriodica_id_reservaPeriodica = r.id_reservaPeriodica AND "+
                                                "(((r.activo = 1) AND (r.periodo = :periodo OR r.periodo = 'Anual') AND "+
                                                "(d.dia != :variableDiaP OR (d.dia = :variableDiaP AND "+
                                                "(:variableHoraInicio >= d.horaFin OR d.horaInicio >= :variableHoraFin)))) OR "+
                                                "((r.activo = 1) AND (r.periodo != :periodo AND r.periodo != 'Anual')) OR (r.activo = 0)) "+
                                                "AND a.capacidad >= :variableCapacidad "+
                                                "AND r.tipoAula = :variableTipoAula) rp , "+ 
                                                "(SELECT DISTINCT a.numeroAula "+
						"FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
						"WHERE a.activo=1 AND a.numeroAula = d.Aula_numeroAula AND "+
						"d.ReservaEsporadica_id_reservaEsporadica = r.id_ReservaEsporadica AND "+
						"(((r.activo = 1) AND "+
						"(d.dia != :variableDia OR (d.dia = :variableDia AND "+
						"(:variableHoraInicio >= d.horaFin OR d.horaInicio >= :variableHoraFin)))) OR "+
						"(r.activo = 0)) "+
						"AND a.capacidad >= :variableCapacidad "+
						"AND r.tipoAula = :variableTipoAula) re "+
                                            "WHERE a.numeroAula = rp.numeroAula AND a.numeroAula = re.numeroAula");

        query.setParameter("variableDia", sqlDia);
        query.setParameter("variableDiaP", diaEnum);
        query.setParameter("variableHoraInicio", sqlHoraInicio);
        query.setParameter("variableHoraFin", sqlHoraFin);
        query.setParameter("variableCapacidad", capacidad);
        query.setParameter("variableTipoAula", tipoAula);
        query.setParameter("periodo", periodo);
            
        List<Object> consulta = query.list();
        List<Aula> retorno = this.getAulas(consulta);
        session.close();
        return retorno;
    }*/
    
    //ESTA CONSULTA ANDA BIEN PARA VALIDAR NUEVAS RESERVAS ESPORADICAS
    public  List<Aula>  consultaEsporadica(Date dia, Date horaInicio, Date horaFin, int capacidad, TipoAula tipoAula){
        
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
                    "AND d.tipoAula = :variableTipoAula");
        query.setParameter("variableDia", sqlDia);
        query.setParameter("variableHoraInicio", sqlHoraInicio);
        query.setParameter("variableHoraFin", sqlHoraFin);
        query.setParameter("variableCapacidad", capacidad);
        query.setParameter("variableTipoAula", tipoAula);
        
        List<Aula> listaRetorno = new ArrayList<>();
        listaRetorno = query.list();
        
        session.close();
       
        return listaRetorno;
    }
    
    public  List<Aula>  consultaEsporadica2 (Date dia, Date horaInicio, Date horaFin, int capacidad, TipoAula tipoAula, PeriodoEnum periodo, int anio){
        
        //java.sql.Date sqlDia = new java.sql.Date(dia.getTime());
        java.sql.Time sqlHoraInicio = new java.sql.Time(horaInicio.getTime());
        java.sql.Time sqlHoraFin = new java.sql.Time(horaFin.getTime());
        
        //De Date a String para el nombre del Día
        String diaString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dia);
        String diaEnum = null;
        String diaEnum2 = null;
        switch(diaString){
            case "lunes":
                diaEnum = "'Monday'";
                diaEnum2 = "Monday";
                break;
            case "martes":
                diaEnum = "'Tuesday'";
                diaEnum2 = "Tuesday";
                break;
            case "miércoles":
                diaEnum = "'Wednesday'";
                diaEnum2 = "Wednesday";
                break;
            case "jueves":
                diaEnum = "'Thursday'";
                diaEnum2 = "Thursday";
                break;
            case "viernes":
                diaEnum = "'Friday'";
                diaEnum2 = "Friday";
                break;
            case "sábado":
                diaEnum = "'Saturday'";
                diaEnum2 = "Saturday";
                break;
        }
        
        List<Aula> listaRetorno = new ArrayList<>();
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        if(periodo==PeriodoEnum.PrimerCuatrimestre || periodo==PeriodoEnum.SegundoCuatrimestre){
            Query query = session.createQuery(
                    "SELECT DISTINCT a "+
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
                    "WHERE a.activo = 1 AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica AND "+
                    "(((r.activo = 1) AND YEAR(d.id.dia) = :anio AND "+
                    "(d.periodo = :periodo "+
                    "AND (DAYNAME(d.id.dia) != :variableDia OR (DAYNAME(d.id.dia) = :variableDia AND "+
                    "(:variableHoraInicio >= d.id.horaFin OR d.id.horaInicio >= :variableHoraFin))) )) OR "+
                    "(r.activo = 0)) "+
                    "AND a.capacidad >= :variableCapacidad "+
                    "AND d.tipoAula = :variableTipoAula");
            query.setParameter("variableDia", diaEnum2);
            query.setParameter("variableHoraInicio", sqlHoraInicio);
            query.setParameter("variableHoraFin", sqlHoraFin);
            query.setParameter("variableCapacidad", capacidad);
            query.setParameter("variableTipoAula", tipoAula);
            query.setParameter("anio", anio);
            query.setParameter("periodo", periodo);
            
            
            listaRetorno = query.list();
            session.close();
            return listaRetorno;
        }else if(periodo==PeriodoEnum.Anual){
            Query query = session.createQuery(
                    "SELECT DISTINCT a "+
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
                    "WHERE a.activo = 1 AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica AND "+
                    "(((r.activo = 1) AND YEAR(d.id.dia) = :anio AND "+
                    "(d.periodo != 'Ninguno') "+
                    "AND (DAYNAME(d.id.dia) != :variableDia OR (DAYNAME(d.id.dia) = :variableDia AND "+
                    "(:variableHoraInicio >= d.id.horaFin OR d.id.horaInicio >= :variableHoraFin))) ) OR "+
                    "(r.activo = 0)) "+
                    "AND a.capacidad >= :variableCapacidad "+
                    "AND d.tipoAula = :variableTipoAula");
            query.setParameter("variableDia", diaEnum2);
            query.setParameter("variableHoraInicio", sqlHoraInicio);
            query.setParameter("variableHoraFin", sqlHoraFin);
            query.setParameter("variableCapacidad", capacidad);
            query.setParameter("variableTipoAula", tipoAula);
            query.setParameter("anio", anio);
            
            listaRetorno = query.list();
            session.close();
            
        }
        
        /*
        List<Aula> listaRetornoFinal = new ArrayList<>();
        for(Aula a: listaRetorno){
            if(this.consultaAulaSinSolapamientoConEsporadicas(diaEnum2, sqlHoraInicio, sqlHoraFin, a, periodo, anio))
                listaRetornoFinal.add(a);
        }
        */
        
       return listaRetorno;
    }
    
    //Retorna true cuando es valida el aula
    public Boolean consultaAulaSinSolapamientoConEsporadicas (String diaEnum, java.sql.Time sqlHoraInicio, java.sql.Time sqlHoraFin, Aula a, PeriodoEnum periodo, int anio){
        Boolean retorno = false;
        
        List<Object> listaRetorno = new ArrayList<>();
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        if(periodo==PeriodoEnum.PrimerCuatrimestre || periodo==PeriodoEnum.SegundoCuatrimestre){
            /*Query query = session.createQuery(
                    "SELECT a "+
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
                    "WHERE a.activo = 1 AND a.numeroAula = :numeroAula AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica AND "+
                    "r.activo = 1 AND YEAR(d.id.dia) = :anio AND "+
                    "(d.periodo = :periodo OR d.periodo = 'Anual') "+
                    "AND DAYNAME(d.id.dia) = :variableDia AND "+
                    "NOT (:variableHoraInicio >= d.id.horaFin OR d.id.horaInicio >= :variableHoraFin) ");*/
            
            Query query = session.createSQLQuery("SELECT a.* " +
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r " +
                    "WHERE a.activo = 1 AND a.numeroAula = :numeroAula " +
                    "AND a.numeroAula = d.Aula_numeroAula AND d.ReservaEsporadica_id_reservaEsporadica = r.id_reservaEsporadica " +
                    "AND r.activo = 1 AND YEAR(d.dia) = :anio AND " +
                    "(d.periodo = :periodo OR d.periodo = 'Anual') AND DAYNAME(d.dia) = :variableDia " +
                    "AND NOT (:variableHoraInicio >= d.horaFin OR d.horaInicio >= :variableHoraFin);");
            query.setParameter("variableDia", diaEnum);
            query.setParameter("variableHoraInicio", sqlHoraInicio);
            query.setParameter("variableHoraFin", sqlHoraFin);
            query.setParameter("anio", anio);
            query.setParameter("periodo", periodo);
            query.setParameter("numeroAula", a.getNumeroAula());
            
            
            listaRetorno = query.list();
            if(listaRetorno.isEmpty())
                retorno=true;
            session.close();
        }else if(periodo==PeriodoEnum.Anual){
            /*Query query = session.createQuery(
                    "SELECT a "+
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
                    "WHERE a.activo = 1 AND a.numeroAula = :numeroAula AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica AND "+
                    "r.activo = 1 AND YEAR(d.id.dia) = :anio AND "+
                    "(d.periodo = 'Anual' OR d.periodo = 'PrimerCuatrimestre' OR d.periodo = 'SegundoCuatrimestre') "+
                    "AND DAYNAME(d.id.dia) = :variableDia AND "+
                    "NOT (:variableHoraInicio >= d.id.horaFin OR d.id.horaInicio >= :variableHoraFin) ");*/
            Query query = session.createSQLQuery("SELECT a.* " +
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r " +
                    "WHERE a.activo = 1 AND a.numeroAula = :numeroAula " +
                    "AND a.numeroAula = d.Aula_numeroAula AND d.ReservaEsporadica_id_reservaEsporadica = r.id_reservaEsporadica " +
                    "AND r.activo = 1 AND YEAR(d.dia) = :anio AND " +
                    "(d.periodo = 'Anual' OR d.periodo = 'PrimerCuatrimestre' OR d.periodo = 'SegundoCuatrimestre') "+
                    "AND DAYNAME(d.dia) = :variableDia " +
                    "AND NOT (:variableHoraInicio >= d.horaFin OR d.horaInicio >= :variableHoraFin);");
            query.setParameter("variableDia", diaEnum);
            query.setParameter("variableHoraInicio", sqlHoraInicio);
            query.setParameter("variableHoraFin", sqlHoraFin);
            query.setParameter("anio", anio);
            query.setParameter("periodo", periodo);
            query.setParameter("numeroAula", a.getNumeroAula());
            
            listaRetorno = query.list();            
            if(listaRetorno.isEmpty())
                retorno=true;
            session.close();
        }
        
        
        return retorno;
    }
    
    public Boolean consultaAulaSinSolapamientoConEsporadicas2 (Date dia, Date horaInicio, Date horaFin, Aula a, PeriodoEnum periodo, int anio){
        Boolean retorno = false;
        
        java.sql.Time sqlHoraInicio = new java.sql.Time(horaInicio.getTime());
        java.sql.Time sqlHoraFin = new java.sql.Time(horaFin.getTime());
        
        //De Date a String para el nombre del Día
        String diaString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dia);
        String diaEnum = null;
        String diaEnum2 = null;
        switch(diaString){
            case "lunes":
                diaEnum = "'Monday'";
                diaEnum2 = "Monday";
                break;
            case "martes":
                diaEnum = "'Tuesday'";
                diaEnum2 = "Tuesday";
                break;
            case "miércoles":
                diaEnum = "'Wednesday'";
                diaEnum2 = "Wednesday";
                break;
            case "jueves":
                diaEnum = "'Thursday'";
                diaEnum2 = "Thursday";
                break;
            case "viernes":
                diaEnum = "'Friday'";
                diaEnum2 = "Friday";
                break;
            case "sábado":
                diaEnum = "'Saturday'";
                diaEnum2 = "Saturday";
                break;
        }
        
        List<Object> listaRetorno = new ArrayList<>();
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        if(periodo==PeriodoEnum.PrimerCuatrimestre || periodo==PeriodoEnum.SegundoCuatrimestre){
            /*Query query = session.createQuery(
                    "SELECT a "+
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
                    "WHERE a.activo = 1 AND a.numeroAula = :numeroAula AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica AND "+
                    "r.activo = 1 AND YEAR(d.id.dia) = :anio AND "+
                    "(d.periodo = :periodo OR d.periodo = 'Anual') "+
                    "AND DAYNAME(d.id.dia) = :variableDia AND "+
                    "NOT (:variableHoraInicio >= d.id.horaFin OR d.id.horaInicio >= :variableHoraFin) ");*/
            
            Query query = session.createSQLQuery("SELECT a.* " +
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r " +
                    "WHERE a.activo = 1 AND a.numeroAula = :numeroAula " +
                    "AND a.numeroAula = d.Aula_numeroAula AND d.ReservaEsporadica_id_reservaEsporadica = r.id_reservaEsporadica " +
                    "AND r.activo = 1 AND YEAR(d.dia) = :anio AND " +
                    "(d.periodo = :periodo OR d.periodo = 'Anual') AND DAYNAME(d.dia) = :variableDia " +
                    "AND NOT (:variableHoraInicio >= d.horaFin OR d.horaInicio >= :variableHoraFin);");
            query.setParameter("variableDia", diaEnum2);
            query.setParameter("variableHoraInicio", sqlHoraInicio);
            query.setParameter("variableHoraFin", sqlHoraFin);
            query.setParameter("anio", anio);
            query.setParameter("periodo", periodo);
            query.setParameter("numeroAula", a.getNumeroAula());
            
            
            listaRetorno = query.list();
            if(listaRetorno.isEmpty())
                retorno=true;
            session.close();
        }else if(periodo==PeriodoEnum.Anual){
            /*Query query = session.createQuery(
                    "SELECT a "+
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
                    "WHERE a.activo = 1 AND a.numeroAula = :numeroAula AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica AND "+
                    "r.activo = 1 AND YEAR(d.id.dia) = :anio AND "+
                    "(d.periodo = 'Anual' OR d.periodo = 'PrimerCuatrimestre' OR d.periodo = 'SegundoCuatrimestre') "+
                    "AND DAYNAME(d.id.dia) = :variableDia AND "+
                    "NOT (:variableHoraInicio >= d.id.horaFin OR d.id.horaInicio >= :variableHoraFin) ");*/
            Query query = session.createSQLQuery("SELECT a.* " +
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r " +
                    "WHERE a.activo = 1 AND a.numeroAula = :numeroAula " +
                    "AND a.numeroAula = d.Aula_numeroAula AND d.ReservaEsporadica_id_reservaEsporadica = r.id_reservaEsporadica " +
                    "AND r.activo = 1 AND YEAR(d.dia) = :anio AND " +
                    "(d.periodo = 'Anual' OR d.periodo = 'PrimerCuatrimestre' OR d.periodo = 'SegundoCuatrimestre') "+
                    "AND DAYNAME(d.dia) = :variableDia " +
                    "AND NOT (:variableHoraInicio >= d.horaFin OR d.horaInicio >= :variableHoraFin);");
            query.setParameter("variableDia", diaEnum);
            query.setParameter("variableHoraInicio", sqlHoraInicio);
            query.setParameter("variableHoraFin", sqlHoraFin);
            query.setParameter("anio", anio);
            query.setParameter("numeroAula", a.getNumeroAula());
            
            listaRetorno = query.list();            
            if(listaRetorno.isEmpty())
                retorno=true;
            session.close();
        }
        
        
        return retorno;
    }

    public List<Aula> reservasEsporadicasSoloConNinguno(int anio, PeriodoEnum periodo){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        Query query = session.createQuery("SELECT a.* " +
                                          "FROM DiaReservaEsporadica d , ReservaEsporadica r, Aula a " +
                                          "WHERE d.ReservaEsporadica_id_reservaEsporadica = r.id_reservaEsporadica " +
                                                "and r.activo = 1 AND d.periodo = 'Ninguno' AND "+
                                                "d.Aula_numeroAula = a.numeroAula AND " +
                                                "d.Aula_numeroAula NOT IN(SELECT d.Aula_numeroAula " +
                                                                        "FROM DiaReservaEsporadica d , ReservaEsporadica r " +
                                                                        "WHERE d.periodo = :periodo AND " +
                                                                              "d.ReservaEsporadica_id_reservaEsporadica = r.id_reservaEsporadica);");
        query.setParameter("anio", anio);
        query.setParameter("periodo", periodo);
        List<Aula> listaRetorno = query.list();
        
        session.close();
        return listaRetorno;    
    
    } 
    
    public List<Aula> reservasEsporadicasSoloConPrimerCuatrimestre(int anio, PeriodoEnum periodo){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        Query query = session.createQuery("SELECT a.* " +
                                          "FROM DiaReservaEsporadica d , ReservaEsporadica r, Aula a " +
                                          "WHERE d.ReservaEsporadica_id_reservaEsporadica = r.id_reservaEsporadica " +
                                                "and r.activo = 1 AND d.periodo = 'PrimerCuatrimestre' AND "+
                                                "d.Aula_numeroAula = a.numeroAula AND " +
                                                "d.Aula_numeroAula NOT IN(SELECT d.Aula_numeroAula " +
                                                                        "FROM DiaReservaEsporadica d , ReservaEsporadica r " +
                                                                        "WHERE d.periodo = :periodo AND " +
                                                                              "d.ReservaEsporadica_id_reservaEsporadica = r.id_reservaEsporadica);");
        query.setParameter("anio", anio);
        query.setParameter("periodo", periodo);
        List<Aula> listaRetorno = query.list();
        
        session.close();
        return listaRetorno;    
    
    } 
    //ESTA CONSULTA ANDA BIEN PARA VALIDAR NUEVAS RESERVAS ESPORADICAS PERIODICAS
    public List<Aula> consultaPeriodica(Date dia, Date horaInicio, Date horaFin, int capacidad, TipoAula tipoAula, PeriodoEnum periodo){
        
        //java.sql.Date sqlDia = new java.sql.Date(dia.getTime());
        java.sql.Time sqlHoraInicio = new java.sql.Time(horaInicio.getTime());
        java.sql.Time sqlHoraFin = new java.sql.Time(horaFin.getTime());
        
        //De Date a String para el nombre del Día
        String diaString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dia);
        DiaSemana diaEnum = null;
        switch(diaString){
            case "lunes":
                diaEnum = DiaSemana.Lunes;
                break;
            case "martes":
                diaEnum = DiaSemana.Martes;
                break;
            case "miércoles":
                diaEnum = DiaSemana.Miercoles;
                break;
            case "jueves":
                diaEnum = DiaSemana.Jueves;
                break;
            case "viernes":
                diaEnum = DiaSemana.Viernes;
                break;
            case "sábado":
                diaEnum = DiaSemana.Sabado;
                break;
        }
        
         //List<Aula> retorno=null;
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        Query query = session.createQuery(
                    "SELECT DISTINCT a "+
                    "FROM Aula a, DiaReservaPeriodica d, ReservaPeriodica r "+
                    "WHERE a.activo=1 AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaPeriodicaIdReservaPeriodica = r.idReservaPeriodica AND "+
                    "(((r.activo = 1) AND (r.periodo = :periodo OR r.periodo = 'Anual') AND "+
                    "(d.id.dia != :variableDia OR (d.id.dia = :variableDia AND "+
                    "(:variableHoraInicio >= d.id.horaFin OR d.id.horaInicio >= :variableHoraFin)))) OR "+
                    "((r.activo = 1) AND (r.periodo != :periodo AND r.periodo != 'Anual')) OR (r.activo = 0)) "+
                    "AND a.capacidad >= :variableCapacidad "+
                    "AND r.tipoAula = :variableTipoAula");
        query.setParameter("periodo", periodo);
        query.setParameter("variableDia", diaEnum);
        query.setParameter("variableHoraInicio", sqlHoraInicio);
        query.setParameter("variableHoraFin", sqlHoraFin);
        query.setParameter("variableCapacidad", capacidad);
        query.setParameter("variableTipoAula", tipoAula);
        
        List<Aula> listaRetorno = query.list();
        
         /*for(Aula a : listaRetorno)
                System.out.print(a.getNumeroAula()+" ");
         System.out.println();*/
         
         
        session.close();
        
        return listaRetorno;
    }
    
    public List<Aula> consultaPeriodica2(Date dia, Date horaInicio, Date horaFin, int capacidad, TipoAula tipoAula, PeriodoEnum periodo){
        //java.sql.Date sqlDia = new java.sql.Date(dia.getTime());
        java.sql.Time sqlHoraInicio = new java.sql.Time(horaInicio.getTime());
        java.sql.Time sqlHoraFin = new java.sql.Time(horaFin.getTime());
        
        //De Date a String para el nombre del Día
        String diaString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dia);
        DiaSemana diaEnum = null;
        switch(diaString){
            case "lunes":
                diaEnum = DiaSemana.Lunes;
                break;
            case "martes":
                diaEnum = DiaSemana.Martes;
                break;
            case "miércoles":
                diaEnum = DiaSemana.Miercoles;
                break;
            case "jueves":
                diaEnum = DiaSemana.Jueves;
                break;
            case "viernes":
                diaEnum = DiaSemana.Viernes;
                break;
            case "sábado":
                diaEnum = DiaSemana.Sabado;
                break;
        }
        
         //List<Aula> retorno=null;
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        Query query = session.createQuery(
                    "SELECT DISTINCT a "+
                    "FROM Aula a, DiaReservaPeriodica d, ReservaPeriodica r "+
                    "WHERE a.activo=1 AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaPeriodicaIdReservaPeriodica = r.idReservaPeriodica AND "+
                    "a.capacidad >= :variableCapacidad "+
                    "AND r.tipoAula = :variableTipoAula");
        query.setParameter("variableCapacidad", capacidad);
        query.setParameter("variableTipoAula", tipoAula);
        
        List<Aula> listaRetorno = query.list();
        
         /*for(Aula a : listaRetorno)
                System.out.print(a.getNumeroAula()+" ");
         System.out.println();*/
         
         
        session.close();
        
        return listaRetorno;
        
    } 
    
    public List<Aula> reservasNingunPeriodo(int anio){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        Query query = session.createQuery("SELECT DISTINCT a " +
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r " +
                    "WHERE a.activo = 1 AND a.numeroAula = d.id.aulaNumeroAula " +
                    "AND a.numeroAula = d.id.aulaNumeroAula AND d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica " +
                    "AND r.activo = 1 AND YEAR(d.id.dia) = :anio AND " +
                    "d.periodo = 'Ninguno'");
        query.setParameter("anio", anio);
        List<Aula> listaRetorno = query.list();
        
        session.close();
        return listaRetorno;
    }
    
    public List<Aula> reservasPrimerCuatrimestre(int anio){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        Query query = session.createQuery("SELECT DISTINCT a " +
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r " +
                    "WHERE a.activo = 1 AND a.numeroAula = d.id.aulaNumeroAula " +
                    "AND a.numeroAula = d.id.aulaNumeroAula AND d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica " +
                    "AND r.activo = 1 AND YEAR(d.id.dia) = :anio AND " +
                    "(d.periodo = 'Primercuatrimestre' OR d.periodo = 'Anual' )");
        query.setParameter("anio", anio);
        List<Aula> listaRetorno = query.list();
        
        session.close();
        return listaRetorno;
    }
        
        public List<Aula> reservasSegundoCuatrimestre(int anio){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        Query query = session.createQuery("SELECT DISTINCT a " +
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r " +
                    "WHERE a.activo = 1 AND a.numeroAula = d.id.aulaNumeroAula " +
                    "AND a.numeroAula = d.id.aulaNumeroAula AND d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica " +
                    "AND r.activo = 1 AND YEAR(d.id.dia) = :anio AND " +
                    "(d.periodo = 'SegundoCuatrimestre' OR d.periodo = 'Anual' )");
        query.setParameter("anio", anio);
        List<Aula> listaRetorno = query.list();
        
        session.close();
        return listaRetorno;
    }
        
        
    public List<Aula> consultaObtenerDisponibilidadSinReservas(int cantAlumnos, TipoAula tipoAula){
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
        
        ArrayList<Aula> aulas = this.getAulas(numerosAulasSinReserva);
        ArrayList<Aula> retorno = new ArrayList<>();
        
        for(Aula a : aulas){
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
