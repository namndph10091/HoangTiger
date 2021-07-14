/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Class.TaiKhoan;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;


/**
 *
 * @author pc
 */
public class FrmDangNhap extends javax.swing.JFrame {

    protected ArrayList<TaiKhoan> listTK;
    protected Connection conn;
    boolean check = false;
    
    public FrmDangNhap() {
        initComponents();
        setLocationRelativeTo(null);
        
        alertUsername.setVisible(false);
        alertPassword.setVisible(false);
        
        txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
        txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
        
        this.listTK = new ArrayList<TaiKhoan>();
        this.initConnection();
        this.listTK = this.fetchList();
        
    }

    protected void initConnection()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=LAPTOP",
                dbUsername = "lnd",
                dbPassword = "abc";

            this.conn = DriverManager.getConnection(url, dbUsername, dbPassword);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    protected ArrayList<TaiKhoan> fetchList()
    {
        ArrayList<TaiKhoan> data = new ArrayList<TaiKhoan>();

        String query = "SELECT * FROM TAIKHOAN";
        try {
            PreparedStatement ps = this.conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("IDNV");
                String user = rs.getString("USERNAME");
                String pass = rs.getString("PASSWORD");
                String role = rs.getString("ROLE");

                data.add(new TaiKhoan(id, user, pass, role));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return data;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        chkRemember = new javax.swing.JCheckBox();
        btnSignIn = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        alertUsername = new javax.swing.JLabel();
        alertPassword = new javax.swing.JLabel();
        lblForgetPassword = new javax.swing.JLabel();
        lblSignUp = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đăng nhập");

        jLabel1.setFont(new java.awt.Font("VNI-Bodon-Poster", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Laptop HoangTiger");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên đăng nhập");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        chkRemember.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkRemember.setText(" Nhớ mật khẩu");
        chkRemember.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkRemember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRememberActionPerformed(evt);
            }
        });

