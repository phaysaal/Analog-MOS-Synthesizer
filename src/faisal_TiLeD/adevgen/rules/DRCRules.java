/*
 * DRCRules.java
 *
 * Created on Jun 25, 2007, 11:07:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.rules;

import faisal_TiLeD.adevgen.graph.DeviceGraph;
import java.util.Vector;

/**
 *
 * @author TV
 */
public class DRCRules extends Vector<GenericRule> {
    
    public DRCRules() {
        construct();
    }
    
    public void construct(){
        add(new GenericRule<DeviceGraph>() {
            //Min Width
            public String check(DeviceGraph obj) {
                return "";
            }
        });
    }
    
    public boolean check(){
        return true;
    }
}
