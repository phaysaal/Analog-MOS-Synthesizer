/*
 * PosGraph.java
 *
 * Created on Jun 22, 2007, 6:13:22 PM
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
public class PosGraph extends Vector<PosNode>{
    DeviceGraph dg;
    public PosGraph(DeviceGraph dg) {
        this.dg = dg;
        construct();
        //print();
    }
    
    private void construct(){
        int pos = dg.get(0).getValue();
        add(new PosNode(pos));
        get(0).add(dg.get(0));
        
        int i=1;
        while(i < dg.size()){
            
            while(i<dg.size() && pos == dg.get(i).getValue()){
                get(size()-1).add(dg.get(i));
                i++;
            }
            
            if(i<dg.size()){
                pos = dg.get(i).getValue();
                add(new PosNode(pos));
                get(size()-1).add(dg.get(i));
                i++;
            }
        }
        
        //Generate Position Edge
        for(i=0; i<size()-1; i++){
            new PosEdge(get(i), get(i+1));
        }
        
    }
    
    private void print(){
        int i, j;
        for(i=0; i<size(); i++){
            System.out.println("Pos: "+get(i).getPosition());
            for(j=0; j<get(i).size(); j++){
                System.out.print(get(i).get(j).getLayerID()+ "  ");
            }
            System.out.println();
        }
    }
}
