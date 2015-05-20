/*
 * STrans.java
 * 
 * Created on May 24, 2007, 11:00:58 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.objecthiererkey;

/**
 *
 * @author Administrator
 */
public class STrans {
    private short strans;
    private double mag = 1.0;
    private double angle = 0.0;

    public short getStrans() {
        return strans;
    }

    public void setStrans(short strans) {
        this.strans = strans;
    }

    public double getMag() {
        return mag;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    public STrans() {
    }

}
