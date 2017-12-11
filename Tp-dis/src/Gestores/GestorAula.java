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
    
    
    public LinkedHashMap<ArrayList<String>, ArrayList<Aula>> obtenerDisponibilidadDeAula(
            TipoReserva tipoReserva, LinkedHashMap listaDiasHoraYDuracion, PeriodoEnum periodo,
            int cantAlumnos, TipoAula tipoAula){
        
        LinkedHashMap<ArrayList<String>, ArrayList<Aula>> retorno = new LinkedHashMap<>();
        
        AulaDAO aulaDao = new AulaDAO();
        List<Aula> listaAulas = aulaDao.obtenerListaDeAulas(tipoAula, cantAlumnos);
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        
        int nroAula;
        GestorReserva gestorReserva = new GestorReserva();
        for(Aula a : listaAulas){
            nroAula=a.getNumeroAula();
            Query query = session.createQuery("SELECT d FROM DiaReservaEsporadica d WHERE Aula_numeroAula = :nroAula");
            query.setParameter("nroAula", nroAula);
            List<DiaReservaEsporadica> listaDiaReservaEsporadica = query.list();
            
            for(DiaReservaEsporadica d : listaDiaReservaEsporadica){
                if(gestorReserva.reservaEsporadicaActiva(d.getId().getReservaEsporadicaIdReservaEsporadica())){
                    
                }
            }
        }
        
        
        return retorno;
    }
}
