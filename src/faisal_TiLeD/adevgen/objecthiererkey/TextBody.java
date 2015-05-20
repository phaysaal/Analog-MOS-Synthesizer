/*
 * TextBody.java
 * 
 * Created on May 24, 2007, 11:00:43 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.objecthiererkey;

import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class TextBody extends Coordinates{
    
    private short texttype;
    private short presentation = 0;
            private short pathtype;
            private int width = 0;

    public short getTexttype() {
        return texttype;
    }

    public void setTexttype(short texttype) {
        this.texttype = texttype;
    }

    public short getPresentation() {
        return presentation;
    }

    public void setPresentation(short presentation) {
        this.presentation = presentation;
    }

    public short getPathtype() {
        return pathtype;
    }

    public void setPathtype(short pathtype) {
        this.pathtype = pathtype;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Vector<STrans> getV_strans() {
        return v_strans;
    }

    public void setV_strans(Vector<STrans> v_strans) {
        this.v_strans = v_strans;
    }
            private String string;  //max 512
            private Vector<STrans> v_strans = new Vector<STrans>();
            
    public TextBody() {
    }

}
