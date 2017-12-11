/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Gestores.GestorAula;
import Modelo.Aula;
import Modelo.PeriodoEnum;
import Modelo.TipoAula;
import Modelo.TipoReserva;
import java.util.List;
import Persistencia.AulaDAO;
import static java.lang.System.exit;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Temp
 */
public class ObtenerDisponibilidadTest {
    
    public static void main(String args[]) {
        
        /*AulaDAO dao = new AulaDAO();
        List<Aula> lista = dao.obtenerListaDeAulas(TipoAula.SinRecursos, 2);
        System.out.println(lista);
        System.out.println(lista.get(0).getAulaSinRecursosAdicionales().getVentiladores());*/
        
        
        Time hora = new Time(System.currentTimeMillis());
        System.out.println(hora);
        
        Time hora2 = new Time(1, 53, 23);
        System.out.println(hora2);
        
        GregorianCalendar calendario = new GregorianCalendar();
        System.out.println(calendario);
        
        System.out.println(calendario.getTime());
        
        //------------------------------------------------------------
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
        
        String string = "January 2, 2010";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date=null;
        try {
            date = format.parse(string);
        } catch (ParseException ex) {
            Logger.getLogger(ObtenerDisponibilidadTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(date);
        
        
        //Probando metodo ObtenerDisponibilidad
        ArrayList<Date> dias = new ArrayList<>();
        
        
        
        GestorAula gestorAula = new GestorAula();
        //gestorAula.obtenerDisponibilidadDeAula(TipoReserva.Esporadica, dias, horaInicio, horaFin, PeriodoEnum.Anual, 0, TipoAula.Informatica);
        
        exit(0);
    }
}
