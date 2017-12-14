/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Gestores.GestorAutenticacion;
import Modelo.*;
import Persistencia.*;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import static java.lang.System.exit;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 *
 * @author L. Nudel
 */
public class IniciarSesion extends javax.swing.JPanel {

    /**
     * Creates new form IniciarSesion
     */
    public IniciarSesion() {
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

        jLabelInicioDeSesion = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelContrasenia = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jPasswordFieldPass = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(400, 400));

        jLabelInicioDeSesion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelInicioDeSesion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInicioDeSesion.setText("Inicio de Sesión");

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuario: ");
        jLabelUsuario.setToolTipText("6 a 32 caracteres. Mayúsculas, minúsculas y números.");

        jLabelContrasenia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContrasenia.setText("Contraseña: ");
        jLabelContrasenia.setToolTipText("6 a 32 caracteres. Mayúsculas, minúsculas, números y especiales (@#$%&*).");

        jTextFieldUsuario.setToolTipText("6 a 32 caracteres. Mayúsculas, minúsculas y números.");
        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });
        jTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioKeyTyped(evt);
            }
        });

        jButtonAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jPasswordFieldPass.setToolTipText("6 a 32 caracteres. Mayúsculas, minúsculas, números y especiales (@#$%&*).");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonAceptar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelUsuario)
                                .addComponent(jLabelContrasenia))
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabelInicioDeSesion)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(jLabelInicioDeSesion)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContrasenia)
                    .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jButtonAceptar)
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        String usuario = this.jTextFieldUsuario.getText();
        String pass = new String(jPasswordFieldPass.getPassword());
        
        //Verificar limite de caracteres en ambos campos
        if(usuario.length()>5 && usuario.length()<33 ){
            if( pass.length()>5 && pass.length()<33){
                //verifico si el usuario existe:
                GestorAutenticacion gestorAu = new GestorAutenticacion();
                int retornoMensajes = gestorAu.autenticarUsuario(usuario, pass);
                
                JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
                switch (retornoMensajes) {
                case 1:
                    MenuPrincipalBedel menuBedel = new MenuPrincipalBedel();
                    menuBedel.setImage("/Imagenes/fondoabs.jpg");
                    topFrame.add(menuBedel, BorderLayout.CENTER);
                    this.setVisible(false);
                    topFrame.remove(this);
                    topFrame.setSize(500,550);
                    break;
                case 2:
                    topFrame.mensajeEmergente("Error", "La contraseña es incorrecta. Vuelva a intentarlo.");
                    break;
                case 3:
                    MenuPrincipalAdmin menuAdmin = new MenuPrincipalAdmin();
                    menuAdmin.setImage("/Imagenes/fondoabs.jpg");
                    topFrame.add(menuAdmin, BorderLayout.CENTER);
                    this.setVisible(false);
                    topFrame.remove(this);
                    topFrame.setSize(500,500);
                    break;
                case 4:
                    topFrame.mensajeEmergente("Error", "No existe un usuario registrado con ese nombre.");
                    break;
                }
                
            }else{
                JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
                topFrame.mensajeEmergente("Error", "El numero de caracteres para el campo contraseña estan fuera del limite");
                //limpia el campo contraseña
                this.jPasswordFieldPass.setText(null);
            }
            
        }else{
            JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
            topFrame.mensajeEmergente("Error", "El numero de caracteres para el campo usuario estan fuera del limite");
            //limpia el campo usuario
            this.jTextFieldUsuario.setText(null);
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jTextFieldUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldUsuarioKeyTyped

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

    //codigo de la imagen de fondo
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
    //
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JLabel jLabelContrasenia;
    private javax.swing.JLabel jLabelInicioDeSesion;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
