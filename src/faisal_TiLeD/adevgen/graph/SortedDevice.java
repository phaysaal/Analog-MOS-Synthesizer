/*
 * SortedDevice.java
 * 
 * Created on Jun 21, 2007, 11:01:52 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.graph;

import java.util.Vector;

/**
 *
 * @author TV
 */
public class SortedDevice extends Vector<DeviceNode>{
    
    public SortedDevice() {
       
    }

    public boolean add(DeviceNode d){
        if(size() == 0){
            super.add(d);
            return true;
        }
        else {
            int i = 0;
            while(i<size() && get(i).getValue() > d.getValue()){
                insertElementAt(d, i);
                i++;
            }
            add(d);
            return true;
        }
    }

    
    public void copy(Vector<DeviceNode> vc) {
        int i;
        for(i=0; i<vc.size(); i++){
            add(vc.get(i));
        }
    }
    
    
}
