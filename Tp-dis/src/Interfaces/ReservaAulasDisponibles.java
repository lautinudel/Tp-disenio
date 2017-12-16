/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Gestores.GestorAula;
import Modelo.Aula;
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

    /**
     * Creates new form ReservaAulasDisponibles
     */
    public ReservaAulasDisponibles(ArrayList<String> diasTexto, ArrayList<Date> dias, ArrayList<Date> horaInicio, ArrayList<Date> horaFin , ArrayList<ArrayList<Aula>> aulasDisponibles, TipoAula tipoAula) {
        initComponents();
        cargarDatosPeriodica(diasTexto, dias, horaFin, horaInicio, aulasDisponibles, tipoAula);
    }
    
    
    
    private void cargarDatosPeriodica(ArrayList<String> diasTexto, ArrayList<Date> dias,ArrayList<Date> horaInicio, ArrayList<Date> horaFin, ArrayList<ArrayList<Aula>> aulasDisponibles, TipoAula tipoAula){
        int cantColumnas = this.jTable1.getColumnCount();
        ArrayList<String> horaInicioTexto = convertirArrayDeDateAArrayStringFormatoHora(horaInicio);
        ArrayList<String> horaFinTexto = convertirArrayDeDateAArrayStringFormatoHora(horaFin);
        Object row[] = new Object[cantColumnas];
        
        for(int i=0;i<diasTexto.size();i++){
            //Seleccion
            row[0] = false;
            //Fecha
            row[1] = diasTexto.get(i);
            //Hora de inicio
            row[2] = horaInicioTexto.get(i);
            //Hora de fin
            row[3] = horaFinTexto.get(i);
            //En este for esta el problema
            for(int j=0;j<aulasDisponibles.get(i).size();j++){
                //Piso
                switch (aulasDisponibles.get(i).get(j).getPiso()){
                    case 0: row[4] = "Planta baja"; break;
                    case 1: row[4] = "Primer piso"; break;
                    case 2: row[4] = "Segundo piso"; break;
                    case 3: row[4] = "Tercer piso"; break;
                }
                //Aula disponible
                row[5] = aulasDisponibles.get(i).get(j).getNumeroAula();
                //Capacidad
                row[6] = aulasDisponibles.get(i).get(j).getCapacidad();
                //Tipo Pizarron
                switch (aulasDisponibles.get(i).get(j).getTipoPizarron()){
                    case 0: row[7] = "Para tiza"; break;
                    case 1: row[7] = "Para tinta"; break;
                }
                switch(aulasDisponibles.get(i).get(j).getAireAcondicionado()){
                    case 0: row[8] = "No"; break;
                    case 1: row[8] = "Si"; break;
                }  
                             
                
                //Aulas sin recursos adicionales
                if(aulasDisponibles.get(i).get(j).getAulaSinRecursosAdicionales() != null){
                    switch(aulasDisponibles.get(i).get(j).getAulaSinRecursosAdicionales().getVentiladores()){
                        case 0: row[9] = "No"; break;
                        case 1: row[9] = "Si"; break;
                    } 
                }
                //Aula informatica
                if(aulasDisponibles.get(i).get(j).getAulaInformatica() != null){
                    row[10] = aulasDisponibles.get(i).get(j).getAulaInformatica().getCantidadPc();
                    
                    switch(aulasDisponibles.get(i).get(j).getAulaInformatica().getCanion()){
                        case 0: row[11] = "No"; break;
                        case 1: row[11] = "Si"; break;
                    }
                }
                //Aula Multimedio
                if(aulasDisponibles.get(i).get(j).getAulaMultimedio() != null){
                    switch(aulasDisponibles.get(i).get(j).getAulaMultimedio().getComputadora()){
                        case 0: row[10] = "No"; break;
                        case 1: row[10] = "Si"; break;
                    }
                    switch(aulasDisponibles.get(i).get(j).getAulaMultimedio().getCanion()){
                        case 0: row[11] = "No"; break;
                        case 1: row[11] = "Si"; break;
                    }
                    switch(aulasDisponibles.get(i).get(j).getAulaMultimedio().getTelevisor()){
                        case 0: row[12] = "No"; break;
                        case 1: row[12] = "Si"; break;
                    }
                    switch(aulasDisponibles.get(i).get(j).getAulaMultimedio().getDvd()){
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Atrás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))))
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
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
