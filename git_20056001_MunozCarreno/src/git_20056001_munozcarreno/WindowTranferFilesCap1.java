/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git_20056001_munozcarreno;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author CLundstedt
 */
public class WindowTranferFilesCap1 extends javax.swing.JFrame {

    
    private Repositorio repositorio;
    private GitController gitController;
    /**
     * Creates new form WindowTranferFilesCap1
     */
    public WindowTranferFilesCap1(Repositorio repositorio, GitController gitController) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.repositorio = repositorio;
        this.gitController = gitController;
        this.TF_AmountFilesAvailables.setText(gitController.GetAmountFiles(repositorio.getZonas(),repositorio));
        
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
        jLabel3 = new javax.swing.JLabel();
        TF_AmountFilesAvailables = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TF_PutAmountFiles = new javax.swing.JTextField();
        BTN_AceptAmountFiles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cantidad de archivos disponibles a tranferir: ");

        TF_AmountFilesAvailables.setBackground(new java.awt.Color(240, 240, 240));
        TF_AmountFilesAvailables.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TF_AmountFilesAvailables.setForeground(new java.awt.Color(128, 128, 128));
        TF_AmountFilesAvailables.setBorder(null);
        TF_AmountFilesAvailables.setCaretColor(new java.awt.Color(128, 128, 128));
        TF_AmountFilesAvailables.setEnabled(false);
        TF_AmountFilesAvailables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventAmountFilesAvailables(evt);
            }
        });

        jLabel4.setText("¿Cuantos archivos desea tranferir?");

        jLabel5.setText("Cantidad de archivos a transferir:");

        TF_PutAmountFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventPutAmountFilesActionPerformed(evt);
            }
        });
        TF_PutAmountFiles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EventPutAmountFilesKeyTyped(evt);
            }
        });

        BTN_AceptAmountFiles.setText("Aceptar");
        BTN_AceptAmountFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventAceptAmountFiles(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(15, 15, 15)
                                .addComponent(TF_AmountFilesAvailables, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2)
                                .addGap(95, 95, 95)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(TF_PutAmountFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(BTN_AceptAmountFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(TF_AmountFilesAvailables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TF_PutAmountFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_AceptAmountFiles))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EventAmountFilesAvailables(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventAmountFilesAvailables
        //AQUI SE MUESTRA LA CANTIDAD DE ARCHIVOS DISPONIBLES EN WORKSPACE
        
      
    }//GEN-LAST:event_EventAmountFilesAvailables

    private void EventPutAmountFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventPutAmountFilesActionPerformed
        // SE PROCE A INGRESAR LA CANTIDAD DE ARCHIVOS A TRANSFERIR
        //int AmountFiles = Integer.parseInt(this.TF_PutAmountFiles.getText());
        
        //SE PROCEDE A REALIZAR UN TRY CATCH
        
        
        
    }//GEN-LAST:event_EventPutAmountFilesActionPerformed

    private void EventAceptAmountFiles(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventAceptAmountFiles
         // SE PROCEDE A INGRESAR LA CANTIDAD DE ARCHIVOS A TRANSFERIR
        int AmountFiles = Integer.parseInt(this.TF_PutAmountFiles.getText());
        
        //Ahora se procede a abrir la siguient ventana para ingresar los archivos
        try{
            WindowTranferFilesCap2 w2 = new WindowTranferFilesCap2(gitController.VerifAmountFiles(repositorio.getZonas(),repositorio,AmountFiles),gitController,AmountFiles);
            w2.setVisible(true);
            this.setVisible(false);
        }
        catch(AmountFilesException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad de archivos válida.", "Error de datos ingresados", JOptionPane.ERROR_MESSAGE);
            this.TF_PutAmountFiles.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        catch(AmountFilesNotIntException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número.", "Error de datos ingresados", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_EventAceptAmountFiles

    private void EventPutAmountFilesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EventPutAmountFilesKeyTyped
        this.TF_PutAmountFiles.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    }//GEN-LAST:event_EventPutAmountFilesKeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_AceptAmountFiles;
    private javax.swing.JTextField TF_AmountFilesAvailables;
    private javax.swing.JTextField TF_PutAmountFiles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
