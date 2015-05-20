/*
 * Layer.java
 *
 * Created on Jun 18, 2007, 10:04:19 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.datastructure;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

/**
 *
 * @author TV
 */
public class Layer extends Vector<Rectangle>{
    private int layerID;
    private String layerName;
    private Color color;
    
    public int getLayerID() {
        return layerID;
    }
    
    public void setLayerID(int layerID) {
        this.layerID = layerID;
    }
    
    public String getLayerName() {
        return layerName;
    }
    
    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    private boolean visible;
    
    public boolean isVisible() {
        return visible;
    }
    
    public void setVisible(boolean isVisible) {
        this.visible = visible;
    }
    
    public Layer() {
    }
    
    public Layer(int id, String name, Color col){
        layerID = id;
        layerName = name;
        color = col;
        visible = true;
    }
    
    public void paint(Graphics g, int x_grid, int y_grid, int left, int top, int width, int height){
        if(visible){
            g.setColor(color);
            int i;
            for(i=0; i<size(); i++){
                get(i).paint(g, x_grid, y_grid, left, top, width, height);
            }
        }
    }
}
