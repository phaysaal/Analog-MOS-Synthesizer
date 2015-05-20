/*
 * Property.java
 * 
 * Created on May 24, 2007, 11:01:09 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.objecthiererkey;

/**
 *
 * @author Administrator
 */
public class Property {
    private short propattr;
    private byte propvalue[];       //max 126 characters
    public Property() {
    }

    public short getPropattr() {
        return propattr;
    }

    public void setPropattr(short propattr) {
        this.propattr = propattr;
    }

    public byte[] getPropvalue() {
        return propvalue;
    }

    public void setPropvalue(byte[] propvalue) {
        this.propvalue = propvalue;
    }

}
