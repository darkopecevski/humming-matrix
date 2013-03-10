/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hummingmatrix.v2;

import hummingmatrix.v2.panels.HomeFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Darko
 */
public class HummingMatrixV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HummingMatrixV2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(HummingMatrixV2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(HummingMatrixV2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HummingMatrixV2.class.getName()).log(Level.SEVERE, null, ex);
        }
        HomeFrame hf = new HomeFrame();
        hf.setLocationRelativeTo(null);
        hf.setVisible(true);
    }
}
