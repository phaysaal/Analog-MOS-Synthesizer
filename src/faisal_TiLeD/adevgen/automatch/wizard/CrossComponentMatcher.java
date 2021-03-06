/*
 * Wizard.java
 *
 * Created on July 27, 2007, 7:54 PM
 */

package faisal_TiLeD.adevgen.automatch.wizard;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author  TV
 */
public class CrossComponentMatcher extends javax.swing.JFrame implements fsActionListener{
    public static final int MAX = 10001;
    int lowerFactor[] = new int[MAX];
    int type;
    double unit_l, unit_w;    
    int parts[];
    String names[];
    String fullPath;
    boolean retry = false;
    int total;
    
    int rows, cols;
    
    
    JTextField txtParts[];
    JButton btnRecalculate;
    JButton btnSuggest;
    
    DragDropGrid ddg;
    
    class MatSize{
        public int row;
        public int col;
        
        public MatSize(int r, int c){
            set(r, c);
        }
        
        public void set(int r, int c){
            row = r;
            col = c;
        }
        
        public String get(){
            return row + "x" + col;
        }
    }
    
    Vector<MatSize> matsize[] = new Vector[MAX];
    
    class LocalAction implements ActionListener{
        
        
        public LocalAction() {
            
        }
        
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Suggest")){
                suggest();
            }else{
                generalAction();            
            }
        }
        
    }
    /** Creates new form Wizard
     * @param type
     * @param parts
     * @param unit_l 
     * @param unit_w 
     * @param path 
     * @param names 
     * 
     * 
     * 
     */
    public CrossComponentMatcher(int type, int parts[], double unit_l, double unit_w, String path, String names[]) {
        this.type = type;
        this.parts = parts;
        this.unit_l = unit_l;
        this.unit_w = unit_w;
        this.fullPath = path;
        this.names = names;
               
        initFactors();
        initComponents();
        lblPartSize.setText(unit_l + "x" + unit_w);
        
        pnGrid.add(ddg = new DragDropGrid());
        generateVariableComponents();
        ddg.addActionListener(this);
        btnRecalculate.doClick();
    }
    
    private void initFactors(){
        int i, j;
        
        for(i=0; i<MAX; i++){
            matsize[i] = new Vector<CrossComponentMatcher.MatSize>();
            matsize[i].add(new MatSize(1, i));
            lowerFactor[i] = 1;
        }
        int max = (int) java.lang.Math.sqrt(MAX);
        
        for(i=2; i <= max; i++){
            for(j=i+i; j<MAX; j+=i){
                if((j / i) > lowerFactor[j]){
                    matsize[j].add(new MatSize(i, j/i));
                    lowerFactor[j] = i;
                }
            }
        }
    }
    
    private void generateVariableComponents(){
        ((GridLayout)pn.getLayout()).setRows(type+2);
        int i,j;
        
        txtParts= new JTextField[type];
        
        pn.add(new JLabel("Component Name"));
        pn.add(new JLabel("Number Of Parts"));
        
        JLabel lbl;
        for(i = 0; i < type; i++){
            lbl = new JLabel(names[i]);
            pn.add(lbl);
            lbl.setOpaque(true);
            lbl.setBackground(ddg.color[i]);
            pn.add(txtParts[i] = new JTextField("" + parts[i]));           
        }
        
        btnRecalculate = new JButton("Re Calculate");
        btnRecalculate.addActionListener(new LocalAction());
        btnSuggest = new JButton("Suggest");
        btnSuggest.addActionListener(new LocalAction());
        pn.add(btnRecalculate);
        pn.add(btnSuggest);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pn = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPartSize = new javax.swing.JLabel();
        pnGrid = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cboArrangeType = new javax.swing.JComboBox();
        cboMatrix = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblCentroid = new javax.swing.JLabel();
        lblDisparity = new javax.swing.JLabel();
        lblPoint = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblInterDistance = new javax.swing.JLabel();
        chkSUA = new javax.swing.JCheckBox();
        txtAsym = new javax.swing.JTextField();
        txtDisp = new javax.swing.JTextField();
        txtCentroid = new javax.swing.JTextField();
        txtPoint = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtInterdistance = new javax.swing.JTextField();
        lblAsymmetry = new javax.swing.JLabel();
        chkCenterPower = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Wizard: Matching Simulator");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Previous");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setForeground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 36));
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("3. Matching Simulator");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pn.setBorder(javax.swing.BorderFactory.createTitledBorder("Customize"));
        pn.setLayout(new java.awt.GridLayout(1, 2));

        jLabel3.setText("Total:");

        jLabel5.setText("Matrix:");

        jLabel4.setText("Unit Size:");

        pnGrid.setLayout(new java.awt.BorderLayout());

        jLabel8.setText("Matching Model:");

        cboArrangeType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Linear Distribution", "Interdigitized Common Centroid", "Cross Coupling", "Single Line Symmetric", "Common Centroid (Hz Symmetric)", "Common Centroid (Vt Symmetric)", "Couple Average" }));
        cboArrangeType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboArrangeTypeActionPerformed(evt);
            }
        });

        jLabel6.setText("Disparity:");

        jLabel9.setText("Asymmetricity:");

        jLabel10.setText("Fitness Point:");

        lblCentroid.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), new java.awt.Color(255, 204, 255)));

        lblDisparity.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), new java.awt.Color(255, 204, 255)));

        lblPoint.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), new java.awt.Color(255, 204, 255)));

        jLabel7.setText("Centroidal:");

        lblInterDistance.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), new java.awt.Color(255, 204, 255)));

        chkSUA.setText("Show Unsupported Arrangements");
        chkSUA.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chkSUA.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel11.setText("Inter Distance:");

        lblAsymmetry.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 204, 204), null));

        chkCenterPower.setText("Center Power");
        chkCenterPower.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chkCenterPower.setMargin(new java.awt.Insets(0, 0, 0, 0));
        chkCenterPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCenterPowerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cboMatrix, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPartSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(cboArrangeType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkCenterPower))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel7)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel11)))
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblAsymmetry, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                                    .addComponent(lblCentroid, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                                    .addComponent(lblInterDistance, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                                    .addComponent(lblDisparity, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblPoint, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCentroid, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                            .addComponent(txtDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAsym, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                            .addComponent(txtInterdistance, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
                                    .addComponent(chkSUA)
                                    .addComponent(pn, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGap(6, 6, 6)
                        .addComponent(pnGrid, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addGap(198, 198, 198)))
                .addGap(0, 0, 0))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAsym, txtCentroid, txtDisp, txtInterdistance, txtPoint});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel6, jLabel7, jLabel9});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(pnGrid, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPartSize, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboMatrix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(chkCenterPower))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboArrangeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabel6))
                                .addComponent(jLabel9))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblAsymmetry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAsym))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDisparity, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCentroid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)
                                        .addComponent(lblCentroid, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInterDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInterdistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPoint))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkSUA)
                .addGap(16, 16, 16))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtAsym, txtCentroid, txtDisp, txtInterdistance, txtPoint});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCentroid, lblDisparity});

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-524)/2, (screenSize.height-706)/2, 524, 706);
    }// </editor-fold>//GEN-END:initComponents

