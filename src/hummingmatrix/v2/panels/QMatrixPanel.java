/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hummingmatrix.v2.panels;

import hummingmatrix.v2.classes.ReadWriteText;
import hummingmatrix.v2.classes.RowNumberTable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Ane
 */
public class QMatrixPanel extends javax.swing.JPanel {

    private ReadWriteText matrixObj;

    /**
     * Creates new form RealMatrixPanel
     */
    public QMatrixPanel(ReadWriteText matrix) {
        initComponents();
        this.matrixObj = matrix;
        initRealMatrix();
    }

    private void initRealMatrix() {
        try {
            int rowNum = this.matrixObj.getNumberOfRows();
            int colNum = this.matrixObj.getNumberOfColumns();
            String[] columnTitles = new String[colNum];
            for (int i = 0; i < colNum; i++) {
                int coltit = i + 1;
                columnTitles[i] = Integer.toString(coltit);

            }
            
            Object[][] matrix = this.matrixObj.getMatrixContent();
            Object[][] qMatrix = this.matrixObj.presmetajQMatrica();
            
            float[] t = this.matrixObj.calculateProbability(matrix);
            HashMap hm = this.matrixObj.verojatnostNaOdredenaSlicnost(qMatrix, t);
            String vos = this.matrixObj.convertVerojatnostNOS(hm);
            this.matrixObj.presmetajPremini(matrix);
            this.matrixObj.verojatnostNaSosednaDistanca();

            jtblRealMatrixTable.setModel(new javax.swing.table.DefaultTableModel(qMatrix, columnTitles));
            jtblRealMatrixTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            jspRealMatrixScrollPane.setViewportView(jtblRealMatrixTable);
            JTable rowTable = new RowNumberTable(jtblRealMatrixTable, 40);
            jspRealMatrixScrollPane.setRowHeaderView(rowTable);
            jspRealMatrixScrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, rowTable.getTableHeader());


        } catch (IOException ex) {
            Logger.getLogger(QMatrixPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblRealMatrixTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jspRealMatrixScrollPane = new javax.swing.JScrollPane();
        jtblRealMatrixTable = new javax.swing.JTable();

        jlblRealMatrixTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("hummingmatrix/v2/translation/Bundle"); // NOI18N
        jlblRealMatrixTitle.setText(bundle.getString("QMatrixPanel.jlblRealMatrixTitle.text")); // NOI18N

        jtblRealMatrixTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblRealMatrixTable.setCellSelectionEnabled(true);
        jtblRealMatrixTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtblRealMatrixTable.setFillsViewportHeight(true);
        jspRealMatrixScrollPane.setViewportView(jtblRealMatrixTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblRealMatrixTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jspRealMatrixScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblRealMatrixTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspRealMatrixScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlblRealMatrixTitle;
    private javax.swing.JScrollPane jspRealMatrixScrollPane;
    private javax.swing.JTable jtblRealMatrixTable;
    // End of variables declaration//GEN-END:variables
}
