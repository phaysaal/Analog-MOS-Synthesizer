/*
 * MaskRectangle.java
 * 
 * Created on Jun 22, 2007, 11:56:04 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.datastructure;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author TV
 */
public class MaskRectangle extends Rectangle{
    public static final int FIXED = 1;
    public static final int VARIABLE = 2;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public MaskRectangle() {
        super();
        type = VARIABLE;
    }
    
    public MaskRectangle(int l, int t, int w, int h) {
        super(l, t, w, h);
        type = VARIABLE;
    }
    
    public void paint(Graphics g, int x_grid, int y_grid, int left, int top, int swidth, int sheight){
        int i;
        if((x + width) >= 0 && x <= swidth && (y + height) >= 0 && y <= sheight ){
            g.setColor(new Color(10,10,10,100));
            //System.out.println("ASA");
            for(i=0; i+2 < getHeight()*y_grid; i+=4){
                
                g.fillRect((left+x)*x_grid, (top+y)*y_grid+i, (width)*x_grid, 2/*(height)*y_grid*/);
            }
        }
    }

}
