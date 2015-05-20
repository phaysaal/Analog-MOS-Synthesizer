/*
 * PosEdge.java
 * 
 * Created on Jun 23, 2007, 8:21:32 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.graph;

import faisal_TiLeD.adevgen.datastructure.MaskRectangle;

/**
 *
 * @author TV
 */
public class PosEdge {
    public static final int MIN = 0;
    public static final int FIXED = 1;
    public static final int VARIABLE = 2;
    private PosNode posNode1;
    private PosNode posNode2;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public PosEdge(PosNode posNode1, PosNode posNode2) {
        this.posNode1 = posNode1;
        this.posNode2 = posNode2;
        this.posNode1.setPosEdgeNext(this);
        this.posNode2.setPosEdgePrev(this);
        setType(MIN);
    }
    
    public void checkAndSetType(MaskRectangle mr, int axis){
        //if intersects
        if(axis == DeviceGraph.X_GRAPH){
            if(mr.getX() <= posNode1.getPosition() && mr.getX()+mr.getWidth() >= posNode2.getPosition()){
                type |= mr.getType();
            }
        }
    }
    
    

}
