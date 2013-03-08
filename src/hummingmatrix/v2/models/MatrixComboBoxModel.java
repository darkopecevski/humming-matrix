/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hummingmatrix.v2.models;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Darko
 */
public class MatrixComboBoxModel extends AbstractListModel implements ComboBoxModel {

    String[] matrixNames = {"Monitor", "Key Board", "Mouse", "Joy Stick", "Modem", "CD ROM",
        "RAM Chip", "Diskette"};
    String selection = null;

    @Override
    public Object getElementAt(int index) {
        return matrixNames[index];
    }

    @Override
    public int getSize() {
        return matrixNames.length;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem; // to select and register an
    } // item from the pull-down list

    // Methods implemented from the interface ComboBoxModel
    @Override
    public Object getSelectedItem() {
        return selection; // to add the selection to the combo box
    }
}
