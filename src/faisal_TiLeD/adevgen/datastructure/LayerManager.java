/*
 * LayerManager.java
 *
 * Created on Jun 18, 2007, 10:09:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.datastructure;

import faisal_TiLeD.adevgen.database.LayerDatabase;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

/**
 *
 * @author TV
 */
public class LayerManager extends Vector<Layer>{
    private Layer maskLayer;
    public LayerManager() {
        //add(new Layer(size(), "ARTFICIAL MASK", new Color(10,10,10,100)));
        loadLayers();
        maskLayer = new Layer(size(), "ARTFICIAL MASK", new Color(10,10,10,100));
        
    }
    
    public void loadLayers(){
        
        LayerDatabase ld = new LayerDatabase();
        Vector<Layer> layers = ld.getLayersList();
        this.addAll(layers);
    }
    
    public void paintAll(Graphics g, int x_grid, int y_grid, int left, int top, int width, int height){
        int i=0;

        while(i < size()){
            get(i).paint(g, x_grid, y_grid, left, top, width, height);
            i++;   
        }
        maskLayer.paint(g, x_grid, y_grid, left, top, width, height);
    }
    
    public Layer get(String name){
        int i;
        for(i=0;i<size(); i++){
            if(get(i).getLayerName().equals(name))
                return get(i);
        }
        return null;
    }
    
    public Layer getbyID(int layerID){
        int i;
        for(i=0;i<size(); i++){
            if(get(i).getLayerID()==layerID)
                return get(i);
        }
        return null;
    }

    public Layer getMaskLayer() {
        return maskLayer;
    }
}
