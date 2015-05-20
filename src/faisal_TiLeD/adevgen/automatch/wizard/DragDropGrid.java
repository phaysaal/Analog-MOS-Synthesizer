/*
 * DragDropGrid.java
 *
 * Created on July 28, 2007, 10:39 AM
 */

package faisal_TiLeD.adevgen.automatch.wizard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author  TV
 */
public class DragDropGrid extends javax.swing.JPanel {
    //Linear Distribution, 
        //Interdigitized Common Centroid, 
        //Cross Coupling, 
        //Interdigitation (Symmetric), 
        //Common Centroid (Hz Symmetric), 
        //Common Centroid (Vt Symmetric), 
        //Couple Average
    public static int GENERAL_DISTRIBUTION = 0;
    public static int INTERDIZITIZED_COMMON_CENTROID  = 1;
    public static int CROSS_COUPLE = 2;    
    public static int INTERDIGITATION_SYMMETRIC= 3;
    public static int COMMON_CENTROID_H_SYMMETRIC  = 4;
    public static int COMMON_CENTROID_V_SYMMETRIC = 5;
    public static int COUPLE_AVERAGE = 6;
    
    int matrix[][];
    int row;
    int col;
    int x[];
    public static boolean isCenterPower = false;
    int col_width;
    int row_height;
    
    int x1;
    int y1;
    int x2;
    int y2;
    boolean isDragged;
    Color color[] = new Color[10];
    
    fsActionListener al;
    /** Creates new form DragDropGrid */
    public DragDropGrid() {
        
        initComponents();
        //color[0] = new Color(200,0,100,70);
        //color[1] = new Color(0,200,100,70);
        color[0] = new Color(255,110,110);
        color[1] = new Color(110,225,110);
        color[2] = new Color(0,0,175);
        color[3] = new Color(100,0,100);
        color[4] = new Color(250,250,100);
        color[5] = new Color(150,150,250);
        color[6] = new Color(125,125,0);
        color[7] = new Color(0,125,125);
        color[8] = new Color(125,0,125);
        color[9] = new Color(250,0,0);
    }
    
    public void addActionListener(fsActionListener al){
        this.al = al;
    }
    
    public void init(int row, int col, int xx[], int arrange){
        this.row = row;
        this.col = col;
        x = new int[xx.length];
        //System.arraycopy(x, 0, this.x, 0, x.length);
        
        System.arraycopy(xx, 0, x, 0, xx.length) ;
        //x = xx;
        matrix = new int[row][col];
        
        if(arrange == GENERAL_DISTRIBUTION){
            generalDistribution();
        }else if(arrange == INTERDIGITATION_SYMMETRIC){
            this.row = 1;
            matrix = new int[1][];
            matrix[0] = getSymmtryRow(x);
        }else if(arrange == COMMON_CENTROID_H_SYMMETRIC){
            matrix = common_centroid_h_symmetric(x, row, col);
        }else if(arrange == COMMON_CENTROID_V_SYMMETRIC){
            matrix = common_centroid_v_symmetric(x, row, col);
        }else if(arrange == INTERDIZITIZED_COMMON_CENTROID){
            matrix = interdigited_common_centroid(x, row, col);
        }else if(arrange == COUPLE_AVERAGE){
            matrix = coupleAverage();
        }else if(arrange == CROSS_COUPLE){
            matrix = crossCouple(x, row, col);
        }
        
        repaint();
    }
    
