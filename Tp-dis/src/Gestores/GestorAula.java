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
            ArrayList<Date> horaFin, ArrayList<PeriodoEnum> periodos,
            int cantAlumnos, TipoAula tipoAula){
        AulaDAO aulaDao = new AulaDAO();
        ArrayList<ArrayList<Aula>> aulas = new ArrayList();
        List<Aula> listaAulasDisponiblesEsporadica = new ArrayList();
        List<Aula> listaAulasDisponiblesPeriodica = new ArrayList();
        ArrayList<Aula> copia1, copia2;
        
                
        for(int i=0; i<dias.size(); i++){
            
            //Busca las aulas disponibles según las reservas esporádicas:
            listaAulasDisponiblesEsporadica = aulaDao.consultaEsporadica(dias.get(i), horaInicio.get(i), horaFin.get(i),cantAlumnos,tipoAula);
            
            //Busca las aulas disponibles según las reservas periódicas:
            //Se agregó un Array de periodos (un periodo para cada dia.)
            //Si el periodo es "Ninguno", quiere decir que la fecha no cae en ningún período.
            //Por ejemplo: una reserva en enero.
            //Entonces se ignora la búsqueda de solapamientos con reservas periódicas, porque
            //  no es posible que exista una reserva periódica fuera de los periódos.
            //Si la fecha que se quiere reservar cae dentro de un período, se evalúa la consulta.
            //Siempre se evalúa en caso de ser reserva períodica.
            //El Array de períodos debe cargarse en el GestorReserva dependiendo las fechas intorducidas.
            
            if(periodos.get(i)!=PeriodoEnum.Ninguno)
                listaAulasDisponiblesPeriodica = aulaDao.consultaPeriodica(dias.get(i), horaInicio.get(i), horaFin.get(i),cantAlumnos,tipoAula, periodos.get(i));
            
            copia1 = new ArrayList<>(listaAulasDisponiblesEsporadica);
            copia2 = new ArrayList<>(listaAulasDisponiblesPeriodica);
            
            aulas.add(i, copia1);
            aulas.get(i).addAll(copia2);
            
            listaAulasDisponiblesEsporadica.clear();
            listaAulasDisponiblesPeriodica.clear();
        }
       
        //FALTA ELIMINAR DUPLICADOS
        
        //Consulta aulas sin reserva:
        List<Aula> aulasSinReserva=aulaDao.consultaObtenerDisponibilidadSinReservas(cantAlumnos, tipoAula);
        
        //Aulas sin reserva
        for(int h=0; h<aulas.size(); h++)
            aulas.get(h).addAll(aulasSinReserva);
        
        return aulas;
    }
}
