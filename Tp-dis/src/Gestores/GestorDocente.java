/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelo.Docente;
import Persistencia.DocenteDao;
import java.util.List;

/**
 *
 * @author ayr_1
 */
public class GestorDocente {

    public GestorDocente() {
    }
    public Docente obtenerDocente(String docenteApellido, String docenteNombre, String emailDato){
        DocenteDao docenteDao = new DocenteDao();
        return docenteDao.obtenerDocente(docenteApellido, docenteNombre, emailDato);
    }
    public List<Docente> verificarExistencia(String docenteApellido, String docenteNombre, String emailDato){
        DocenteDao docenteDao = new DocenteDao();
        return docenteDao.verificarExistencia(docenteApellido, docenteNombre, emailDato);
    }
}