    public void generalDistribution(){
        int i, j, k = 0;
        int nx = 0;
        for(i=0; i<row; i++){
            for(j=0; j<col; j++){
                matrix[i][j] = nx;
                k++;
                if(k == x[nx]){
                    k = 0;
                    nx ++;
                }
            }
        }
    }
        
    
    public static void printMatrix(int mat[][]){
        int i,j;
//        for(i=0; i<mat.length; i++){
//            
//            for(j=0; j<mat[i].length; j ++){
//                System.out.print(mat[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
    
    public static void printMatrix(int mat[]){
        int i,j;
//        for(i=0; i<mat.length; i++){                       
//            System.out.print(mat[i]+" ");                       
//        }
    }
    
    public static int sum(int x[]){
        int i;
        int t = 0;
        for(i=0; i<x.length; i++)
            t+= x[i];
        return t;
    }
    
    static int[] getDefaultSymmetryRow(int x[]){
        int t = sum(x);
        int colCapacity[] = new int[t];
        int dummy[] = new int[t];
        Vector<Integer> vd[] = new Vector[t];
        
        int i, j, s;
        double p;
        
        for(i=0; i<t; i++)
            vd[i] = new Vector<Integer>();
            
            //Half Tone
            int sz;
            for(i=0; i<x.length; i++){
                p = t / (double)(x[i]+1);
                sz = (x[i]+1)/2;
                for(j=1; j <= sz; j++){
                    s = (int)(p * j);
                    //dummy[s] = dummy[s] * 10 + (i+1);
                    if(x[i] == 1)
                        vd[s].insertElementAt(new Integer(i+1), 0);
                    else
                        vd[s].add(new Integer(i+1));
                    x[i] --;
                    
                    if(x[i] > 0){
                        vd[t-1-s].add(new Integer(i+1));
                        x[i] --;
                    }
                    //vd[s].insertElementAt(new Integer(i+1),0);
                }
            }

            for(i=0; i<t; i++){
                for(j=0; j<vd[i].size(); j++)
                    System.out.print(vd[i].get(j));
                System.out.print("-");
            }
            System.out.println();

            Register reg = new Register(vd);
            vd = reg.distribute();

            for(i=0; i<t; i++){
                for(j=0; j<vd[i].size(); j++)
                    System.out.print(vd[i].get(j));
                System.out.print("-");
            }
            System.out.println();

            for(i=0; i < vd.length; i++){
                if(vd[i].size() > 0)
                    colCapacity[i] = vd[i].get(0)-1;
            }
            return colCapacity;
    }
    
    static int[] getSymmtryRow(int x[]){
        if(isCenterPower)
            return symmetryCenter(x, sum(x));
        else
            return symmetryLine(x, sum(x));
//        int t = sum(x);
//        int colCapacity[] = new int[t];
//        
//        if(x.length == 2){
//            if(t == 1){
//                colCapacity[0] = 0;
//            }else if(t == 2){
//                colCapacity[0] = 0;
//                colCapacity[1] = 1;            
//            }/*else if(t == 3){
//                colCapacity[0] = 0;
//                colCapacity[1] = 1;            
//                colCapacity[2] = 0;
//            }*/else if(t == 4 && x[0] == x[1]){
//                colCapacity[0] = 0;
//                colCapacity[1] = 1;            
//                colCapacity[2] = 1;
//                colCapacity[3] = 0;
//            }else{
//                colCapacity = getDefaultSymmetryRow(x);
//            }
//        }else if(x.length == 3){
//            if(x[0] == 1 && x[0] == x[1] && x[1] == x[2]){
//                colCapacity[0] = 0;
//                colCapacity[1] = 1;            
//                colCapacity[2] = 2;
//            }else if(x[0] == 2 && x[0] == x[1] && x[1] == x[2]){
//                colCapacity[0] = 0;
//                colCapacity[1] = 1;            
//                colCapacity[2] = 2;
//                colCapacity[3] = 2;
//                colCapacity[4] = 1;            
//                colCapacity[5] = 0;
//            }else{
//                colCapacity = getDefaultSymmetryRow(x);
//            }
//        }
//        else{
//            boolean isAllEqual = true;
//            for(int i = 1; i < x.length; i++){
//                if(x[i] != x[i-1])
//                    isAllEqual = false;
//            }
//            if(isAllEqual){
//                int k = 0;
//                if(x[0] == 1 || x[0] == 2){
//                    for(int i = 0; i < x.length; i++){
//                        for(int j=0; j < x[i]; j++){
//                            colCapacity[k] = i;
//                            k++;
//                        }                        
//                    }
//                }else{
//                    colCapacity = getDefaultSymmetryRow(x);
//                }
//            }else{
//                colCapacity = getDefaultSymmetryRow(x);
//            }
//        }
//        //printMatrix(colCapacity);
//        return colCapacity;
    }
    
    public static int[][] common_centroid_h_symmetric(int x[], int row, int col){
        int mat[][] = new int [row][col];
        int lin[] = getSymmtryRow(x);
        
        
        int i,j,k=0, d = 1;
        for(i=0; i<row; i++){            
            for(j= d==1?0:col-1 ; d==1?j<col:j>=0; j = j + d){
                mat[i][j] = lin[k];
                k++;
            }            
            //d = - d;
        }
        
//        for(i=0; i<row; i++){
//            
//            for(j=0; j<col; j ++){
//                System.out.print(mat[i][j]+" ");
//            }
//            System.out.println();
//        }
        
        return mat;
    }
    
    public static int[][] common_centroid_v_symmetric(int x[], int row, int col){
        int mat[][] = new int [row][col];
        int lin[] = getSymmtryRow(x);
        
        int i,j,k=0, d = 1;
        for(i=0; i<col; i++){            
            for(j=d==1?0:row-1; d==1?j<row:j>=0; j = j + d){                
                mat[j][i] = lin[k];                
                k++;
            }            
            //d = - d;
        }
                       
        return mat;
    }
    
    private static int lowestFactor(int x, int s){
        int i;        
        for(i=s; i <= x; i++){
            if(x % i == 0){
                return i;
            }
        }
        return (x % 2) ;
    }
    
    public static int[][] interdigited_common_centroid(int x[], int row, int col){
        int i, j, k;
        int gcd = x[0];
        for(i=1; i<x.length; i++){
            gcd = ComponentSplit.gcd(x[i], gcd);
        }
        //Get the lowest factor greater than 2 as length of unit
        int factor = lowestFactor(col, x.length < col ? x.length > 2 ? x.length : 3 : col);
        if(factor < x.length){
            factor = x.length;
        }
        if(factor == 1){
            int matrix[][] = new int[1][];
            matrix[0] = getSymmtryRow(x);
            return matrix;
        }
        if(gcd == 1){            
            return common_centroid_h_symmetric(x, row, col);
        }
        
        
        
        //Total number of type
        int type = x.length;
        int unit[] = new int[type];
        int unitarray[][] = new int[2][factor];
        
        
        
        
        //for equal distribution
        int fraction = (col / factor) * row;
        int sm = 0;
        for(i=0; i<type-1; i++){
            unit[i] = x[i] / fraction;
            sm += unit[i];
        }
        unit[i] = factor - sm;
        
        unitarray[0] = getSymmtryRow(unit);
        for(i=0; i<unitarray[0].length; i++){
            //unitarray[1][i] =  unitarray[0][factor - i - 1];
            if(factor >= x.length && unitarray[0][unitarray[0].length -1]!=unitarray[0][0]){
                unitarray[1][i] = unitarray[0][unitarray[0].length - i -1];
            }else{
                unitarray[1][i] =  type - unitarray[0][i] - 1;
            }
        }
        
        int col_repeat = col / factor;
        
        int rows[] = new int[2];
        rows[1] = (int)(row / 2) ;
        rows[0] = row - rows[1];
        
        int rowarray[] = getSymmtryRow(rows);
        
        int colarray[][] = new int[2][col];
        k = 0;
        if(unitarray[0][factor-1] == unitarray[1][0]){
            for(i=0; i<col_repeat; i++){
                for(j=0; j<factor; j++){                
                    colarray[0][k] = unitarray[i%2][j];
                    colarray[1][k] = unitarray[(i+1)%2][j];
                    k++;
                }
            }   
        }else{
            for(i=0; i<col_repeat; i++){
                for(j=0; j<factor; j++){                
                    colarray[0][k] = unitarray[0][j];
                    colarray[1][k] = unitarray[1][j];
                    k++;
                }
            }
        }
        
        int mat[][] = new int[row][];
        for(i=0; i<row; i++){
            mat[i] = colarray[rowarray[i]];
        }
        
        printMatrix(mat);
        return mat;
    }
    
    
    public static int[] symmetryLine(int x[], int cell){
        int i;
        int holder[][] = new int[2][cell];
        int mantissa;
        int len;
        double prob;
        double carry;
        int k;
        //for(k=0; )
        int max = sum(x) / cell;
        int full = 0;
        double total = holder[0].length;
        
//        //sorting
//        int min, temp;
//        
//        int dx[] = new int[x.length];
//        for(i = 0 ; i < x.length; i++)
//            dx[i] = i;
//        for(i = 0 ; i < x.length; i++){
//            min = i;
//            for(k = i+1; k<x.length; k++){
//                if(x[min] > x[k])
//                    min = k;
//            }
//            temp = dx[i];
//            dx[i] = dx[min];
//            dx[min] = temp;
//                                       
//            temp = x[i];
//            x[i] = x[min];
//            x[min] = temp;
//
//        }
        for(k=x.length-1; k>=0; k--){    
        //for(k=0; k<x.length; k++){ 
            ////******************************************************************
            prob = carry = x[k] / (total-full);
            
            //if((total-full)% x[k] == 0 && (total-full)/ x[k] > 1){
            if(x[k] > 1 && (total-full) % x[k] == 0 && (total-full)/ x[k] > 1){
                i = 0;
                len = (int)((total)/2-1);
                while(i < len ){
                    while(i < len && holder[1][i] == max)
                        i++;
                    mantissa = (int)Math.round(carry);
                    carry -= mantissa;
                    carry += prob;
                    if(mantissa > 0){
                        holder[0][i] = k;
                        holder[1][i] += mantissa;

                        holder[0][holder[0].length-i-1] = k;                    
                        holder[1][holder[0].length-i-1] += mantissa;
                    }
                    i++;
                }
                
                while(i < len && holder[1][i] == max)
                    i++;
                if(x[k]%2 == 1){
                    holder[0][i] = k;
                    holder[1][i] = (int)Math.round(carry);
                }

            }else{
                i = 0;
                while(i < holder[0].length){
                    while(i < holder[0].length && holder[1][i] == max)
                        i++;
                    
                    mantissa = (int)Math.round(carry);
                    carry -= mantissa;
                    carry += prob;
                    if(i<holder[0].length && mantissa > 0){
                        holder[0][i] = k;
                        holder[1][i] += mantissa;
                    }
                    
                    i++;
                }
            }
            ////******************************************************************
                        
            
            
            full = 0;
            for(i=0; i<holder[0].length; i++){
                if(holder[1][i] == max)
                    full ++;
            }
            
        }
        
        return holder[0];
    }
    public static int[] symmetryCenter(int x[], int cell){
        int i;
        int holder[][] = new int[2][cell];
        int mantissa;
        int len;
        double prob;
        double carry;
        int k;
        //for(k=0; )
        int max = sum(x) / cell;
        int full = 0;
        double total = holder[0].length;
        
        //sorting
        int min, temp;
        
        int dx[] = new int[x.length];
        for(i = 0 ; i < x.length; i++)
            dx[i] = i;
        for(i = 0 ; i < x.length; i++){
            min = i;
            for(k = i+1; k<x.length; k++){
                if(x[min] > x[k])
                    min = k;
            }
            temp = dx[i];
            dx[i] = dx[min];
            dx[min] = temp;
                                       
            temp = x[i];
            x[i] = x[min];
            x[min] = temp;

        }
        //for(k=x.length-1; k>=0; k--){    
        for(k=0; k<x.length; k++){ 
            ////******************************************************************
//////            prob = carry = x[k] / (total-full);
//////            
//////            //if((total-full)% x[k] == 0 && (total-full)/ x[k] > 1){
//////            if(x[k] > 1 && (total-full) % x[k] == 0 && (total-full)/ x[k] > 1){
//////                i = 0;
//////                len = (int)((total)/2-1);
//////                while(i < len ){
//////                    while(i < len && holder[1][i] == max)
//////                        i++;
//////                    mantissa = (int)Math.round(carry);
//////                    carry -= mantissa;
//////                    carry += prob;
//////                    if(mantissa > 0){
//////                        holder[0][i] = k;
//////                        holder[1][i] += mantissa;
//////
//////                        holder[0][holder[0].length-i-1] = k;                    
//////                        holder[1][holder[0].length-i-1] += mantissa;
//////                    }
//////                    i++;
//////                }
//////                
//////                while(i < len && holder[1][i] == max)
//////                    i++;
//////                if(x[k]%2 == 1){
//////                    holder[0][i] = k;
//////                    holder[1][i] = (int)Math.round(carry);
//////                }
//////
//////            }else{
//////                i = 0;
//////                while(i < holder[0].length){
//////                    while(i < holder[0].length && holder[1][i] == max)
//////                        i++;
//////                    
//////                    mantissa = (int)Math.round(carry);
//////                    carry -= mantissa;
//////                    carry += prob;
//////                    if(i<holder[0].length && mantissa > 0){
//////                        holder[0][i] = k;
//////                        holder[1][i] += mantissa;
//////                    }
//////                    
//////                    i++;
//////                }
//////            }
            ////******************************************************************
            
            
            prob = (total-full) / (x[k]+1);
            for(i=1; i<=x[k]; i++){
                carry = Math.floor(prob * i);
                while(holder[1][(int)carry] == max)
                    carry++;
                holder[1][(int)carry]++;
                holder[0][(int)carry] = dx[k];
            }
            
            
            full = 0;
            for(i=0; i<holder[0].length; i++){
                if(holder[1][i] == max)
                    full ++;
            }
            
        }
        
        return holder[0];
    }
    public static void Symmetry(int x[], int row, int col){
        long sm = System.currentTimeMillis();
        long s = System.nanoTime();
        int m[] = symmetryLine(x, sum(x));
        long em = System.currentTimeMillis() - sm;
        long e = System.nanoTime();
        
//        System.out.println(s+"\t"+e+"\t"+(e-s)+"\t"+em);
        int i;
        for(i=0; i<m.length; i++){
            System.out.print(m[i]);
        }
        
    }
    
//    public int[][] coupleAverage(int x[], int row, int col){                
//        return null;
//    }
            
    
    public int[][] coupleAverage(){
        if(x.length == 2){
            int x = this.x[0];
            int y = this.x[1];
            
            int a = x;//x < y ? x : y;
            int i, j;
            
            XDimension xd = new XDimension(col);
            YDimension yd = new YDimension(row);
            xd.capasityDistribute(a);
            yd.capasityDistribute(a);

            Point elements[] = new Point[x];
            for(i=0; i<elements.length; i++){
                elements[i] = new Point();
            }

            xd.distribute(elements);
            yd.distribute(elements);

            for(i=0; i<row; i++){
                for(j=0; j<col; j++){                
                     matrix[i][j] = 1;
                }
            }

            for(i=0; i<elements.length; i++){
                matrix[elements[i].y][elements[i].x] = 0;
            }

            elements = null;
            xd = null;
            yd = null;
            return matrix;
        }else{
            return interdigited_common_centroid(x, row, col);
        }       
    }
    
    public static int[][] crossCouple(int x[], int row, int col){
        int i, j, k, l;
        int mat[][] = new int[row][col];
        
        l = 0;
        for(i=0; i<row; i++){
            k = l;
            for(j=0; j<col; j++){
                if(k == x.length)
                    k = 0;
                if(x[k] > 0)
                    mat[i][j] = k;
                x[k] --;
                k ++;
            }
            l++;
            if(l == x.length)
                l = 0;
        }
        return mat;
    }
    
    public static void main(String args[]){
        int x[] = {2,6};
        //common_centroid_h_symmetric(new int[]{4,8}, 2, 6);
        //printMatrix(getSymmtryRow(x));
        //interdigited_common_centroid(new int[]{4,8}, 2, 6);
        Symmetry(new int[]{4,4}, 0, 0);
    }
    
    
    //    public double distance(int a, int b, int n){
    //        int i, j;
    //        double sum = 0;
    //        for(i=0; i<row; i++){
    //            for(j=0; j<col; j++){
    //                 if(matrix[i][j] == n){
    //                     sum += Math.sqrt(Math.sqrt((a-i)*(a-i)+(b-j)*(b-j)));
    //                 }
    //            }
    //        }
    //        return sum;
    //    }
    //    public double calculateDistance(){
    //        int i, j;
    //        int n = 1;
    //        double sum = 0;
    //        for(i=0; i<row; i++){
    //            for(j=0; j<col; j++){
    //                 if(matrix[i][j] == n){
    //                     sum += distance(i, j, n);
    //                 }
    //            }
    //        }
    //        return sum/2;
    //    }
    
    //    public void averageSequence(int x){
    //        //Queue<Integer>
    //
    //    }
    //    public void reArrange(){
    //        int a = x;//x < y ? x : y;
    //        int i, j;
    //        XDimension xd = new XDimension(col);
    //        YDimension yd = new YDimension(row);
    //        xd.capasityDistribute(a);
    //        yd.capasityDistribute(a);
    //
    //        Element elements[] = new Element[x];
    //        for(i=0; i<elements.length; i++){
    //            elements[i] = new Element();
    //        }
    //        xd.distribute(elements);
    //        yd.distribute(elements);
    //
    //        for(i=0; i<row; i++){
    //            for(j=0; j<col; j++){
    //                 matrix[i][j] = 2;
    //            }
    //        }
    //
    //        for(i=0; i<elements.length; i++){
    //            matrix[elements[i].getY()][elements[i].getX()] = 1;
    //        }
    //
    //        elements = null;
    //        xd = null;
    //        yd = null;
    //        repaint();
    //
    //    }
    
    //    public double calculateDistribution(){
    //        double ratio = x / (double)(x+y);
    //        double result = 0.0;
    //        int i, j;
    //        double count;
    //        for(i=0; i<matrix.length; i++){
    //            count = 0;
    //            for(j=0; j<matrix[i].length; j++){
    //                if(matrix[i][j] == 1)
    //                    count ++;
    //            }
    //            result += Math.pow(ratio - (count/matrix[i].length), 2.0);
    //        }
    //        for(i=0; i<matrix[0].length; i++){
    //            count = 0;
    //            for(j=0; j<matrix.length; j++){
    //                if(matrix[j][i] == 1)
    //                    count ++;
    //            }
    //            result += Math.pow(ratio - (count/matrix.length), 2.0);
    //        }
    //        return result;
    //    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
    //x2 = evt.getX() ;
    //y2 = evt.getY() ;
    y2 = evt.getX() / col_width;
    x2 = evt.getY() / row_height;
    repaint();
}//GEN-LAST:event_formMouseDragged

private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
    y2 = evt.getX() / col_width;
    x2 = evt.getY() / row_height;
    
    
    
