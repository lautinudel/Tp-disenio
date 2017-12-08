/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import Gestores.GestorBedel;
import Modelo.*;
import Persistencia.BedelDAO;
import Gestores.GestorPoliticas;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import static java.lang.System.exit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author L. Nudel
 */
public class RegistrarBedel extends javax.swing.JPanel {

    /**
     * Creates new form RegistrarBedel
     */
    public RegistrarBedel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelTurno = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelContrasenia = new javax.swing.JLabel();
        jLabelConfirmacionContrasenia = new javax.swing.JLabel();
        jLabelRegistrarBedel = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldUsuario = new javax.swing.JTextField();
        jTextFieldConfirmacionContrasenia = new javax.swing.JTextField();
        jComboBoxTurno = new javax.swing.JComboBox<>();
        jButtonAceptar = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jTextFieldContrasenia = new javax.swing.JPasswordField();

        jLabelNombre.setText("Nombre");
        jLabelNombre.setToolTipText("2 a 32 caracteres. Mayúsculas, minúsculas y números.");

        jLabelApellido.setText("Apellido");
        jLabelApellido.setToolTipText("2 a 32 caracteres. Mayúsculas, minúsculas y números.");

        jLabelTurno.setText("Turno");
        jLabelTurno.setToolTipText("Elija un turno de la lista.");

        jLabelUsuario.setText("Usuario");
        jLabelUsuario.setToolTipText("6 a 32 caracteres. Mayúsculas, minúsculas y números.");

        jLabelContrasenia.setText("Contraseña");
        jLabelContrasenia.setToolTipText("6 a 32 caracteres. Mayúsculas, minúsculas, números y especiales (@#$%&*).");

        jLabelConfirmacionContrasenia.setText("Confirmar contraseña");
        jLabelConfirmacionContrasenia.setToolTipText("6 a 32 caracteres. Mayúsculas, minúsculas, números y especiales (@#$%&*).");

        jLabelRegistrarBedel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelRegistrarBedel.setText("Registrar Bedel");

        jTextFieldNombre.setToolTipText("2 a 32 caracteres. Mayúsculas, minúsculas y números.");
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldApellido.setToolTipText("2 a 32 caracteres. Mayúsculas, minúsculas y números.");

        jTextFieldUsuario.setToolTipText("6 a 32 caracteres. Mayúsculas, minúsculas y números.");

        jTextFieldConfirmacionContrasenia.setToolTipText("6 a 32 caracteres. Mayúsculas, minúsculas, números y especiales (@#$%&*).");

        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Noche" }));
        jComboBoxTurno.setToolTipText("Elija un turno de la lista.");
        jComboBoxTurno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTurnoActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonAtras.setText("Atras");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jTextFieldContrasenia.setToolTipText("6 a 32 caracteres. Mayúsculas, minúsculas, números y especiales (@#$%&*).");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRegistrarBedel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonAtras)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAceptar))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelUsuario)
                                .addComponent(jLabelContrasenia)
                                .addComponent(jLabelConfirmacionContrasenia)
                                .addComponent(jLabelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldNombre)
                                .addComponent(jTextFieldApellido)
                                .addComponent(jTextFieldUsuario)
                                .addComponent(jTextFieldConfirmacionContrasenia)
                                .addComponent(jTextFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabelRegistrarBedel)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContrasenia)
                    .addComponent(jTextFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConfirmacionContrasenia)
                    .addComponent(jTextFieldConfirmacionContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonAtras))
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
                  
       GestorBedel gestor = new GestorBedel();
       String pass = new String(jTextFieldContrasenia.getPassword());
       int msj = gestor.registrarBedel(jTextFieldNombre.getText(),
               jTextFieldApellido.getText(),jComboBoxTurno.getSelectedItem().toString(),
               jTextFieldUsuario.getText(), pass,
               jTextFieldConfirmacionContrasenia.getText());
       
       JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
        switch (msj) {
            case 0:
                topFrame.mensajeEmergente("Registro Exitoso", "El Bedel se registró correctamente.");
                break;
            case 1:
                topFrame.mensajeEmergente("Error de passwords", "Las contraseñas no coinciden.");
                
                break;
            case 2:
                topFrame.mensajeEmergente("Error de validación de políticas", "Los datos ingresados no respetan las políticas establecidas.");
                
                break;
            case 3:
                topFrame.mensajeEmergente("Nombre de Usuario existente", "Ya existe un Bedel con el nombre de Usuario: "+ jTextFieldUsuario.getText()+".");
                
                break;
        }
      
        
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jComboBoxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTurnoActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        // TODO add your handling code here:
        JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
        
        ArrayList<JButton> botonesDialogo = new ArrayList<>();
        botonesDialogo = topFrame.mensajeEmergenteConfirmacion("Mensaje de Confirmación", "Al regresar al menú principal, los datos que haya ingresado en algún campo serán descartados.");
        JDialog dialogo = (JDialog) SwingUtilities.getWindowAncestor(botonesDialogo.get(0));
        
        botonesDialogo.get(0).addActionListener((ActionEvent e) -> {
            dialogo.setVisible(false);
            this.remove(dialogo);
            MenuPrincipalAdmin panelMenu = new MenuPrincipalAdmin();
            topFrame.add(panelMenu, BorderLayout.CENTER);
            this.setVisible(false);
            topFrame.remove(this);
            topFrame.setSize(500,500);             
        });
        
        botonesDialogo.get(1).addActionListener((ActionEvent e) -> {
            dialogo.setVisible(false);
            this.remove(dialogo);
        });
    }//GEN-LAST:event_jButtonAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JComboBox<String> jComboBoxTurno;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelConfirmacionContrasenia;
    private javax.swing.JLabel jLabelContrasenia;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelRegistrarBedel;
    private javax.swing.JLabel jLabelTurno;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldConfirmacionContrasenia;
    private javax.swing.JPasswordField jTextFieldContrasenia;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
