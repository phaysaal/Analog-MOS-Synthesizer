/*
 * DrawingCanvas.java
 *
 * Created on March 12, 2007, 9:45 PM
 */

package faisal_TiLeD.adevgen.matchingchecker;

import faisal_TiLeD.adevgen.matchingchecker.*;
import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author  Mahmudul Faisal Al Ameen
 */
public class DrawingCanvas extends javax.swing.JPanel  {
    public static final int EDIT_UPPER = 1;
    public static final int EDIT_LOWER = 2;
    public static final int EDIT_LEFT = 3;
    public static final int EDIT_RIGHT = 4;
    public static final int EDIT_BODY = 5;
    
    public static final int MAX_WIDTH = 100000;
    public static final int MAX_HEIGHT = 100000;
    
    public static final double ZOOM_FACTOR = 1.25;
    public int edit_mode;
    public static DrawingObject selectedObject;
    
    private DocumentsHolder parent;
    private boolean isDragging;
    
    
    private int centerX;
    private int centerY;
    
    //private double preZoomX;
    //private double preZoomY;
    private static int zoomX;
    private static int zoomY;
    
    private int x1, x2, y1, y2;
    /** Creates new form DrawingCanvas
     * @param parent
     */
    public DrawingCanvas(DocumentsHolder parent) {
        this.parent = parent;
        isDragging = false;
        setBackground(Color.WHITE);
        initComponents();
        initView();
        parent.jscHorizontal.setMaximum(MAX_WIDTH);
        parent.jscVertical.setMaximum(MAX_HEIGHT);
    }
    
    
    public void initView(){
        zoomX = 20;
        zoomY = 20;
        //preZoomX = 1;
        //preZoomY = 1;
        centerX = 0;//MAX_WIDTH / 2;
        centerY = 0;//MAX_HEIGHT / 2;
        adjustCenter();
    }
    
    public static int getZoomX() {
        return zoomX;
    }
    
    public static int getZoomY() {
        return zoomY;
    }
    
    
    
    public void adjustCenter(){
        parent.jscHorizontal.setValue(centerX);
        parent.jscVertical.setValue(centerY);
    }
    
    public void zoomIn(int x1, int y1, int x2, int y2){
        double w = Math.abs(x2-x1);
        double h = Math.abs(y2-y1);
        
        
        if( w < 5 || h < 5)
            zoomIn(x2, y2);
        else{
            //swap if necessary
            /*
            if(x1 > x2){
                int t = x1;
                x1 = x2;
                x2 = t;
            }
            if(y1 > y2){
                int t = y1;
                y1 = y2;
                y2 = t;
            }
             */
            //double preZoomX = zoomX;
            //double preZoomY = zoomY;
            
            zoomX = (int)(getWidth() / w );
            zoomY = (int)(getHeight() / h );
            
            //zoomX = (int)(getWidth() / (w / preZoomX));
            //zoomY = (int)(getHeight() / (h / preZoomY));
            
            //double x = x1 + (w / 2);
            //double y = y1 + (h / 2);
            
            //centerX += (int)((x-centerX)-(((x-centerX)/preZoomX)*zoomX));
            //centerY += (int)((y-centerY)-(((y-centerY)/preZoomY)*zoomY));
            
            centerX = - x1 + 1;
            centerY = - y1 + 1;
            adjustCenter();
            //centerX = centerX-(int)((x1 / preZoomX)*zoomX);
            //centerY = centerY-(int)((y1 / preZoomY)*zoomY);
            
            
            //centerX -= ((x1 / preZoomX) );
            //centerY -= ((y1 / preZoomY) );
            
            //zoomY = getHeight()/h;
            //centerX = -x1;
            //centerY = -y1;
        }
        
    }
    
