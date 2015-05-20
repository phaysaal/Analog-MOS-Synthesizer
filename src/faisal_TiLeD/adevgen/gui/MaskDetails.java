/*
 * MaskDetails.java
 *
 * Created on July 9, 2007, 12:44 PM
 */

package faisal_TiLeD.adevgen.gui;

import faisal_TiLeD.adevgen.datastructure.MaskRectangle;

/**
 *
 * @author  TV
 */
public class MaskDetails extends javax.swing.JDialog {
    
    /** Creates new form MaskDetails 
     * @param parent 
     * @param modal 
     */
    
    MaskRectangle mr;
           
    public MaskDetails(javax.swing.JFrame parent, boolean modal, MaskRectangle mask) {
        super(parent, modal);
        mr = mask;
        initComponents();
        setVisible(modal);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        rdoVertical = new javax.swing.JRadioButton();
        rdoHorizontal = new javax.swing.JRadioButton();
        rdoBoth = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        chkVariable = new javax.swing.JCheckBox();
        rdoVertical1 = new javax.swing.JRadioButton();
        rdoHorizontal1 = new javax.swing.JRadioButton();
        rdoBoth1 = new javax.swing.JRadioButton();
        chkIterated = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mask Options");

        jLabel2.setText("Orientation");

        buttonGroup1.add(rdoVertical);
        rdoVertical.setText("Vertical");
        rdoVertical.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdoVertical.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(rdoHorizontal);
        rdoHorizontal.setText("Horizontal");
        rdoHorizontal.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdoHorizontal.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(rdoBoth);
        rdoBoth.setSelected(true);
        rdoBoth.setText("Both");
        rdoBoth.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdoBoth.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel1.setText("Mask Type");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        chkVariable.setSelected(true);
        chkVariable.setText("Variable");
        chkVariable.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chkVariable.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup2.add(rdoVertical1);
        rdoVertical1.setSelected(true);
        rdoVertical1.setText("Vertical");
        rdoVertical1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdoVertical1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup2.add(rdoHorizontal1);
        rdoHorizontal1.setText("Horizontal");
        rdoHorizontal1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdoHorizontal1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup2.add(rdoBoth1);
        rdoBoth1.setText("Both");
        rdoBoth1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdoBoth1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        chkIterated.setText("Iterated");
        chkIterated.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chkIterated.setMargin(new java.awt.Insets(0, 0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(chkIterated)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(70, 70, 70))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkVariable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoBoth1)
                    .addComponent(rdoVertical1)
                    .addComponent(rdoHorizontal1)
                    .addComponent(rdoBoth)
                    .addComponent(rdoVertical)
                    .addComponent(rdoHorizontal)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoHorizontal)
                    .addComponent(chkVariable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoVertical)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoBoth)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoHorizontal1)
                    .addComponent(chkIterated))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoVertical1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoBoth1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // Cancel
    this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // OK
    int type = 0;
    
    if(chkVariable.isSelected()){
        type |= 0x08;
    }
    if(rdoVertical.isSelected()){
        type |= 0x01;
    }else if(rdoHorizontal.isSelected()){
        type |= 0x02;
    }else if(rdoBoth.isSelected()){
        type |= 0x03;
    }
    
    if(chkIterated.isSelected()){
        type |= 0x80;
    }
    if(rdoVertical1.isSelected()){
        type |= 0x10;
    }else if(rdoHorizontal1.isSelected()){
        type |= 0x20;
    }else if(rdoBoth1.isSelected()){
        type |= 0x30;
    }
    
    mr.setType(type);
    this.dispose();
}//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox chkIterated;
    private javax.swing.JCheckBox chkVariable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rdoBoth;
    private javax.swing.JRadioButton rdoBoth1;
    private javax.swing.JRadioButton rdoHorizontal;
    private javax.swing.JRadioButton rdoHorizontal1;
    private javax.swing.JRadioButton rdoVertical;
    private javax.swing.JRadioButton rdoVertical1;
    // End of variables declaration//GEN-END:variables
    
}
