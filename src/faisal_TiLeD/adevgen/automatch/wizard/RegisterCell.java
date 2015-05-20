/*
 * RegisterCell.java
 * 
 * Created on Aug 13, 2007, 10:22:55 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.automatch.wizard;

import java.util.Vector;

/**
 *
 * @author TV
 */
public class RegisterCell extends Vector<Integer>{
    //int index;
    public RegisterCell(Vector<Integer> v) {
        //this.index = index;
        addAll(v);
    }

    public int getLeft(RegisterCell rc[], int x, int index){
        
        for(int i=0; i < size(); i++){
            if(get(i) == x) {
                if(index > 0)
                    return (1+ rc[index-1].getLeft(rc, x, index-1));
                else
                    return 1;
            }
        } 
        return 0;
    }
    public int getRight(RegisterCell rc[], int x, int index){
        for(int i=0; i < size(); i++){
            if(get(i) == x) {
                if(index < rc.length - 1)
                    return (1+ rc[index+1].getRight(rc, x, index+1));
                else
                    return 1;
            }
        } 
        return 0;
    }
    
    public void pushLeft(RegisterCell rc[], int index){
        int i, t = rc[index].size();
        int l, r;
        Integer s;
        for(i=1; i < t; i++){
            l = rc[index-1].getLeft(rc, rc[index].get(i), index-1);
            r = rc[index+1].getRight(rc, rc[index].get(i), index+1);
            if(l+r >0 && l >= r){
                s = rc[index].remove(i);
                rc[index].insertElementAt(s, 0);
            }
        } 
        
        for(i=1; i < t; i++){
            insertElementAt(rc[index].remove(1), 0);
        }        
    }
    
    
    public void pullLeft(RegisterCell rc[], int index, int prev){
        if(size() == 0 && prev > 0){
            rc[prev-1].pullLeft(rc, index, prev-1);
        }else if(size() > 0){
            rc[index].insertElementAt(remove(0), 0);
        }
    }
         
    public void pushRight(RegisterCell rc[], int index){
        int i, t = rc[index].size();
        int l, r;
        Integer s;
        for(i=1; i < t; i++){
            l = rc[index-1].getLeft(rc, rc[index].get(i), index-1);
            r = rc[index+1].getRight(rc, rc[index].get(i), index+1);
            if(l <= r){
                s = rc[index].remove(i);
                rc[index].insertElementAt(s, 0);
            }
        } 
        
        for(i=1; i < t; i++){
            insertElementAt(rc[index].remove(1), 0);
        }        
    }
    
    
    public void pullRight(RegisterCell rc[], int index, int next){
        if(size() == 0 && next < rc.length-1){
            rc[next+1].pullRight(rc, index, next+1);
        }else if(size() > 0){
            rc[index].insertElementAt(remove(0), 0);
        }
    }
}
