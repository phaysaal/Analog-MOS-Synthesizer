/*
 * Dimension.java
 * 
 * Created on Jul 29, 2007, 9:28:26 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.automatch;

/**
 *
 * @author TV
 */
public class YDimension extends XDimension{
    public YDimension(int x) {
        super(x);
    }
    
    public void distribute(Element elements[]){
        int i, j=0;
        int ind = 0;
        boolean isAdded = false;
        for(i=0; i<elements.length; ){
            isAdded = index[ind].add(elements[i]);
            if(isAdded){
                elements[i].setY(ind);
                i++;
            }else{
                ind ++;
            }
        }
    }
}
