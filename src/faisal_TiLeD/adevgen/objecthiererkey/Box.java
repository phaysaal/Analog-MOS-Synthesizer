/*
 * Box.java
 * 
 * Created on May 24, 2007, 11:00:19 PM
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
public class Box extends AbstractElement{
    private short boxtype;

    public short getBoxtype() {
        return boxtype;
    }

    public void setBoxtype(short boxtype) {
        this.boxtype = boxtype;
    }
    public Box() {
    }

    public void read(RandomAccessFile ras, int len) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void write(RandomAccessFile ras) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
