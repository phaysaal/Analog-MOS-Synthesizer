/*
 * DrawingStatus.java
 * 
 * Created on Jun 18, 2007, 10:38:55 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.gui;

/**
 *
 * @author TV
 */
public interface DrawingStatusListener {
    public void drawStarted(int x, int y);
    public void drawFinished(int x, int y);
    public void drawCanceled();
}
