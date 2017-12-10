/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Modelo.Aula;
import Modelo.TipoAula;
import java.util.List;
import Persistencia.AulaDAO;
import static java.lang.System.exit;

/**
 *
 * @author Temp
 */
public class ObtenerDisponibilidadTest {
    
    public static void main(String args[]) {
        
        AulaDAO dao = new AulaDAO();
        List<Aula> lista = dao.obtenerListaDeAulas(TipoAula.SinRecursos, 2);
        System.out.println(lista);
        System.out.println(lista.get(0).getAulaSinRecursosAdicionales().getVentiladores());
        
        exit(0);
    }
}