private void chkCenterPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCenterPowerActionPerformed
    ddg.isCenterPower = chkCenterPower.isSelected();
}//GEN-LAST:event_chkCenterPowerActionPerformed

    public void actionPerformed() {
        showCalculations();
    }
    public void select(String s) {
        //showCalculations();
    }
    
    private double getPoint(double sym, double avg, double dis){
        return -(sym*20 + avg*60 + (-dis*10));
    }
    public void showCalculations(){
        //try{
            double sym = MatchingCalculator.getSymmetricity(ddg.matrix, parts);
            lblAsymmetry.setText(sym+"");
            txtAsym.setText(sym+"");
            double avg = MatchingCalculator.getAverage(ddg.matrix, parts);
            lblCentroid.setText(avg+"");
            txtCentroid.setText(avg+"");
            
//            double dis = MatchingCalculator.getDisparity(ddg.matrix, parts);
            double dis = MatchingCalculator.getInterDistance(ddg.matrix, parts);
            lblInterDistance.setText(dis+"");
            txtInterdistance.setText(dis+"");
            
            double disp = MatchingCalculator.getDisparity(ddg.matrix, parts);
            lblDisparity.setText(disp+"");
            txtDisp.setText(disp+"");
            double total = getPoint(sym, avg, dis);
            lblPoint.setText(total+"");
            txtPoint.setText(total+"");
            //retry = false;
        //}catch(Exception e){
            //JOptionPane.showMessageDialog(this, e+"\n"+ parts.length);
            //if(retry)
                //JOptionPane.showMessageDialog(this,"\n"+ "Sorry, impossible choice, try another" );
//            else{
//                retry = true;
//                btnRecalculate.doClick();
//                
//            }
        //}    
    }
    
    public boolean isMatrixValid(){
        boolean isValid = true;
        
        int i,j;
        int dummy[] = new int[parts.length];
        for(i=0; i<ddg.matrix.length; i++){
            for(j=0; j<ddg.matrix[i].length; j++){
                dummy[ddg.matrix[i][j]]++;
            }
        }
        
        for(i=0;i<dummy.length;i++){
            if(dummy[i] != parts[i]){
                isValid = false;
            }
        }
        return isValid;
    }
    
    public void makeTotal(){
        int total = 0;
        int i;
        for(i=0; i<type; i++){
            parts[i] = Integer.parseInt(txtParts[i].getText());
            total += parts[i];
        }
        
        if(this.total != total){
            cboMatrix.removeAllItems();
            for(i = matsize[total].size()-1; i >= 0 ; i--){
                cboMatrix.addItem(matsize[total].get(i).get());
            }
            this.total = total;
        }
        
        lblTotal.setText(""+total);
    }
    
    public void suggest(){
        int i,j;
        makeTotal();
        //int parts[] = new int[this.parts.length];        
        
        double sym;
        double avg;
        double dis;
        double total;
        
        double minPoint = Double.NEGATIVE_INFINITY;
        int ei = 0;
        int emode = 0;
        int matcount;
        if(cboMatrix.getItemCount() > 1)
            matcount = cboMatrix.getItemCount()-1;
        else
            matcount = 1;
        for(i=0; i<matcount; i++){
            cboMatrix.setSelectedIndex(i);           
            getRowsAndColumns();
            for(j=0; j<7; j++){
                if(j==3) continue;
                try{
                    ddg.init(rows, cols, parts, j); 
                    sym = MatchingCalculator.getSymmetricity(ddg.matrix, parts);        
                    avg = MatchingCalculator.getAverage(ddg.matrix,  parts);        
                    //dis = MatchingCalculator.getDisparity(ddg.matrix, parts);
                    dis = MatchingCalculator.getInterDistance(ddg.matrix, parts);
                    total = getPoint(sym, avg, dis);
                    if(total > minPoint){          
                        minPoint = total;
                        ei = i;
                        emode = j;
                    }
                }catch(Exception e){
                    if(chkSUA.isSelected())
                        JOptionPane.showMessageDialog(this,"\n"+ "Invalid Case [Row:" + rows + " Col:" + cols + " Mode:" + cboArrangeType.getItemAt(j) + "]\n");                        
                }                    
            }
        }
        cboMatrix.setSelectedIndex(ei);
        cboArrangeType.setSelectedIndex(emode);
        generalAction();
    }
    
    public void getRowsAndColumns(){
        //txtRows.setText(""+lowerFactor[total]);
        //txtColumns.setText(""+(total/lowerFactor[total]));
        //rows = lowerFactor[total];
        //cols = total / lowerFactor[total];
        int selInd = cboMatrix.getSelectedIndex();
        int size = matsize[total].size() - 1;
        rows = matsize[total].get(size-selInd).row;
        cols = matsize[total].get(size-selInd).col;        
//        String str = (String)cboMatrix.getSelectedItem();
//        String size[] = str.split("x");
//        rows = Integer.parseInt(size[0]);
//        cols = Integer.parseInt(size[1]);
    }
    
    public void generalAction(){
        //Linear Distribution, 
        //Interdigitized Common Centroid, 
        //Cross Coupling, 
        //Interdigitation (Symmetric), 
        //Common Centroid (Hz Symmetric), 
        //Common Centroid (Vt Symmetric), 
        //Couple Average
        
        int parts[] = new int[this.parts.length];        
        
               
        if(cboArrangeType.getSelectedIndex() == 0){
            makeTotal();
            System.arraycopy(this.parts, 0, parts, 0, this.parts.length) ;
            getRowsAndColumns();            
            ddg.init(rows, cols, parts,ddg.GENERAL_DISTRIBUTION);
            //"General Matrix, Interdigitation, Common Centroid"
        }else if(cboArrangeType.getSelectedIndex() == 1){
            makeTotal();
            System.arraycopy(this.parts, 0, parts, 0, this.parts.length) ;
            getRowsAndColumns();
                        
            ddg.init(rows, cols, parts,ddg.INTERDIZITIZED_COMMON_CENTROID); 
        }else if(cboArrangeType.getSelectedIndex() == 2){
            makeTotal();
            System.arraycopy(this.parts, 0, parts, 0, this.parts.length) ;
            getRowsAndColumns();
            
            ddg.init(rows, cols, parts,ddg.CROSS_COUPLE);
            
        }else if(cboArrangeType.getSelectedIndex() == 3){
            makeTotal();
            System.arraycopy(this.parts, 0, parts, 0, this.parts.length) ;
            rows = 1;
            cols = total;                        
            ddg.init(rows, cols, parts,ddg.INTERDIGITATION_SYMMETRIC);            
        }
        else if(cboArrangeType.getSelectedIndex() == 4){
            makeTotal();
            System.arraycopy(this.parts, 0, parts, 0, this.parts.length) ;
            getRowsAndColumns();
                        
            ddg.init(rows, cols, parts,ddg.COMMON_CENTROID_H_SYMMETRIC);            
        }else if(cboArrangeType.getSelectedIndex() == 5){
            makeTotal();
            System.arraycopy(this.parts, 0, parts, 0, this.parts.length) ;
            getRowsAndColumns();
                        
            ddg.init(rows, cols, parts,ddg.COMMON_CENTROID_V_SYMMETRIC);            
        }
        else if(cboArrangeType.getSelectedIndex() == 6){
            makeTotal();
            System.arraycopy(this.parts, 0, parts, 0, this.parts.length) ;
            getRowsAndColumns();
                        
            ddg.init(rows, cols, parts,ddg.COUPLE_AVERAGE);            
        }
        
        if(!isMatrixValid()){
            
            System.arraycopy(this.parts, 0, parts, 0, this.parts.length) ;
            ddg.init(rows, cols, parts,ddg.COMMON_CENTROID_V_SYMMETRIC);
        }
        showCalculations();
    }
    
    private void cboArrangeTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboArrangeTypeActionPerformed
        
}//GEN-LAST:event_cboArrangeTypeActionPerformed
    
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    dispose();
    ComponentParts.componentParts.setVisible(true);
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    //int type, String fullPath, double L, double W, String names[], int matrix[][]
    (new LayoutInfo(type, fullPath, unit_l, unit_w, names, ddg.matrix)).setVisible(true);
    setVisible(false);
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    dispose();
}//GEN-LAST:event_jButton1ActionPerformed

/**
 * @param args the command line arguments
 */
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Wizard().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboArrangeType;
    private javax.swing.JComboBox cboMatrix;
    private javax.swing.JCheckBox chkCenterPower;
    private javax.swing.JCheckBox chkSUA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAsymmetry;
    private javax.swing.JLabel lblCentroid;
    private javax.swing.JLabel lblDisparity;
    private javax.swing.JLabel lblInterDistance;
    private javax.swing.JLabel lblPartSize;
    private javax.swing.JLabel lblPoint;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pn;
    private javax.swing.JPanel pnGrid;
    private javax.swing.JTextField txtAsym;
    private javax.swing.JTextField txtCentroid;
    private javax.swing.JTextField txtDisp;
    private javax.swing.JTextField txtInterdistance;
    private javax.swing.JTextField txtPoint;
    // End of variables declaration//GEN-END:variables
    
}