    if(evt.getButton()!=evt.BUTTON1){
        matrix[x2][y2] ++;
        if(matrix[x2][y2] == x.length)
            matrix[x2][y2] = 0;
    }else{
        if(matrix[x1][y1] != matrix[x2][y2]){
            int t = matrix[x1][y1] ;
            matrix[x1][y1] = matrix[x2][y2] ;
            matrix[x2][y2] = t;
        }
    }
    
    isDragged = false;
    //System.out.println("Released: "+x2+","+y2);
    
    repaint();
    if(al != null)
        al.actionPerformed();
}//GEN-LAST:event_formMouseReleased

private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
    y1 = evt.getX() / col_width;
    x1 = evt.getY() / row_height;
    
    //System.out.println("Pressed: "+x1+","+y1);
    isDragged = true;
}//GEN-LAST:event_formMousePressed

public void paint(Graphics g){
    super.paint(g);
    int row = matrix.length;
    int col = matrix[0].length;
    col_width  = getWidth() / (col);
    row_height = getHeight() / (row);
    int i, j;
    
    for(i=0; i<row; i++){
        for(j=0; j<col; j++){
            g.setColor(color[matrix[i][j]]);
            g.fillRect(j*col_width+3, i*row_height+3, col_width-6, row_height-6);
            //System.out.println(matrix[i][j]);
        }
    }
    
    if(isDragged){
        g.setColor(color[matrix[x1][y1]]);
        g.fillRect(y2*col_width+3, x2*row_height+3, col_width-6, row_height-6);
        //g.fillRect(x2+3, y2+3, col_width-6, row_height-6);
    }
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
