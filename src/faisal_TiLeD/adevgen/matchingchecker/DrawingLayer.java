/*
 * DrawingLayer.java
 *
 * Created on March 12, 2007, 8:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.matchingchecker;

import faisal_TiLeD.adevgen.matchingchecker.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Administrator
 */
public class DrawingLayer implements ActionListener{
    String name;
    JLabel lblCaption;
    JRadioButton rdoChooseToDraw;
    JCheckBox chkVisibility;
    DrawingObject type;
    
    Vector<DrawingObject> vcObjects;
    
    DocumentsHolder parent;
    /** Creates a new instance of DrawingLayer 
     * @param name 
     * @param parent 
     * @param type 
     * 
     */
    public DrawingLayer(String name, DocumentsHolder parent, DrawingObject type) {
        this.name = name;
        this.parent = parent;
        this.type = type;
        vcObjects = new Vector<DrawingObject>();
        rdoChooseToDraw = new JRadioButton();
        rdoChooseToDraw.addActionListener(this);
        chkVisibility = new JCheckBox();
        chkVisibility.addActionListener(this);
        lblCaption = new JLabel(name);
    }

    public DrawingObject getType() {
        return type;
    }
    
    
    public void addToPanel(JPanel panel){
        lblCaption.setOpaque(true);
        lblCaption.setBackground(type.getColor());
        rdoChooseToDraw.setBackground(lblCaption.getBackground());
        chkVisibility.setBackground(lblCaption.getBackground());
        
        panel.add(lblCaption);
        panel.add(rdoChooseToDraw);
        panel.add(chkVisibility); 
        rdoChooseToDraw.setSelected(true);
        chkVisibility.setSelected(true);
        parent.setCurrentLayer(this);
    }
    
    public void addToButtonGroup(ButtonGroup buttonGroup){
        buttonGroup.add(rdoChooseToDraw);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rdoChooseToDraw){
            parent.setCurrentLayer(this);
            
            //parent.selectType(name);
            chkVisibility.setSelected(true);
            if(!parent.tglDrawRect.isSelected())
                parent.tglDrawRect.doClick();
        }
        else if(e.getSource() == chkVisibility){
            parent.refresh();
        }   
    }
    
    public void addObject(int x, int y, int w, int h){
        DrawingObject dobj = new DrawingObject(x, y, w, h, type);
        vcObjects.addElement(dobj);
        parent.showStatus("Object Added: x:"+x+", y:"+y+", w:"+w+", h:"+h);
        parent.currentComponent.element.add(dobj);
        parent.refresh();
    }
    
    public void addObject(DrawingObject d){
        vcObjects.addElement(d);
    }
    
    public void deleteAll(){
        DrawingObject dobj;
        for(int i=0; i<vcObjects.size(); i++){
            dobj = ((DrawingObject)vcObjects.get(i));
            dobj = null;
        }
        vcObjects.clear();
    }
    
    public boolean delete(DrawingObject dobj){
        return vcObjects.remove(dobj);
        //dobj = null;
    }

    public DrawingObject delete(int x, int y){
        DrawingObject dobj;
        if(!chkVisibility.isSelected())
            return null;
        for(int i=vcObjects.size() - 1; i >= 0; i--){
            dobj = (DrawingObject)vcObjects.get(i);
            if(dobj.isIn(x, y)){
                delete(dobj);
                return dobj;
            }        
        }
        return null;
    }
    
    public String getName() {
        return name;
    }
            
    public void paint(Graphics g){
    	if(chkVisibility.isSelected()){
            for(int i=0; i<vcObjects.size(); i++){
                ((DrawingObject)vcObjects.get(i)).paint(g);
            }
        }
    }
    
    public void offPaint(Graphics g){
    	if(chkVisibility.isSelected()){
            for(int i=0; i<vcObjects.size(); i++){
                ((DrawingObject)vcObjects.get(i)).paint(g, true);
            }
        }
    }
    
    public int isLocated(int x, int y){
        int mode;
        if(!chkVisibility.isSelected())
            return 0;
        for(int i=vcObjects.size() - 1; i >= 0; i--){
            mode = (((DrawingObject)vcObjects.get(i)).isLocated(x, y));
            if(mode != 0)
                return mode;
        }
        return 0;
    }
}
