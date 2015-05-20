/*
 * bnAutoSim.java
 *
 * Created on April 4, 2007, 9:09 PM
 */

package faisal_TiLeD.adevgen.matchingchecker;

import java.awt.Graphics;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 * @author Administrator
 */
public class bnAutoSim extends JPanel implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    public bnAutoSim() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
    public void paint(Graphics g){
        g.drawRect(40,40,40,40);
    }
}


