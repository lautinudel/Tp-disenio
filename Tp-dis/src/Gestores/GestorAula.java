/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

//import java.sql.Date;
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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Temp
 */
public class GestorAula {
    
    
    public ArrayList<ArrayList<Aula>> obtenerDisponibilidadDeAula(
            ArrayList<Date> dias, ArrayList<Date> horaInicio,
            ArrayList<Date> horaFin, PeriodoEnum periodo,
            int cantAlumnos, TipoAula tipoAula){
        AulaDAO aulaDao = new AulaDAO();
        ArrayList<ArrayList<Aula>> aulas = new ArrayList();
        List<Aula> listaAulasDisponiblesEsporadica = new ArrayList();
        List<Aula> listaAulasDisponiblesPeriodica = new ArrayList();
        ArrayList<Aula> copia1, copia2;
        
                
        for(int i=0; i<dias.size(); i++){
            
            listaAulasDisponiblesEsporadica = aulaDao.consultaEsporadica(dias.get(i), horaInicio.get(i), horaFin.get(i),cantAlumnos,tipoAula);
            listaAulasDisponiblesPeriodica = aulaDao.consultaPeriodica(dias.get(i), horaInicio.get(i), horaFin.get(i),cantAlumnos,tipoAula);
            
            copia1 = new ArrayList<>(listaAulasDisponiblesEsporadica);
            copia2 = new ArrayList<>(listaAulasDisponiblesPeriodica);
            
            aulas.add(i, copia1);
            aulas.get(i).addAll(copia2);
            
            listaAulasDisponiblesEsporadica.clear();
            listaAulasDisponiblesPeriodica.clear();
        }
        
        //LO QUE PASA ES QUE LOS OBJETOS AULAS SON DISTINTOS POR MAS QUE TENGAS MISMOS DATOS
        //HACELO VOS, ME VOY A ESTUDIAR SUPERIOR, ESTO YA ES UN ERROR TONTO
        
        //Consulta aulas sin reserva:
        List<Aula> aulasSinReserva=aulaDao.consultaObtenerDisponibilidadSinReservas(cantAlumnos, tipoAula);
        
        //Aulas sin reserva
        for(int h=0; h<aulas.size(); h++)
            aulas.get(h).addAll(aulasSinReserva);
        
        return aulas;
    }
}
