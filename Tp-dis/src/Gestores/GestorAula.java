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
        AulaDAO aulaDao = new AulaDAO();
        ArrayList<ArrayList<Aula>> aulas = new ArrayList();
        List<Aula> listaAulas = new ArrayList();
        ArrayList<Aula> copia;
        
        /*
        Format formatterDia = new SimpleDateFormat("yyyy-MM-dd");
        Format formatterHora = new SimpleDateFormat("hh:mm:ss");
        String diaString, horaInicioString, horaFinString;
        */
        
        for(int i=0; i<dias.size(); i++){
            /*
            diaString = formatterDia.format(dias.get(i));
            horaInicioString = formatterHora.format(horaInicio.get(i));
            horaFinString = formatterHora.format(horaFin.get(i));*/
            
            
            //Consulta aulas disponibles:
            listaAulas = aulaDao.consultaObtenerDisponibilidadEsporadica(dias.get(i), horaInicio.get(i), horaFin.get(i),cantAlumnos,tipoAula);
            
            /*for(int k = 0; k<listaAulas.size();k++){
                System.out.print(listaAulas.get(k).getNumeroAula()+" ");
            }
            
            System.out.print("\n");*/
            
            copia = new ArrayList<>(listaAulas);
            aulas.add(i, copia);
            listaAulas.clear();
        }
        
        //Consulta aulas sin reserva:
        List<Aula> aulasSinReserva=aulaDao.consultaObtenerDisponibilidadSinReservas();
        
        //Consulta aulas del tipo y capacidad:
        //List<Aula> aulasCapacidadTipo = aulaDao.obtenerListaDeAulas(tipoAula, cantAlumnos);
        
        //Aulas sin reserva
        for(int h=0; h<aulas.size(); h++)
            aulas.get(h).addAll(aulasSinReserva);
        /*
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
        }*/
        
        return aulas;
    }
}
