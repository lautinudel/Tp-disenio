/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObtenerDisponibilidadTest;

import Gestores.GestorAula;
import Interfaces.RegistrarReserva;
import Modelo.Aula;
import Modelo.Bedel;
import Modelo.ClaveBedel;
import Modelo.ClaveBedelId;
import Modelo.DiaReservaEsporadica;
import Modelo.PeriodoEnum;
import Modelo.ReservaPeriodica;
import Modelo.TipoAula;
import Modelo.TipoReserva;
import Modelo.TurnoEnum;
import java.util.List;
import Persistencia.AulaDAO;
import Persistencia.BedelDAO;
import Persistencia.NewHibernateUtil;
import static java.lang.System.exit;
import java.sql.Time;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Temp
 */
public class ObtenerDisponibilidadTest {
    
    public static void main(String args[]) throws ParseException {
        /*
        AulaDAO dao = new AulaDAO();
        List<Aula> lista = dao.obtenerListaDeAulas(TipoAula.SinRecursos, 20);
        for(Aula a: lista)
            System.out.println(a.getNumeroAula()+" ");*/
        
               
        //------------------------------------------------------------
        //Porquerias para parsear dias y horas:
        //------------------------------------------------------------
        
               
        //De String a Date para HORA:
        String myTime = "10:30:54";
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date horaDate = null;
        try {
            horaDate = sdf.parse(myTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedTime = sdf.format(horaDate);
        System.out.println(formattedTime);
        
        //De String a Date para FECHA:
        String string = "January 2, 2010";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date=null;
        try {
            date = format.parse(string);
        } catch (ParseException ex) {
            Logger.getLogger(ObtenerDisponibilidadTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(date);
        
        //De Date a String para FECHA:
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(date);
        System.out.println(s);
        
        //De Date a String para HORA:
        Format formatter2 = new SimpleDateFormat("hh:mm:ss");
        String s2 = formatter2.format(horaDate);
        System.out.println(s2);
        
        //De Date a String para el nombre del Día
        String cadena =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(date);
        System.out.println (cadena);
              //--------------------------------------------------------------
        //--------------------------------------------------------------
        //Probando metodo ObtenerDisponibilidad
        String dia1 = "2018-04-03"; //Martes
        String dia2 = "2018-05-05"; //Sabado
        String dia3 = "2017-12-21"; //Jueves
        String dia4 = "2018-03-05"; //Lunes
        String dia5 = "2018-05-07"; //Lunes
        String dia6 = "2017-08-15"; //Martes
        DateFormat formatoDia = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=null, date2=null, date3=null, date4=null, date5=null, date6=null;
        try {
            date1 = formatoDia.parse(dia1);
            date2 = formatoDia.parse(dia2);
            date3 = formatoDia.parse(dia3);
            date4 = formatoDia.parse(dia4);
            date5 = formatoDia.parse(dia5);
            date6 = formatoDia.parse(dia6);
        } catch (ParseException ex) {
            Logger.getLogger(ObtenerDisponibilidadTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Date> dias = new ArrayList<>();
        dias.add(date1);
        dias.add(date2);
        dias.add(date3);
        dias.add(date4);
        dias.add(date5);
        dias.add(date6);
        
        String hora1 = "16:00:00";
        String hora2 = "15:30:00";
        String hora3 = "07:09:00";
        String hora4 = "14:30:00";
        String hora5 = "12:58:00";
        String hora6 = "19:45:00";
        String horaFin1 = "19:00:00";
        String horaFin2 = "22:08:00";
        String horaFin3 = "10:09:00";
        String horaFin4 = "18:00:00";
        String horaFin5 = "13:58:00";
        String horaFin6 = "21:15:00";
        DateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
        Date time1=null, time2=null, time3=null, time4=null, time5=null, time6=null;
        Date timeFin1=null, timeFin2=null, timeFin3=null, timeFin4=null, timeFin5=null, timeFin6=null;
        try {
            time1 = formatoHora.parse(hora1);
            time2 = formatoHora.parse(hora2);
            time3 = formatoHora.parse(hora3);
            time4 = formatoHora.parse(hora4);
            time5 = formatoHora.parse(hora5);
            time6 = formatoHora.parse(hora6);
            
            timeFin1 = formatoHora.parse(horaFin1);
            timeFin2 = formatoHora.parse(horaFin2);
            timeFin3 = formatoHora.parse(horaFin3);
            timeFin4 = formatoHora.parse(horaFin4);
            timeFin5 = formatoHora.parse(horaFin5);
            timeFin6 = formatoHora.parse(horaFin6);
        } catch (ParseException ex) {
            Logger.getLogger(ObtenerDisponibilidadTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Date> horasInicio = new ArrayList<>();
        horasInicio.add(time1);
        horasInicio.add(time2);
        horasInicio.add(time3);
        horasInicio.add(time4);
        horasInicio.add(time5);
        horasInicio.add(time6);
        ArrayList<Date> horasFin = new ArrayList<>();
        horasFin.add(timeFin1);
        horasFin.add(timeFin2);
        horasFin.add(timeFin3);
        horasFin.add(timeFin4);
        horasFin.add(timeFin5);
        horasFin.add(timeFin6);
        
        ArrayList<PeriodoEnum> periodos = new ArrayList<>();
        periodos.add(PeriodoEnum.Ninguno);
        periodos.add(PeriodoEnum.Ninguno);
        periodos.add(PeriodoEnum.Ninguno);
        periodos.add(PeriodoEnum.PrimerCuatrimestre);
        periodos.add(PeriodoEnum.PrimerCuatrimestre);
        periodos.add(PeriodoEnum.SegundoCuatrimestre);
        
        System.out.println(dias);
        System.out.println(horasInicio);
        System.out.println(horasFin);
        
        ArrayList<Date> unDia = new ArrayList<>();
        unDia.add(date1);
        ArrayList<Date> unDiaHI = new ArrayList<>();
        unDiaHI.add(time1);
        ArrayList<Date> unDiaHF = new ArrayList<>();
        unDiaHF.add(timeFin1);
        
        /*
        GestorAula gestorAula = new GestorAula();
        ArrayList<ArrayList<Aula>>aulasDisp = gestorAula.obtenerDisponibilidadDeAula(unDiaHF, horasInicio, horasFin, periodos, 10, TipoAula.SinRecursos);
        for(int i = 0; i<aulasDisp.size();i++){
            for(int j=0; j<aulasDisp.get(i).size();j++){
                System.out.print(aulasDisp.get(i).get(j).getNumeroAula()+" ");
            }
            System.out.print("\n");
        }*/
        
        /*
        ArrayList<ArrayList<Date>> prueba = new ArrayList<>();
        prueba.add(0, dias);
        prueba.add(1,horasInicio);
        prueba.add(2,horasFin);
        System.out.println(prueba);*/
        
        /*
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
                    "NOT(d.id.horaInicio >= :variableHoraInicio AND d.id.horaFin <= :variableHoraFin) AND "+
                    "((d.id.horaInicio < :variableHoraInicio AND d.id.horaInicio > :variableHoraFin) OR "+
                    "(d.id.horaInicio > :variableHoraInicio AND d.id.horaFin < :variableHoraInicio)))))) OR "+
                    "(r.activo = 0)");
        query.setParameter("variableDia", date6);
        query.setParameter("variableHoraInicio", time6);
        query.setParameter("variableHoraFin", timeFin6);
        List<Aula> listaAulas = query.list();
        
        System.out.println(listaAulas);
        
        AulaDAO aulaDao = new AulaDAO();
        List<Aula> aulasCapacidadTipo = aulaDao.obtenerListaDeAulas(TipoAula.SinRecursos, 20);
        
        System.out.println(aulasCapacidadTipo.get(0).getNumeroAula());
        
        boolean bandera = false;
        Iterator<Aula> iter;
            iter = listaAulas.iterator();
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
        
        
        System.out.println(listaAulas.get(0).getNumeroAula());*/
        
        /*
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
        
        List<Object> listaAulasSinReserva = queryAulaSinReservas.list();
        System.out.println(listaAulasSinReserva);
        
        AulaDAO aulaDao = new AulaDAO();
        ArrayList<Aula> aulasSinReserva = aulaDao.getAulas(listaAulasSinReserva);
        for(Aula a: aulasSinReserva)
            System.out.println(a.getNumeroAula()+" ");*/
        
       
        /*Iterator itr = listaAulasSinReserva.iterator();
        while(itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            //now you have one array of Object for each row
            Integer nroAula = Integer.parseInt(String.valueOf(obj[0])); // don't know the type of column CLIENT assuming String 
            Integer piso = Integer.parseInt(String.valueOf(obj[1])); //SERVICE assumed as int
            //same way for all obj[2], obj[3], obj[4]
            
            System.out.println(nroAula);
            System.out.println(piso);
        }*/
        
       /*
       SessionFactory sesion = NewHibernateUtil.getSessionFactory();
       Session session;
       session = sesion.openSession();
       Query query = session.createQuery("SELECT d FROM DiaReservaEsporadica d");
       List<DiaReservaEsporadica> listaReservas = query.list();
       session.close();
       
       System.out.println(listaReservas.get(0).getId().getDia());
       System.out.println(listaReservas.get(0).getId().getHoraInicio());
       System.out.println(listaReservas.get(0).getId().getHoraFin());
       
       System.out.println(date1);
       System.out.println(time1);*/
       
       /*
       java.util.Date utilDate = new java.util.Date();
       java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
       System.out.println("utilDate:" + utilDate);
       System.out.println("sqlDate:" + sqlDate);
       
       java.sql.Time sqlHora = new java.sql.Time(time1.getTime());
       System.out.println("sqlHora:" + sqlHora);*/
       
       /*
       java.sql.Date sqlDate = new java.sql.Date(date6.getTime());
       java.sql.Time sqlTime= new java.sql.Time(time6.getTime());
       SessionFactory sesion = NewHibernateUtil.getSessionFactory();
       Session session;
       session = sesion.openSession();
       Query query = session.createQuery("SELECT d FROM DiaReservaEsporadica d WHERE d.id.dia = :diaParam AND d.id.horaInicio = :horaParam");
       query.setParameter("diaParam", sqlDate);
       query.setParameter("horaParam", sqlTime);
       List<DiaReservaEsporadica> listaReservas = query.list();
       session.close();
       System.out.println(listaReservas.get(0).getId().getAulaNumeroAula());
       System.out.println(listaReservas);*/
       
       /*
       String diaLunes = "2017-11-27"; //Lunes
        String diaMartes = "2017-11-28"; //Martes
        String diaMiercoles = "2017-11-29"; //Miercoles
        String diaJueves = "2017-11-30"; //Jueves
        String diaViernes = "2017-12-1"; //Viernes
        String diaSabado = "2017-12-2"; //Sabado
        DateFormat formatoDiaSemana = new SimpleDateFormat("yyyy-MM-dd");
        Date dateLunes=null, dateMartes=null, dateMiercoles=null, dateJueves=null, dateViernes=null, dateSabado=null;
        try {
            dateLunes = formatoDiaSemana.parse(diaLunes);
            dateMartes = formatoDiaSemana.parse(diaMartes);
            dateMiercoles = formatoDiaSemana.parse(diaMiercoles);
            dateJueves = formatoDiaSemana.parse(diaJueves);
            dateViernes = formatoDiaSemana.parse(diaViernes);
            dateSabado = formatoDiaSemana.parse(diaSabado);
        } catch (ParseException ex) {
            Logger.getLogger(ObtenerDisponibilidadTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       String diaLunesString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dateLunes);
       String diaMartesString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dateMartes);
       String diaMiercolesString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dateMiercoles);
       String diaJuevesString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dateJueves);
       String diaViernesString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dateViernes);
       String diaSabadoString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(dateSabado);
       
       System.out.println(diaLunesString);
       System.out.println(diaMartesString);
       System.out.println(diaMiercolesString);
       System.out.println(diaJuevesString);
       System.out.println(diaViernesString);
       System.out.println(diaSabadoString);
       */
       String diaLunes = "lunes";
       //Date datechiripiorca = null;
       
       /*SimpleDateFormat dayFormat = new SimpleDateFormat("E", new Locale("es", "ES"));
        Date datechiripiorca = dayFormat.parse(diaLunes);
        
        
        System.out.println(datechiripiorca);*/
        /*
        Date today = new Date();
        System.out.println(today);
        
        ClaveBedelId id = new ClaveBedelId("chiripiorca", "chiripiorca", today);
        Bedel b = new Bedel("chiripiorca", "Garlopa", "Juan", TurnoEnum.Maniana);
        BedelDAO bdao = new BedelDAO();
        ClaveBedel c = new ClaveBedel(id, b);
        bdao.guardarBedel(b, c);

        */
        /*
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createSQLQuery("SELECT AUTO_INCREMENT "+
                                            "FROM information_schema.TABLES " +
                                            "WHERE TABLE_SCHEMA = 'ayrtonco_tp_disenio' " +
                                            "AND TABLE_NAME = 'ReservaEsporadica'");
        List<Object> ids = query.list();
        
        int id = Integer.parseInt(String.valueOf(ids.get(0)));
        session.close();
        
        System.out.println(id);*/
        
        
        
        
        /*
        java.sql.Time sqlHoraInicio = new java.sql.Time(time1.getTime());
        java.sql.Time sqlHoraFin = new java.sql.Time(timeFin1.getTime());
        
        //De Date a String para el nombre del Día
        String diaString =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(date1);
        String diaEnum = null;
        switch(diaString){
            case "lunes":
                diaEnum = "'Monday'";
                break;
            case "martes":
                diaEnum = "'Tuesday'";
                break;
            case "miércoles":
                diaEnum = "'Wednesday'";
                break;
            case "jueves":
                diaEnum = "'Thursday'";
                break;
            case "viernes":
                diaEnum = "'Friday'";
                break;
            case "sábado":
                diaEnum = "'Saturday'";
                break;
        }
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery(
                     "SELECT DISTINCT a "+
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
                    "WHERE a.activo=1 AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica AND "+
                    "(((r.activo = 1) AND "+
                    "((DAYNAME(d.id.dia) != :variableDia OR (DAYNAME(d.id.dia) = :variableDia AND "+
                    "(:variableHoraInicio >= d.id.horaFin OR d.id.horaInicio >= :variableHoraFin))) "+
                    "AND YEAR(d.id.dia) = :anio AND (d.periodo = :periodo OR d.periodo= 'Anual' OR d.periodo = 'Ninguno'))) OR "+
                    "(r.activo = 0)) "+
                    "AND a.capacidad >= :variableCapacidad "+
                    "AND d.tipoAula = :variableTipoAula");
        query.setParameter("variableDia", diaEnum);
        query.setParameter("variableHoraInicio", sqlHoraInicio);
        query.setParameter("variableHoraFin", sqlHoraFin);
        query.setParameter("variableCapacidad", 10);
        query.setParameter("variableTipoAula", TipoAula.SinRecursos);
        query.setParameter("anio", 2018);
        query.setParameter("periodo", PeriodoEnum.PrimerCuatrimestre);
        
        List<Aula> listaRetorno = new ArrayList<>();
        listaRetorno = query.list();
        
        session.close();
        for(Aula a:listaRetorno){
            System.out.print(a.getNumeroAula()+"  ");
        }
        
        java.sql.Time sqlHoraInicio2 = new java.sql.Time(time1.getTime());
        java.sql.Time sqlHoraFin2 = new java.sql.Time(timeFin1.getTime());
        
        //De Date a String para el nombre del Día
        String diaString2 =new SimpleDateFormat("EEEE", new Locale("es", "ES")).format(date2);
        String diaEnum2 = null;
        switch(diaString2){
            case "lunes":
                diaEnum2 = "'Monday'";
                break;
            case "martes":
                diaEnum2 = "'Tuesday'";
                break;
            case "miércoles":
                diaEnum2 = "'Wednesday'";
                break;
            case "jueves":
                diaEnum2 = "'Thursday'";
                break;
            case "viernes":
                diaEnum2 = "'Friday'";
                break;
            case "sábado":
                diaEnum2 = "'Saturday'";
                break;
        }
        
        SessionFactory sesion2 = NewHibernateUtil.getSessionFactory();
        Session session2;
        session2 = sesion2.openSession();
        Query query2 = session2.createQuery(
                    "SELECT DISTINCT a "+
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
                    "WHERE a.activo=1 AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica AND "+
                    "(((r.activo = 1) AND YEAR(d.id.dia) = :anio AND "+
                    "(d.periodo = 'Ninguno' OR "+
                    "(((:periodo = Modelo.PeriodoEnum.PrimerCuatrimestre OR :periodo = Modelo.PeriodoEnum.SegundoCuatrimestre) AND "+
                    "(d.periodo = :periodo OR d.periodo = 'Anual')) OR (:periodo = Modelo.PeriodoEnum.Anual AND "+
                    "(d.periodo = 'Anual' OR d.periodo = 'PrimerCuatrimestre' OR d.periodo = 'SegundoCuatrimestre'))) "+
                    "AND (DAYNAME(d.id.dia) != :variableDia OR (DAYNAME(d.id.dia) = :variableDia AND "+
                    "(:variableHoraInicio >= d.id.horaFin OR d.id.horaInicio >= :variableHoraFin))) )) OR "+
                    "(r.activo = 0)) "+
                    "AND a.capacidad >= :variableCapacidad "+
                    "AND d.tipoAula = :variableTipoAula");
        query2.setParameter("variableDia", diaEnum2);
        query2.setParameter("variableHoraInicio", sqlHoraInicio2);
        query2.setParameter("variableHoraFin", sqlHoraFin2);
        query2.setParameter("variableCapacidad", 10);
        query2.setParameter("variableTipoAula", TipoAula.SinRecursos);
        query2.setParameter("anio", 2018);
        query2.setParameter("periodo", PeriodoEnum.PrimerCuatrimestre);
        
        List<Aula> listaRetorno2 = new ArrayList<>();
        listaRetorno2 = query2.list();
        
        session2.close();
        for(Aula a:listaRetorno2){
            System.out.print(a.getNumeroAula()+"  ");
        }*/
        
        
        /*
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery(
                    "SELECT DISTINCT d "+
                    "FROM DiaReservaEsporadica d "+
                    "WHERE DAYNAME(d.id.dia) = 'Tuesday' ");
        
        List<DiaReservaEsporadica> listaRetorno = new ArrayList<>();
        listaRetorno = query.list();
        
        session.close();
        for(DiaReservaEsporadica a:listaRetorno){
            System.out.print(a.getId().getReservaEsporadicaIdReservaEsporadica()+"  ");
        }*/
        
        
        /*
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery(
                    "SELECT DISTINCT d "+
                    "FROM DiaReservaEsporadica d "+
                    "WHERE YEAR(d.id.dia) = 2018 ");
        
        List<DiaReservaEsporadica> listaRetorno = new ArrayList<>();
        listaRetorno = query.list();
        
        session.close();
        for(DiaReservaEsporadica a:listaRetorno){
            System.out.print(a.getId().getReservaEsporadicaIdReservaEsporadica()+"  ");
        }*/
        
        /*
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Query query = session.createQuery(
                    "SELECT a "+
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r "+
                    "WHERE a.activo=1 AND a.numeroAula = :numeroAula AND a.numeroAula = d.id.aulaNumeroAula AND "+
                    "d.id.reservaEsporadicaIdReservaEsporadica = r.idReservaEsporadica AND "+
                    "r.activo = 1 AND YEAR(d.id.dia) = :anio AND "+
                    "(d.periodo = :periodo OR d.periodo = 'Anual') "+
                    "AND DAYNAME(d.id.dia) = :variableDia AND "+
                    "NOT (:variableHoraInicio >= d.id.horaFin OR d.id.horaInicio >= :variableHoraFin) "+
                    "AND a.capacidad >= :variableCapacidad "+
                    "AND d.tipoAula = :variableTipoAula");
            query.setParameter("variableDia", diaEnum);
            query.setParameter("variableHoraInicio", sqlHoraInicio);
            query.setParameter("variableHoraFin", sqlHoraFin);
            query.setParameter("variableCapacidad", capacidad);
            query.setParameter("variableTipoAula", tipoAula);
            query.setParameter("anio", anio);
            query.setParameter("periodo", periodo);
            query.setParameter("numeroAula", a.getNumeroAula());
            
            
            listaRetorno = query.list();
            if(listaRetorno.isEmpty())
                retorno=true;
            session.close();*/
        
        /*
         java.sql.Time sqlHoraInicio = new java.sql.Time(time1.getTime());
        java.sql.Time sqlHoraFin = new java.sql.Time(timeFin1.getTime());
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        List<Object> listaRetorno = new ArrayList<>();
            Query query = session.createSQLQuery("SELECT a.* " +
                    "FROM Aula a, DiaReservaEsporadica d, ReservaEsporadica r " +
                    "WHERE a.activo = 1 AND a.numeroAula = :numeroAula " +
                    "AND a.numeroAula = d.Aula_numeroAula AND d.ReservaEsporadica_id_reservaEsporadica = r.id_reservaEsporadica " +
                    "AND r.activo = 1 AND YEAR(d.dia) = :anio AND " +
                    "(d.periodo = :periodo OR d.periodo = 'Anual') AND DAYNAME(d.dia) = :variableDia " +
                    "AND NOT (:variableHoraInicio >= d.horaFin OR d.horaInicio >= :variableHoraFin);");
            query.setParameter("variableDia", "Tuesday");
            query.setParameter("variableHoraInicio", sqlHoraInicio);
            query.setParameter("variableHoraFin", sqlHoraFin);
            query.setParameter("anio", 2018);
            query.setParameter("periodo", "PrimerCuatrimestre");
            query.setParameter("numeroAula", 3);
            
            
            listaRetorno = query.list();
            
            System.out.println(listaRetorno);
                
            session.close();*/
        
        /*
        AulaDAO aulaDao  = new AulaDAO();
        
        ArrayList<Aula> auxiliar = new ArrayList<>();
        if(aulaDao.consultaAulaSinSolapamientoConEsporadicas2(date1, time1, timeFin1,a, PeriodoEnum.PrimerCuatrimestre, an2018io))
                            auxiliar.add(a);
        
        */
       exit(0);
    }
}
