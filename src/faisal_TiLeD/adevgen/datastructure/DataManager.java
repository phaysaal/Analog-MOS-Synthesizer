/*
 * DataManager.java
 * 
 * Created on Jun 18, 2007, 10:11:10 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.datastructure;

/**
 *
 * @author TV
 */
public class DataManager {
    private static LayerManager lm = new LayerManager();
    private static DeviceManager dm = new DeviceManager();

    public static LayerManager getLm() {
        return lm;
    }

    public static DeviceManager getDm() {
        return dm;
    }
    
    public DataManager() {
    }
    
    public static void addRectangle(Rectangle rec, Layer layer, Device device){
        rec.setLayer(layer);
        rec.setDevice(device);
        layer.add(rec);
        device.add(rec);
        
        //System.out.println(layer.size()+"  "+device.size());
    }

}
