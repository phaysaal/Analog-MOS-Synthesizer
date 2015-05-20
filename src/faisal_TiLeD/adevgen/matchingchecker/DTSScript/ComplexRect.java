/*
 * ComplexRect.java
 * 
 * Created on Jul 16, 2007, 11:28:44 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.matchingchecker.DTSScript;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

/**
 *
 * @author TV
 */
public class ComplexRect {

    
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
    
    ComplexRect(){
        layer = 0;
        width = 0;
    }
    public double getWidth(){
        return bottom - top;
    }
    public double getLength(){
        return right - left;
    }
    public boolean extract(Vector<ComplexRect> vRect){
        ComplexRect cr;
        double d;
        if(width > 0){  //iterated
            if(alignment == 1){ //horizontal
                d = left;
                while(d+width < right){
                    cr = new ComplexRect();
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
                    cr = new ComplexRect();
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
        vRect.add(this);
        return false;
    }
    public void print(){
        //System.out.println(layer+"= "+left+":"+right+":"+top+":"+bottom);
    }
    
    public void paint(Graphics g, int sl, int st, int factor){
        g.setColor(color[layer]);
        g.drawRect((int)(left*factor)+sl, (int)(top*factor)+st, (int)(getLength()*factor), (int)(getWidth()*factor));
    }
    


}
