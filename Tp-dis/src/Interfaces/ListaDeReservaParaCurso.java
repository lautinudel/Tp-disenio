/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.event.ActionEvent;
import static java.lang.System.exit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 *
 * @author L. Nudel
 */
public class ListaDeReservaParaCurso extends javax.swing.JPanel {

    /**
     * Creates new form ListaDeReservaParaCurso
     */
    public ListaDeReservaParaCurso() {
        initComponents();
        
        this.buttonGroupTipoCurso.add(this.jRadioButtonEsporadica);
        this.buttonGroupTipoCurso.add(this.jRadioButtonPeriodica);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipoCurso = new javax.swing.ButtonGroup();
        jLabelListadodeReservaParaUnCurso = new javax.swing.JLabel();
        jLabelIntroducirCursoEspecifico = new javax.swing.JLabel();
        jTextFieldCursoEspecifico = new javax.swing.JTextField();
        jLabelTipoDeReserva = new javax.swing.JLabel();
        jRadioButtonEsporadica = new javax.swing.JRadioButton();
        jRadioButtonPeriodica = new javax.swing.JRadioButton();
        jLabelanio = new javax.swing.JLabel();
        jSpinnerAnio = new javax.swing.JSpinner();
        jLabelCursosDisponibles = new javax.swing.JLabel();
        jButtonAtras = new javax.swing.JButton();
        jButtonVerReservas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaDeCursos = new javax.swing.JTable();

        jLabelListadodeReservaParaUnCurso.setText("Listado de Reserva para un curso");

        jLabelIntroducirCursoEspecifico.setText("Introducir curso especifico: ");

        jLabelTipoDeReserva.setText("Tipo de reserva:");

        jRadioButtonEsporadica.setText("Esporadica");

        jRadioButtonPeriodica.setText("Periodica");

        jLabelanio.setText("Año:");

        jLabelCursosDisponibles.setText("Cursos disponibles:");

        jButtonAtras.setText("Atras");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonVerReservas.setText("Ver Reservas");
        jButtonVerReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerReservasActionPerformed(evt);
            }
        });

        jTableListaDeCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Lista de Cursos"
            }
        ));
        jScrollPane1.setViewportView(jTableListaDeCursos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonVerReservas)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCursosDisponibles)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelanio)
                                .addGap(40, 40, 40)
                                .addComponent(jSpinnerAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTipoDeReserva)
                                .addGap(87, 87, 87)
                                .addComponent(jRadioButtonEsporadica)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonPeriodica))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelIntroducirCursoEspecifico)
                                .addGap(90, 90, 90)
                                .addComponent(jTextFieldCursoEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonAtras)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelListadodeReservaParaUnCurso)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabelListadodeReservaParaUnCurso)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIntroducirCursoEspecifico)
                    .addComponent(jTextFieldCursoEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoDeReserva)
                    .addComponent(jRadioButtonEsporadica)
                    .addComponent(jRadioButtonPeriodica))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelanio)
                    .addComponent(jSpinnerAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelCursosDisponibles)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtras)
                    .addComponent(jButtonVerReservas))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerReservasActionPerformed
        // TODO add your handling code here:
        String nombreCurso = this.jTextFieldCursoEspecifico.getText();
        Boolean b;
        
    }//GEN-LAST:event_jButtonVerReservasActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipoCurso;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonVerReservas;
    private javax.swing.JLabel jLabelCursosDisponibles;
    private javax.swing.JLabel jLabelIntroducirCursoEspecifico;
    private javax.swing.JLabel jLabelListadodeReservaParaUnCurso;
    private javax.swing.JLabel jLabelTipoDeReserva;
    private javax.swing.JLabel jLabelanio;
    private javax.swing.JRadioButton jRadioButtonEsporadica;
    private javax.swing.JRadioButton jRadioButtonPeriodica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerAnio;
    private javax.swing.JTable jTableListaDeCursos;
    private javax.swing.JTextField jTextFieldCursoEspecifico;
    // End of variables declaration//GEN-END:variables
}
