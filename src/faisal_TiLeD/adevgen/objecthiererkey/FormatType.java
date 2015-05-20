/*
 * FormatType.java
 * 
 * Created on May 24, 2007, 10:32:44 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.objecthiererkey;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Administrator
 */
public class FormatType extends RecordConstants {
    private short format;
    private String masks;       //string

    public FormatType(RandomAccessFile ras) {
        try {
            format = ras.readShort();
        } catch (IOException iOException) {
        }
    }
    
    public void setMask(String str){
        masks = str;
    }

}
