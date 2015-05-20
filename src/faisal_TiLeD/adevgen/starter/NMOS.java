/*
 * NMOS.java
 * 
 * Created on Jul 6, 2007, 8:28:26 AM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.starter;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author TV
 */

public class NMOS extends JFrame{

    class Rect{
        public double left,right,top,bottom;
        public int layer;
        
        /**
         * 
         */
        public Color color[]={
            new Color(0xFF0000),
            new Color(0,255,0,100),    //1
            new Color(255,255,0),
            new Color(0xFFFF00),
            new Color(0xFFFF00),
            new Color(0xFFFF00),
            new Color(0xFFFF00),
            new Color(255,111,111),    //7
            new Color(0xFFFF00),
            new Color(155,155,155,100),    //9
            new Color(0xFFFF00),
            new Color(150,0,0),    //11
            new Color(0xFF00FF)
        };
        
        Rect(int l){
            layer = l;
        }
        public double getWidth(){
            return bottom - top;
        }
        public double getLength(){
            return right - left;
        }
        public void print(){
            System.out.println(layer+"= "+left+":"+right+":"+top+":"+bottom);
        }
        public void paint(Graphics g, int sl, int st, int factor){
            g.setColor(color[layer]);
            g.fillRect((int)(left*factor)+sl, (int)(top*factor)+st, (int)(getLength()*factor), (int)(getWidth()*factor));
        }
       
    }
    
    double W;
    double L;
    Vector<Rect> vRect;
    int factor;
    double left, right, top, bottom;
    
    public NMOS() {
        W = Double.parseDouble(JOptionPane.showInputDialog(null));
        L = Double.parseDouble(JOptionPane.showInputDialog(null));
        factor = 40;
        left = 0;
        right = 0;
        top = 0;
        bottom = 0;
        vRect = new Vector<Rect>();
        generateGraph();
                
    }

    public void generateGraph(){
        //Create Poly
        Rect poly = new Rect(7);
        Rect od = new Rect(1);
        Rect nimp = new Rect(9);
        Rect contL[];;
        Rect contR[];
        int i;

        //X axis
        //Poly x_length = L
        //-----------------------------(+L:INTEGER)     x
        //-----------------------------(+W:INTEGER)     x
        //-----------------------------(L:INPUT)
        //-----------------------------(W:INPUT)
        //-----------------------------(+POLYa:POLY 1)  x
        //-----------------------------(POLYa.L:0) 
        poly.left = 0;
        //-----------------------------(POLYa.R:POLYa.L+L)
        poly.right = getRule("POLY WIDTH") >= L ? getRule("POLY WIDTH") : L;
        
        //OD y_width = W
        //-----------------------------(+ODa:OD)        x
        //-----------------------------(ODa.T:0)
        od.top = 0;
        //-----------------------------(ODa.B:ODa.T+W)
        od.bottom = getRule("OD WIDTH") >= W ? getRule("POLY WIDTH") : W;
        
        //Left Travarse
        //-----------------------------(+N:INTEGER)     x
        //-----------------------------(N:)
        int N = (int)(((W - (getRule("CONT IN OD") * 2))+getRule("CONT SPACE")) / (getRule("CONT WIDTH")+getRule("CONT SPACE")));
        System.out.println(N+" :N");
        
        contL = new Rect[N];
        contR = new Rect[N];
        
        //-----------------------------(CONTa.R:POLYa.L-CONT_OUT_POLY)
        //-----------------------------(CONTa.L:CONTa.R-CONT_WIDTH)
        for(i=0; i<N; i++){
            contL[i] = new Rect(11);
            contL[i].right = poly.left - getRule("CONT OUT POLY");
            contL[i].left = contL[i].right - getRule("CONT WIDTH");
        }
        
        //-----------------------------(ODa.L:CONTa.L-CONT_IN_OD)
        od.left = contL[0].left - getRule("CONT IN OD");
        //-----------------------------(NIMPa.L:ODa.L-OD_IN_NIMP)
        nimp.left = od.left - getRule("OD IN NIMP");
        
        left = -nimp.left;
        //Right Travarse
        //-----------------------------(CONTb.L:POLYa.R+CONT_OUT_POLY)
        //-----------------------------(CONTb.R:CONTb.L+CONT_WIDTH)
        for(i=0; i<N; i++){
            contR[i] = new Rect(11);
            contR[i].left = poly.right + getRule("CONT OUT POLY");
            contR[i].right = contR[i].left + getRule("CONT WIDTH");
        }
        
        //-----------------------------(ODa.R:CONTb.R+CONT_IN_OD)
        od.right = contR[0].right + getRule("CONT IN OD");
        //-----------------------------(NIMPa.R:ODa.R+OD_IN_NIMP)
        nimp.right = od.right + getRule("OD IN NIMP");
        
        right = nimp.right;
        //top travarse
        //-----------------------------(NIMPa.T:ODa.T-OD_IN_NIMP)
        nimp.top = od.top - getRule("OD IN NIMP");
        //-----------------------------(POLYa.T:ODa.T-POLY_OUT_OD)
        poly.top = od.top - getRule("POLY OUT OD");
        
        top = -poly.top;
        //bottom travarse
        //-----------------------------(CONTa.T:ODa.T+CONT_IN_OD:ODa.B-CONT_IN_OD:CONT_WIDTH+CONT_SPACE)
        //-----------------------------(CONTa.B:ODa.T+CONT_IN_OD+CONT_WIDTH:ODa.B-CONT_IN_OD:CONT_WIDTH+CONT_SPACE)
        for(i=0; i<N; i++){
            contL[i].top = od.top + getRule("CONT IN OD") + i*(getRule("CONT WIDTH")+getRule("CONT SPACE"));
            contL[i].bottom = contL[i].top + getRule("CONT WIDTH");
            contR[i].top = contL[i].top;
            contR[i].bottom = contL[i].bottom;
        }
        
        //-----------------------------(NIMPa.B:ODa.B+OD_IN_NIMP)        
        nimp.bottom = od.bottom + getRule("OD IN NIMP");
        //-----------------------------(POLYa.B:ODa.B+POLY_OUT_OD)
        poly.bottom = od.bottom + getRule("POLY OUT OD");
        
        bottom = poly.bottom;
        
        vRect.add(poly);
        vRect.add(od);
        vRect.add(nimp);
        for(i=0; i<N; i++){
            vRect.add(contL[i]);
            vRect.add(contR[i]);
        }
        
        for(i=0; i<vRect.size(); i++){
            vRect.get(i).top+=(top);
            vRect.get(i).left+=(left);
            vRect.get(i).right+=(left);
            vRect.get(i).bottom+=(top);
        }
        
        print();
    }
    
    public void print(){
        setSize(600, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public double getRule(String str){
        if(str.equals("POLY WIDTH"))
            return 0.5;
        if(str.equals("CONT WIDTH"))
            return 0.5;
        if(str.equals("CONT SPACE"))
            return 0.5;
        if(str.equals("CONT IN OD"))
            return 0.3;
        if(str.equals("CONT OUT POLY"))
            return 0.4;
        if(str.equals("OD IN NIMP"))
            return 0.2;
        if(str.equals("POLY OUT OD"))
            return 0.5;
        return 0;
    }
    
    public void paint(Graphics g){
        int i;
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());
        for(i=0; i<vRect.size(); i++){
            vRect.get(i).paint(g, 50, 50, factor);
            //vRect.get(i).print();
        }
    }
}
