/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.GitController;
import Errores.RepositoryAuthorException;
import Errores.InvalidDatasException;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author CLundstedt
 */
public class MainWindow extends javax.swing.JFrame {

    //se instacia un obejto de tipo GitController
     private GitController gitController;
     private ArrayList<String> COMANDOS = new ArrayList<>();;
    /**
     * Creates new form MainWindow
     */
    public MainWindow(GitController gitController) {
        initComponents();
        this.gitController = gitController;
        //this.COMANDOS = COMANDOS;
        this.setLocationRelativeTo(null); 
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
        TF_ImputAuthorName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TF_ImputRepName = new javax.swing.JTextField();
        BTN_ApplyAuthorName = new javax.swing.JButton();
        BTN_ApplyRepName = new javax.swing.JButton();
        BTN_ApplyInit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Repositorio");

        jLabel1.setText("Ingrese la siguiente informacion para inicializar su repositorio.");

        TF_ImputAuthorName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF_ImputAuthorNameKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre del autor:");

        jLabel3.setText("Nombre del repositorio:");

        TF_ImputRepName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF_ImputRepNameKeyTyped(evt);
            }
        });

        BTN_ApplyAuthorName.setText("Aplicar");
        BTN_ApplyAuthorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventClickAuthorName(evt);
            }
        });

        BTN_ApplyRepName.setText("Aplicar");
        BTN_ApplyRepName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventClickRepoName(evt);
            }
        });

        BTN_ApplyInit.setText("Init (Crear repositorio)");
        BTN_ApplyInit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventClickInit(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TF_ImputRepName, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(TF_ImputAuthorName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BTN_ApplyRepName, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(BTN_ApplyAuthorName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTN_ApplyInit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_ImputAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(BTN_ApplyAuthorName))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TF_ImputRepName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_ApplyRepName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(BTN_ApplyInit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //se hace click en el boton de aplicar nombre de autor
    /**
     * Evento relacionado con el boton "aplicar" del campo de texto nombre del autor del repositorio, se valida la entrada.
     * @param evt 
     */
    private void EventClickAuthorName(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventClickAuthorName

        
        String Author = this.TF_ImputAuthorName.getText();
        if(Author == null || Author.isEmpty() || Author.trim().isEmpty()){
            this.TF_ImputAuthorName.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        else{
          this.TF_ImputAuthorName.setBorder(BorderFactory.createLineBorder(Color.green));
        }
    }//GEN-LAST:event_EventClickAuthorName

    
    /**
     * Evento relacionado con el boton "aplicar" del campo de texto del nombre del repositorio
     * @param evt 
     */
    private void EventClickRepoName(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventClickRepoName
        
        String NombreRepositorio = this.TF_ImputRepName.getText();
        if(NombreRepositorio == null || NombreRepositorio.isEmpty() || NombreRepositorio.trim().isEmpty()){
            this.TF_ImputRepName.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        else{ 
          this.TF_ImputRepName.setBorder(BorderFactory.createLineBorder(Color.green));
        }
    }//GEN-LAST:event_EventClickRepoName

   
    /**
     * Evento relacionado al campo de texto relacionado al nombre del autor del repositorio, se rivisa si es valida la entrada.
     * @param evt 
     */
    private void TF_ImputAuthorNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_ImputAuthorNameKeyTyped
        
        String Author = this.TF_ImputAuthorName.getText();
        if(Author != null && !Author.isEmpty() && !Author.trim().isEmpty()){
            this.TF_ImputAuthorName.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        }
    }//GEN-LAST:event_TF_ImputAuthorNameKeyTyped

   
    /**
     * Evento relacionado al campo de texto donde se ingresa el nombre del repositorio, se revisa si la entrada es valida.
     * @param evt 
     */
    private void TF_ImputRepNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_ImputRepNameKeyTyped
        
        String NombreRepositorio = this.TF_ImputRepName.getText();
        if(NombreRepositorio != null && !NombreRepositorio.isEmpty() && !NombreRepositorio.trim().isEmpty()){
            this.TF_ImputRepName.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        }
    }//GEN-LAST:event_TF_ImputRepNameKeyTyped
  
    /**
     * Evento relacionado al boton git Init, se inicializa el repositorio
     * @param evt 
     */
    private void EventClickInit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventClickInit
        
        String Author = this.TF_ImputAuthorName.getText();
        String NameRep = this.TF_ImputRepName.getText();
        if(Author != null  && !Author.trim().isEmpty() && NameRep !=null && !NameRep.trim().isEmpty() && !Author.equals(NameRep)){
            JOptionPane.showMessageDialog(this, "Repositorio listo", "Creacion de repositorio", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        try{
            
            PrincipalWindow KeepWindow = new PrincipalWindow(this.gitController.gitInit(NameRep, Author),gitController,COMANDOS);
            KeepWindow.setVisible(true);
            this.setVisible(false);
        }
        catch(RepositoryAuthorException e){
            JOptionPane.showMessageDialog(this, "El nombre del repositorio debe ser distinto al nombre del autor", "Error de datos ingresados", JOptionPane.ERROR_MESSAGE);
        }
        catch(InvalidDatasException e){
            JOptionPane.showMessageDialog(this, "Repositorio no valido", "Error de validacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EventClickInit

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow(new GitController()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_ApplyAuthorName;
    private javax.swing.JButton BTN_ApplyInit;
    private javax.swing.JButton BTN_ApplyRepName;
    private javax.swing.JTextField TF_ImputAuthorName;
    private javax.swing.JTextField TF_ImputRepName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
