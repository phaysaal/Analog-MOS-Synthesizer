/*
 * Dimension.java
 * 
 * Created on Jul 29, 2007, 9:28:26 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.automatch.wizard;

import faisal_TiLeD.adevgen.automatch.*;
import java.awt.Point;

/**
 *
 * @author TV
 */
public class YDimension extends XDimension{
    public YDimension(int x) {
        super(x);
    }
    
    public void distribute(Point elements[]){
        int i, j=0;
        int ind = 0;
        boolean isAdded = false;
        for(i=0; i<elements.length; ){
            isAdded = index[ind].add(elements[i]);
            if(isAdded){
                elements[i].y = ind;
                i++;
            }else{
                ind ++;
            }
        }
    }
}
