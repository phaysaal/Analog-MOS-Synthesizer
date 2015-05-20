/*
 * Device.java
 * 
 * Created on Jun 18, 2007, 10:05:22 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.datastructure;

import java.util.Vector;

/**
 *
 * @author TV
 */
public class Device extends Vector<Rectangle>{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Device() {
    }

}
