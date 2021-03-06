/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hummingmatrix.v2.panels;

import hummingmatrix.v2.classes.ReadWriteText;
import hummingmatrix.v2.interfaces.MatrixChangeObserver;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darko
 */
public class DiffusionPanel extends javax.swing.JPanel implements MatrixChangeObserver {
    
    private ReadWriteText matrixObj;
    /**
     * Creates new form DiffusionPanel
     */
    public DiffusionPanel(ReadWriteText matrix) {
        initComponents();
        this.matrixObj = matrix;
        try {
            this.initResults();
        } catch (IOException ex) {
            Logger.getLogger(ProbabilityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.matrixObj.register(this);
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
        jtfDiffusion = new javax.swing.JTextField();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("hummingmatrix/v2/translation/Bundle"); // NOI18N
        jLabel1.setText(bundle.getString("label.diffusion.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jtfDiffusion))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDiffusion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(249, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jtfDiffusion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onMatrixChange(ReadWriteText matrix) {
        this.matrixObj = matrix;
        try {
            initResults();
        } catch (IOException ex) {
            Logger.getLogger(CoefficientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initResults() throws IOException {
        this.matrixObj.presmetajPremini(this.matrixObj.getMatrixContent());
        jtfDiffusion.setText(this.matrixObj.difuzija);
    }
}
