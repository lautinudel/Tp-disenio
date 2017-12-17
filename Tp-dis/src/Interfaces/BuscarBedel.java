/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Gestores.GestorBedel;
import Gestores.GestorValidacion;
import Modelo.Bedel;
import Modelo.TurnoEnum;
import Persistencia.BedelDAO;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 *
 * @author L. Nudel
 */
public class BuscarBedel extends javax.swing.JPanel {
    public List<Bedel> bedeles;
    /**
     * Creates new form BuscarBedel
     */
    public BuscarBedel() {
        initComponents();
        this.bedeles= new ArrayList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBusquedaDeBedeles = new javax.swing.JLabel();
        jCheckBoxApellido = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldApellido = new javax.swing.JTextField();
        jCheckBoxTurno = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxTurno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBedeles = new javax.swing.JTable();
        jButtonBuscar = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();

        jLabelBusquedaDeBedeles.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelBusquedaDeBedeles.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBusquedaDeBedeles.setText("Busqueda de bedeles");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Apellido");

        jTextFieldApellido.setToolTipText("2 a 32 caracteres. Mayúsculas y minúsculas");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Turno");

        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Noche" }));
        jComboBoxTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTurnoActionPerformed(evt);
            }
        });

        jTableBedeles = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        jTableBedeles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Apellido", "Nombre", "Turno", "Usuario"
            }
        ));
        jTableBedeles.setFocusable(false);
        jTableBedeles.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableBedeles);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonAtras.setText("Atras");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonBuscar)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBoxApellido)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBoxTurno)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelBusquedaDeBedeles)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminar)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelBusquedaDeBedeles)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBoxApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxTurno)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jButtonBuscar)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtras)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonEliminar))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        
        //elimino las filas
        for(int i=((DefaultTableModel)this.jTableBedeles.getModel()).getRowCount()-1;i>=0;i--){
            ((DefaultTableModel)this.jTableBedeles.getModel()).removeRow(i);
        }
        
        
        GestorBedel GB = new GestorBedel();
        GestorValidacion GV = new GestorValidacion();
        //apellido y turno
        if(this.jCheckBoxApellido.isSelected() && this.jCheckBoxTurno.isSelected()){
            //valido apellido
            if(GV.validarApellido(this.jTextFieldApellido.getText())){
                 
                 //busco segun turno y apellido
                 if(this.jComboBoxTurno.getSelectedItem().toString().equals("Mañana")){
                        bedeles = GB.buscarBedelApellidoyTurno(this.jTextFieldApellido.getText(),TurnoEnum.Maniana );   
                   }else if(this.jComboBoxTurno.getSelectedItem().toString().equals("Tarde")){
                       bedeles = GB.buscarBedelApellidoyTurno(this.jTextFieldApellido.getText(),TurnoEnum.Tarde );   
                   } else bedeles = GB.buscarBedelApellidoyTurno(this.jTextFieldApellido.getText(),TurnoEnum.Noche );   
                 
                if(!bedeles.isEmpty()){
                    //muestro en tabla
                    
                   for(int i=0;i<bedeles.size();i++){
                       if(bedeles.get(i).getTurnoTrabaja().equals(TurnoEnum.Maniana)){
                           Object row[] = {bedeles.get(i).getApellido(),bedeles.get(i).getNombre(), "Mañana", bedeles.get(i).getUsername()};
                           ((DefaultTableModel)this.jTableBedeles.getModel()).addRow(row);
                           
                       }else{
                           Object row[] = {bedeles.get(i).getApellido(),bedeles.get(i).getNombre(), bedeles.get(i).getTurnoTrabaja(), bedeles.get(i).getUsername()};
                           ((DefaultTableModel)this.jTableBedeles.getModel()).addRow(row);
                       }
                      
                   }}else{
                       JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
                        topFrame.mensajeEmergente("Resultado", "No hay bedeles con ese criterio de busqueda");
                   }  
            }else{
                JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
                    topFrame.mensajeEmergente("Error de validación del apeliido", "El apellido ingresado debe tener entre 2 y 32 caracteres y contener sólo letras (minúsculas o mayúsculas).");
            }
            
            
            
            
        }else{
            
            
            
            //solo apellido
            if(this.jCheckBoxApellido.isSelected()){
                //valido
               if(GV.validarApellido(this.jTextFieldApellido.getText())){
                   bedeles = GB.buscarBedelApellido(this.jTextFieldApellido.getText());
                   if(!bedeles.isEmpty()){
                       //muestro en tabla
                   for(int i=0;i<bedeles.size();i++){
                       if(bedeles.get(i).getTurnoTrabaja().equals(TurnoEnum.Maniana)){
                           Object row[] = {bedeles.get(i).getApellido(),bedeles.get(i).getNombre(), "Mañana", bedeles.get(i).getUsername()};
                           ((DefaultTableModel)this.jTableBedeles.getModel()).addRow(row);
                           
                       }else{
                           Object row[] = {bedeles.get(i).getApellido(),bedeles.get(i).getNombre(), bedeles.get(i).getTurnoTrabaja(), bedeles.get(i).getUsername()};
                           ((DefaultTableModel)this.jTableBedeles.getModel()).addRow(row);
                       }
                   }}else{
                       JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
                        topFrame.mensajeEmergente("Resultado", "No hay bedeles con ese apellido");
                   }
                }else{
                    JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
                    topFrame.mensajeEmergente("Error de validación del apeliido", "El apellido ingresado debe tener entre 2 y 32 caracteres y contener sólo letras (minúsculas o mayúsculas).");
                } 
               
               
               
               
               
            }else{
                
                
                //solo turno
                
                if(this.jCheckBoxTurno.isSelected()){
                    
                   if(this.jComboBoxTurno.getSelectedItem().toString().equals("Mañana")){
                        bedeles = GB.buscarBedelTurno(TurnoEnum.Maniana);   
                   }else if(this.jComboBoxTurno.getSelectedItem().toString().equals("Tarde")){
                       bedeles = GB.buscarBedelTurno(TurnoEnum.Tarde); 
                   } else bedeles = GB.buscarBedelTurno(TurnoEnum.Noche); 
                   if(!bedeles.isEmpty()){
                       //muestro en tabla
                   for(int i=0;i<bedeles.size();i++){
                       if(bedeles.get(i).getTurnoTrabaja().equals(TurnoEnum.Maniana)){
                           Object row[] = {bedeles.get(i).getApellido(),bedeles.get(i).getNombre(), "Mañana", bedeles.get(i).getUsername()};
                           ((DefaultTableModel)this.jTableBedeles.getModel()).addRow(row);
                           
                       }else{
                           Object row[] = {bedeles.get(i).getApellido(),bedeles.get(i).getNombre(), bedeles.get(i).getTurnoTrabaja(), bedeles.get(i).getUsername()};
                           ((DefaultTableModel)this.jTableBedeles.getModel()).addRow(row);
                       }
                   }}else{
                       JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
                        topFrame.mensajeEmergente("Resultado", "No hay bedeles con ese turno");
                   }
                   
                   
                   
                   
                   
                   
                }else{
                    JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
                    topFrame.mensajeEmergente("Error", "Debe seleccionar al menos una de las opciones de busqueda");
                }
            }
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jComboBoxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTurnoActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        // TODO add your handling code here:
        JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
        
        ArrayList<JButton> botonesDialogo = new ArrayList<>();
        botonesDialogo = topFrame.mensajeEmergenteConfirmacion("Mensaje de Confirmación", "Volverá al menu principal. ¿Continuar? ");
        JDialog dialogo = (JDialog) SwingUtilities.getWindowAncestor(botonesDialogo.get(0));
        
        botonesDialogo.get(0).addActionListener((ActionEvent e) -> {
            dialogo.setVisible(false);
            this.remove(dialogo);
            MenuPrincipalAdmin panelMenu = new MenuPrincipalAdmin();
            panelMenu.setImage("/Imagenes/fondoabs.jpg");
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

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        if(!bedeles.isEmpty()){
            if(this.jTableBedeles.getSelectedRow()!=-1){
                Bedel b = bedeles.get(this.jTableBedeles.getSelectedRow());
                JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
                ModificarBedel mb = new ModificarBedel(b);
                mb.setImage("/Imagenes/fondoabs.jpg");
                topFrame.add(mb, BorderLayout.CENTER);
                this.setVisible(false);
                topFrame.remove(this);
                topFrame.setSize(500,500); 
            }else{
                JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
           topFrame.mensajeEmergente("Error", "Primero debe seleccionar un bedel de la tabla");
            }   
        }else{
           JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
           topFrame.mensajeEmergente("Error", "Primero debe realizar una busqueda correcta"); 
        }
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        JFramePrincipal topFrame = (JFramePrincipal) SwingUtilities.getWindowAncestor(this);
           topFrame.mensajeEmergente("Funcionalidad en desarrollo", "Aún no se ha implementado la funcionalidad requerida."); 
    }//GEN-LAST:event_jButtonEliminarActionPerformed

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
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JCheckBox jCheckBoxApellido;
    private javax.swing.JCheckBox jCheckBoxTurno;
    private javax.swing.JComboBox<String> jComboBoxTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBusquedaDeBedeles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBedeles;
    private javax.swing.JTextField jTextFieldApellido;
    // End of variables declaration//GEN-END:variables
}
