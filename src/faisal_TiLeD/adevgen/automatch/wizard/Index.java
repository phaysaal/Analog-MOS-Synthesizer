/*
 * Index.java
 * 
 * Created on Jul 29, 2007, 9:25:40 AM
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
public class Index {
    private int capacity;
    private int count;
    private Point elements[];
    public Index() {
        count = 0;
        capacity = 0;
    }

    public void setCapacity(int x){
        capacity = x;
        elements = new Point[x];
    }
    
    public boolean add(Point element){
        if(count < capacity){
            elements[count] = element;
            count++;
            return true;
        }
        return false;
    }
}
