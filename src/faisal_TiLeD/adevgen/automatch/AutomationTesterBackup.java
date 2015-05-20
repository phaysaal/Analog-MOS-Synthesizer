/*
 * Analyzer.java
 *
 * Created on July 26, 2007, 7:19 PM
 */
package faisal_TiLeD.adevgen.automatch;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
/**
 *
 * @author  TV
 */
public class AutomationTesterBackup extends javax.swing.JFrame implements ActionListener {
    public static final int MAX = 10001;
    JComboBox jcb[][];
    JLabel txtRowResult[][];
    JLabel txtColResult[][];
    int row;
    int col;
    int type;
    
    int lowerFactor[] = new int[MAX];
    DragDropGrid ddg = new DragDropGrid();
        
    /** Creates new form Analyzer */
    public AutomationTesterBackup() {
        initComponents();
        initFactors();
        ddg.addActionListener(this);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLeft = new javax.swing.JPanel();
        txtA = new javax.swing.JTextField();
        txtB = new javax.swing.JTextField();
        btnShorten = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFinalCost = new javax.swing.JTextField();
        chkAbsolute = new javax.swing.JCheckBox();
        chkDebug = new javax.swing.JCheckBox();
        txtRow = new javax.swing.JTextField();
        txtCol = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnReLay = new javax.swing.JButton();
        txtUA = new javax.swing.JTextField();
        txtUB = new javax.swing.JTextField();
        btnLayGen = new javax.swing.JButton();
        txtTolerance = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDistance = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtDistribution = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtX1 = new javax.swing.JTextField();
        txtX2 = new javax.swing.JTextField();
        txtY1 = new javax.swing.JTextField();
        txtY2 = new javax.swing.JTextField();
        btnSplit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        pnAnal = new javax.swing.JPanel();
        pnGrid = new javax.swing.JPanel();
        pnRowResult = new javax.swing.JPanel();
        pnColResult = new javax.swing.JPanel();
        pnSummeryResult = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CenterBase");

        btnShorten.setText("Shorten");
        btnShorten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShortenActionPerformed(evt);
            }
        });

        jLabel1.setText("A :");

        jLabel2.setText("B :");

        jLabel4.setText("Symmetry Cost:");

        chkAbsolute.setText("Absolute");
        chkAbsolute.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chkAbsolute.setMargin(new java.awt.Insets(0, 0, 0, 0));
        chkAbsolute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAbsoluteActionPerformed(evt);
            }
        });

        chkDebug.setText("Debug");
        chkDebug.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chkDebug.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel3.setText("Col:");

        jLabel5.setText("Row:");

        btnReLay.setText("Lay Gen");
        btnReLay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReLayActionPerformed(evt);
            }
        });

        btnLayGen.setText("Matrix Gen");
        btnLayGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLayGenActionPerformed(evt);
            }
        });

        jLabel6.setText("Num A:");

        jLabel7.setText("Num B:");

        jLabel8.setText("Tolerance:");

        jLabel9.setText("Inner Distance:");

        jButton1.setText("Distribute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Distribution:");

        txtX1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtX1ActionPerformed(evt);
            }
        });

        txtX2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtX2ActionPerformed(evt);
            }
        });

        btnSplit.setText("Auto Split");
        btnSplit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSplitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtY1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtY2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSplit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtX1, txtX2, txtY1, txtY2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtY1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtY2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSplit)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButton2.setText("jButton2");

        javax.swing.GroupLayout pnLeftLayout = new javax.swing.GroupLayout(pnLeft);
        pnLeft.setLayout(pnLeftLayout);
        pnLeftLayout.setHorizontalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel3))
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel5))
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel8))
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel7))
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6))
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel2))
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(btnReLay, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(txtCol, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(txtRow, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(btnLayGen)
                            .addComponent(txtTolerance, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(txtUB, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(txtUA, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(btnShorten, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(txtB, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(txtA, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtDistribution, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDistance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtFinalCost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkAbsolute)
                                    .addComponent(chkDebug))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(13, 13, 13)))))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLeftLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnLeftLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDistance, txtDistribution, txtFinalCost});

        pnLeftLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLayGen, btnReLay, btnShorten, jButton1, txtA, txtB, txtCol, txtRow, txtTolerance, txtUA, txtUB});

        pnLeftLayout.setVerticalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShorten)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTolerance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLayGen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReLay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDistribution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFinalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addComponent(chkAbsolute)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkDebug))
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnLeft, java.awt.BorderLayout.WEST);

        pnCenter.setLayout(new java.awt.BorderLayout());

        pnAnal.setLayout(new java.awt.GridLayout(2, 2));

        javax.swing.GroupLayout pnGridLayout = new javax.swing.GroupLayout(pnGrid);
        pnGrid.setLayout(pnGridLayout);
        pnGridLayout.setHorizontalGroup(
            pnGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        pnGridLayout.setVerticalGroup(
            pnGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        pnAnal.add(pnGrid);

        javax.swing.GroupLayout pnRowResultLayout = new javax.swing.GroupLayout(pnRowResult);
        pnRowResult.setLayout(pnRowResultLayout);
        pnRowResultLayout.setHorizontalGroup(
            pnRowResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        pnRowResultLayout.setVerticalGroup(
            pnRowResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        pnAnal.add(pnRowResult);

        javax.swing.GroupLayout pnColResultLayout = new javax.swing.GroupLayout(pnColResult);
        pnColResult.setLayout(pnColResultLayout);
        pnColResultLayout.setHorizontalGroup(
            pnColResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        pnColResultLayout.setVerticalGroup(
            pnColResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        pnAnal.add(pnColResult);

        javax.swing.GroupLayout pnSummeryResultLayout = new javax.swing.GroupLayout(pnSummeryResult);
        pnSummeryResult.setLayout(pnSummeryResultLayout);
        pnSummeryResultLayout.setHorizontalGroup(
            pnSummeryResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        pnSummeryResultLayout.setVerticalGroup(
            pnSummeryResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        pnAnal.add(pnSummeryResult);

        pnCenter.add(pnAnal, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSplitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSplitActionPerformed
    try{
        int x1, x2, y1, y2, nx, ny, n1, n2;
        x1 = Integer.parseInt(txtX1.getText());
        y1 = Integer.parseInt(txtY1.getText());
        x2 = Integer.parseInt(txtX2.getText());
        y2 = Integer.parseInt(txtY2.getText());
        nx = gcd(x1, x2);
        ny = gcd(y1, y2);
        n1 = (x1/nx)*(y1/ny);
        n2 = (x2/nx)*(y2/ny);
        txtUA.setText(""+n1);
        txtUB.setText(""+n2);
    }catch(Exception e){
        
    }
}//GEN-LAST:event_btnSplitActionPerformed

private void txtX2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtX2ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_txtX2ActionPerformed

    private void txtX1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtX1ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_txtX1ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if(ddg.row == 0){
        btnReLay.doClick();
    }
    ddg.reArrange();
    txtDistribution.setText(""+ddg.calculateDistribution());
}//GEN-LAST:event_jButton1ActionPerformed
    
    private void initFactors(){
        int i, j;
        for(i=0; i<MAX; i++){
            lowerFactor[i] = 1;
        }
        int max = (int) java.lang.Math.sqrt(MAX);
        
        for(i=2; i <= max; i++){
            for(j=i+i; j<MAX; j+=i){
                if((j / i) > lowerFactor[j]){
                    lowerFactor[j] = i;
                }
            }
        }
        
        //        for(i=0; i<MAX; i++){
        //            System.out.println(i+"->"+lowerFactor[i]+" x "+(i/lowerFactor[i]));
        //        }
    }
    
    private int nextSuggest(int xx, int best_d, int tol, int best[]){
        if(tol == 0) return best_d;
        int x = xx + 1;
        int nd = ((x/lowerFactor[x]) - lowerFactor[x]);
        if(best_d > nd)
            best_d = nd;
        int d = nextSuggest(x, best_d, tol-1, best);
        if(nd == d){
            best[0] = x;
            best[1] = tol;
        }
        return d;
        ////
        ////        if( pc < 0.4 ){
        ////            return nextSuggest(x+1, nd);
        ////        }else{
        ////            return xx;
        ////        }
    }
    
    private void suggest(int x, int tol){
        int best[] = new int[2];
        int nd = ((x/lowerFactor[x]) - lowerFactor[x]);
        best[0] = x;
        nextSuggest(x, nd, tol, best);
        int l = lowerFactor[best[0]];
        int h = best[0] / l;
        
        txtTolerance.setText(""+best[1]);
        txtRow.setText(""+l);
        txtCol.setText(""+h);
    }
    
private void btnLayGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLayGenActionPerformed
    int numA;
    int numB;
    int total;
    int tol;
    int A, B;
    try{
        numA = Integer.parseInt(txtUA.getText());
        numB = Integer.parseInt(txtUB.getText());
        String strTol = txtTolerance.getText();
        total = numA + numB; 
        try{
            tol = Integer.parseInt(strTol);
        }catch(NumberFormatException e){
            if(lowerFactor[total]==1)
                tol = 1;
            else
                tol = 0;
            txtTolerance.setText(""+tol);
        }
       
        
        suggest(total, tol);
        
    }catch(Exception e){
        
    }
}//GEN-LAST:event_btnLayGenActionPerformed

    private void btnReLayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReLayActionPerformed
                
        pnAnal.remove(0);
        if(pnRowResult.getComponentCount() > 0){
            //pnGrid.removeAll();
            pnRowResult.removeAll();
            pnColResult.removeAll();
        }
        //pnAnal.setLayout(new Gri());
        
        pnAnal.add(ddg, 0/*BorderLayout.CENTER*/);
        try{
            row = Integer.parseInt(txtRow.getText());
            col = Integer.parseInt(txtCol.getText());
            
            int a = Integer.parseInt(txtUA.getText());
            int b = Integer.parseInt(txtUB.getText());
            if(a < b){
                a = (row * col) - b;
            }else{
                b = (row * col) - a;
            }
            ddg.init(row, col, a, b);
            
            type = 2;
            int nr = 1;//type * 3;
            int i,j;
            pnRowResult.setLayout(new GridLayout(row, nr));
            txtRowResult = new JLabel[row][nr];
            for(i=0; i<row; i++){
                
                for(j=0; j<nr; j++){
                    txtRowResult[i][j] = new JLabel("0");
                    txtRowResult[i][j].setVisible(true);
                    pnRowResult.add(txtRowResult[i][j]);
                }
            }
            pnRowResult.updateUI();
            
            nr = type * 2 + 1;
            pnColResult.setLayout(new GridLayout(nr, col));
            txtColResult = new JLabel[nr][col];
            for(i=0; i<nr; i++){
                for(j=0; j<col; j++){
                    txtColResult[i][j] = new JLabel("0");
                    txtColResult[i][j].setVisible(true);
                    pnColResult.add(txtColResult[i][j]);
                }
            }
            pnColResult.updateUI();
        }catch(Exception e){
            
        }
        pnAnal.updateUI();
        //    try{
        //
        //
        //        type = 2;
        //
        //        row = Integer.parseInt(txtRow.getText());
        //        col = Integer.parseInt(txtCol.getText());
        //        //*
        //        if(pnGrid.getComponentCount() > 0){
        //            pnGrid.removeAll();
        //            pnRowResult.removeAll();
        //            pnColResult.removeAll();
        //        }
        //        Vector<Integer> items = new Vector<Integer>();
        //        int i, j;
        //        for(i=0; i<type; i++){
        //            items.add(i);
        //        }
        //
        //        jcb = new JComboBox[row][col];
        //        pnGrid.setLayout(new GridLayout(row, col));
        //        for(i=0; i<row; i++){
        //            for(j=0; j<col; j++){
        //                jcb[i][j] = new JComboBox(items);
        //                jcb[i][j].setVisible(true);
        //                jcb[i][j].addActionListener(this);
        //                pnGrid.add(jcb[i][j]);
        //            }
        //        }
        //        pnGrid.updateUI();
        //
        //        int nr = 1;//type * 3;
        //
        //        pnRowResult.setLayout(new GridLayout(row, nr));
        //        txtRowResult = new JLabel[row][nr];
        //        for(i=0; i<row; i++){
        //
        //            for(j=0; j<nr; j++){
        //                txtRowResult[i][j] = new JLabel("0");
        //                txtRowResult[i][j].setVisible(true);
        //                pnRowResult.add(txtRowResult[i][j]);
        //            }
        //        }
        //        pnRowResult.updateUI();
        //
        //        nr = type * 2 + 1;
        //        pnColResult.setLayout(new GridLayout(nr, col));
        //        txtColResult = new JLabel[nr][col];
        //        for(i=0; i<nr; i++){
        //            for(j=0; j<col; j++){
        //                txtColResult[i][j] = new JLabel("0");
        //                txtColResult[i][j].setVisible(true);
        //                pnColResult.add(txtColResult[i][j]);
        //            }
        //        }
        //        pnColResult.updateUI();
        //
        //        //*/
        //    }catch(Exception e){
        //
        //    }
}//GEN-LAST:event_btnReLayActionPerformed
    
private void chkAbsoluteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAbsoluteActionPerformed
    calculate();
}//GEN-LAST:event_chkAbsoluteActionPerformed

private int gcd(int a, int b){
    if(a == 0)
        return b;
    return gcd(b % a, a);
}

private void btnShortenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShortenActionPerformed
    int numA;
    int numB;
    int gcd;
    int A, B;
    try{
        numA = Integer.parseInt(txtA.getText());
        numB = Integer.parseInt(txtB.getText());
        gcd = gcd(numA, numB);
        A = numA / gcd;
        B = numB / gcd;
        
        txtUA.setText(""+A);
        txtUB.setText(""+B);
        
    }catch(Exception e){
        
    }
    
    
}//GEN-LAST:event_btnShortenActionPerformed

public void calculate(){
    int i, j;
    double rowSum[][] = new double[row][type];
    double colSum[][] = new double[type][col];
    double rowCount[][] = new double[row][type];
    double colCount[][] = new double[type][col];
    double rowAvg[][] = new double[row][type];
    double colAvg[][] = new double[type][col];
    double rowSD[] = new double[row];
    double colSD[] = new double[col];
    
    //Sum & Count
    int val;
    double rowMid = (row-1) / 2.0, colMid = (col-1) / 2.0;
    for(i=0; i<row; i++){
        for(j=0; j<col; j++){
            //val = jcb[i][j].getSelectedIndex();
            val = ddg.matrix[i][j]-1;
            if(chkAbsolute.isSelected()){
                rowSum[i][val] += Math.abs(j-rowMid);
                colSum[val][j] += Math.abs(i-colMid);
            }else{
                rowSum[i][val] += (rowMid-j);
                colSum[val][j] += (colMid-i);
            }
            rowCount[i][val] ++;
            colCount[val][j] ++;
        }
    }
    
    //Row average
    for(i=0; i<row; i++){
        for(j=0; j<type; j++){
            if(rowSum[i][j] > 0)
                rowAvg[i][j] = rowSum[i][j] / rowCount[i][j];
            else
                rowAvg[i][j] = 0;
        }
    }
    double sum;
    double avg;
    
    //mahmudulfaisal@gmail.com
    //ameenuddin@yahoo.com
    
    //Column average
    for(i=0; i<type; i++){
        for(j=0; j<col; j++){
            if(colSum[i][j] > 0)
                colAvg[i][j] = colSum[i][j] / colCount[i][j];
            else
                colAvg[i][j] = 0;
        }
    }
    
    String res = "";
    double rowSDAvg = 0, colSDAvg = 0;
    
    for(i=0; i<row; i++){
        res = "";
        for(j=0; j<type; j++){
            
            res += ("Sum("+j+"):"+rowSum[i][j]+"  ");
        }
        sum = 0;
        for(j=0; j<type; j++){
            
            res += ("Avg("+j+"):"+rowAvg[i][j]+"  ");
            sum += rowAvg[i][j];
        }
        avg = sum / type;
        for(j=0; j<type; j++){
            sum += (avg-rowAvg[i][j])*(avg-rowAvg[i][j]);
        }
        rowSD[i] = Math.sqrt(sum/type);
        rowSDAvg += rowSD[i];
        txtRowResult[i][0].setText(res+"SD: "+rowSD[i]);
    }
    
    for(i=0; i<col; i++){
        res = "";
        for(j=0; j<type; j++){
            txtColResult[j][i].setText("Sum("+j+"):"+colSum[j][i]);
            txtColResult[j+type][i].setText("Avg("+j+"):"+colAvg[j][i]);
            
        }
        sum = 0;
        for(j=0; j<type; j++){
            
            sum += colAvg[j][i];
        }
        avg = sum / type;
        for(j=0; j<type; j++){
            sum += (avg-colAvg[j][i])*(avg-colAvg[j][i]);
        }
        colSD[i] = Math.sqrt(sum/type);
        colSDAvg += colSD[i];
        txtColResult[type+type][i].setText("SD: "+colSD[i]);
    }
    
    txtFinalCost.setText("" + (((rowSDAvg/row) + (colSDAvg/col))/2.0));
    txtDistance.setText(""+ddg.calculateDistance());
    txtDistribution.setText(ddg.calculateDistribution()+"");
    
}

public void actionPerformed(ActionEvent ae){
    calculate();
    
}
/**
 * @param args the command line arguments
 */
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new AutomationTester().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLayGen;
    private javax.swing.JButton btnReLay;
    private javax.swing.JButton btnShorten;
    private javax.swing.JButton btnSplit;
    private javax.swing.JCheckBox chkAbsolute;
    private javax.swing.JCheckBox chkDebug;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnAnal;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnColResult;
    private javax.swing.JPanel pnGrid;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnRowResult;
    private javax.swing.JPanel pnSummeryResult;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtCol;
    private javax.swing.JTextField txtDistance;
    private javax.swing.JTextField txtDistribution;
    private javax.swing.JTextField txtFinalCost;
    private javax.swing.JTextField txtRow;
    private javax.swing.JTextField txtTolerance;
    private javax.swing.JTextField txtUA;
    private javax.swing.JTextField txtUB;
    private javax.swing.JTextField txtX1;
    private javax.swing.JTextField txtX2;
    private javax.swing.JTextField txtY1;
    private javax.swing.JTextField txtY2;
    // End of variables declaration//GEN-END:variables
    
}