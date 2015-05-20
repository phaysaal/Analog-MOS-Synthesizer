/*
 * Structure.java
 * 
 * Created on May 24, 2007, 10:33:01 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.objecthiererkey;

import faisal_TiLeD.adevgen.matchingchecker.DocumentsHolder;
import java.io.RandomAccessFile;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class Structure extends RecordConstants{
    private short bgnstr[] = new short[14];
    private String structurename;       //upto 32 character
    private Vector<Element> v_element = new Vector<Element>();
    private double x, y;
    
    //********************************************
    /////Create constructor with nested parsing
    //********************************************
    public short[] getBgnstr() {
        return bgnstr;
    }

    public void setBgnstr(short[] bgnstr) {
        this.bgnstr = bgnstr;
    }

    public String getStructurename() {
        return structurename;
    }

    public void setStructurename(String structurename) {
        this.structurename = structurename;
    }

    public Vector<Element> getV_element() {
        return v_element;
    }

    public void setV_element(Vector<Element> v_element) {
        this.v_element = v_element;
    }

    public void setXy(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    
    public Structure() {
    }
    
    public void write(RandomAccessFile ras, String filename){
        try{    
            //BGNSTR
            ras.writeShort(0x001C);
            ras.writeShort(BGNSTR);            
            ras.writeShort(2007);//Year(last modifield)
            ras.writeShort(8);//month
            ras.writeShort(2);//day
            ras.writeShort(1);//hour
            ras.writeShort(1);//minutes
            ras.writeShort(1);//second
            ras.writeShort(2007);//year(last access)
            ras.writeShort(8);//month
            ras.writeShort(2);//day
            ras.writeShort(1);//hour
            ras.writeShort(1);//minute
            ras.writeShort(1);//second 
            //STRNAME
////            ras.writeShort(4+structurename.length());
////            ras.writeShort(STRNAME);
////            ras.write(structurename.getBytes());
            ras.writeShort(4+filename.length());
            ras.writeShort(STRNAME);
            ras.write(filename.getBytes());
            //[STRCLASS]
            //Not used
            //{<element>}*
                //{<boundary>|<path>}<sref>|<aref>|<text>|<node>|<box>}
            //text
//                185. Len: 4 Head: 0xc00
//                186. TEXT
            ras.writeShort(4);
            ras.writeShort(TEXT);
//                187. Len: 6 Head: 0xd02
//                188. >>Layer: 0
            ras.writeShort(6);
            ras.writeShort(LAYER);
            ras.writeShort(2);            
//                189. Len: 6 Head: 0x1602
//                190. TEXTTYPE
//                191. <<TextType: 0            
            ras.writeShort(6);
            ras.writeShort(TEXTTYPE);
            ras.writeShort(0);     
//                192. Len: 6 Head: 0x1701
//                193. PESENTATION
//                194. <<Presentation: 5
            ras.writeShort(6);
            ras.writeShort(PRESENTATION);
            ras.writeShort(5);   //0, middle, center
//                195. Len: 6 Head: 0x1a01
//                196. >>Strans: 0
            ras.writeShort(6);
            ras.writeShort(STRANS);
            ras.writeShort(0);
//                197. Len: 12 Head: 0x1b05
//                198. MAG
//                199. >>Magnification: 524288.0
            ras.writeShort(12);
            ras.writeShort(MAG);
            ras.writeDouble(524288.0);
//                200. Len: 12 Head: 0x1c05
//                201. ANGLE
//                202. >>angle:1.18747255799808E15
            ras.writeShort(12);
            ras.writeShort(ANGLE);
            ras.writeDouble(1.18747255799808E15);
//                203. Len: 12 Head: 0x1003
//                204. >>XY: 1700
//                205. >>XY: 5250
            ras.writeShort(12);
            ras.writeShort(XY);
            ras.writeInt((int)(x * 1000 / DocumentsHolder.lambda)); //*****************************************|  *1000 / lambda
            ras.writeInt((int)(y * 1000 / DocumentsHolder.lambda));    //***************************************| *1000 / lambda
//                206. Len: 14 Head: 0x1906
//                207. STRING
//                208. >>string: NMOS_10_1
            ras.writeShort(4+structurename.length());
            ras.writeShort(STRING);
            ras.write(structurename.getBytes());
//                209. Len: 4 Head: 0x1100
//                210. ENDEL
            ras.writeShort(4);
            ras.writeShort(ENDEL);
            
//          Other Elements            
                for(int i=0; i<v_element.size(); i++){
                    v_element.get(i).write(ras);
                }
            //ENDSTR
            ras.writeShort(0x4);
            ras.writeShort(ENDSTR);
        }catch(Exception e){
            
        }
    }

}
