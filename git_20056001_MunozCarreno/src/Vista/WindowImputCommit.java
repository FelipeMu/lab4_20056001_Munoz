/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.GitController;
import Errores.InvalidCommitException;
import Modelo.Repositorio;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author CLundstedt
 */
public class WindowImputCommit extends javax.swing.JFrame {

    private Repositorio repositorio;
    private GitController gitController;
    private ArrayList<String> COMANDOS;
    /**
     * Creates new form WindowImputCommit
     */
    public WindowImputCommit(Repositorio repositorio, GitController gitController,ArrayList<String> COMANDOS) {
        initComponents();
        //PANTALLA CENTRADA
        this.setLocationRelativeTo(null);
        this.repositorio = repositorio;
        this.gitController = gitController;
        this.COMANDOS = COMANDOS;
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
        TF_AuthorCommit = new javax.swing.JTextField();
        TF_MessageCommit = new javax.swing.JTextField();
        BTN_SaveAuthorCommit = new javax.swing.JButton();
        BTN_SaveMessageCommit = new javax.swing.JButton();
        BTN_CreateCommit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Creacion de commit");

        jLabel1.setText("Rellene los recuadros para crear el commit.");

        jLabel2.setText("Nombre de autor:");

        jLabel3.setText("Mensaje descriptivo:");

        TF_AuthorCommit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EventAuthorCommitKeyTyped(evt);
            }
        });

        TF_MessageCommit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EventMessageCommitKeyTyped(evt);
            }
        });

        BTN_SaveAuthorCommit.setText("Guardar");
        BTN_SaveAuthorCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventClickBTNSaveAuthorCommitActionPerformed(evt);
            }
        });

        BTN_SaveMessageCommit.setText("Guardar");
        BTN_SaveMessageCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventClickBTNSavMessgeCommitActionPerformed(evt);
            }
        });

        BTN_CreateCommit.setText("Crear commit");
        BTN_CreateCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventClickBTNCreateCommitActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TF_MessageCommit, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(42, 42, 42)
                                .addComponent(TF_AuthorCommit, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BTN_SaveAuthorCommit, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(BTN_SaveMessageCommit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(BTN_CreateCommit, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TF_AuthorCommit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_SaveAuthorCommit))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TF_MessageCommit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_SaveMessageCommit))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(BTN_CreateCommit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * EVENTO VINCULADO A LA ESCRITURA SOBRE EL TEXT FIELD PARA INGRESAR EL AUTOR DE COMMIT.  VERIRIFICA LA ENTRADA
     * @param evt 
     */
    private void EventAuthorCommitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EventAuthorCommitKeyTyped
        String Author = this.TF_AuthorCommit.getText();
        if(Author != null && !Author.isEmpty() && !Author.trim().isEmpty()){
            this.TF_AuthorCommit.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        }
    }//GEN-LAST:event_EventAuthorCommitKeyTyped

    /**
     * EVENTO VINCULADO A LA ESCRITURA SOBRE EL TEXT FIELD PARA INGRESAR EL CONTENIDO DEL COMMIT.  VERIRIFICA LA ENTRADA
     * @param evt 
     */
    private void EventMessageCommitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EventMessageCommitKeyTyped
        String Author = this.TF_MessageCommit.getText();
        if(Author != null && !Author.isEmpty() && !Author.trim().isEmpty()){
            this.TF_MessageCommit.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        }
    }//GEN-LAST:event_EventMessageCommitKeyTyped

    /**
     * EVENTO VINCULADO AL BOTON "Guardar" PARA EL NOMBRE DEL AUTOR DEL COMMIT, VERIFICA LA ENTRADA Y CAMBIA EL COLOR DEL BORDE DEL TEXTFIELD
     * @param evt 
     */
    private void EventClickBTNSaveAuthorCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventClickBTNSaveAuthorCommitActionPerformed
        // se verifica la entrada del nombre de autor
        String Author = this.TF_AuthorCommit.getText();
        if(Author == null || Author.isEmpty() || Author.trim().isEmpty()){
            this.TF_AuthorCommit.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        else{
          this.TF_AuthorCommit.setBorder(BorderFactory.createLineBorder(Color.green));
        }
    }//GEN-LAST:event_EventClickBTNSaveAuthorCommitActionPerformed

    /**
     * EVENTO VINCULADO AL BOTON "Guardar" PARA EL CONTENIDO DEL COMMIT, VERIFICA LA ENTRADA Y CAMBIA EL COLOR DEL BORDE DEL TEXTFIELD
     * @param evt 
     */
    private void EventClickBTNSavMessgeCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventClickBTNSavMessgeCommitActionPerformed
        // Tse verifica la entrada del mesaje descriptivo:
        String Author = this.TF_MessageCommit.getText();
        if(Author == null || Author.isEmpty() || Author.trim().isEmpty()){
            this.TF_MessageCommit.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        else{
          this.TF_MessageCommit.setBorder(BorderFactory.createLineBorder(Color.green));
        }
        
    }//GEN-LAST:event_EventClickBTNSavMessgeCommitActionPerformed

    /**
     * EVENTO VINCULADO AL BOTON "Crear commit", VERIFICA SI LOS DATOS INGRESADOS SON VALIDOS PARA CREAR EL COMMIT Y AGREGARLO A LOCAL
     * @param evt 
     */
    private void EventClickBTNCreateCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventClickBTNCreateCommitActionPerformed
        // se procede a actualizar el repositorio, exactamente local repository
        String Author = this.TF_AuthorCommit.getText();
        String Message = this.TF_MessageCommit.getText();
        
        try{
            PrincipalWindow KeepWindow6 = new PrincipalWindow(gitController.gitCommit(repositorio.getZonas(),repositorio,Author,Message),gitController,COMANDOS);
            JOptionPane.showMessageDialog(this, "Se ha realizado correctamente el commit.", "Commit creado", JOptionPane.INFORMATION_MESSAGE);
            KeepWindow6.setVisible(true);
            this.setVisible(false);
        }
        catch(InvalidCommitException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingresa datos validos.", "Error de datos ingresados", JOptionPane.ERROR_MESSAGE);
        
        }
    }//GEN-LAST:event_EventClickBTNCreateCommitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CreateCommit;
    private javax.swing.JButton BTN_SaveAuthorCommit;
    private javax.swing.JButton BTN_SaveMessageCommit;
    private javax.swing.JTextField TF_AuthorCommit;
    private javax.swing.JTextField TF_MessageCommit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
