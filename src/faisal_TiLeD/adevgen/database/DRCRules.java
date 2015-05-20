/*
 * DRCRules.java
 *
 * Created on Jun 14, 2007, 11:02:45 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.database;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DRCRules {
    
    Hashtable<String, Double> drcRules;
    /**
     *
     * @param filename
     */
    public DRCRules(String filename) {
        String s = System.getProperty("user.dir");
        String ln[];
        try {
            RandomAccessFile ras = new RandomAccessFile(s + "\\"+ filename, "r");
            drcRules = new Hashtable<String, Double>();
            while(ras.getFilePointer() < ras.length()){
                ln = ras.readLine().split(":");
                drcRules.put(ln[0], Double.parseDouble(ln[1].split(" ")[0]));
            }
        } catch (IOException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
    }
    
    public double ruleValue(String rule){
        return drcRules.get(rule);
    }
    
    public Enumeration<String> getRules(){
        return drcRules.keys();
    }
}
