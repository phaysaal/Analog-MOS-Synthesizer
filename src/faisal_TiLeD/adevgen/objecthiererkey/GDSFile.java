/*
 * LayoutFile.java
 *
 * Created on May 24, 2007, 9:23:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.objecthiererkey;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class GDSFile extends RecordConstants{
    private short version = 0;
    private short bgnlib[] = new short[14];
    private String libname = "";                    //string
    private String reflibs[] = new String[15];    //string
    private String fonts[] = new String[4];            //string
    private String attrtable;        //two byte +- int
    private short generations;      //two byte +- int
    private Vector<FormatType> v_formatType = new Vector<FormatType>();
    private double sizeOfDatabaseUnitInUserUnit;
    private double sizeOfDatabaseUnitInMeter;
    private Vector<Structure> v_structure = new Vector<Structure>();
    
    private Vector<NewItemListener> v_newItemListener = new Vector<NewItemListener>();
    
    int cnt = 0;
    public short[] getBgnlib() {
        return bgnlib;
    }
    
    public void setBgnlib(short[] bgnlib) {
        this.bgnlib = bgnlib;
    }
    
    public String getLibname() {
        return libname;
    }
    
    public void setLibname(String libname) {
        this.libname = libname;
    }
    
    
    
    public Vector<FormatType> getV_FormatType() {
        return v_formatType;
    }
    
    public void setV_FormatType(Vector<FormatType> formatType) {
        this.v_formatType = formatType;
    }
    
    
    
    public Vector<Structure> getV_Structure() {
        return v_structure;
    }
    
    public void setV_Structure(Vector<Structure> structure) {
        this.v_structure = structure;
    }
    
    
    
    public short getVersion() {
        return version;
    }
    
    public void setVersion(short version) {
        this.version = version;
    }
    
    public GDSFile() {
    }
    
    public void write(File file){
        try{
            RandomAccessFile ras = new RandomAccessFile(file, "rw");
            /* HEADER(0002) : Two-byte signed integer: Contains two bytes of data representing the stream version number
             */ 
            ras.writeShort(0x0006);
            ras.writeShort(HEADER);
            ras.writeShort(0x0003);
            /*BGNLIB(0102) : Two-byte signed integer: Contains the last modification time of a library 
                    (two bytes each for year, month, day, hour, minute, and second), the time of last access (same format), 
                    and marks beginning of a library
             */ 
            ras.writeShort(0x001C);
            ras.writeShort(BGNLIB);            
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
            /*LIBNAME(0206) : ASCII String
             */
            ras.writeShort(libname.length()+4);
            ras.writeShort(LIBNAME);
            ras.write(libname.getBytes());
            //[REFLIBS] : No Reflibs
            //------------
            //[FONTS] : No Fonts
            //------------
            //[ATTRTABLE] : No Attrtable
            //------------
            //[GENERATIONS] : No Generations
            //------------
            //[<FormatType>] : No Format or Archived as Default
                //FORMAT | FORMAT {MASK}+ ENDMASKS
                //------------
            //UNITS 
            ras.writeShort(20);
            ras.writeShort(UNITS);
            ras.writeDouble(8.165836334228516E-9);
            ras.writeDouble(7.980852135579423E-33);
            //{<structure>}* 
            String localFile = file.getName().substring(0, file.getName().lastIndexOf("."));
            for(int i=0; i<v_structure.size(); i++)    {
                v_structure.get(i).write(ras, localFile);
            }
            //ENDLIB
            ras.writeShort(0x4);
            ras.writeShort(ENDLIB);
        }catch(Exception e){
            
        }
    }
    
    public void parse(File file){
        try {
            java.io.RandomAccessFile ras = new java.io.RandomAccessFile(file, "r");
            
            int data;
            int rec;
            int len;
            int head;
            int i, j;
            int __n;
            boolean isLib = true;
            //int rec[] = new int[65536];
            while(isLib && ras.getFilePointer() < ras.length()){
                data = ras.readInt();
                
                len = ((data & 0xFFFF0000) >>> 16);
                head = data & 0x0000FFFF;
                pr("Len: "+len+" Head: 0x"+Integer.toHexString(head));
                switch(head){
                case HEADER:
                    version = ras.readShort();  //Read 2 bytes
                    pr(">>header:"+Integer.toHexString(version));
                    break;
                case BGNLIB:
                    //begin library
                    for(i=0; i<12; i++){
                        bgnlib[i] = ras.readShort();
                        pr(">>Date/Time["+ i+ "]: "+bgnlib[i]);
                    }
                    break;
                case LIBNAME:
                    libname = "";
                    for(i=0; i<len-4 && ras.getFilePointer() < ras.length(); i++){
                        rec = ras.read();
                        libname += (char)rec;
                    }
                    pr(">>Libname: "+ libname);
                    break;
                case UNITS:
                    sizeOfDatabaseUnitInUserUnit = ras.readDouble();
                    sizeOfDatabaseUnitInMeter = ras.readDouble();
                    pr(">>sizeOfDatabaseUnitInUserUnit: "+ sizeOfDatabaseUnitInUserUnit);
                    pr(">>sizeOfDatabaseUnitInMeter: "+ sizeOfDatabaseUnitInMeter);
                    break;
                case ENDLIB:
                    //No data
                    //End of library
                    pr("ENDLIB");
                    isLib = false;
                    break;
                case BGNSTR:
                    pr("                                                       BGNSTR");
                    //begin library
                    for(i=0; i<12; i++){
                        
                        pr(">>Date/Time["+ i+ "]: "+ras.readShort());
                    }
                    break;
                case STRNAME:
                    libname = "";
                    for(i=0; i<len-4 && ras.getFilePointer() < ras.length(); i++){
                        rec = ras.read();
                        libname += (char)rec;
                    }
                    pr(">>StrName: "+ libname);
                    
                    break;
                case ENDSTR:
                    pr("                                                        ENDSTR");
                    break;
                case BOUNDARY: 
                    pr("BOUNDARY");
                    break;
                case PATH:
                    pr("PATH");
                    break;
                case SREF:
                    pr("SREF");
                    break;
                case AREF:
                    pr("AREF");
                    break;
                case TEXT:
                    pr("TEXT");
                    break;
                case LAYER:
                    pr(">>Layer: "+ ras.readShort());
                    break;
                case DATATYPE:
                    pr(">>DataType: "+ ras.readShort());
                    break;
                case WIDTH:
                    pr("WIDTH");
                    break;
                case XY:
                    for(i=0; i<len-4 && ras.getFilePointer() < ras.length(); i+=4){
                        pr(">>XY: "+ ras.readInt());                        
                    }
                    
                    break;
                case ENDEL:
                    pr("ENDEL");
                    break;
                case SNAME:
                    libname = "";
                    for(i=0; i<len-4 && ras.getFilePointer() < ras.length(); i++){
                        rec = ras.read();
                        libname += (char)rec;
                    }
                    pr(">>Sname: "+ libname);
                    break;
                case COLROW:
                    pr("COLROW");
                    pr(">>Cols: " + ras.readShort());
                    pr(">>Rows: " + ras.readShort());
                    break;
                case NODE:
                    pr("NODE");
                    break;
                case TEXTTYPE:
                    pr("TEXTTYPE");
                    pr("<<TextType: " + ras.readShort());
                    break;
                case PRESENTATION:
                    pr("PESENTATION");
                    pr("<<Presentation: " + ras.readShort());
                    break;
                case STRING:
                    pr("STRING");
                    attrtable = "";
                    for(j = 4; j < len; j++){
                        rec = ras.read();
                        attrtable += (char)rec;
                    }
                    pr(">>string: "+ attrtable);
                    break;
                case STRANS:
                    pr(">>Strans: "+ Integer.toHexString(ras.readShort()));
                    break;
                case MAG:
                    pr("MAG");
                    pr(">>Magnification: " + ras.readDouble());
                    break;
                case ANGLE:
                    pr("ANGLE");
                    pr(">>angle:" + ras.readDouble());
                    break;
                case REFLIBS:
                    __n = len / 44;
                    
                    for(i=0; i < __n; i++){
                        reflibs[i] = "";
                        for(j = 0; j < 44; j++){
                            rec = ras.read();
                            reflibs[i] += (char)rec;
                        }
                    }
                    pr(">>reflibs: "+ reflibs);
                    break;
                case FONTS:
                    __n = len / 44;
                    
                    for(i=0; i < __n; i++){
                        fonts[i] = "";
                        for(j = 0; j < 44; j++){
                            rec = ras.read();
                            fonts[i] += (char)rec;
                        }
                    }
                    pr(">>fonts: "+ fonts);
                    break;
                case PATHTYPE:
                    pr("PATHTYPE");
                    break;
                case GENERATIONS:
                    generations = ras.readShort();
                    pr("GENERATIONS");
                    break;
                case ATTRTABLE:
                    attrtable = "";
                    for(j = 0; j < len; j++){
                        rec = ras.read();
                        attrtable += (char)rec;
                    }
                    pr(">>attrtable: "+ attrtable);
                    break;
                case ELFLAGS:
                    break;
                case NODETYPE:
                    break;
                case PROPATTR:
                    break;
                case PROPVALUE:
                    break;
                case BOX:
                    break;
                case BOXTYPE:
                    break;
                case PLEX:
                    break;
                case TAPENUM:
                    break;
                case TAPECODE:
                    break;
                case FORMAT:
                    v_formatType.add(new FormatType(ras));
                    break;
                case MASK:
                    pr("MASK");
                    String str = "";
                    for(i=0; i<len-4 && ras.getFilePointer() < ras.length(); i++){
                        rec = ras.read();
                        str += (char) rec;
                    }
                    v_formatType.get(v_formatType.size()-1).setMask(str);
                    break;
                case ENDMASKS:
                    pr("ENDMASK");
                    break;
                default:
                    //for(i=0; i<len-4 && ras.getFilePointer() < ras.length(); i++){
                        //rec = ras.read();
                        //pr(">>"+Integer.toHexString(rec));
                    //}
                }
                
            }
            
        } catch (Exception ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
    }
    
    public void pr(String str){
        int i;
        for(i=0; i<v_newItemListener.size(); i++){
            cnt ++;
            v_newItemListener.get(i).newItem(cnt + ". " + str);
        }
    }
    
    public void addNewItemListener(NewItemListener nil){
        v_newItemListener.add(nil);
    }
    
    public void removeNewItemListener(NewItemListener nil){
        v_newItemListener.remove(nil);
    }
}
