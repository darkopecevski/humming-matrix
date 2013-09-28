/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hummingmatrix.v2.dialogs;

/**
 *
 * @author Darko
 */
public class NoMatrixEnteredAlertDialog extends javax.swing.JDialog {

    /**
     * Creates new form NoMatrixEnteredAlertDialog
     */
    public NoMatrixEnteredAlertDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jPanel1 = new javax.swing.JPanel();
        jlblAlertMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbtnCancel = new javax.swing.JButton();
        jbtnCreateMatrix = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("hummingmatrix/v2/translation/Bundle"); // NOI18N
        setTitle(bundle.getString("NoMatrixEnteredAlertDialog.title")); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        jlblAlertMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblAlertMessage.setText(bundle.getString("NoMatrixEnteredAlertDialog.jlblAlertMessage.text")); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hummingmatrix/v2/resources/alert.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jlblAlertMessage)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlblAlertMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnCancel.setText(bundle.getString("NoMatrixEnteredAlertDialog.jbtnCancel.text")); // NOI18N
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jbtnCreateMatrix.setText(bundle.getString("CreateMatrixDialog.jbtnCreate.text")); // NOI18N
        jbtnCreateMatrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateMatrixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnCreateMatrix)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCancel)
                    .addComponent(jbtnCreateMatrix))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnCancelActionPerformed

    private void jbtnCreateMatrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateMatrixActionPerformed
        this.dispose();
        WarningDialog wd = new WarningDialog(null, true, "This is just a test message long message to check if it will expand properly");
        wd.revalidate();
        wd.repaint();
        wd.setLocationRelativeTo(this);
        wd.setVisible(true);
        CreateMatrixDialog cmd = new CreateMatrixDialog(null, true);
        cmd.setLocationRelativeTo(this);
        cmd.setVisible(true);
    }//GEN-LAST:event_jbtnCreateMatrixActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NoMatrixEnteredAlertDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NoMatrixEnteredAlertDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NoMatrixEnteredAlertDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NoMatrixEnteredAlertDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                NoMatrixEnteredAlertDialog dialog = new NoMatrixEnteredAlertDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnCreateMatrix;
    private javax.swing.JLabel jlblAlertMessage;
    // End of variables declaration//GEN-END:variables
}
