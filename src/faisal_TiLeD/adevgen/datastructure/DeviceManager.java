/*
 * DeviceManager.java
 * 
 * Created on Jun 18, 2007, 10:10:14 PM
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
public class DeviceManager extends Vector<Device>{
    private static Device currentDevice;

    public static Device getCurrentDevice() {
        return currentDevice;
    }
    
    public DeviceManager() {
        currentDevice = new Device();
    }
    
    public Device saveAndNew(){
        add(currentDevice);
        currentDevice = new Device();
        return currentDevice;
    }

}
