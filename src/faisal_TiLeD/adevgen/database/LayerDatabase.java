/*
 * LayerDatabase.java
 * 
 * Created on Jun 18, 2007, 9:22:24 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.database;

import faisal_TiLeD.adevgen.datastructure.Layer;
import faisal_TiLeD.adevgen.gui.GUIParameter;
import java.awt.Color;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TV
 */
public class LayerDatabase {
    //static int LAYER_TRANSPARENCY = 100;
    private Vector<Layer> hLayers;
    //private Hashtable<Integer, Color> layersColor;
    //private Hashtable<Integer, Color> layersColor;

    
    public LayerDatabase() {
        this("layers.txt");
    }
    
    public LayerDatabase(String filename) {
        String part[];
        String ln[];
        String cols[];
        String line;
        String s = System.getProperty("user.dir");
        Vector<String> vcLayers = new Vector<String>();
        //System.
        //javax.swing.JOptionPane.showMessageDialog(null, System.getProperty("java.class.path"));
        hLayers = new Vector<Layer>();
        //layersColor = new Hashtable<Integer, Color>();
        try {
            RandomAccessFile ras = new RandomAccessFile(s + "\\"+ filename, "r");
            
            while(ras.getFilePointer() < ras.length()){
                line = ras.readLine();
                vcLayers.add(line);
            }
            int i=0;
            Color color;
            Layer layer;
            while(i < vcLayers.size() ){
                line = vcLayers.get(i);
                part = line.split(";");
                ln = part[0].trim().split("=");
                cols = part[1].split(",");
                color = new Color(Integer.parseInt(cols[0].trim()),
                                    Integer.parseInt(cols[1].trim()),
                                    Integer.parseInt(cols[2].trim()),
                                    GUIParameter.LAYER_TRANSPARENCY);
                layer = new Layer(Integer.parseInt(ln[0].trim()),
                        ln[1].trim(),
                        color);
                //System.out.println(cols[0]+"  "+cols[1]);
                hLayers.add(layer);

                i++;
               
            }
        } catch (IOException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public int size(){
        return hLayers.size();
    }
    
    public Vector<Layer> getLayersList(){
        return hLayers;
    }
    
}
