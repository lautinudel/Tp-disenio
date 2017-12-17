/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Gestores.GestorActividad;
import Gestores.GestorAula;
import Gestores.GestorBedel;
import Gestores.GestorDiaReserva;
import Gestores.GestorDocente;
import Gestores.GestorReserva;
import Modelo.ActividadUniversitaria;
import Modelo.Aula;
import Modelo.Bedel;
import Modelo.DiaReservaEsporadica;
import Modelo.DiaReservaEsporadicaId;
import Modelo.DiaReservaPeriodica;
import Modelo.DiaReservaPeriodicaId;
import Modelo.DiaSemana;
import Modelo.Docente;
import Modelo.PeriodoEnum;
import Modelo.ReservaEsporadica;
import Modelo.ReservaPeriodica;
import Modelo.TipoAula;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Temp
 */
public class ReservaAulasDisponibles extends javax.swing.JPanel {
    ArrayList<String> diasTexto;
    ArrayList<Date> dias;
    ArrayList<Date> horaInicio;
    ArrayList<Date> horaFin;
    ArrayList<ArrayList<Aula>> aulasDisponibles;
    
    int cantAlumnos;
    Docente docente;
    ActividadUniversitaria actividad;
    Bedel bedel;
    PeriodoEnum periodo;
    /**
     * Creates new form ReservaAulasDisponibles
     */
    public ReservaAulasDisponibles(ArrayList<String> diasTexto, ArrayList<Date> dias, ArrayList<Date> horaInicio, 
                                    ArrayList<Date> horaFin , ArrayList<ArrayList<Aula>> aulasDisponibles, 
                                    int cantAlumnos, String docenteApellido,String docenteNombre, String actividad, PeriodoEnum periodo, String emailDato, Bedel b) {
        initComponents();
        
        //JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
        GestorDocente gestorDocente = new GestorDocente();
        GestorActividad gestorActividad = new GestorActividad(); 
        GestorBedel gestorBedel = new GestorBedel();
                
        this.diasTexto = diasTexto;
        this.dias = dias;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aulasDisponibles = aulasDisponibles;
        this.cantAlumnos = cantAlumnos;
        this.docente = gestorDocente.obtenerDocente(docenteApellido, docenteNombre, emailDato);
        this.actividad = gestorActividad.obtenerIdActividad(actividad);
        this.bedel = b;
        this.periodo = periodo;
                
        cargarDatos();
    }
    
    
    
