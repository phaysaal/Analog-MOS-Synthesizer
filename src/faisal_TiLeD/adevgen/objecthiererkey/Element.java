/*
 * Element.java
 * 
 * Created on May 24, 2007, 10:57:23 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.objecthiererkey;

import java.io.RandomAccessFile;

/**
 *
 * @author Administrator
 */
public abstract class Element extends RecordConstants{

    private int layer;
    
    public void setLayer(int layer){
        this.layer = layer;
    }
    
    public int getLayer(){
        return layer;
    }
    
    public Element() {
    }

    public abstract void write(RandomAccessFile ras);
        
    
}
