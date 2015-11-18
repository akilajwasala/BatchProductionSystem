/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchprosys;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author prathibha
 */
public class UpdateAccountAdmin2 extends javax.swing.JFrame {

    DBOperations dbops = new DBOperations();
    
    
    public UpdateAccountAdmin2() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    void setFields(User user){
        
        jlblUserID.setText(user.getUserID());
        jlblUserName.setText(user.getUsername());
        jlblUserType.setText(user.getUserType());
        jlblUserSection.setText(user.getSection());
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUserID = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblUserType = new javax.swing.JLabel();
        lblUserSection = new javax.swing.JLabel();
        lblSetUserType = new javax.swing.JLabel();
        ddUserType = new javax.swing.JComboBox();
        lblSetSection = new javax.swing.JLabel();
        ddSetSection = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jlblUserID = new javax.swing.JLabel();
        jlblUserName = new javax.swing.JLabel();
        jlblUserType = new javax.swing.JLabel();
        jlblUserSection = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Account");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Update User Designation"));

        lblUserID.setText("User_ID:");

        lblUserName.setText("User Name:");

        lblUserType.setText("User Type:");

        lblUserSection.setText("User Section:");

        lblSetUserType.setText("Set User Type:");

        ddUserType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Production Manager", "Production Planner", "Section Leader" }));

        lblSetSection.setText("Set Section:");

        ddSetSection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Pre Work", "Assembly Line", "Wave Soldering", "Quality Control", "Testing", "Final", "Packing" }));
        ddSetSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddSetSectionActionPerformed(evt);
            }
        });

        jButton1.setText("Update Account");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSetUserType)
                    .addComponent(lblSetSection)
                    .addComponent(lblUserID)
                    .addComponent(lblUserName)
                    .addComponent(lblUserType)
                    .addComponent(lblUserSection))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlblUserSection)
                    .addComponent(jlblUserType)
                    .addComponent(jlblUserName)
                    .addComponent(jlblUserID)
                    .addComponent(ddUserType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ddSetSection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ddSetSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUserID)
                            .addComponent(jlblUserID))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUserName)
                            .addComponent(jlblUserName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUserType)
                            .addComponent(jlblUserType))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUserSection)
                            .addComponent(jlblUserSection))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSetUserType)
                            .addComponent(ddUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSetSection)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        User user=new User();
        user.setUserID(jlblUserID.getText());
        user.setUserType(ddUserType.getSelectedItem().toString());//Drop down indexes : 0,1,2,3....
        //user.setUsername(txtUsername.getText());
        user.setSection(ddSetSection.getSelectedItem().toString());
        
        String a=ddUserType.getSelectedItem().toString();
        String b=ddSetSection.getSelectedItem().toString();
        
        if(!dbops.updateUser(user)){
            JOptionPane.showMessageDialog(this,"Error while Updating... !");
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        else {
            
        
            if ("Production Planner".equals(a) && !("None".equals(b))){
                JOptionPane.showMessageDialog(this, "Error occured. Only Section leaders have sections");
            }
            else if ("Production Manager".equals(a) && !("None".equals(b))){
                JOptionPane.showMessageDialog(this, "Error occured. Only Section leaders have sections");
            }
            else if ("Section Leader".equals(a) && ("None".equals(b))){
                JOptionPane.showMessageDialog(this, "Please select the section");
            }
            else {
                JOptionPane.showMessageDialog(this,"Successfully Update !");
                jlblUserType.setText(a);
                jlblUserSection.setText(b);
                return;
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ddSetSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddSetSectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddSetSectionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateAccountAdmin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateAccountAdmin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateAccountAdmin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateAccountAdmin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateAccountAdmin2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ddSetSection;
    private javax.swing.JComboBox ddUserType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlblUserID;
    private javax.swing.JLabel jlblUserName;
    private javax.swing.JLabel jlblUserSection;
    private javax.swing.JLabel jlblUserType;
    private javax.swing.JLabel lblSetSection;
    private javax.swing.JLabel lblSetUserType;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserSection;
    private javax.swing.JLabel lblUserType;
    // End of variables declaration//GEN-END:variables
}
