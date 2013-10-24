/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hummingmatrix.v2.interfaces;

/**
 *
 * @author Darko
 */
public interface MatrixChangeSubject {
    //methods to register and unregister observers
    public void register(MatrixChangeObserver obj);
    public void unregister(MatrixChangeObserver obj);
    //method to notify observers of change
    public void notifyObservers();
}
