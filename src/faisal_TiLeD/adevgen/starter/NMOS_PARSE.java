/*
 * NMOS.java
 *
 * Created on Jul 6, 2007, 8:28:26 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.starter;

import java.awt.Color;
import java.awt.Graphics;
import java.io.RandomAccessFile;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author TV
 */


class ComplextRect {
    public double left,right,top,bottom;
    public int layer;
    double width;
    double space;
    int alignment;  //1=H   2=V 3=B
    
    /**
     *
     */
    public Color color[]={
        new Color(0xFF0000),
            new Color(0,255,0,100),    //1
            new Color(255,255,0),
            new Color(0xFFFF00),
            new Color(0xFFFF00),
            new Color(0xFFFF00),
            new Color(0xFFFF00),
            new Color(255,111,111),    //7
            new Color(0xFFFF00),
            new Color(155,155,155,100),    //9
            new Color(0xFFFF00),
            new Color(150,0,0),    //11
            new Color(0xFF00FF)
    };
    
    ComplextRect(){
        layer = 0;
        width = 0;
    }
    public double getWidth(){
        return bottom - top;
    }
    public double getLength(){
        return right - left;
    }
    public boolean extract(Vector<ComplextRect> vRect){
        ComplextRect cr;
        double d;
        if(width > 0){  //iterated
            if(alignment == 1){ //horizontal
                d = left;
                while(d+width < right){
                    cr = new ComplextRect();
                    cr.left = d;
                    cr.right = d + width;
                    cr.top = top;
                    cr.bottom = bottom;
                    cr.layer = layer;
                    
                    vRect.add(cr);
                    d += (width+space);
                }
                
            }else if(alignment == 2){ //vertical
                d = top;
                while(d+width < bottom){
                    cr = new ComplextRect();
                    cr.left = left;
                    cr.right = right;
                    cr.top = d;
                    cr.bottom = d + width;
                    cr.layer = layer;
                    
                    vRect.add(cr);
                    d += (width+space);
                }
            }
            //vRect.remove(this);
            return true;
        }
        return false;
    }
    public void print(){
        System.out.println(layer+"= "+left+":"+right+":"+top+":"+bottom);
    }
    
    public void paint(Graphics g, int sl, int st, int factor){
        g.setColor(color[layer]);
        g.drawRect((int)(left*factor)+sl, (int)(top*factor)+st, (int)(getLength()*factor), (int)(getWidth()*factor));
    }
    
}

public class NMOS_PARSE extends JFrame{
    double W;
    double L;
    Vector<ComplextRect> vRect;
    int factor;
    double left, right, top, bottom;
    
    Hashtable<String, Double> values;
    Hashtable<String, ComplextRect> identifiers;
    
    public NMOS_PARSE() {
        //W = Double.parseDouble(JOptionPane.showInputDialog(null));
        //L = Double.parseDouble(JOptionPane.showInputDialog(null));
        factor = 40;
        left = 0;
        right = 0;
        top = 0;
        bottom = 0;
        vRect = new Vector<ComplextRect>();
        //generateGraph();
        parseData();
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void parseData(){

        values = new Hashtable<String, Double>();
        identifiers = new Hashtable<String, ComplextRect>();
        
        loadRules(values);
        String line = "";
        String data[];
        String id_val[];
        String elem[];
        String strvar[];
        double dval;
        
        try{
            RandomAccessFile ras = new RandomAccessFile("C:\\NMOS_comp.txt", "r");
            while(ras.getFilePointer() < ras.length()){
                line    =       ras.readLine();         //  [STRING]
                if(line.equals("")) continue;
                if(line.startsWith("//")) continue;     //comments
                data    =       line.split("//");       //  [DATA //COMMENT]
                id_val  =       data[0].split("=");     //  [ID = VALUE]

                dval = evaluate(id_val[1].trim(), values);
                values.put(id_val[0].trim(), dval);
                
            }
        }catch(Exception e){
            System.out.println(line);
        }
        
        //Load Device Rect Data
        Enumeration<String> ids = values.keys();
        String key;
        String keys[];// = "ABC.R".replace(".", ":").split(":");
        double keyval;
        ComplextRect trec;
        
        //boolean b = "hello.vff".matches("*llo*");
        while(ids.hasMoreElements()){
            key = ids.nextElement();
            keyval = values.get(key);
            key = key.replace(".", ":");
            keys = key.split(":");
            
            if(keys.length == 2){
                trec = identifiers.get(keys[0]);
                
                if(trec == null){
                    trec = new ComplextRect();
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
        
        
        ComplextRect cr;
        ids = identifiers.keys();
        while(ids.hasMoreElements()){
            cr = identifiers.get(ids.nextElement());
            cr.print();
            if(!cr.extract(vRect)){
                vRect.add(cr);
            }else{
                //vRect.add(cr);
            }
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
        if(str.trim().equals("INPUT"))
            return Double.parseDouble(JOptionPane.showInputDialog(str));
        
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
   
    public void print(){
        setSize(600, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void loadRules(Hashtable<String, Double> values){
        
        values.put("POLY_WIDTH", 0.5);
        values.put("CONT_WIDTH", 0.5);
        values.put("CONT_SPACE", 0.5);
        values.put("CONT_IN_OD", 0.3);
        values.put("CONT_OUT_POLY", 0.4);
        values.put("OD_IN_NIMP", 0.4);
        values.put("POLY_OUT_OD", 0.5);
        
    }
    //*
    public void paint(Graphics g){
        int i;
        super.paint(g);
        //g.drawRect(20,30,30,40);
        /*
        Enumeration<String> ids = identifiers.keys();
        
        while(ids.hasMoreElements()){
            identifiers.get(ids.nextElement()).paint(g, 100, 100, factor);
        }
         * */
        //*
        for(i=0; i<vRect.size(); i++){
            vRect.get(i).paint(g, 100, 100, factor);
            //vRect.get(i).print();
        }
        // * */
    }
    // * */
}
