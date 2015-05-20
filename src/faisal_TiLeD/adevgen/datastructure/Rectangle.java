/*
 * Rectangle.java
 *
 * Created on Jun 18, 2007, 10:05:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.datastructure;

import java.awt.Graphics;

/**
 *
 * @author TV
 */
public class Rectangle extends java.awt.Rectangle{
    
    private Layer layer;
    
    public Layer getLayer() {
        return layer;
    }
    
    public void setLayer(Layer layer) {
        this.layer = layer;
    }
    
    
    
    public Device getDevice() {
        return device;
    }
    
    public void setDevice(Device device) {
        this.device = device;
    }
    private Device device;
    
    public Rectangle() {
        
    }
    
    public Rectangle(int l, int t, int w, int h) {
        super(l, t, w, h);
    }
    
    public void paint(Graphics g, int x_grid, int y_grid, int left, int top, int swidth, int sheight){
        if((x + width) >= 0 && x <= swidth && (y + height) >= 0 && y <= sheight ){
            g.fillRect((left+x)*x_grid, (top+y)*y_grid, (width)*x_grid, (height)*y_grid);
        }
    }
    
    public boolean touches(Rectangle r){
        boolean tch ;
        tch = (r.getX()+r.getWidth() >= getX()) && (r.getX() <= getX()+getWidth());
        
        tch = tch && (r.getY()+r.getHeight() >= getY()) && (r.getY() <= getY()+getHeight());
        return false;
    }
}
