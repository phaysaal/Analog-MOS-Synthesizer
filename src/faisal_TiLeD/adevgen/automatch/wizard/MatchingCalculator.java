/*
 * MatchingCalculator.java
 * 
 * Created on Aug 17, 2007, 9:45:17 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.automatch.wizard;

/**
 *
 * @author TV
 */
public class MatchingCalculator {
    public static double getSymmetricity(int matrix[][], int x[]){
        double val = 0;
        int i,j;
        int row = matrix.length;
        
        if(row == 1){
            int col = matrix[0].length;
            
            int midCol = (int)(col / 2);
            for(i=0; i<=midCol; i++){
                val += Math.abs(matrix[0][i] - matrix[0][col - i - 1]);
            }
            return val;
        }else if(row == 2){
            
//            for(i=1; i<x.length; i++){
//                if(x[i] != x[i-1])
//                    break;
//            }
            
            //if(i == x.length){
                
                int col = matrix[0].length;
                double xval = 0;
                int midCol = (int)(col / 2);

                for(i=0; i<=midCol; i++){
                    xval += Math.abs(matrix[0][i] - matrix[0][col - i - 1]);
                    xval += Math.abs(matrix[1][i] - matrix[1][col - i - 1]);
                }

                for(i=0; i<col; i++){
                    val += Math.abs(x.length - matrix[0][i] - matrix[1][i] - 1);
                }

                int val1 = (int) (val + xval);
                
//            }
//            else{
//                int col = matrix[0].length;
                val = 0;
                for(i=0; i<col; i++){
                    val += Math.abs(matrix[0][i] - matrix[1][col-i-1]);
                }

                return val < val1 ? val:val1;
//            }
        }
        
        
        
        
        
            int col = matrix[0].length;
            double xval = 0;
            int midCol = (int)(col / 2);
            for(j=0; j<row; j++){
                for(i=0; i<=midCol; i++){
                    xval += Math.abs(matrix[j][i] - matrix[row-j-1][col - i - 1]);
                }
            }
            return xval;
        
        
        
        
//        int midRow = (int)(row / 2);
//        for(i=0; i<=midRow; i++){
//            if(matrix[i].length == matrix[row - i - 1].length){
//                for(j=0; j<matrix[i].length; j++){
//                    val += Math.abs(matrix[i][j] - matrix[row-i-1][matrix[i].length - j - 1]);
//                }
//            }else{
//                val += (matrix[i].length + matrix[row - i - 1].length);
//            }
//        }                
        
    }
    
    public static double getAverage(int matrix[][], int x[]){
        double xval[] = new double[x.length];
        double yval[] = new double[x.length];
        double val = 0;
        int i,j;
        int row = matrix.length;
        int midRow = (int)(row / 2);
        
        //positions
        for(i=0; i<matrix.length; i++){
            for(j=0; j<matrix[i].length; j++){
                xval[matrix[i][j]] += j;
                yval[matrix[i][j]] += i;
            }
        }     
        
        double xavg[] = new double[x.length];
        double yavg[] = new double[x.length];
        double xsum = 0, ysum = 0;
        
        for(i=0; i<x.length; i++){
            xavg[i] = xval[i] / x[i];
            yavg[i] = yval[i] / x[i];
            xsum += xavg[i];
            ysum += yavg[i];
        }
        
        double xav = xsum / x.length;
        double yav = ysum / x.length;
        
        double xsd = 0, ysd = 0;
        
        for(i=0; i<x.length; i++){
            xsd += (Math.pow(xav - xavg[i], 2));
            ysd += (Math.pow(yav - yavg[i], 2));
        }
        
        val = ( xsd + ysd );
        return val;
    }
    
