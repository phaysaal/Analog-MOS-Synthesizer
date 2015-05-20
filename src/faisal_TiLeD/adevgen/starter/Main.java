/*
 * Main.java
 * 
 * Created on May 24, 2007, 12:23:36 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.starter;

import faisal_TiLeD.adevgen.gui.GUIContainer;
/**
 *
 * @author Administrator
 */
public class Main {

    /** Creates a new instance of Main */
    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //int x[] = {3,4,5};
                //System.out.println(x.length);
                //new GUIContainer().setVisible(true);
                new NMOS_PARSE();
                // s = "hello.jocky";
                //System.out.print("hello/sdsds".contains("/"));
            }
        });
    }
    
}