    public void zoomIn(int x, int y){
        double preZoomX = zoomX;
        double preZoomY = zoomY;
        
        if(zoomX < 60 || zoomY < 60){
            zoomX = (int)Math.ceil(zoomX * ZOOM_FACTOR);
            zoomY = (int)Math.ceil(zoomY * ZOOM_FACTOR);
        }
        //centerX = centerX -((((x - centerX)/preZoomX)*zoomX)-(x - centerX));
        //centerX += (int)((((x - centerX) / zoomX) - ((x - centerX) / preZoomX)) * zoomX);
        //centerY += (int)((((y - centerY) / zoomY) - ((y - centerY) / preZoomY)) * zoomY);
        //centerX += (int)((x-centerX)-(((x-centerX)/preZoomX)*zoomX));
        //centerY += (int)((y-centerY)-(((y-centerY)/preZoomY)*zoomY));
        /*
            cx' = dx / zoomX
         *      = x - mx' / zoomX
         *      = x - (ox * zoomX) / zoomX
         *      = x - ((x/preZoomX - centerX) * zoomX) / zoomX
         *      = (x / zoomX) - (x/preZoomX - centerX)
         * */
        
        centerX = (int)( (x / zoomX) - (x/ preZoomX - centerX));
        centerY = (int)( (y / zoomY) - (y/ preZoomY - centerY));
        adjustCenter();
        //System.out.println(centerX+"  "+zoomX);
    }
    
    public void zoomOut(int x, int y){
        double preZoomX = zoomX;
        double preZoomY = zoomY;
        
        if(zoomX > 1 || zoomY > 1){
            zoomX /= ZOOM_FACTOR;
            zoomY /= ZOOM_FACTOR;
        }
        //centerX += (int)((((x - centerX) / zoomX) - ((x - centerX) / preZoomX)) * zoomX);
        //centerY += (int)((((y - centerY) / zoomY) - ((y - centerY) / preZoomY)) * zoomY);
        //centerX += (int)((x-centerX)-(((x-centerX)/preZoomX)*zoomX));
        //centerY += (int)((y-centerY)-(((y-centerY)/preZoomY)*zoomY));
        //centerX = (int) ((((centerX + x) * preZoomX) - (x * zoomX))) / (zoomX);
        //centerY = (int) ((((centerY + y) * preZoomY) - (y * zoomY))) / (zoomY);
        centerX = (int)( (x / zoomX) - (x/ preZoomX - centerX));
        centerY = (int)( (y / zoomY) - (y/ preZoomY - centerY));
        adjustCenter();
        //System.out.println(centerX+"  "+zoomX);
    }
    
