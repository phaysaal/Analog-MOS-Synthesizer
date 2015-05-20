/*
 * Rule.java
 * 
 * Created on Jun 21, 2007, 9:46:10 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.rules;

import faisal_TiLeD.adevgen.datastructure.Layer;
import faisal_TiLeD.adevgen.graph.DeviceNode;

/**
 *
 * @author TV
 */
public class Rule {
    public static final int WIDTH = 1;
    public static final int INTER = 2;
    public static final int CONNECT = 3;
    public static final int BORDER = 4;
    
    private Layer leftLayer;
    private Layer rightLayer;
    private int ruleType;
    private Expression exp;
    
    public Layer getLeftLayer() {
        return leftLayer;
    }

    public Layer getRightLayer() {
        return rightLayer;
    }

    public Expression getExp() {
        return exp;
    }
    
    public Rule(Layer l1, Layer l2, int ruleType, String str) {
        leftLayer = l1;
        rightLayer = l2;
        this.ruleType = ruleType;
        exp = new Expression(str);
    }
    public Rule(Layer l1, Layer l2, int ruleType, int str) {
        leftLayer = l1;
        rightLayer = l2;
        this.ruleType = ruleType;
        exp = new Expression(str);
    }
    public boolean isEquals(int l1, int l2, int type){
        boolean is;
        is = leftLayer.getLayerID() == l1;
        is = is && rightLayer.getLayerID() == l2;
        is = is && type==ruleType;
        if(is){
            return true;
        }else{
            is = rightLayer.getLayerID() == l1;
            is = is && leftLayer.getLayerID() == l2;
            is = is && type==ruleType;
            return is;
        }
    }
    public static int getType(DeviceNode d1, DeviceNode d2){
        //Same rectangle
        if(d1.getRec() == d2.getRec()){
            return WIDTH;
        }
        //Different rectangle
        //Different Layer
        if(d1.getLayerID() != d2.getLayerID()){
            //if(d1.getType()==DeviceNode.LEFT_BORDER && d2.getType()==DeviceNode.LEFT_BORDER)
            return BORDER;
            //else if(d1.getType()==DeviceNode.LEFT_BORDER && d2.getType()==DeviceNode.LEFT_BORDER)
                
        }
        //Same Layer
        //Connected
        if(d1.getValue() == d2.getValue()){
            if(d1.getRec().touches(d2.getRec()))
                return CONNECT;
            else{
                
                return INTER;
                
            }
        }
        //Not Connected
        return INTER;
    }
        
}
