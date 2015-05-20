/*
 * DTSParser.java
 * 
 * Created on Jul 16, 2007, 11:04:58 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.matchingchecker.DTSScript;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author TV
 */
public class DTSParser {
    
    public Hashtable<String, Double> values;
    Hashtable<String, ComplexRect> identifiers;
    
    Vector<ComplexRect> vRect;
    
    public boolean isRulesOnly;
    
    public DTSParser() {
        isRulesOnly = false;
    }
    
    public Vector<ComplexRect> getParsed(String params[]){
        values = new Hashtable<String, Double>();
        identifiers = new Hashtable<String, ComplexRect>();
        vRect = new Vector<ComplexRect>();
        parse(params);
        return vRect;
    }

    public void parse(String params[]){
        
        
        //loadRules(values);
        String line = "";
        String data[];
        String id_val[];
        String elem[];
        String strvar[];
        double dval;
        int count = 1;
        
        try{
            File file = new File(params[0]);
            RandomAccessFile ras = new RandomAccessFile(file, "r");
            while(ras.getFilePointer() < ras.length()){
                line    =       ras.readLine();         //  [STRING]
                if(line.equals("")) continue;
                if(line.startsWith("//")) continue;     //comments
                data    =       line.split("//");       //  [DATA //COMMENT]
                id_val  =       data[0].split("=");     //  [ID = VALUE]

                if(id_val[1].trim().charAt(0) == '"'){
                    elem = id_val[1].split(",");
                    
                    if(elem[0].contains("/")){
                        elem[0] = elem[0].trim().substring(1, elem[0].trim().length()-1);
                        
                    }else{
                        elem[0] = file.getParent()+file.separator+elem[0].trim().substring(1, elem[0].trim().length()-1);
                        //parse(elem);
                    }
                    parse(elem);
                }else{
                    if(id_val[1].trim().equals("INPUT")){  
                        if(count < params.length){
                            dval = Double.parseDouble(params[count]);    
                            count++;
                        }else{
                            dval = Double.parseDouble(JOptionPane.showInputDialog("Please enter value for the parameter: "+id_val[0]));    
                        }                                     
                    }else{
                        if(isRulesOnly){
                            if(id_val[0].trim().contains("."))
                                continue;
                        }
                        dval = evaluate(id_val[1].trim(), values);
                        
                    }
                    
                    values.put(id_val[0].trim(), dval);
                }
            }
            
            ras.close();
        }catch(Exception e){
            System.out.println(e);  
        }
        
        //Load Device Rect Data
        Enumeration<String> ids = values.keys();
        String key;
        String keys[];// = "ABC.R".replace(".", ":").split(":");
        double keyval;
        ComplexRect trec;
        
        
        //boolean b = "hello.vff".matches("*llo*");
        while(ids.hasMoreElements()){
            key = ids.nextElement();
            keyval = values.get(key);
            key = key.replace(".", ":");
            keys = key.split(":");
            
            if(keys.length == 2){
                trec = identifiers.get(keys[0]);
                
                if(trec == null){
                    trec = new ComplexRect();
                    identifiers.put(keys[0], trec);
                }
                
                if(keys[1].equals("L"))
                    trec.left = keyval;
                else if(keys[1].equals("R"))
                    trec.right = keyval;
                else if(keys[1].equals("T"))
                    trec.top = keyval;
                else if(keys[1].equals("B"))
                    trec.bottom = keyval;
                else if(keys[1].equals("N"))
                    trec.layer = (int) keyval;
                else if(keys[1].equals("W")){
                    trec.width =  keyval;
                }
                else if(keys[1].equals("S")){
                    trec.space =  keyval;
                }
                else if(keys[1].equals("A")){
                    trec.alignment = (int) keyval;                    
                }  
            }
        }
        
        
        ComplexRect cr;
        ids = identifiers.keys();
        while(ids.hasMoreElements()){
            cr = identifiers.get(ids.nextElement());
            cr.print();
            
            cr.extract(vRect);
            
        }
        
    }
    
   
    
    public double getValue(String str, Hashtable<String, Double> values){
        
        try{
            return Double.parseDouble(str.trim());
        }catch(Exception e){
            return values.get(str.trim());
        }
    }
    
    public double evaluate(String str, Hashtable<String, Double> values){
        
        //Vector<String> sv = new Vector<String>();
        int i = 0, j = 0;
        String tmp;
        double value = 0;
        String op;
        while(i < str.length()){
            if(str.charAt(i) == '+' || str.charAt(i) == '-'){
                //At the first case
                if(j == 0){
                    tmp = str.substring(j, i);
                    value = getValue(tmp, values);
                    j = i;
                }else{
                    op = str.substring(j, j+1);
                    tmp = str.substring(j+1, i);
                    if(op.equals("+")){
                        value += getValue(tmp, values);
                    }else if(op.equals("-")){
                        value -= getValue(tmp, values);
                    }
                    j = i;
                }
            }
            i++;
        }
        if(j == 0){
            tmp = str.substring(j, i);
            value = getValue(tmp, values);
            j = i;
        }else{
            op = str.substring(j, j+1);
            tmp = str.substring(j+1, i);
            if(op.equals("+")){
                value += getValue(tmp, values);
            }else if(op.equals("-")){
                value -= getValue(tmp, values);
            }
            j = i;
        }
        
        
        return value;
        
    }
}
