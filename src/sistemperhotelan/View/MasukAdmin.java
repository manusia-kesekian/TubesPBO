/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemperhotelan.View;
import sistemperhotelan.model.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author bijak
 */
public class MasukAdmin extends javax.swing.JFrame {
    Dashboard b;
    Karyawan worker;
    static final String DB_URL = "jdbc:mysql://localhost/tubespbo";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    /**
     * Creates new form UI
     */
    public MasukAdmin() {
        initComponents();
        b = new Dashboard();
        b.setVisible(false);
    }
    
    public void SaveDataKaryawan(String ID){
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `karyawan` WHERE `id_karyawan` = '"+ID+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                if ("Resepsionis".equals(rs.getString("posisi"))){
                    System.out.println("Resep");
                    worker = new Resepsionis(rs.getString("id_karyawan"), rs.getString("nama_karyawan"),rs.getString("gender_karyawan"),rs.getString("no_hp"),rs.getString("posisi"));
                } else{
                    System.out.println("lainnya");
                    worker = new Housekeeping(rs.getString("id_karyawan"), rs.getString("nama_karyawan"),rs.getString("gender_karyawan"),rs.getString("no_hp"),rs.getString("posisi"));
                }
                
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
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

        MasukSebagaiTamu = new javax.swing.JLabel();
        Login_Admin01 = new javax.swing.JTextField();
        Login_Admin02 = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        H1admin = new javax.swing.JLabel();
        Login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MasukSebagaiTamu.setText("<html> <u>Masuk Sebagai Tamu</u> </html> ");

        Login_Admin01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_Admin01ActionPerformed(evt);
            }
        });

        Login_Admin02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_Admin02ActionPerformed(evt);
            }
        });

        Email.setText("Email");

        Password.setText("Password");

        H1admin.setText("<html> <h1>Masuk Admin</h1> </html> ");

        Login.setText("Masuk");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(H1admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MasukSebagaiTamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(Login))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Password)
                            .addComponent(Email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Login_Admin01)
                            .addComponent(Login_Admin02, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(H1admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login_Admin01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login_Admin02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Password))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MasukSebagaiTamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Login))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login_Admin01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_Admin01ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Login_Admin01ActionPerformed

    private void Login_Admin02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_Admin02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Login_Admin02ActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        
        String email = Login_Admin01.getText();
        String pass = Login_Admin02.getText();
        System.out.println(email+" "+pass);
        String DBemail = "";
        String DBpass = "";
        String DBid_karyawan = "";
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM admin WHERE email='" + email + "' && password='" + pass+ "'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                DBemail = rs.getString("email");
                DBpass = rs.getString("password");
                DBid_karyawan = rs.getString("id_karyawan");
                System.out.println(rs.getString("email")+" "+ DBid_karyawan +" "+rs.getString("password"));
//                SELECT * FROM `karyawan` WHERE `id_karyawan` = 101
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (email.equals(DBemail) && pass.equals(DBpass)){
            System.out.print("Masuk");
            SaveDataKaryawan(DBid_karyawan);
            b.worker = worker;
            b.HaloAdmin1.setText("<html><h3>Halo, "+worker.getNama()+"</h3></html>");
            this.setVisible(false);
            b.setVisible(true);
            
        } else {
            System.out.print("Gagal");
            JOptionPane.showMessageDialog(this, "Gagal Login, Tolong Periksa Email Dan Password","Peringatan", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_LoginActionPerformed

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
            java.util.logging.Logger.getLogger(MasukAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasukAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasukAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasukAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasukAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email;
    private javax.swing.JLabel H1admin;
    private javax.swing.JButton Login;
    private javax.swing.JTextField Login_Admin01;
    private javax.swing.JTextField Login_Admin02;
    private javax.swing.JLabel MasukSebagaiTamu;
    private javax.swing.JLabel Password;
    // End of variables declaration//GEN-END:variables
}
