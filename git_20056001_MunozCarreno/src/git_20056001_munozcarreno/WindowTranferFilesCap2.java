/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git_20056001_munozcarreno;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author CLundstedt
 */
public class WindowTranferFilesCap2 extends javax.swing.JFrame {

    private Repositorio repositorio;
    private GitController gitController;
    private ArrayList<String> COMANDOS;
    private int AmountFiles;
    /**
     * Creates new form WindowTranferFilesCap2
     */
    public WindowTranferFilesCap2(Repositorio repositorio,GitController gitController, int AmountFiles,ArrayList<String> COMANDOS) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.repositorio = repositorio;
        this.gitController = gitController;
        this.COMANDOS = COMANDOS;
        this.AmountFiles = AmountFiles;
        //se pasa el entero AmountFiles como String 
        String Cadena = String.valueOf(AmountFiles);
        this.TF_ShowAmountFiles.setText(Cadena);
        
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
        TF_ShowAmountFiles = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_FilesAvailables = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        TF_PutNumberFile = new javax.swing.JTextField();
        BTN_TransferFiles = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BTN_ReadyForBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transferencia de archivos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Archivos por enviar:");

        TF_ShowAmountFiles.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TF_ShowAmountFiles.setForeground(new java.awt.Color(128, 128, 128));
        TF_ShowAmountFiles.setBorder(null);
        TF_ShowAmountFiles.setCaretColor(new java.awt.Color(128, 128, 128));
        TF_ShowAmountFiles.setEnabled(false);

        TA_FilesAvailables.setColumns(20);
        TA_FilesAvailables.setRows(5);
        TA_FilesAvailables.setEnabled(false);
        TA_FilesAvailables.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                EventShowFilesAvailablesActionPerformed(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(TA_FilesAvailables);

        jLabel2.setText("N° archivo:");

        TF_PutNumberFile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EventPutNumberFileKeyTyped(evt);
            }
        });

        BTN_TransferFiles.setText("Transferir");
        BTN_TransferFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventClickTransferFilesActionPerformed(evt);
            }
        });

        jLabel3.setText("Archivos disponibles:");

        BTN_ReadyForBack.setText("Listo");
        BTN_ReadyForBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventClickButtonReadyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TF_ShowAmountFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TF_PutNumberFile, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTN_TransferFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13))))
                            .addComponent(jLabel3))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(BTN_ReadyForBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TF_ShowAmountFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TF_PutNumberFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addComponent(BTN_TransferFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_ReadyForBack, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * EVENTO QUE MUESTRA EN EL TEXT AREA LOS ARCHIVOS EN WORSKAPCE ENUMERADOS
     * @param evt 
     */
    private void EventShowFilesAvailablesActionPerformed(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_EventShowFilesAvailablesActionPerformed
        // Se muestran los archivos disponibles en workspace
        this.TA_FilesAvailables.setText(gitController.gitFilesToTransfer(repositorio));
    }//GEN-LAST:event_EventShowFilesAvailablesActionPerformed

    /**
     * EVENTO VINCULADO AL BOTON "Transferir". TRANSFIERE EL ARCHIVO INGRESADO A INDEX
     * @param evt 
     */
    private void EventClickTransferFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventClickTransferFilesActionPerformed
        // Aqui se procede a tranferir el archivo a la zona index, la ventana
        //se vuelve a reaparecer hasta que todos los archivos sean
        //transferidos
        
        // se obtiene el numero ingresado por el usuario
        String NumberChoose1 = this.TF_PutNumberFile.getText();
        int NumberChoose2 = Integer.parseInt(this.TF_PutNumberFile.getText());
        int NumberChooseNew = NumberChoose2 - 1;

        //se realiza el try catch
        try{
            //Se setea la cantidad de archivos a transferir
            int newAmountFiles = Integer.parseInt(this.TF_ShowAmountFiles.getText());
            newAmountFiles -=1;
            /*
            String NewAmountFiles = String.valueOf(newAmountFiles);
            this.TF_ShowAmountFiles.setText(NewAmountFiles);
            */
            WindowTranferFilesCap2 WindowLoop = new WindowTranferFilesCap2(gitController.gitAddCaso2(repositorio.getZonas(), repositorio, AmountFiles, NumberChoose2),gitController,AmountFiles-1,COMANDOS);
            
            String NewAmountFiles = String.valueOf(newAmountFiles);
            this.TF_ShowAmountFiles.setText(NewAmountFiles);
            
            WindowLoop.setVisible(true);
            this.setVisible(false);
        
        }
        catch(FilesTransferedException e){
            JOptionPane.showMessageDialog(this, "Todos los archivos fueron ingresados, por favor presaione el botón 'Listo'.", "Error de datos ingresados", JOptionPane.ERROR_MESSAGE);
            this.TF_PutNumberFile.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        catch(NumberFileOutLimitException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de archivo válido.", "Error de datos ingresados", JOptionPane.ERROR_MESSAGE);
            this.TF_PutNumberFile.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        
        
        
        
        
        
    }//GEN-LAST:event_EventClickTransferFilesActionPerformed

    /**
     * EVENTO RELACIOANDO AL BOTON "Listo". RETORNA A LA VENTANA PRINCIPAL CON REPOSITORIO MODIFICADO
     * @param evt 
     */
    private void EventClickButtonReadyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventClickButtonReadyActionPerformed
        //SE PROCEDE A ACTUALIZAR EL REPOSITORIO ELIMINANDO LOS ARCHIVOS REPETIVOS DE INDEX A TRAVES
        //DE gitController
        try{
            PrincipalWindow KeepWindow5 = new PrincipalWindow(gitController.DeleteFilesRep(repositorio.getZonas(), repositorio,AmountFiles),gitController,COMANDOS);
            JOptionPane.showMessageDialog(this, "Se han tranferido los archivos correctamente", "Transferencia completada", JOptionPane.INFORMATION_MESSAGE);
            KeepWindow5.setVisible(true);
            this.setVisible(false);
        }
        catch(AmountFilesStillPositiveException e){
            JOptionPane.showMessageDialog(this, "Aún existen archivos por transferir, por favor transfiera la cantidad de archivos restantes.", "Error de acción ejecutada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EventClickButtonReadyActionPerformed

    /**
     * EVENTO RELACIONADO A LA ESCRITURA SOBRE EL TEXT FIELD PARA INGRESAR EL NUMERO DE ARCHIVO A TRANSFERIR
     * @param evt 
     */
    private void EventPutNumberFileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EventPutNumberFileKeyTyped
        this.TF_PutNumberFile.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    }//GEN-LAST:event_EventPutNumberFileKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_ReadyForBack;
    private javax.swing.JButton BTN_TransferFiles;
    private javax.swing.JTextArea TA_FilesAvailables;
    private javax.swing.JTextField TF_PutNumberFile;
    private javax.swing.JTextField TF_ShowAmountFiles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
