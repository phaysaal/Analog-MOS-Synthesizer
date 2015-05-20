/*
 * Coordinates.java
 * 
 * Created on May 24, 2007, 11:27:29 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.objecthiererkey;

import faisal_TiLeD.adevgen.matchingchecker.DocumentsHolder;
import java.awt.Point;
import java.io.RandomAccessFile;

/**
 *
 * @author Administrator
 */
public class Coordinates extends RecordConstants{
    private Point xy[];
    public Coordinates() {
    }
    public Point[] getXy() {
        return xy;
    }

    public void setXy(Point[] xy) {
        this.xy = xy;
    }
    
    public void write(RandomAccessFile ras) {
        try{
            ras.writeShort(4+(xy.length*8));
            ras.writeShort(XY);
            for(int i=0; i<xy.length; i++){
                ras.writeInt(xy[i].x * 1000 / DocumentsHolder.lambda);
                ras.writeInt(xy[i].y * 1000 / DocumentsHolder.lambda);
            }
            
            
        }catch(Exception e){
            
        }
    }
}
