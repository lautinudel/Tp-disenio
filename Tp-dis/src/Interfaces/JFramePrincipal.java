/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author L. Nudel
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipal
     */
    public JFramePrincipal() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de reserva de aulas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        JFramePrincipal ventana = new JFramePrincipal();
        ventana.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        ventana.setLayout(new BorderLayout());
        
        /*       
        //Menu Principal -- PROVISORIO
        MenuPrincipalAdmin menu = new MenuPrincipalAdmin();
        ventana.add(menu, BorderLayout.CENTER);
        ventana.setSize(500,500); 
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);*/
        
        //Ventana a iniciar sesion
        IniciarSesion IS = new IniciarSesion();
        ventana.add(IS, BorderLayout.CENTER);
        ventana.setSize(400,400); 
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            if (JOptionPane.showConfirmDialog(ventana, 
                "Confirmación de cierre", "¿Está seguro de querer salir del programa?", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
            }
        }
        });
        
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mensajeEmergente(String titulo, String mensaje){
        JDialog dialogo = new JDialog(this, titulo);
        JLabel etiqueta = new JLabel(mensaje);
        JButton boton = new JButton("Aceptar");
        dialogo.setLayout(new FlowLayout());
        dialogo.getContentPane().add(etiqueta, BorderLayout.CENTER);
        dialogo.getContentPane().add(boton, BorderLayout.CENTER);
	dialogo.pack();
        dialogo.setLocationRelativeTo (null);
        dialogo.setVisible(true);
        
        boton.addActionListener((ActionEvent e) -> {
            dialogo.setVisible(false);
            this.remove(dialogo);
        });
    }
    
    public ArrayList<JButton> mensajeEmergenteConfirmacion (String titulo, String mensaje){
        JDialog dialogo = new JDialog(this, titulo);
        JLabel etiqueta = new JLabel(mensaje);
        JButton botonSi = new JButton("SI");
        JButton botonNo = new JButton("NO");
        ArrayList<JButton> retorno = new ArrayList<>();
        retorno.add(botonSi);
        retorno.add(botonNo);
        dialogo.setLayout(new FlowLayout());
        dialogo.getContentPane().add(etiqueta, BorderLayout.CENTER);
        dialogo.getContentPane().add(botonSi, BorderLayout.CENTER);
        dialogo.getContentPane().add(botonNo, BorderLayout.CENTER);
	dialogo.pack();
        dialogo.setLocationRelativeTo (null);
        dialogo.setVisible(true);
                
        /*botonSi.addActionListener((ActionEvent e) -> {
            dialogo.setVisible(false);
            this.remove(dialogo);
        });
        
        botonNo.addActionListener((ActionEvent e) -> {
            dialogo.setVisible(false);
            this.remove(dialogo);
        });*/
        
        return retorno;
    }
}