    public static double getInterDistance(int matrix[][], int x[]) {
        //int sum = DragDropGrid.sum(x);
        int xcor[][] = new int[x.length][];
        int ycor[][] = new int[x.length][];
        int ind[] = new int[x.length];
        int index = 0;;
        int i,j, k;
        
        int maxholder = 0;
        for(i=1; i<x.length; i++){
            if(x[maxholder] < x[i])
                maxholder = i;
        }
        
        for(i=0; i<x.length; i++){
            if(i!=maxholder){
                xcor[i] = new int[x[i]];
                ycor[i] = new int[x[i]];
            }
        }
        
        int ival = 0;
        for(i=0; i<matrix.length; i++){
            for(j=0; j<matrix[i].length; j++){
                ival += matrix[i][j];
            }
        }
        
        if(ival == 0)
            return 0;
        
            for(i=0; i<matrix.length; i++){
                for(j=0; j<matrix[i].length; j++){
                    if(matrix[i][j]!=maxholder){
                        index = matrix[i][j];
                        xcor[index][ind[index]] = j;
                        ycor[index][ind[index]] = i;
                        ind[index] ++;
                    }
                }
            }
        
        
        double temp, revtemp;
        double dis[] = new double[x.length];
        int xl, xr, yt, yb;
        for(i=0; i<x.length; i++){
            if(i == maxholder) continue;
            dis[i] = 0;
            for(j=0; j<xcor[i].length-1; j++){
                for(k=j+1; k<xcor[i].length; k++){
                    temp = Math.sqrt(Math.pow((xcor[i][j]-xcor[i][k]), 2)+Math.pow((ycor[i][j]-ycor[i][k]), 2));
                    if(xcor[i][j] < xcor[i][k]){
                        xl = xcor[i][j];
                        xr = ((xcor[i][k]+1)%matrix[0].length);
                    }else{
                        xl = xcor[i][k];
                        xr = ((xcor[i][j]+1)%matrix[0].length);
                    }
                    if(ycor[i][j] < ycor[i][k]){
                        yt = ycor[i][j];
                        yb = ((ycor[i][k]+1)%matrix.length);
                    }else{
                        yt = ycor[i][k];
                        yb = ((ycor[i][j]+1)%matrix.length);
                    }
                                        
                    revtemp = Math.sqrt(Math.pow((xl-xr), 2)+Math.pow((yt-yb), 2));
                    
                    dis[i] += (temp<revtemp?temp:revtemp);
                }
            }
            dis[i] = (dis[i] / 2) / x[i];
        }
        
        double val = 0;
        for(i=0; i<x.length; i++){
            val += dis[i];
        }
        val /= x.length;
        double sd = 0;
        for(i=0; i<x.length; i++){
            sd += Math.pow(dis[i]-val, 2);
        }
        sd = Math.sqrt(sd)/x.length;
        
        //double disp = getDisparity(matrix, x);
        return sd;
    }
    
    public static double getDisparity(int matrix[][], int x[]) {
        //int sum = DragDropGrid.sum(x);
        double xval[] = new double[x.length];
        double yval[] = new double[x.length];
        double val = 0;
        int i,j;
        int row = matrix.length;
        int midRow = (int)(row / 2);
        
        //positions
        for(i=0; i<matrix.length; i++){
            for(j=0; j<matrix[i].length; j++){
                xval[matrix[i][j]] += j;
                yval[matrix[i][j]] += i;
            }
        }     
        
        double xavg[] = new double[x.length];
        double yavg[] = new double[x.length];
        double xsum = 0, ysum = 0;
        //average
        for(i=0; i<x.length; i++){
            xavg[i] = xval[i] / x[i];
            yavg[i] = yval[i] / x[i];
            //xsum += xavg[i];
            //ysum += yavg[i];
        }
        
        //sum for SD
        for(i=0; i<x.length; i++){
            xval[i] =0;
            yval[i] =0;            
        }
        
        int maxholder = 0;
        for(i=1; i<x.length; i++){
            if(x[maxholder] < x[i])
                maxholder = i;
        }
        
        double intv;
        double cen;
        for(i=0; i<matrix.length; i++){
            for(j=0; j<matrix[i].length; j++){
                if(matrix[i][j] != maxholder){
                    //xval[matrix[i][j]] += Math.pow(j-xavg[matrix[i][j]], 2);
                    //yval[matrix[i][j]] += Math.pow(i-yavg[matrix[i][j]], 2);
                
                
                    intv = matrix[i].length/(double)((x[matrix[i][j]]%matrix[i].length)+1);
                    xval[matrix[i][j]] += (matrix[i].length-Math.pow(j-(Math.round((j+1)/intv)*intv), 2));
                    
                    intv = matrix.length/((x[matrix[i][j]]%matrix.length)+1);
                    yval[matrix[i][j]] += (matrix.length-Math.pow(j-(Math.round((i+1)/intv)*intv), 2));
                    
                    
//                    if(i < matrix.length/2){
//                        yval[matrix[i][j]] -= Math.pow(i-(1/matrix.length), 2);
//                    }else if(i >= matrix.length/2){
//                        yval[matrix[i][j]] -= Math.pow(i-(2/matrix.length), 2);
//                    }
//                    if(j < matrix[i].length/2){
//                        xval[matrix[i][j]] -= Math.pow(j-(2/matrix[i].length), 2);
//                    }else if(j >= matrix[i].length/2){
//                        xval[matrix[i][j]] -= Math.pow(j-(2/matrix[i].length), 2);
//                    }
                }
            }
        }
        
        //SD
        for(i=0; i<x.length; i++){
            xavg[i] = xval[i] / x[i];
            yavg[i] = yval[i] / x[i];
            xsum += xavg[i];
            ysum += yavg[i];
        }
        
        double xav = xsum / x.length;
        double yav = ysum / x.length;
        
        //double xsd = 0, ysd = 0;
        
//        for(i=0; i<x.length; i++){
//            xsd += (Math.pow(xav - xavg[i], 2));
//            ysd += (Math.pow(yav - yavg[i], 2));
//        }
        
        val = ( xav + yav ) / 2;
        return val;
    }
}