    public int getCenterX() {
        return centerX;
    }
    
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }
    
    public int getCenterY() {
        return centerY;
    }
    
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }
    
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuPopUp = new javax.swing.JPopupMenu();
        mnuDownRight = new javax.swing.JMenuItem();
        mnuUpLeft = new javax.swing.JMenuItem();

        mnuDownRight.setText("Move Down Right");
        mnuPopUp.add(mnuDownRight);

        mnuUpLeft.setText("Move Up Left");
        mnuPopUp.add(mnuUpLeft);

        setBackground(new java.awt.Color(255, 254, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setComponentPopupMenu(mnuPopUp);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if(parent.canvasMode == parent.MODE_EDIT){
            //edit_mode = parent.isLocated((int)((evt.getX()/zoomX)-(centerX/zoomX)), (int)((evt.getY()/zoomY)-(centerY/zoomY)));
            x1 = evt.getX();
            y1 = evt.getY();
            edit_mode = parent.isLocated((int)((x1/zoomX)-centerX), (int)((y1/zoomY)-centerY));
            
            repaint();
        }
    }//GEN-LAST:event_formMouseMoved
    
    
    
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if(parent.canvasMode == parent.MODE_DRAW){
            int w, h;
            int x, y;
            
            x2 = evt.getX();
            y2 = evt.getY();
            
            if(x1 < x2){
                x = x1;
                w = x2 - x1;
            }else{
                x = x2;
                w = x1 - x2;
            }
            
            if(y1 < y2){
                y = y1;
                h = y2 - y1;
            }else{
                y = y2;
                h = y1 - y2;
            }
            
            parent.changeCurrentObjectsPosition((int)(x/zoomX-centerX), (int)(y/zoomY-centerY), (int)(w/zoomX)+1, (int)(h/zoomY)+1);
            parent.showStatus("Dragging: x:"+x+", y:"+y+", w:"+w+", h:"+h);
            repaint();
        } else if(parent.canvasMode == parent.MODE_EDIT){
            x2 = evt.getX();
            y2 = evt.getY();
            
            if(edit_mode != 0){
                if(edit_mode != EDIT_BODY){
                    selectedObject.changeShape(edit_mode, (int)(x2/zoomX-centerX), (int)(y2/zoomY-centerY));
                    //selectedObject.changeShape(edit_mode, (int)((x2-x1)/zoomX), (int)((y2-y1)/zoomY));
                    //selectedObject.changeShape(edit_mode, (int)((x2/zoomX)-(centerX/zoomX)), (int)((y2/zoomY)-(centerY/zoomY)));
                } else{
                    selectedObject.changeShape(edit_mode, (int)((x2-x1)/zoomX-centerX), (int)((y2-y1)/zoomY-centerY));
                    //selectedObject.changeShape(edit_mode, (int)(x2/zoomX), (int)(y2/zoomY));
                    if(x1==x2+zoomX || x1+zoomX==x2)
                        x1 = x2;
                    if(y1==y2+zoomY || y1+zoomY==y2)
                        y1 = y2;
                }
                
                repaint();
            }
        } else if(parent.canvasMode == parent.MODE_ZOOM_IN){
            x2 = evt.getX();
            y2 = evt.getY();
            
            repaint();
        }
    }//GEN-LAST:event_formMouseDragged
    
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        //System.out.println(evt.getX());
        isDragging = false;
        if(parent.canvasMode == parent.MODE_DRAW){
            int w, h;
            int x, y;
            
            x2 = evt.getX();
            y2 = evt.getY();
            
            if(x1 < x2){
                x = x1;
                w = x2 - x1;
            }else{
                x = x2;
                w = x1 - x2;
            }
            
            if(y1 < y2){
                y = y1;
                h = y2 - y1;
            }else{
                y = y2;
                h = y1 - y2;
            }
            if(w ==0 || h==0) return;
            parent.addObjectToLayer((int)(x/zoomX-centerX), (int)(y/zoomY-centerY), (int)(w/zoomX)+1, (int)(h/zoomY)+1);
            repaint();
        } else if(parent.canvasMode == parent.MODE_ZOOM_IN){
            //zoomIn((int)(x1/zoomX), (int)(y1/zoomY), (int)(evt.getX()/zoomX), (int)(evt.getY()/zoomY));
            //zoomIn((int)(evt.getX()/zoomX), (int)(evt.getY()/zoomY));
            zoomIn((int)(x1/zoomX-centerX), (int)(y1/zoomY-centerY), evt.getX()/zoomX-centerX+3, evt.getY()/zoomY+centerY+3);
            parent.showStatus("Zoom Factor: "+ getZoomX() + "x" + getZoomY());
            repaint();
        } else if(parent.canvasMode == parent.MODE_ZOOM_OUT){
            //zoomOut((int)(evt.getX()/zoomX), (int)(evt.getY()/zoomY));
            zoomOut(evt.getX(), evt.getY());
            parent.showStatus("Zoom Factor: "+ getZoomX() + "x" + getZoomY());
            repaint();
        } else if(parent.canvasMode == parent.MODE_LEFT){
            centerX += 10;
            repaint();
        } else if(parent.canvasMode == parent.MODE_SELECT_POINT){
            parent.addObjects(evt.getX()/zoomX-centerX, evt.getY()/zoomY+centerY);
            repaint();
        } else if(parent.canvasMode == parent.MODE_CUT){
            parent.deleteObject(evt.getX()/zoomX-centerX, evt.getY()/zoomY+centerY);
            repaint();
        }
        
    }//GEN-LAST:event_formMouseReleased
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        isDragging = true;
        x1 = evt.getX();
        y1 = evt.getY();
        if(parent.canvasMode == parent.MODE_DRAW){
            parent.createCurrentObject((int)(x1/zoomX-centerX), (int)(y1/zoomY-centerY), 0, 0);
        } else if(parent.canvasMode == parent.MODE_EDIT){
            parent.showStatus("Mode: " + edit_mode);
        }
    }//GEN-LAST:event_formMousePressed
    
    public void paint(Graphics g){
        super.paint(g);
        FsGraphics g2d = new FsGraphics(g, zoomX, zoomY, centerX, centerY);
        //Graphics2D g2d = (Graphics2D)g;
        /*
        g2d.setColor(Color.RED);
        g2d.drawRect(100,100,100,100);
        g2d.scale(0.5, 0.5);
         
        g2d.setColor(Color.BLUE);
        g2d.drawRect(100,100,100,100);
         
        g2d.translate(50, 50);
        g2d.setColor(Color.GREEN);
        g2d.drawRect(100,100,100,100);
         */
        /////g2d.translate(centerX, centerY);
        //g2d.translate(-(centerX*preZoomX), -(centerY*preZoomY));
        /////g2d.scale(zoomX,zoomY);
        //g2d.translate(-(centerX), -(centerY));
        //g2d.translate((centerX/zoomX), (centerY/zoomY));
        
        /*
        for(int i=0; i<getWidth()/zoomX; i+=(40/zoomX)){
            g2d.drawLine(i, 0, i, 40);
            g2d.drawString(""+i, i, 40);
        }
         */
        int i,j;
        if(parent.isGridVisible){
            if(zoomX > 8 && zoomY > 8){
                g2d.setColor(new Color(50,50,250));
                for(i=0; i < this.getWidth()/zoomX; i++){
                    for(j=0; j<this.getHeight()/zoomY; j++){
                        g2d.drawLine(i-centerX, j-centerY, i-centerX, j-centerY);
                    }
                }
            }
            
            int inc = 100/zoomX;//(13-zoomX/10)<10 ?(13-zoomX/10) : 10;
            int pos = this.getHeight()/zoomY - 1;
            for(i=0; i < this.getWidth()/zoomX; i+=inc){
                g2d.drawString(""+(i-centerX), (i-centerX), -centerY+pos);
            }
            
            inc = 100/zoomY;//(13-zoomY/10)<10 ?(13-zoomY/10) : 10;
            pos = this.getWidth()/zoomX - 1;
            for(i=0; i < this.getHeight()/zoomY; i+=inc){
                g2d.drawString(""+(i-centerY), -centerX+(this.getWidth() - 50)/zoomX, (i-centerY) );
            }
        }
        
        if(DocumentsHolder.canvasMode == DocumentsHolder.MODE_DRAW || 
                DocumentsHolder.canvasMode == DocumentsHolder.MODE_CUT){
            if(isDragging){
                parent.offPaintLayers(g2d);
                
                //g.drawOval(x1,y1,x2,y2);
            } else{
                parent.paintLayers(g2d);
                parent.paintComponentNames(g2d);
            }
        } else if(parent.canvasMode == parent.MODE_EDIT){
            parent.paintLayers(g2d);
            parent.paintComponentNames(g2d);
            if(edit_mode != 0)
                selectedObject.paintSelected(g2d, edit_mode);
        } else if(parent.canvasMode == parent.MODE_ZOOM_IN){
            //System.out.println(centerX);
            //g2d.translate(centerX, centerY);
            //System.out.println(preZoomX+"  "+zoomX+"");
            parent.paintLayers(g2d);
            parent.paintComponentNames(g2d);
            if(isDragging){
                //////g2d.scale(1/zoomX,1/zoomY);
                //g2d.translate(-centerX, -centerY);
                //g2d.translate(-(centerX*preZoomX), -(centerY*preZoomY));
                
                g2d.setColor(Color.ORANGE);
                //g2d.draw3DRect((int)(x1/zoomX), (int)(y1/zoomY), (int)(x2/1), (int)(y2/1), true);
                if(x1 > x2){
                    int t = x1;
                    x1 = x2;
                    x2 = t;
                }
                if(y1 > y2){
                    int t = y1;
                    y1 = y2;
                    y2 = t;
                }
                g2d.draw3DRect(x1/zoomX, y1/zoomX, (x2-x1)/zoomX, (y2-y1)/zoomY, true);
                //g2d.draw3DRect((int)(x1/zoomX), (int)(y1/zoomY), (int)((x2-x1)/zoomX), (int)((y2-y1)/zoomY), true);
                //g2d.draw3DRect(x1, y1, (int)((x2-x1)/zoomX), (int)((y2-y1)/zoomY), true);
            }
        } else if(parent.canvasMode == parent.MODE_ZOOM_OUT){
            parent.paintLayers(g2d);
            parent.paintComponentNames(g2d);
        } else if(parent.canvasMode == parent.MODE_LEFT){
            parent.paintLayers(g2d);
            parent.paintComponentNames(g2d);
            g2d.drawLine(0,0,1,1);
        }
        //g2d.setColor(Color.RED);
        //.fillRect(0,0,1,1) ;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem mnuDownRight;
    private javax.swing.JPopupMenu mnuPopUp;
    private javax.swing.JMenuItem mnuUpLeft;
    // End of variables declaration//GEN-END:variables
    
}
