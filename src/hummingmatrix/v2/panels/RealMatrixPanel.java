/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hummingmatrix.v2.panels;

/**
 *
 * @author Ane
 */
public class RealMatrixPanel extends javax.swing.JPanel {

    /**
     * Creates new form RealMatrixPanel
     */
    public RealMatrixPanel() {
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

        jlblRealMatrixTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jspRealMatrixScrollPane = new javax.swing.JScrollPane();
        jtblRealMatrixTable = new javax.swing.JTable();

        jlblRealMatrixTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("hummingmatrix/v2/translation/Bundle"); // NOI18N
        jlblRealMatrixTitle.setText(bundle.getString("RealMatrixPanel.jlblRealMatrixTitle.text")); // NOI18N

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