        btnSignIn.setBackground(new java.awt.Color(153, 153, 153));
        btnSignIn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSignIn.setText("Đăng nhập");
        btnSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSignInMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSignInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSignInMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSignInMousePressed(evt);
            }
        });
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        btnSignIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSignInKeyPressed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        alertUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/alert.png"))); // NOI18N

        alertPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/alert.png"))); // NOI18N

        lblForgetPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblForgetPassword.setForeground(new java.awt.Color(255, 0, 0));
        lblForgetPassword.setText("Quên mật khẩu?");
        lblForgetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblForgetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgetPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblForgetPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblForgetPasswordMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblForgetPasswordMousePressed(evt);
            }
        });

        lblSignUp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSignUp.setForeground(new java.awt.Color(0, 0, 204));
        lblSignUp.setText("Đăng ký");
        lblSignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSignUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSignUpMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSignUpMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("|");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 153));
        jLabel4.setText("ĐĂNG NHẬP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkRemember)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSignIn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblSignUp)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblForgetPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alertPassword)
                            .addComponent(alertUsername))))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtPassword, txtUsername});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alertUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(alertPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(chkRemember)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSignUp)
                    .addComponent(jLabel5)
                    .addComponent(lblForgetPassword))
                .addGap(18, 18, 18)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtPassword, txtUsername});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        // TODO add your handling code here:
        if(checkNull()) return;
        else if(checkPassword()) return;
        checkTK();
    }//GEN-LAST:event_btnSignInActionPerformed

    private void chkRememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRememberActionPerformed
        // TODO add your handling code here:
        if(chkRemember.isSelected() == true) JOptionPane.showMessageDialog(this, "Đã ghi nhớ tài khoản!");
    }//GEN-LAST:event_chkRememberActionPerformed

    private void btnSignInMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignInMousePressed
        // TODO add your handling code here:
        btnSignIn.setBackground(java.awt.Color.CYAN);
    }//GEN-LAST:event_btnSignInMousePressed

    private void btnSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignInMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSignInMouseClicked

    private void btnSignInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignInMouseExited
        // TODO add your handling code here:
        btnSignIn.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_btnSignInMouseExited

    private void btnSignInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignInMouseEntered
        // TODO add your handling code here:
        btnSignIn.setBackground(new java.awt.Color(204, 255, 255));
    }//GEN-LAST:event_btnSignInMouseEntered

    private void lblForgetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPasswordMouseClicked
        // TODO add your handling code here:
        FrmDoiMatKhau FrmDMK = new FrmDoiMatKhau();
        FrmDMK.show();
        this.dispose();
    }//GEN-LAST:event_lblForgetPasswordMouseClicked

    private void lblForgetPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPasswordMouseEntered
        // TODO add your handling code here:
        lblForgetPassword.setForeground(java.awt.Color.BLUE);
    }//GEN-LAST:event_lblForgetPasswordMouseEntered

    private void lblForgetPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPasswordMouseExited
        // TODO add your handling code here:
        lblForgetPassword.setForeground(new java.awt.Color(255, 0, 0));
    }//GEN-LAST:event_lblForgetPasswordMouseExited

    private void lblForgetPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPasswordMousePressed
        // TODO add your handling code here:
        lblForgetPassword.setForeground(new java.awt.Color(204, 0, 204));
    }//GEN-LAST:event_lblForgetPasswordMousePressed

    private void lblSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMouseClicked
        // TODO add your handling code here:
        String query = "SELECT * FROM TAIKHOAN";
        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getString(2).equals(txtUsername.getText()) && rs.getString(3).equals(txtPassword.getText())){
                    check = true;
                    if(rs.getString(4).equals("Admin")){
                        FrmDangKy frmDK = new FrmDangKy();
                        frmDK.show();
                        this.dispose();
                    }
                    break;
                }
            }
            if(check == false){
                JOptionPane.showMessageDialog(this, "Không thể đăng ký!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmDangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblSignUpMouseClicked

    private void lblSignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMouseEntered
        // TODO add your handling code here:
        lblSignUp.setForeground(java.awt.Color.RED);
    }//GEN-LAST:event_lblSignUpMouseEntered

    private void lblSignUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMouseExited
        // TODO add your handling code here:
        lblSignUp.setForeground(new java.awt.Color(0, 0, 204));
    }//GEN-LAST:event_lblSignUpMouseExited

    private void lblSignUpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMousePressed
        // TODO add your handling code here:
        lblSignUp.setForeground(new java.awt.Color(204, 0, 204));
    }//GEN-LAST:event_lblSignUpMousePressed

    private void btnSignInKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSignInKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSignInKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(checkNull()) return;
            else if(checkPassword()) return;
            checkTK();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(checkNull()) return;
            else if(checkPassword()) return;
            checkTK();
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

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
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertPassword;
    private javax.swing.JLabel alertUsername;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JCheckBox chkRemember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblForgetPassword;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
    private boolean checkNull(){
        if(txtUsername.getText().equals("")){
            if(txtPassword.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập gì!");
                txtUsername.requestFocus();
                txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                alertUsername.setVisible(true);
                alertPassword.setVisible(true);
                return true;
            }
            else{
                JOptionPane.showMessageDialog(this, "Tên đăng nhập không được để trống!");
                txtUsername.requestFocus();
                txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                alertUsername.setVisible(true);
                alertPassword.setVisible(false);
                return true;
            }
        }
        else if(txtPassword.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống!");
            txtPassword.requestFocus();
            txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
            txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
            alertUsername.setVisible(false);
            alertPassword.setVisible(true);
            return true;
        }
        return false;
    }
    private boolean checkPassword(){
        if(txtPassword.getText().length() < 8){
            JOptionPane.showMessageDialog(this, "Mật khẩu phải dài từ 8 kí tự trở lên!");
            txtPassword.requestFocus();
            txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
            txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
            alertUsername.setVisible(false);
            alertPassword.setVisible(true);
            return true;
        }
        return false;
    }
    private void checkTK(){
        initConnection();
        String query = "SELECT * FROM TAIKHOAN";
        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if(rs.getString(2).equals(txtUsername.getText()) && rs.getString(3).equals(txtPassword.getText())){
                    check = true;
                    if(rs.getString(4).equals("Admin")){
                        FrmTrangChu FrmTC = new FrmTrangChu();
                        FrmTC.show();
                        this.dispose();
                    }
//                    else if(rs.getString(4).equals("Nhân Viên")){
//                        FrmTrangChu2 FrmTC2 = new FrmTrangChu2();
//                        FrmTC2.show();
//                        this.dispose();
//                    }
//                    else if(rs.getString(4).equals("Khách Hàng")){
//                        FrmTrangChu3 FrmTC3 = new FrmTrangChu3();
//                        FrmTC3.show();
//                        this.dispose();
//                    }
                    break;
                }
            }
            if(check == false){
                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng!");
                txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                alertUsername.setVisible(true);
                alertPassword.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmDangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
