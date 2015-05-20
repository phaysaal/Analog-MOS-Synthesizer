/*
 * Register.java
 * 
 * Created on Aug 13, 2007, 10:22:40 PM
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
public class Register {

    RegisterCell rc[];
    public Register(Vector<Integer> v[]) {
        //rc = new RegisterCell[v.length];
        rc = new RegisterCell[v.length];
        for(int i=0; i<v.length; i++){
            rc[i] = new RegisterCell(v[i]);
        }
        //rc = (RegisterCell[])v;
    }
    
    private boolean isSymmetric(){
        int len = rc.length-1;
        int mid = (int) ((len) / 2);
        int i, j;
        
        for(i = mid; i >= 0; i--){
            if(rc[i].size() == rc[len-i].size()){
                for(j=0; j<rc[i].size(); j++){
                    if(rc[i].get(j).intValue() != rc[len-i].get(j).intValue())
                        return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
    
    public Vector<Integer>[] distribute(){
        int len = rc.length-1;
        int mid = (int) ((rc.length-1) / 2);
        int i;
        boolean isSym = false;
        //Center to Left Right distribution
        if(rc.length % 2 == 1){
            while(rc[mid].size() > 1){
                rc[mid-1].insertElementAt(rc[mid].remove(1), 0);
                if(rc[mid].size() > 1)
                    rc[mid+1].insertElementAt(rc[mid].remove(1), 0);
            }            
        }
        
        isSym = isSymmetric();
        //Left Part Distribute
        for(i=mid; i>=1; i--){
            if(rc[i].size() == 0){
                rc[i-1].pullLeft(rc, i, i-1);
            }
            if(rc[i].size() > 1){
                rc[i-1].pushLeft(rc, i);
            }
        }
        
        if(isSym){
            for(i=mid; i>=0; i--){
                rc[len - i] = rc[i];
            }
        }else{
        //Right Part Distribute
            for(i=mid+1; i<rc.length-1; i++){
                if(rc[i].size() == 0){
                    rc[i+1].pullRight(rc, i, i+1);
                }
                if(rc[i].size() > 1){
                    rc[i+1].pushRight(rc, i);
                }
            }
        }
        
        //Special Check
        for(i=0; i<rc.length - 1; i++){
            if(rc[i].size() == 0){
                rc[i+1].pullRight(rc, i, i+1);  //Pull From Right
            }
            if(rc[i].size() > 1){
                rc[i+1].pushRight(rc, i); //Push To Right
            }
        }
        
        return rc;
    }

}
