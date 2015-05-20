/*
 * Expression.java
 * 
 * Created on Jun 21, 2007, 9:38:15 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.rules;

/**
 *
 * @author TV
 */
public class Expression{
    
    private String exp;
    private int value;

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getExp() {
        return exp;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public Expression(String exp) {
        this.exp = exp;
        value = Integer.parseInt(exp);
    }
    public Expression(int val) {
        this.exp = val+"";
        value = val;
    }
    public int getValue(){
        return value;
    }
}
