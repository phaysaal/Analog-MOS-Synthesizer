/*
 * Main.java
 *
 * Created on March 12, 2007, 7:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.matchingchecker;

import faisal_TiLeD.adevgen.matchingchecker.*;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class Main{
    
    /** Creates a new instance of Main */
    public Main() {
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DocumentsHolder app = new DocumentsHolder();
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //System.out.print("hello/sdsds".contains("//"));
            }
        });
    }
    
}
