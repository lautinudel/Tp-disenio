/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObtenerDisponibilidadTest;

import Gestores.GestorAula;
import Modelo.Aula;
import Modelo.DiaReservaEsporadica;
import Modelo.PeriodoEnum;
import Modelo.TipoAula;
import Modelo.TipoReserva;
import java.util.List;
import Persistencia.AulaDAO;
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

/**
 *
 * @author Temp
 */
public class ObtenerDisponibilidadTest {
    
    public static void main(String args[]) {
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
        String dia1 = "2018-01-12";
        String dia2 = "2018-02-13";
        String dia3 = "2017-12-21";
        String dia4 = "2018-03-05";
        String dia5 = "2018-05-07";
        String dia6 = "2017-08-15";
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
        
        String hora1 = "15:29:00";
        String hora2 = "21:08:00";
        String hora3 = "07:09:00";
        String hora4 = "11:11:00";
        String hora5 = "12:58:00";
        String hora6 = "19:45:00";
        String horaFin1 = "17:29:00";
        String horaFin2 = "22:08:00";
        String horaFin3 = "10:09:00";
        String horaFin4 = "14:11:00";
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
        
       
        System.out.println(dias);
        System.out.println(horasInicio);
        System.out.println(horasFin);
        
        ArrayList<Date> unDia = new ArrayList<>();
        unDia.add(date6);
        ArrayList<Date> unDiaHI = new ArrayList<>();
        unDiaHI.add(time6);
        ArrayList<Date> unDiaHF = new ArrayList<>();
        unDiaHF.add(timeFin6);
        
        GestorAula gestorAula = new GestorAula();
        ArrayList<ArrayList<Aula>>aulasDisp = gestorAula.obtenerDisponibilidadDeAula(TipoReserva.Esporadica, dias, horasInicio, horasFin, PeriodoEnum.Anual, 35, TipoAula.SinRecursos);
        for(int i = 0; i<aulasDisp.size();i++){
            for(int j=0; j<aulasDisp.get(i).size();j++){
                System.out.print(aulasDisp.get(i).get(j).getNumeroAula()+" ");
            }
            System.out.print("\n");
        }
        
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
       
       
       exit(0);
    }
}
