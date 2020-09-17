/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git_20056001_munozcarreno;

/**
 *
 * @author CLundstedt
 */
public class WindowHowSendFiles extends javax.swing.JFrame {

    
    private Repositorio repositorio;
    private GitController gitController;
    /**
     * Creates new form WindowHowSendFiles
     */
    /**
     * CONSTRUCTOR
     * @param repositorio
     * @param gitController 
     */
    public WindowHowSendFiles(Repositorio repositorio, GitController gitController) {
        initComponents();
        //PANTALLA CENTRADA
        this.setLocationRelativeTo(null);
        this.repositorio = repositorio;
        this.gitController = gitController;
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
        BTN_TransferAllFiles = new javax.swing.JButton();
        BTN_TranferEspFiles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transferencia de archivos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("¿De que forma desea transferir los archivos?");

        BTN_TransferAllFiles.setText("Transferir todos los archivos");
        BTN_TransferAllFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventTranferAllFilesActionPerformed(evt);
            }
        });

        BTN_TranferEspFiles.setText("Transferir archivos específicos");
        BTN_TranferEspFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventTransferEspFilesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_TransferAllFiles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_TranferEspFiles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTN_TransferAllFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTN_TranferEspFiles, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EventTranferAllFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventTranferAllFilesActionPerformed
        // SE DECIDE TRANFERIR TODOS LOS ARCHIVOS DE WORKSPACE A INDEX
        // SE MUESTRA UNA PEQUEÑA VENTANA Y SE VUELVE A LA VENTANA PRINCIPAL
        
        
        //se vuelve a la pantalla principal y se ejecuta el controlador gitAddCaso1
        PrincipalWindow KeepWindow4 = new PrincipalWindow(gitController.gitAddCaso1(repositorio.getZonas(),repositorio),gitController);
        KeepWindow4.setVisible(true);
        this.setVisible(false);
        
        
    }//GEN-LAST:event_EventTranferAllFilesActionPerformed

    private void EventTransferEspFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventTransferEspFilesActionPerformed
        // Se PROCEDE A MOSTRAR UNA NUEVA VENTANA QUE INFORMA AL USUARIO
        // LA CANTIDAD DE ARCHIVOS DISPONIBLES Y CUANTOS DESEA TRANFERIR
        
        //SE CREA LA NUEVA VENTANA
        WindowTranferFilesCap1 w1 = new WindowTranferFilesCap1(repositorio,gitController);
        w1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_EventTransferEspFilesActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_TranferEspFiles;
    private javax.swing.JButton BTN_TransferAllFiles;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
