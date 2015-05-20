/*
 * RuleCollection.java
 * 
 * Created on Jun 21, 2007, 9:50:10 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.rules;

import faisal_TiLeD.adevgen.datastructure.DataManager;
import faisal_TiLeD.adevgen.datastructure.LayerManager;
import faisal_TiLeD.adevgen.graph.DeviceNode;
import java.util.Vector;

/**
 *
 * @author TV
 */
public class RuleCollection extends Vector<Rule>{
    //private static RuleCollection rc;

    public static RuleCollection getRc() {
        return new RuleCollection();
    }
    public RuleCollection() {
        loadRules();
    }
    
    public void loadRules(){
        LayerManager lm = DataManager.getLm();
        add(new Rule(lm.get(1-1), lm.get(1-1), Rule.WIDTH, 6));
        add(new Rule(lm.get(1-1), lm.get(1-1), Rule.INTER, 9));
        add(new Rule(lm.get(1-1), lm.get(1-1), Rule.CONNECT, 7));
        add(new Rule(lm.get(7-1), lm.get(7-1), Rule.WIDTH, 6));
        add(new Rule(lm.get(7-1), lm.get(7-1), Rule.INTER, 9));
        add(new Rule(lm.get(7-1), lm.get(7-1), Rule.CONNECT, 7));
        add(new Rule(lm.get(9-1), lm.get(9-1), Rule.WIDTH, 6));
        add(new Rule(lm.get(9-1), lm.get(9-1), Rule.INTER, 9));
        add(new Rule(lm.get(9-1), lm.get(9-1), Rule.CONNECT, 7));
        add(new Rule(lm.get(1-1), lm.get(7-1), Rule.BORDER, 6));
        add(new Rule(lm.get(1-1), lm.get(9-1), Rule.BORDER, 9));
        add(new Rule(lm.get(7-1), lm.get(9-1), Rule.BORDER, 7));
    }
    
    public int getValue(int l1, int l2, int type){
        int i;
        for(i=0; i<size(); i++){
            if(get(i).isEquals(l1, l2, type))
                return get(i).getExp().getValue();
        }
        return -1;
    }
    public Rule getRule(int l1, int l2, int type){
        int i;
        for(i=0; i<size(); i++){
            if(get(i).isEquals(l1, l2, type))
                return get(i);
        }
        return null;
    }
    public Rule getRule(DeviceNode d1, DeviceNode d2){
        int i;
        int l1 =        d1.getLayerID();
        int l2 =        d2.getLayerID();
        int ruleType = Rule.getType(d1, d2);
        for(i=0; i<size(); i++){
            if(get(i).isEquals(l1, l2, ruleType))
                return get(i);
        }
        return null;
    }
    public int getType(DeviceNode d1, DeviceNode d2){
        return Rule.getType(d1, d2);
    }
}
