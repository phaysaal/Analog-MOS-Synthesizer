/*
 * PosNode.java
 *
 * Created on Jun 22, 2007, 6:11:50 PM
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
public class PosNode extends Vector<DeviceNode>{
    private int position;
    private PosEdge posEdgeNext = null;
    private PosEdge posEdgePrev = null;
    
    public PosEdge getPosEdgePrev() {
        return posEdgePrev;
    }
    
    public void setPosEdgePrev(PosEdge posEdgePrev) {
        this.posEdgePrev = posEdgePrev;
    }
    public PosEdge getPosEdgeNext() {
        return posEdgeNext;
    }
    
    public void setPosEdgeNext(PosEdge posEdgeNext) {
        this.posEdgeNext = posEdgeNext;
    }
    
    
    
    public int getPosition() {
        return position;
    }
    public PosNode(int position) {
        this.position = position;
    }
    
}
