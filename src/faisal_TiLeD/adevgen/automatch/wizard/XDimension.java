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
public class XDimension {
    Index index[];
    int count;
    public XDimension(int x) {
        index = new Index[x];
    }

    public void capasityDistribute(int n ){
        int i, j;
        int number_per_dimension;
        double average_number_per_dimension = n / (double)index.length;
        double rest = 0;
        double total;
        int distributed = 0;
        for(i=0; i<index.length-1; i++){
            total = average_number_per_dimension + rest;
            number_per_dimension = (int)Math.round(total);
            (index[i] = new Index()).setCapacity(number_per_dimension);
            rest = total - number_per_dimension;
            distributed += number_per_dimension;
        }
        (index[i] = new Index()).setCapacity(n - distributed);
    }
    
    public void distribute(Point elements[]){
        int i, j=0;
        int ind = 0;
        boolean isAdded = false;
        for(i=0; i<elements.length; ){
            isAdded = index[ind].add(elements[i]);
            if(isAdded){
                elements[i].x = ind;
                i++;
            }
            ind += 2;
            if(ind >= index.length){
                if(ind % 2 == 0)
                    ind = 1;
                else
                    ind = 0;
            }
        }
    }
}
