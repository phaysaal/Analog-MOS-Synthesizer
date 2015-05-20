/*
 * AbstractRecord.java
 * 
 * Created on May 24, 2007, 9:28:54 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.objecthiererkey;



/**
 *
 * @author Administrator
 */
public abstract class AbstractElement extends Coordinates implements AbstractRecord{

    private short elflags;
    private int plex;
    private short layer;
    private short datatype;
    

    public short getElflags() {
        return elflags;
    }

    public void setElflags(short elflags) {
        this.elflags = elflags;
    }

    public int getPlex() {
        return plex;
    }

    public void setPlex(int plex) {
        this.plex = plex;
    }

    public short getLayer() {
        return layer;
    }

    public void setLayer(short layer) {
        this.layer = layer;
    }

    public short getDatatype() {
        return datatype;
    }

    public void setDatatype(short datatype) {
        this.datatype = datatype;
    }

    
    
    public AbstractElement() {
    }
    

        
}
