/*
 * Boundary.java
 * 
 * Created on May 24, 2007, 10:58:54 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.objecthiererkey;


import faisal_TiLeD.adevgen.matchingchecker.DrawingObject;
import java.awt.Point;
import java.io.RandomAccessFile;

/**
 *
 * @author Administrator
 */
public class Boundary extends Element{
    private int datatype;
    private Coordinates coordinates;
    
    public void setDataType(int datatype){
        this.datatype = datatype;
    }
    
    public int getDataType(){
        return datatype;
    }
    
    public Boundary() {
        coordinates = new Coordinates();
    }
    
    public Coordinates getCoordinates(){
        return coordinates;
    }
    
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }
    
    public void write(RandomAccessFile ras) {
        try{
            ras.writeShort(0x4);
            ras.writeShort(BOUNDARY);
            ras.writeShort(0x6);
            ras.writeShort(LAYER);
            ras.writeShort(getLayer());
            ras.writeShort(0x6);
            ras.writeShort(DATATYPE);
            ras.writeShort(getDataType());
            
            coordinates.write(ras);
            //{<property>}* 
                    //PROPATTR

                    //PROPVALUE
            ras.writeShort(0x4);        
            ras.writeShort(ENDEL);
        }catch(Exception e){
            
        }
    }
    
    public static Boundary decode(DrawingObject rect){
        /*
         *      0/4         1
         * 
         *       3          2
         * 
         * */
        Boundary boundary = new Boundary();
        Point pnt[] = new Point[5];
        pnt[0] = new Point();
        pnt[1] = new Point();
        pnt[2] = new Point();
        pnt[3] = new Point();
        pnt[4] = new Point();
        
        pnt[4].x = pnt[3].x = pnt[0].x = (int) Math.round(rect.x);
        pnt[1].x = pnt[2].x = (int)Math.round(pnt[0].x + rect.w );
        
        pnt[4].y = pnt[1].y = pnt[0].y = (int) Math.round(rect.y);
        pnt[3].y = pnt[2].y = (int) Math.round(pnt[0].y + rect.h);
        
        boundary.coordinates.setXy(pnt);
        boundary.setLayer(rect.getGdsII());
        return boundary;
    }

}
