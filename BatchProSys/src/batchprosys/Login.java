/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchprosys;
//import com.apple.laf.AquaLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
//import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author prathibha
 */
public class Login extends javax.swing.JFrame {
    
ArrayList<User> userList;
DBOperations dbops = new DBOperations();
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    private static  String md5(String s){
        try {
            MessageDigest digs=MessageDigest.getInstance("MD5");
            digs.update(s.getBytes("UTF8"));
            String str=new String(digs.digest());
            return str;
        } catch (Exception ex) {
            return "";
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BPSTextField1 = new javax.swing.JTextField();
        BPSPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        BackgroundLayer1 = new javax.swing.JLabel();
        BackgroundLayer2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Batch Production System-Variosystems-Login");
        setPreferredSize(new java.awt.Dimension(1024, 768));
        getContentPane().setLayout(null);

        BPSTextField1.setBackground(new java.awt.Color(238, 237, 237));
        BPSTextField1.setFont(new java.awt.Font("Helvetica", 0, 18)); // NOI18N
        BPSTextField1.setForeground(new java.awt.Color(102, 102, 102));
        BPSTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BPSTextField1.setBorder(null);
        BPSTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPSTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(BPSTextField1);
        BPSTextField1.setBounds(522, 475, 250, 33);

        BPSPasswordField1.setBackground(new java.awt.Color(237, 237, 237));
        BPSPasswordField1.setFont(new java.awt.Font("Helvetica", 0, 18)); // NOI18N
        BPSPasswordField1.setForeground(new java.awt.Color(102, 102, 102));
        BPSPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BPSPasswordField1.setBorder(null);
        BPSPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BPSPasswordField1FocusGained(evt);
            }
        });
        BPSPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BPSPasswordField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BPSPasswordField1KeyReleased(evt);
            }
        });
        getContentPane().add(BPSPasswordField1);
        BPSPasswordField1.setBounds(522, 560, 250, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batchprosys/images/normal_mood.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(780, 164, 92, 500);

        BackgroundLayer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batchprosys/images/background.jpg"))); // NOI18N
        getContentPane().add(BackgroundLayer1);
        BackgroundLayer1.setBounds(0, 0, 1024, 768);

        BackgroundLayer2.setText("jLabel3");
        BackgroundLayer2.setPreferredSize(new java.awt.Dimension(1024, 768));
        getContentPane().add(BackgroundLayer2);
        BackgroundLayer2.setBounds(1030, 0, 1024, 768);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        ImageIcon II=new ImageIcon(getClass().getResource("/batchprosys/images/MOUSE_enter.png"));
        jLabel1.setIcon(II);
        
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        ImageIcon II=new ImageIcon(getClass().getResource("/batchprosys/images/MOUSE_CLICKED final.png"));
        jLabel1.setIcon(II);
        
        
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        ImageIcon II=new ImageIcon(getClass().getResource("/batchprosys/images/normal_mood.png"));
        jLabel1.setIcon(II);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
        // TODO add your handling code here:
        ImageIcon II=new ImageIcon(getClass().getResource("/batchprosys/images/MOUSE_enter.png"));
        jLabel1.setIcon(II);
        int Interface=dbops.OpenInterface(BPSTextField1.getText());
        int result=dbops.checkUserAvailability(BPSTextField1.getText());
        
        dbops.getUserName(BPSTextField1.getText());
        //User user=new User();
        //user.setUsername();
        if (result == 1) {
            int Check = dbops.checkUsernamePassword(BPSTextField1.getText(), BPSPasswordField1.getText());
            if (Check == 1) {
                if (Interface==1) {
                    AdminInterface2 ai = new AdminInterface2();
                    ai.setVisible(true);
                    ai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                }
                if (Interface==2) {
                    PManager pman = new PManager();
                    pman.setVisible(true);
                    pman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                }
                if (Interface==3) {
                    ProductionPlanner pplanner = new ProductionPlanner();
                    pplanner.setUserName();
                    //User user =userList.get(BPSTextField1.getText());
                    pplanner.setVisible(true);
                    pplanner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                }
                if (Interface==4) {
                    SectionLeader sleader = new SectionLeader();
                    sleader.setVisible(true);
                    sleader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                }
                

            } else if (Check == 0) {
                JOptionPane.showMessageDialog(this, "Username Password mismatch!");
                BPSTextField1.setText("");
                BPSPasswordField1.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error occured while checking username!");
                BPSTextField1.setText("");
                BPSPasswordField1.setText("");
            }
        }else if(result==0){
            JOptionPane.showMessageDialog(this, "You are not longer a valid user");
        }
        else{
            JOptionPane.showMessageDialog(this, "Error occured while checking Availability!");
        }
        //this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseReleased

    private void BPSTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPSTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BPSTextField1ActionPerformed

    private void BPSPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BPSPasswordField1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            ImageIcon II=new ImageIcon(getClass().getResource("/batchprosys/images/MOUSE_CLICKED final.png"));
        jLabel1.setIcon(II);
        int Interface=dbops.OpenInterface(BPSTextField1.getText());
        int result=dbops.checkUserAvailability(BPSTextField1.getText());
        
        dbops.getUserName(BPSTextField1.getText());
        //User user=new User();
        //user.setUsername();
        if (result == 1) {
            int Check = dbops.checkUsernamePassword(BPSTextField1.getText(), BPSPasswordField1.getText());
            if (Check == 1) {
                if (Interface==1) {
                    AdminInterface2 ai = new AdminInterface2();
                    ai.setVisible(true);
                    ai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                }
                if (Interface==2) {
                    PManager pman = new PManager();
                    pman.setVisible(true);
                    pman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                }
                if (Interface==3) {
                    ProductionPlanner pplanner = new ProductionPlanner();
                    pplanner.setUserName();
                    //User user =userList.get(BPSTextField1.getText());
                    pplanner.setVisible(true);
                    pplanner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                }
                if (Interface==4) {
                    SectionLeader sleader = new SectionLeader();
                    sleader.setVisible(true);
                    sleader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                }
                

            } else if (Check == 0) {
                JOptionPane.showMessageDialog(this, "Username Password mismatch!");
                BPSTextField1.setText("");
                BPSPasswordField1.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error occured while checking username!");
                BPSTextField1.setText("");
                BPSPasswordField1.setText("");
            }
        }else if(result==0){
            JOptionPane.showMessageDialog(this, "You are not longer a valid user");
            BPSTextField1.setText("");
            BPSPasswordField1.setText("");
        }
        else{
            JOptionPane.showMessageDialog(this, "Error occured while checking Availability!");
            BPSTextField1.setText("");
            BPSPasswordField1.setText("");
        }
        }
    }//GEN-LAST:event_BPSPasswordField1KeyPressed

    private void BPSPasswordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BPSPasswordField1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_BPSPasswordField1FocusGained

    private void BPSPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BPSPasswordField1KeyReleased
        ImageIcon II=new ImageIcon(getClass().getResource("/batchprosys/images/normal_mood.png"));
        jLabel1.setIcon(II);
    }//GEN-LAST:event_BPSPasswordField1KeyReleased

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    UIManager.setLookAndFeel(new AluminiumLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField BPSPasswordField1;
    private javax.swing.JTextField BPSTextField1;
    private javax.swing.JLabel BackgroundLayer1;
    private javax.swing.JLabel BackgroundLayer2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
