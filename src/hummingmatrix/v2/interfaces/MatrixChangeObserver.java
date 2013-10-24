/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hummingmatrix.v2.interfaces;

import hummingmatrix.v2.classes.ReadWriteText;

/**
 *
 * @author Darko
 */
public interface MatrixChangeObserver {
    public void onMatrixChange(ReadWriteText matrix);
}
