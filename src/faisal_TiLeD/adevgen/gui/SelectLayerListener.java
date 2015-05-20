/*
 * ArrayActionListener.java
 * 
 * Created on Jun 19, 2007, 7:55:41 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author TV
 */
public class SelectLayerListener implements ActionListener{
    int index;
    FunctionCallListener fp;
    public SelectLayerListener(int index,FunctionCallListener fp){
        this.index = index;
        this.fp = fp;
    }
    public void actionPerformed(ActionEvent e) {
        fp.selectLayer(e, index);
    }
    
}
