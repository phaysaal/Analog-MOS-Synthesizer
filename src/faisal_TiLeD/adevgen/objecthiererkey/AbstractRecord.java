/*
 * AbstractRecord.java
 * 
 * Created on May 25, 2007, 12:14:03 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.objecthiererkey;

import java.io.RandomAccessFile;

/**
 *
 * @author Administrator
 */
public interface AbstractRecord {
    abstract public void read(RandomAccessFile ras, int len);
    abstract public void write(RandomAccessFile ras);
}
