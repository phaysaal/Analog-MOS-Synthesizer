/*
 * ConsEdge.java
 *
 * Created on Jun 21, 2007, 9:26:02 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.graph;

import faisal_TiLeD.adevgen.rules.Rule;
import faisal_TiLeD.adevgen.rules.RuleCollection;

/**
 *
 * @author TV
 */
public class ConsEdge {
    private DeviceNode node1;
    private DeviceNode node2;
    private Rule rule;
    private int distance;
    private String exp = "";
    
    private static RuleCollection ruleCollection = new RuleCollection();
    public DeviceNode getNode1() {
        return node1;
    }
    
    public DeviceNode getNode2() {
        return node2;
    }
    
    public Rule getRule() {
        return rule;
    }
    
    public int getDistance() {
        return distance;
    }
    
    public ConsEdge(DeviceNode node1, DeviceNode node2) {
        this.node1 = node1;
        this.node2 = node2;
        distance = node2.getValue() - node1.getValue();
        /////Probable bad coding
        rule = ruleCollection.getRule(node1, node2);
        System.out.print(rule+"-");
        node1.add(this);
        node2.add(this);
    }
    
    public void setExp(PosEdge pe){
        if(rule == null){
            exp = "";
            return;
        }
        
        
        if((pe.getType() & pe.VARIABLE) == pe.VARIABLE)
            //VARIABLE
            if((pe.getType() ^ pe.VARIABLE) == pe.MIN){
                //MIN
                exp = rule.getExp().getValue() + "X";
            }else{
                //FIXED
                exp = distance + "X";
            }
           
        else{
            if(pe.getType() == pe.MIN){
                //MIN
                //System.out.println(rule);
                exp = rule.getExp().getValue() + "";
            }else{
                //FIXED
                exp = distance + "";
            }
        }
    }

    public String getExp() {
        return exp;
    }
    
}
