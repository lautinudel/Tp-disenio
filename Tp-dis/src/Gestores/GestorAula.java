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
            int cantAlumnos, TipoAula tipoAula, TipoReserva tipoReserva, int anio){
        AulaDAO aulaDao = new AulaDAO();
        ArrayList<ArrayList<Aula>> aulas = new ArrayList();
        List<Aula> listaAulasDisponiblesEsporadica = new ArrayList();
        List<Aula> auxiliar = new ArrayList();
        List<Aula> listaAulasDisponiblesPeriodica = new ArrayList();
        List<Aula> listaAulasReservasNinguno = new ArrayList();
        List<Aula> listaAulasReservasPrimero = new ArrayList();
        List<Aula> listaAulasReservasSegundo = new ArrayList();
        ArrayList<Aula> copia1, copia2;
        boolean nohayEsporadicas = false, nohayPeriodicas = false;
        ArrayList<Boolean> arregloEsporadicas = new ArrayList<>();
        ArrayList<Boolean> arregloPeriodicas = new ArrayList<>();
        
        
        for(int i=0; i<dias.size(); i++){
            
            //Busca las aulas disponibles según las reservas esporádicas:
            if(tipoReserva==TipoReserva.Esporadica){
                listaAulasDisponiblesEsporadica = aulaDao.consultaEsporadica(dias.get(i), horaInicio.get(i), horaFin.get(i),cantAlumnos,tipoAula);
                if(listaAulasDisponiblesEsporadica.isEmpty())
                    nohayEsporadicas=true;
                else
                    nohayEsporadicas=false;
            
                System.out.println("AULAS DISPONIBLES - CONSULTA ESPORADICAS - RESERVA "+i);
                for(Aula a : listaAulasDisponiblesEsporadica)
                    System.out.print(a.getNumeroAula()+" ");
                System.out.print("\n");

                //Busca las aulas disponibles según las reservas periódicas:
                if(periodos.get(i)!=PeriodoEnum.Ninguno)
                    listaAulasDisponiblesPeriodica = aulaDao.consultaPeriodica(dias.get(i), horaInicio.get(i), horaFin.get(i),cantAlumnos,tipoAula, periodos.get(i));
                else
                    listaAulasDisponiblesPeriodica = aulaDao.consultaPeriodica2(dias.get(i), horaInicio.get(i), horaFin.get(i),cantAlumnos,tipoAula, periodos.get(i));
                
                if(listaAulasDisponiblesPeriodica.isEmpty())
                    nohayPeriodicas=true;
                else
                    nohayPeriodicas=false;
            
                System.out.println("AULAS DISPONIBLES - CONSULTA PERIODICAS - RESERVA "+i);
                for(Aula a : listaAulasDisponiblesPeriodica)
                    System.out.print(a.getNumeroAula()+" ");
                System.out.println();
            
                System.out.println("PERIODO RESERVA "+i);
                System.out.println(periodos.get(i)+"\n");
            }else{
                listaAulasDisponiblesEsporadica = aulaDao.consultaEsporadica2(dias.get(i), horaInicio.get(i), horaFin.get(i),cantAlumnos,tipoAula, periodos.get(i), anio);
                      
                if(listaAulasDisponiblesEsporadica.isEmpty())
                    nohayEsporadicas=true;
                else
                    nohayEsporadicas=false;
            
                System.out.println("AULAS DISPONIBLES - CONSULTA ESPORADICAS - RESERVA "+i);
                for(Aula a : listaAulasDisponiblesEsporadica)
                    System.out.print(a.getNumeroAula()+" ");
                System.out.print("\n");
            
                listaAulasDisponiblesPeriodica = aulaDao.consultaPeriodica(dias.get(i), horaInicio.get(i), horaFin.get(i),cantAlumnos,tipoAula, periodos.get(i));
                
                if(listaAulasDisponiblesPeriodica.isEmpty())
                    nohayPeriodicas=true;
                else
                    nohayPeriodicas=false;
            
                System.out.println("AULAS DISPONIBLES - CONSULTA PERIODICAS - RESERVA "+i);
                for(Aula a : listaAulasDisponiblesPeriodica)
                    System.out.print(a.getNumeroAula()+" ");
                System.out.println();
            
                System.out.println("PERIODO RESERVA "+i);
                System.out.println(periodos.get(i)+"\n");
                
                if(nohayEsporadicas==false && nohayPeriodicas==false){
                    for(Aula a: listaAulasDisponiblesEsporadica){
                        if(!aulaDao.consultaAulaSinSolapamientoConEsporadicas2(dias.get(i), horaInicio.get(i), horaFin.get(i), a, periodos.get(i), anio))
                            auxiliar.add(a);
                    }
                    listaAulasDisponiblesEsporadica.clear();
                    listaAulasDisponiblesEsporadica=auxiliar;
                }if(nohayEsporadicas==false && nohayPeriodicas==false){
                    for(Aula a: listaAulasDisponiblesPeriodica){
                        if(!aulaDao.consultaAulaSinSolapamientoConEsporadicas2(dias.get(i), horaInicio.get(i), horaFin.get(i), a, periodos.get(i), anio))
                            auxiliar.add(a);
                    }
                    listaAulasDisponiblesPeriodica.clear();
                    listaAulasDisponiblesPeriodica=auxiliar;
                    auxiliar.clear();
                }
            }
            
            arregloEsporadicas.add(nohayEsporadicas);
            arregloPeriodicas.add(nohayPeriodicas);
            
            copia1 = new ArrayList<>(listaAulasDisponiblesEsporadica);
            copia2 = new ArrayList<>(listaAulasDisponiblesPeriodica);
            
            aulas.add(i, copia1);
            aulas.get(i).addAll(copia2);
            
                       
            listaAulasDisponiblesEsporadica.clear();
            listaAulasDisponiblesPeriodica.clear();
        }
        
       
        System.out.println("ANTES DE CONSERVAR DUPLICADOS");
        for(int i = 0 ; i<aulas.size();i++){
            for(Aula al : aulas.get(i))
                System.out.print(al.getNumeroAula()+" ");
            
            System.out.print("\n");
        }
                
        //CONSERVAR SOLO DUPLICADOS
        for(int i=0;i<aulas.size();i++){
            if(!arregloEsporadicas.get(i) && !arregloPeriodicas.get(i)){
                this.mantenerRepetidos(aulas.get(i));
                this.eliminarRepetidosPos(aulas.get(i));
            }
        }

        /*
        Boolean flag=false;
        if(tipoReserva==TipoReserva.Periodica){
            ArrayList<ArrayList<Aula>> aulasFinal = new ArrayList<>();
            for(int p = 0; p<aulas.size(); p++){
                if(!aulas.get(p).isEmpty()){
                    aulasFinal.add(new ArrayList<>());
                    for(int q=0; q<aulas.get(p).size(); q++){
                        if(aulaDao.consultaAulaSinSolapamientoConEsporadicas2(dias.get(p), horaInicio.get(p), horaFin.get(p), aulas.get(p).get(q), periodos.get(p), anio))
                            aulasFinal.get(p).add(aulas.get(p).get(q));
                    }
                    flag=true;
                }
            }
            
            if(flag){
                aulas.clear();
                aulas=aulasFinal;
            }
        }
        */
        
        System.out.println("DESPUES DE CONSERVAR DUPLICADOS");
        for(int i = 0 ; i<aulas.size();i++){
            for(Aula al : aulas.get(i))
                System.out.print(al.getNumeroAula()+" ");
            
            System.out.print("\n");
        }
        
        //consulta aulas en periodo ninguno:
        for(int r=0; r<aulas.size(); r++){
            if(tipoReserva==TipoReserva.Periodica){
                auxiliar.clear();
                listaAulasReservasNinguno = aulaDao.reservasNingunPeriodo(anio);
                for(int t=0; t<listaAulasReservasNinguno.size(); t++){
                    if(!aulaDao.consultaAulaSinSolapamientoConEsporadicas2(dias.get(r), horaInicio.get(r), horaFin.get(r), listaAulasReservasNinguno.get(r), periodos.get(r), anio))
                        auxiliar.add(listaAulasReservasNinguno.get(t));
                }
            
                listaAulasReservasNinguno.clear();
                listaAulasReservasNinguno = new ArrayList(auxiliar);
            }
            /*
            else if (tipoReserva==TipoReserva.Periodica && periodos.get(0)==PeriodoEnum.SegundoCuatrimestre){
                auxiliar.clear();
                listaAulasReservasNinguno = aulaDao.reservasNingunPeriodo(anio);
                for(int t=0; t<listaAulasReservasNinguno.size(); t++){
                    if(!aulaDao.consultaAulaSinSolapamientoConEsporadicas2(dias.get(r), horaInicio.get(r), horaFin.get(r), listaAulasReservasNinguno.get(r), periodos.get(r), anio))
                        auxiliar.add(listaAulasReservasNinguno.get(t));
                }
            
                listaAulasReservasNinguno.clear();
                listaAulasReservasNinguno = new ArrayList(auxiliar);

                auxiliar.clear();
                listaAulasReservasPrimero = aulaDao.reservasPrimerCuatrimestre(anio);
                for(int t=0; t<listaAulasReservasPrimero.size(); t++){
                    if(!aulaDao.consultaAulaSinSolapamientoConEsporadicas2(dias.get(r), horaInicio.get(r), horaFin.get(r), listaAulasReservasPrimero.get(r), periodos.get(r), anio))
                        auxiliar.add(listaAulasReservasPrimero.get(t));
                }
            
                listaAulasReservasPrimero.clear();
                listaAulasReservasPrimero = new ArrayList(auxiliar);

            }else if(tipoReserva==TipoReserva.Periodica && periodos.get(0)==PeriodoEnum.PrimerCuatrimestre){
                auxiliar.clear();
                listaAulasReservasNinguno = aulaDao.reservasNingunPeriodo(anio);
                for(int t=0; t<listaAulasReservasNinguno.size(); t++){
                    if(!aulaDao.consultaAulaSinSolapamientoConEsporadicas2(dias.get(r), horaInicio.get(r), horaFin.get(r), listaAulasReservasNinguno.get(r), periodos.get(r), anio))
                        auxiliar.add(listaAulasReservasNinguno.get(t));
                }
            
                listaAulasReservasNinguno.clear();
                listaAulasReservasNinguno = new ArrayList(auxiliar);

                auxiliar.clear();
                listaAulasReservasSegundo = aulaDao.reservasSegundoCuatrimestre(anio);
                for(int t=0; t<listaAulasReservasSegundo.size(); t++){
                    if(!aulaDao.consultaAulaSinSolapamientoConEsporadicas2(dias.get(r), horaInicio.get(r), horaFin.get(r), listaAulasReservasPrimero.get(r), periodos.get(r), anio))
                        auxiliar.add(listaAulasReservasSegundo.get(t));
                }
            
                listaAulasReservasSegundo.clear();
                listaAulasReservasSegundo = new ArrayList(auxiliar);
            }
             */
        }
        
        
        
        //Consulta aulas sin reserva:
        List<Aula> aulasSinReserva=aulaDao.consultaObtenerDisponibilidadSinReservas(cantAlumnos, tipoAula);
        
        //Aulas sin reserva
        for(int h=0; h<aulas.size(); h++)
            aulas.get(h).addAll(aulasSinReserva);
        
        System.out.println("DESPUES DE AÑADIR AULAS SIN RESERVA");
        for(int i = 0 ; i<aulas.size();i++){
            for(Aula al : aulas.get(i))
                System.out.print(al.getNumeroAula()+" ");
            
            System.out.print("\n");
        }
        
        
        return aulas;
    }
    public void mantenerRepetidos(ArrayList<Aula> lista){
        boolean encontrado=false;
        
       for(int i=0;i<lista.size();i++){
           encontrado=false;
          for(int j=0;j<lista.size();j++){
              if(i!=j){
              if(lista.get(i).getNumeroAula()==lista.get(j).getNumeroAula()){
                  encontrado=true;
              }}
             
                      
          } 
          if(!encontrado){
                 lista.remove(i);
                 if(i!=0) i--;
             }
        }
         
    }
    
    public void eliminarRepetidosPos (ArrayList<Aula> lista){
        
        for(int i=0;i<lista.size();i++){
          for(int j=0;j<lista.size();j++){
              if(i!=j){
              if(lista.get(i).getNumeroAula()==lista.get(j).getNumeroAula()){
                  lista.remove(j);
                  j--;
              }}
                      
          }  
        }
        
        
        
    }
    
    
}


