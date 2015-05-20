/*
 * DrawingObject.java
 *
 * Created on March 12, 2007, 10:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.matchingchecker;

import faisal_TiLeD.adevgen.matchingchecker.*;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Administrator
 */
public class DrawingObject_1 {
    
    Color selectedBorderColor = new Color(150,0,80);
    
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;
    private String style;
    private boolean fill;
    private String name;
    private int gdsII;
    
    //private JRadioButton rdoItself;
    /** Creates a new instance of DrawingObject */
    DocumentsHolder parent;
    
    public DrawingObject_1(String name, Color color, String style) {
        this(name, color, style, false, 0);
    }
    
    public DrawingObject_1(String name, Color color, boolean fill) {
        this(name, color, "", true, 0);
    }
    
    
    public DrawingObject_1(String name, Color color, String style, boolean fill, int GDSII) {
        this.color = color;
        this.style = style;  
        this.fill = fill;
        this.name = name;
        gdsII = GDSII;       
    }
    
    public DrawingObject_1(int x, int y, int w, int h, DrawingObject type) {
        this(type.name, type.color, type.style, type.fill, type.gdsII);
        changePosition(x, y, w, h);
    }

    public int getGdsII() {
        return gdsII;
    }
    
    
    /*
    public DrawingObject(int x, int y, int w, int h, Color color, String style) {
        this(x, y, w, h, color, style, false);
    }
    
    public DrawingObject(int x, int y, int w, int h, Color color, boolean fill) {
        this(x, y, w, h, color, "", true);
    }
    
    
    public DrawingObject(int x, int y, int w, int h, Color color, String style, boolean fill) {
        this(color, style, fill);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    */
    public void changePosition(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    private Color getInvert(){
        return new Color(255-color.getRed(),255-color.getGreen(),255-color.getBlue() );
    }
    
    public void paint(Graphics g){
        paint(g, false);
    }
    
    public String getName(){
        return name;
    }
    
    public int isLocated(int x, int y){
        int mode = 0;
        if( x == this.x ){
            if(y > this.y && y < this.y+this.h)
                mode = DrawingCanvas.EDIT_LEFT;
        }
        else if( x == (this.x+this.w)){
            if(y > this.y && y < this.y+this.h)
                mode = DrawingCanvas.EDIT_RIGHT;
        }
        else if( y == this.y ){
            if(x > this.x && x < this.x+this.w)
                mode = DrawingCanvas.EDIT_UPPER;
        }
        else if( y == (this.y+this.h)){
            if(x > this.x && x < this.x+this.w)
                mode = DrawingCanvas.EDIT_LOWER;
        }
        else if( x > this.x+1 && x < this.x+this.w-1 && y > this.y+1 && y < this.y+this.h-1){
            mode = DrawingCanvas.EDIT_BODY;
        }
        
        if(mode != 0){
            DrawingCanvas.selectedObject = this;
        }
        return mode;
    }
    
    /*
     * 
     public int isLocated(int x, int y){
        int mode = 0;
        if( Math.abs(x - this.x) < 3 ){
            if(y > this.y && y < this.y+this.h)
                mode = DrawingCanvas.EDIT_LEFT;
        }
        else if( Math.abs(x - (this.x+this.w)) < 3){
            if(y > this.y && y < this.y+this.h)
                mode = DrawingCanvas.EDIT_RIGHT;
        }
        else if( Math.abs(y - this.y ) < 3){
            if(x > this.x && x < this.x+this.w)
                mode = DrawingCanvas.EDIT_UPPER;
        }
        else if( Math.abs(y - (this.y+this.h)) < 3){
            if(x > this.x && x < this.x+this.w)
                mode = DrawingCanvas.EDIT_LOWER;
        }
        else if( x > this.x+3 && x < this.x+this.w-3 && y > this.y+3 && y < this.y+this.h-3){
            mode = DrawingCanvas.EDIT_BODY;
        }
        
        if(mode != 0){
            DrawingCanvas.selectedObject = this;
        }
        return mode;
    }
     * 
     * */
    
    public void changeShape(int mode, int x, int y){
        if(mode == DrawingCanvas.EDIT_LEFT){
            this.w += (this.x - x);
            this.x = x;
        }
        else if(mode == DrawingCanvas.EDIT_RIGHT){
            this.w += (x - (this.x + this.w));
        }
        else if(mode == DrawingCanvas.EDIT_UPPER){
            this.h += (this.y - y);
            this.y = y;
        }
        else if(mode == DrawingCanvas.EDIT_LOWER){
            this.h += (y - (this.y + this.h));
        }
        else if(mode == DrawingCanvas.EDIT_BODY){
            //this.x += x;
            //this.y += y;
        }
    }
    
    public void paintSelectedBorder(Graphics g, int x, int y, int w, int h){
        
        g.setColor(Color.BLACK);
        g.fillRoundRect(x, y, w, h, 5, 5);
        //g.fillRoundRect((x+1), (y+1), (w-2), (h-2), 5, 5);
        //g.drawRoundRect((x*zx), (y*zy), (w*zx), (h*zy), 5, 5);
        //g.drawRoundRect(((x+1)*zx), ((y+1)*zy), ((w-2)*zx), ((h-2)*zy), 5, 5);
    }
    public void paintSelected(Graphics g, int mode, double zx, double zy ){
        //int zx = (int) DrawingCanvas.getZoomX();
        //int zy = (int) DrawingCanvas.getZoomY();
        
        g.setXORMode(Color.WHITE);
        
        g.setColor(selectedBorderColor);
        if(mode == DrawingCanvas.EDIT_LEFT){
            paintSelectedBorder(g, (int)(x*zx) , (int)(y*zy), (int)zx, (int)(h*zy+zy));
        }
        else if(mode == DrawingCanvas.EDIT_RIGHT){
            //paintSelectedBorder(g, x + w - 3, y - 3, (int)(6/zx), h + 6);
            paintSelectedBorder(g, (int)((x+w)*zx) , (int)(y*zy), (int)zx, (int)(h*zy+zy));
        }
        else if(mode == DrawingCanvas.EDIT_UPPER){
            //paintSelectedBorder(g, x - 3, y - 3, w + 6, (int)(6/zy));
            paintSelectedBorder(g, (int)(x*zx) , (int)(y*zy), (int)((w+1)*zx), (int)(zy));
        }
        else if(mode == DrawingCanvas.EDIT_LOWER){
            //paintSelectedBorder(g, x - 3, y + h - 3, w + 6, (int)(6/zy));
            paintSelectedBorder(g, (int)(x*zx) , (int)((y+h)*zy), (int)((w+1)*zx), (int)(zy));
        }
        else if(mode == DrawingCanvas.EDIT_BODY){
            paintSelectedBorder(g, x + 5, y + 5, w - 10, h - 10);
        }
        
    }
    public void paint(Graphics g, boolean off){
        int zx = (int) DrawingCanvas.getZoomX();
        int zy = (int) DrawingCanvas.getZoomY();
        
        if(!off)
            g.setColor(color);
        else
            g.setColor(Color.LIGHT_GRAY);
        
        if(fill){
            g.fillRect(x * zx, y* zy, (w+1) * zx, (h+1)*zy);
        }else{
            g.drawRect(x * zx, y* zy, (w+1) * zx, (h+1)*zy);
        }
        
        /*
        if(!style.equals("")){
            if(!off){
                if(fill)
                    g.setColor(getInvert());
            }else{
                g.setColor(Color.DARK_GRAY);
            }
            int horizontalSpace = g.getFontMetrics().charsWidth(style.toCharArray(), 0, style.length());
            int verticalSpace = g.getFontMetrics().getHeight();
            int i, j;
            for(i = verticalSpace; i < h; i += verticalSpace){
                for(j = 0; j < w; j += horizontalSpace){
                    g.drawString(style, x+j, y+i);
                }
            }
        }
         **/
    }
    /*
    public void addToPanel(JPanel panel, DocumentsHolder dh){
        parent = dh;
        rdoItself = new JRadioButton(name);
        rdoItself.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.selectType(this);
            }
        });
        panel.add(rdoItself); 
    }
    
    public void addToButtonGroup(ButtonGroup buttonGroup){
        buttonGroup.add(rdoItself);
    }
    */
}