    private void cargarDatos(){
        int cantColumnas = this.jTable1.getColumnCount();
        ArrayList<String> horaInicioTexto = convertirArrayDeDateAArrayStringFormatoHora(this.horaInicio);
        ArrayList<String> horaFinTexto = convertirArrayDeDateAArrayStringFormatoHora(this.horaFin);
        Object row[] = new Object[cantColumnas];
        
        for(int i=0;i<this.diasTexto.size();i++){
            //Seleccion
            row[0] = false;
            //Fecha
            row[1] = this.diasTexto.get(i);
            //Hora de inicio
            row[2] = horaInicioTexto.get(i);
            //Hora de fin
            row[3] = horaFinTexto.get(i);
            //En este for esta el problema
            for(int j=0;j<this.aulasDisponibles.get(i).size();j++){
                //Piso
                switch (this.aulasDisponibles.get(i).get(j).getPiso()){
                    case 0: row[4] = "Planta baja"; break;
                    case 1: row[4] = "Primer piso"; break;
                    case 2: row[4] = "Segundo piso"; break;
                    case 3: row[4] = "Tercer piso"; break;
                }
                //Aula disponible
                row[5] = this.aulasDisponibles.get(i).get(j).getNumeroAula();
                //Capacidad
                row[6] = this.aulasDisponibles.get(i).get(j).getCapacidad();
                //Tipo Pizarron
                switch (this.aulasDisponibles.get(i).get(j).getTipoPizarron()){
                    case 0: row[7] = "Para tiza"; break;
                    case 1: row[7] = "Para tinta"; break;
                }
                switch(this.aulasDisponibles.get(i).get(j).getAireAcondicionado()){
                    case 0: row[8] = "No"; break;
                    case 1: row[8] = "Si"; break;
                }  
                             
                
                //Aulas sin recursos adicionales
                if(this.aulasDisponibles.get(i).get(j).getAulaSinRecursosAdicionales() != null){
                    switch(this.aulasDisponibles.get(i).get(j).getAulaSinRecursosAdicionales().getVentiladores()){
                        case 0: row[9] = "No"; break;
                        case 1: row[9] = "Si"; break;
                    } 
                }
                //Aula informatica
                if(this.aulasDisponibles.get(i).get(j).getAulaInformatica() != null){
                    row[10] = this.aulasDisponibles.get(i).get(j).getAulaInformatica().getCantidadPc();
                    
                    switch(this.aulasDisponibles.get(i).get(j).getAulaInformatica().getCanion()){
                        case 0: row[11] = "No"; break;
                        case 1: row[11] = "Si"; break;
                    }
                }
                //Aula Multimedio
                if(this.aulasDisponibles.get(i).get(j).getAulaMultimedio() != null){
                    switch(this.aulasDisponibles.get(i).get(j).getAulaMultimedio().getComputadora()){
                        case 0: row[10] = "No"; break;
                        case 1: row[10] = "Si"; break;
                    }
                    switch(this.aulasDisponibles.get(i).get(j).getAulaMultimedio().getCanion()){
                        case 0: row[11] = "No"; break;
                        case 1: row[11] = "Si"; break;
                    }
                    switch(this.aulasDisponibles.get(i).get(j).getAulaMultimedio().getTelevisor()){
                        case 0: row[12] = "No"; break;
                        case 1: row[12] = "Si"; break;
                    }
                    switch(this.aulasDisponibles.get(i).get(j).getAulaMultimedio().getDvd()){
                        case 0: row[13] = "No"; break;
                        case 1: row[13] = "Si"; break;
                    }
                }
                
                /*Recupero el modelo de la tabla y agrego las filas a la tabla*/
                ((DefaultTableModel)this.jTable1.getModel()).addRow(row);
            }
        }
    } 
    
    
    private ArrayList<String> convertirArrayDeDateAArrayStringFormatoHora(ArrayList<Date> horas){
        ArrayList<String> retorno = new ArrayList();
        Format formatter = new SimpleDateFormat("HH:mm");
        String horaString;
        for(int i=0;i<horas.size();i++){
           //De Date a String para FECHA:
            horaString = formatter.format(horas.get(i));
            retorno.add(horaString);
        }
        return retorno;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Atras = new javax.swing.JButton();
        Confirmar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aulas disponibles para las reservas");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione el aula que desee para cada reserva (sólo un aula por reserva) y presione el botón confirmar.");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Selección", "Fecha", "Hora de inicio", "Hora de fin", "Piso", "Aula disponible", "Capacidad", "Tipo pizarron", "Aire acondicionado", "Ventilador", "Computadoras", "Proyector", "Televisor", "DVD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        Atras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Atras.setText("Atrás");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });

        Confirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Confirmar.setText("Confirmar");
        Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Atras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Confirmar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 237, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Confirmar)
                    .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        // TODO add your handling code here:
        
        JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
        
        ArrayList<JButton> botonesDialogo = new ArrayList<>();
        botonesDialogo = topFrame.mensajeEmergenteConfirmacion("Mensaje de Confirmación", "Si regresa a la interfaz anterior los datos ingresedaos previamente se perderán.");
        JDialog dialogo = (JDialog) SwingUtilities.getWindowAncestor(botonesDialogo.get(0));
        
        botonesDialogo.get(0).addActionListener((ActionEvent e) -> {
            dialogo.setVisible(false);
            this.remove(dialogo);
            RegistrarReserva panelReserva = new RegistrarReserva();
            panelReserva.setImage("/Imagenes/fondoabs.jpg");
            topFrame.add(panelReserva, BorderLayout.CENTER);
            this.setVisible(false);
            topFrame.remove(this);
            topFrame.setSize(700,600);             
        });
        
        botonesDialogo.get(1).addActionListener((ActionEvent e) -> {
            dialogo.setVisible(false);
            this.remove(dialogo);
        });
        
    }//GEN-LAST:event_AtrasActionPerformed

    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarActionPerformed
        /*Verifico que se halla seleccionado una sola aula para cada día y horario
         y por cada reserva la guardo en la bd
        Para cada reserva necesito: 
            Si es Esporadica -> cantidadAlumnos, Bedel_username, Docente_dni, Docente_apellido, ActividadUniversitaria_idActividad y el tipoAula
                  DiaReservaEsporadica -> id_reservaEsporadica, horaInicio, horaFin, dia(date), Aula_numeroAula
            Si es Periodica -> cantidadAlumnos, periodo, Bedel_username, ActividadUniversitaria_idActividad,Docente_apellido,Docente_dni, tipoAula
                DiaReservaPeriodica -> id_reservaPeriodica, Aula_numeroAula, dia (String), horaInicio, horaFin, anio        
        */
        JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
        
        GestorDiaReserva gestorDiaReserva = new GestorDiaReserva();
        GestorReserva gestorReserva = new GestorReserva();
        ArrayList<String> fechaTabla = new ArrayList();
        ArrayList<String> horaInicioTabla = new ArrayList();
        //Almaceno el numero de fila en donde están las fechas válidas
        ArrayList<Integer> fila = new ArrayList();
        
        TipoAula tipoAula;
        int i = 0;
        boolean hayRepetidos = false;
        
        while(i<this.jTable1.getRowCount() && !hayRepetidos){
            if((Boolean)jTable1.getModel().getValueAt(i, 0) && 
                    (!fechaTabla.contains(jTable1.getModel().getValueAt(i, 1).toString()) ||
                    (fechaTabla.contains(jTable1.getModel().getValueAt(i, 1).toString()) && 
                    !horaInicioTabla.contains(jTable1.getModel().getValueAt(i, 2).toString())))){
                fila.add(i);
                fechaTabla.add(jTable1.getModel().getValueAt(i, 1).toString());
                horaInicioTabla.add(jTable1.getModel().getValueAt(i, 2).toString());
            }else{
                if((Boolean)jTable1.getModel().getValueAt(i, 0)){
                    String mensaje = "Se ha seleccionado más de un aula para una misma reserva (Fila ";
                    topFrame.mensajeEmergente("Error", mensaje.concat(String.valueOf(i+1)).concat(")."));
                    fechaTabla.clear();
                    horaInicioTabla.clear();
                    fila.clear();
                    hayRepetidos = true;
                }
            }
            i++;
        }
        //Recorro el array filas Y saco los datos para la realizar la reserva y el DiaReserva
        //Si el periodo es ninguno entonces es una reserva esporadica
        if(this.periodo == PeriodoEnum.Ninguno){
            ReservaEsporadica reservaE = new ReservaEsporadica();
            DiaReservaEsporadica diaReserva = new DiaReservaEsporadica();
            DiaReservaEsporadicaId idReserva = new DiaReservaEsporadicaId();
            
            //Por cada fecha 
            for(int j = 0; j < this.dias.size();j++){
                //Me fijo que aula fue elegida
                for(int k = 0; k<fila.size();j++){
                    if(aulasDisponibles.get(j).get(k).getAulaSinRecursosAdicionales() != null){
                        tipoAula = TipoAula.SinRecursos;
                    }else{
                        if(aulasDisponibles.get(j).get(k).getAulaMultimedio() != null){
                            tipoAula = TipoAula.Multimedios;
                        }else{
                            tipoAula = TipoAula.Informatica;
                        }
                    }
                    
                    reservaE.setDocente(this.docente);
                    reservaE.setTipoAula(tipoAula);
                    reservaE.setActividadUniversitaria(this.actividad);
                    reservaE.setBedel(this.bedel);
                    reservaE.setCantidadAlumnos(cantAlumnos);
                    //SETEAR ID RESERVA
                    //reservaE.setDiaReservaEsporadicas();
                   
                    
                    idReserva.setAulaNumeroAula(aulasDisponibles.get(j).get(k).getNumeroAula());
                    idReserva.setDia(this.dias.get(j));
                    idReserva.setHoraInicio(this.horaInicio.get(j));
                    idReserva.setHoraFin(this.horaFin.get(j));
                    //idReserva.setReservaEsporadicaIdReservaEsporadica();??
                    
                    diaReserva.setAula(aulasDisponibles.get(j).get(k));
                    diaReserva.setId(idReserva);
                    diaReserva.setReservaEsporadica(reservaE); //tira null
                    /*System.out.println(diaReserva.getAula().getNumeroAula());
                    System.out.println(diaReserva.getId().getAulaNumeroAula());
                    System.out.println(diaReserva.getReservaEsporadica().getIdReservaEsporadica());*/
                    
                    gestorReserva.registrarReserva(reservaE);
                    gestorDiaReserva.registrarDias(diaReserva);
                }
            }
        }else{
           ReservaPeriodica reservaP = new ReservaPeriodica();
           DiaReservaPeriodica diaReserva = new DiaReservaPeriodica();
           DiaReservaPeriodicaId idReserva = new DiaReservaPeriodicaId();
           
            //Por cada fecha 
            for(int j = 0; j < this.dias.size();j++){
                //Me fijo que aula fue elegida
                for(int k = 0; k<fila.size();j++){
                    if(aulasDisponibles.get(j).get(k).getAulaSinRecursosAdicionales() != null){
                        tipoAula = TipoAula.SinRecursos;
                    }else{
                        if(aulasDisponibles.get(j).get(k).getAulaMultimedio() != null){
                            tipoAula = TipoAula.Multimedios;
                        }else{
                            tipoAula = TipoAula.Informatica;
                        }
                    }
                    reservaP.setDocente(this.docente);
                    reservaP.setTipoAula(tipoAula);
                    reservaP.setActividadUniversitaria(this.actividad);
                    reservaP.setBedel(this.bedel);
                    reservaP.setCantidadAlumnos(cantAlumnos);
                    reservaP.setPeriodo(periodo);
                    
                    idReserva.setAulaNumeroAula(aulasDisponibles.get(j).get(k).getNumeroAula());
                    switch(this.diasTexto.get(j)){
                        case "lunes": idReserva.setDia(DiaSemana.Lunes);
                        case "martes": idReserva.setDia(DiaSemana.Martes);
                        case "miércoles": idReserva.setDia(DiaSemana.Miercoles);
                        case "jueves": idReserva.setDia(DiaSemana.Jueves);
                        case "viernes": idReserva.setDia(DiaSemana.Viernes);
                        case "sabado": idReserva.setDia(DiaSemana.Sabado);
                    }
                    
                    
                    //No puedo sacarlo del array de dia porque tengo solo el nombre del dia
                    Date diaActualParaSacarAnio = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                    String anio = sdf.format(diaActualParaSacarAnio);
        
                    idReserva.setAnio(Integer.parseInt(anio));
                    idReserva.setHoraInicio(this.horaInicio.get(j));
                    idReserva.setHoraFin(this.horaFin.get(j));
                    //idReserva.setReservaPeriodicaIdReservaPeriodica();???
                    
                    
                    diaReserva.setAula(aulasDisponibles.get(j).get(k));
                    diaReserva.setId(idReserva);
                    diaReserva.setReservaPeriodica(reservaP);
                    
                    
                    gestorReserva.registrarReserva(reservaP);
                    gestorDiaReserva.registrarDias(diaReserva);
                }
            }
        }
        
    }//GEN-LAST:event_ConfirmarActionPerformed

    //codigo de la imagen de fondo ----------------------------------------
    private Image fondo=null;
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo,0,0,getWidth(),getHeight(),null);
    }
    
    public void setImage(String image){
        if (image!=null) {
            fondo=new ImageIcon(getClass().getResource(image)).getImage();
        }
    }
    //-----------------------------------------------------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JButton Confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
