/*
 * FsGraphics.java
 * 
 * Created on Jul 14, 2007, 9:57:48 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.matchingchecker;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 *
 * @author TV
 */
public class FsGraphics extends Graphics{

    private int zoomX;
    private int zoomY;
    private int left;
    private int top;
    
    private Graphics g;
    
    public FsGraphics(Graphics g, int zx, int zy, int l, int t) {
        this.g = g;
        zoomX = zx;
        zoomY = zy;
        left = l;
        top = t;
    }

    public int getZoomX() {
        return zoomX;
    }

    public void setZoomX(int zoomX) {
        this.zoomX = zoomX;
    }

    public int getZoomY() {
        return zoomY;
    }

    public void setZoomY(int zoomY) {
        this.zoomY = zoomY;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    
    public Graphics create() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void translate(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Color getColor() {
        return g.getColor();
    }

    public void setColor(Color c) {
        g.setColor(c);
    }

    public void setPaintMode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setXORMode(Color c1) {
        g.setXORMode(c1);
    }

    public Font getFont() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setFont(Font font) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public FontMetrics getFontMetrics(Font f) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Rectangle getClipBounds() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clipRect(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setClip(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Shape getClip() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setClip(Shape clip) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void copyArea(int x, int y, int width, int height, int dx, int dy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        g.drawLine((left+x1)*zoomX, (top+y1)*zoomY, (left+x2)*zoomX, (top+y2)*zoomY);
    }

    public void fillRect(int x, int y, int width, int height) {
        g.fillRect((left+x)*zoomX, (top+y)*zoomY, width*zoomX, height*zoomY);
    }
    
    public void drawRect(int x, int y, int width, int height) {
        g.drawRect((left+x)*zoomX, (top+y)*zoomY, width*zoomX, height*zoomY);
    }

    public void clearRect(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        g.fillRoundRect((left+x)*zoomX, (top+y)*zoomY, width*zoomX, height*zoomY, arcWidth, arcHeight);
    }

    public void drawOval(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void fillOval(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void drawString(String str, int x, int y) {
        g.drawString(str,(left+x)*zoomX, (top+y)*zoomY);
    }

    public void drawString(AttributedCharacterIterator iterator, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
