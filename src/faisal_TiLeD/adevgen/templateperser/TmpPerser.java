/*
 * TmpPerser.java
 * 
 * Created on Jul 4, 2007, 11:57:54 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.templateperser;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TV
 */
public class TmpPerser {

    public TmpPerser() {
        try {
            RandomAccessFile ras = new RandomAccessFile("as", "");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
    }

}
