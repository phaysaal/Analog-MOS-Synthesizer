/*
 * DeviceNode.java
 *
 * Created on Jun 21, 2007, 9:20:45 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.graph;

import faisal_TiLeD.adevgen.datastructure.Rectangle;
import java.util.Vector;

/**
 *
 * @author TV
 */
public class DeviceNode extends Vector<ConsEdge>{
    public static final int LEFT_BORDER = 1;
    public static final int RIGHT_BORDER = 2;
    public static final int TOP_BORDER = 3;
    public static final int BOTTOM_BORDER = 4;
    private Rectangle rec;
    private int type;
    public Rectangle getRec() {
        return rec;
    }
    
    public int getType() {
        return type;
    }
    
    public int getLayerID(){
        return rec.getLayer().getLayerID();
    }
    /*
     * Type:
     *  False:=Left/Top
     *  True:=Right/Down
     */
    
    public DeviceNode(Rectangle rec, int type) {
        this.rec = rec;
        this.type = type;
    }
    
    public int getValue(){
        /*
         * if left then else right
         * */
        if(type==LEFT_BORDER){
            return (int) rec.getX();
        }else if(type==RIGHT_BORDER){
            return (int) (rec.getX()+rec.getWidth());
        }else if(type==TOP_BORDER){
            return (int) rec.getY();
        }else{
            return (int) (rec.getY()+rec.getHeight());
        }
    }
    
    public boolean isIndirectlyConnected(DeviceNode dn){
        int i;
        for(i=0; i<size(); i++){
            if(get(i).getNode1().getRec() == dn.getRec())
                return true;
        }
        return false;
    }
    
    public void adopt(PosEdge pe){
        int i;
        for(i=0; i<size(); i++){
            if(get(i).getNode1() == this){
                get(i).setExp(pe);
            }
            
        }
    }
    
}
