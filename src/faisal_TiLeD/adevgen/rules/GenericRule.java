/*
 * GenericRules.java
 * 
 * Created on Jun 25, 2007, 10:23:21 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.rules;

/**
 *
 * @param T 
 * @author TV
 */
public interface GenericRule<T> {
    public String check(T obj);
}
