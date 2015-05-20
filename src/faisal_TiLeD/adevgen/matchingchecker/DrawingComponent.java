/*
 * DrawingComponent.java
 * 
 * Created on Aug 9, 2007, 11:45:22 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.matchingchecker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

/**
 *
 * @author TV
 */
public class DrawingComponent {
    static int count = 0;
    String name;
    public Vector<DrawingObject> element;
    
    public double left;
    public double top;
    public double length;
    public double width;
    
    public DrawingComponent() {
        this("Component_"+count);
    }
    public DrawingComponent(String name) {
        element = new Vector<DrawingObject>();
        setName(name);
        count++;
        left = 0;
        top = 0;
        
        
    }
    
    public DrawingComponent clone(String name){
        DrawingComponent dc = new DrawingComponent(name);
        DrawingObject d;
        for(int i=0; i<element.size(); i++){
            d = element.get(i).clone();
            dc.element.add(d);
        }
        dc.left = left;
        dc.top = top;
        dc.length = length;
        dc.width = width;
        return dc;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void destroy(){
        DrawingObject d;
        for(int i=0; i<element.size(); i++){
            d = element.remove(0);
            d = null;
        }
        //element.removeAllElements();
        
    }
    
    public boolean delete(DrawingObject dobj){
        return element.remove(dobj);
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public void move(double x, double y){
        int i;
        for(i=0; i<element.size(); i++){
            element.get(i).x += x;
            element.get(i).y += y;
        }
        left += x;
        top += y;
    }
    
    public double getHorizontalMiddle(){        
        return left + (length / 2);
    }
    
    public double getVerticalMiddle(){        
        return top + (width / 2);
    }
    
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawString(name, (int)getHorizontalMiddle(), (int)getVerticalMiddle());
    }
}
