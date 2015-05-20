/*
 * DeviceGraph.java
 *
 * Created on Jun 21, 2007, 9:23:13 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.graph;

import faisal_TiLeD.adevgen.datastructure.Device;
import faisal_TiLeD.adevgen.datastructure.MaskRectangle;
import faisal_TiLeD.adevgen.datastructure.Rectangle;

import faisal_TiLeD.adevgen.rules.RuleCollection;
import java.util.Vector;


/**
 *
 * @author TV
 */
public class DeviceGraph extends Vector<DeviceNode>{
    public static final int X_GRAPH = 1;
    public static final int Y_GRAPH = 2;
    //public static final int Z_GRAPH = 3;
    private Device device;
    private DeviceNode starter;
    private int type;
    
    PosGraph pg;
    public DeviceGraph( ) {
        
    }
    
    public DeviceGraph(Device device, int type) {
        this.device = device;
        this.type = type;
        collectNodes();
        
        constructGraph();
        printall(this);
    }
    
    private void collectNodes(){
        int i;
        if(type == X_GRAPH){
            for(i=0; i<device.size(); i++){
                if(!(device.get(i) instanceof MaskRectangle)){
                    add(new DeviceNode(device.get(i), DeviceNode.LEFT_BORDER));
                    add(new DeviceNode(device.get(i), DeviceNode.RIGHT_BORDER));
                }
            }
        }else{
            for(i=0; i<device.size(); i++){
               if(!(device.get(i) instanceof MaskRectangle)){
                    add(new DeviceNode(device.get(i), DeviceNode.TOP_BORDER));
                    add(new DeviceNode(device.get(i), DeviceNode.BOTTOM_BORDER));
                }
            }
        }
    }
    
    public boolean add(DeviceNode d){
        if(size() == 0){
            super.add(d);
            return true;
        } else {
            int i = 0;
            while(i<size() && get(i).getValue() < d.getValue()){
                i++;
            }
            insertElementAt(d, i);
            return true;
        }
    }
    
    public void constructGraph(){
        //First Stage
        //Generate Position Graph
        pg = new PosGraph(this);
        int i, j;
        //Generate all edges
        for(i=0; i<pg.size()-1; i++){
            for(j=i+1; j<pg.size(); j++){
                generateEdges(pg.get(i), pg.get(j));
            }
        }
        
        //Appling contraints to position graph
        j = 0;
        for(i=0; i<device.size(); i++){
            if(device.get(i) instanceof MaskRectangle){
                for(j=0; j<pg.size()-1; j++){
                    //System.out.println(j + "" + (pg.get(j)==null));
                    pg.get(j).getPosEdgeNext().checkAndSetType((MaskRectangle)device.get(i), type);
                }
            }
        }
        
        //Appling expression to the graph
        for(i=0; i<pg.size()-1; i++){
            for(j=0; j<pg.get(i).size(); j++){
                pg.get(i).get(j).adopt(pg.get(i).getPosEdgeNext());
            }
        }
    }
    
    public void generateEdges(PosNode p1, PosNode p2){
        int i, j;
        //inter position
        for(i=0; i<p1.size(); i++){
            for(j=0; j<p2.size(); j++){
                addEdge(p1.get(i), p2.get(j));
            }
        }
        //at the same position
        //no support is given now
    }
    
    public void addEdge(DeviceNode d1, DeviceNode d2){
        int ruleType = RuleCollection.getRc().getType(d1, d2);
        if(ruleType > 0 && isYDimensionalOverlap(d1.getRec(), d2.getRec()) && (!d1.isIndirectlyConnected(d2))) {
            new ConsEdge(d1, d2);
        }
    }
    
    private boolean isYDimensionalOverlap(Rectangle r1, Rectangle r2){
        
        int dis =(int)( (r1.getY()+r1.getHeight()>r2.getY()+r2.getHeight()?r1.getY()+r1.getHeight(): r2.getY()+r2.getHeight()) 
                - (r1.getY()<r2.getY()?r1.getY():r2.getY()));
        if(dis <= r1.getHeight()+r2.getHeight())
            return true;
        else
            return false;
    }
    
    public void printall(Vector<DeviceNode> vc){
        int i, j;
        for(i=0; i<vc.size(); i++){
            System.out.println("Node: "+vc.get(i).getValue());
            for(j=0; j<vc.get(i).size(); j++){
                if(vc.get(i).get(j).getNode1() == vc.get(i)){
                    System.out.println("        Edge: "+vc.get(i).get(j).getExp());
                }
            }
            
        }
    }
    
}
