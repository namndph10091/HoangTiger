/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Class.TaiKhoan;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;


/**
 *
 * @author pc
 */
public class FrmDangKy extends javax.swing.JFrame {
    
    protected ArrayList<TaiKhoan> listTK;
    protected Connection conn;
    int check = 0;
    
    public FrmDangKy() {
        initComponents();
        setLocationRelativeTo(null);
        
        alertUsername.setVisible(false);
        alertPassword.setVisible(false);
        alertConfirmPassword.setVisible(false);
        alertRole.setVisible(false);
        
        txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
        txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
        txtConfirmPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
        
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
    public int insert(TaiKhoan tk){
        String query = "INSERT INTO TAIKHOAN(USERNAME, PASSWORD, ROLE)"
//                + " OUTPUT INSERTED.ID"
                + " VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setString(1, tk.getUsername());
            ps.setString(2, tk.getPassword());
            ps.setString(3, tk.getRole());

            ps.execute();
//            ResultSet rs = ps.getResultSet();
//            rs.next();
//
//            return rs.getInt("IDNV");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return -1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btnCreateAccount = new javax.swing.JButton();
        btnSignInNow = new javax.swing.JButton();
        alertUsername = new javax.swing.JLabel();
        alertPassword = new javax.swing.JLabel();
        alertConfirmPassword = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdoAdmin = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        rdoUser = new javax.swing.JRadioButton();
        alertRole = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tạo tài khoản");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("VNI-Bodon-Poster", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Laptop HoangTiger");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên đăng nhập");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        txtConfirmPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfirmPasswordKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nhập lại mật khẩu");

        btnCreateAccount.setBackground(new java.awt.Color(204, 204, 204));
        btnCreateAccount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCreateAccount.setText("Tạo tài khoản");
        btnCreateAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCreateAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCreateAccountMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCreateAccountMousePressed(evt);
            }
        });
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        btnSignInNow.setBackground(new java.awt.Color(204, 204, 204));
        btnSignInNow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSignInNow.setText("Đăng nhập ngay");
        btnSignInNow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignInNow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSignInNowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSignInNowMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSignInNowMousePressed(evt);
            }
        });
        btnSignInNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInNowActionPerformed(evt);
            }
        });

        alertUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/alert.png"))); // NOI18N

        alertPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/alert.png"))); // NOI18N

        alertConfirmPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/alert.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Chức vụ");

        buttonGroup1.add(rdoAdmin);
        rdoAdmin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoAdmin.setText("Admin");
        rdoAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdoAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdoAdminKeyPressed(evt);
            }
        });

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoNhanVien.setText("Nhân viên");
        rdoNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdoNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdoNhanVienKeyPressed(evt);
            }
        });

        buttonGroup1.add(rdoUser);
        rdoUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoUser.setText("User");
        rdoUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdoUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdoUserKeyPressed(evt);
            }
        });

        alertRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/alert.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 102));
        jLabel7.setText("Tạo tài khoản mới");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alertUsername)
                            .addComponent(alertPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreateAccount)
                            .addComponent(btnSignInNow)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoAdmin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdoNhanVien)
                                        .addGap(10, 10, 10)
                                        .addComponent(rdoUser)
                                        .addGap(8, 8, 8))
                                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alertConfirmPassword)
                                    .addComponent(alertRole))))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(128, 128, 128))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCreateAccount, btnSignInNow});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(alertUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(alertPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(alertConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(rdoAdmin)
                        .addComponent(rdoNhanVien)
                        .addComponent(rdoUser))
                    .addComponent(alertRole, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSignInNow, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtConfirmPassword, txtPassword, txtUsername});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCreateAccount, btnSignInNow});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateAccountMousePressed
        // TODO add your handling code here:
        btnCreateAccount.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_btnCreateAccountMousePressed

    private void btnCreateAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateAccountMouseExited
        // TODO add your handling code here:
        btnCreateAccount.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnCreateAccountMouseExited

    private void btnSignInNowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignInNowMousePressed
        // TODO add your handling code here:
        btnSignInNow.setBackground(new Color(255, 255, 102));
    }//GEN-LAST:event_btnSignInNowMousePressed

    private void btnSignInNowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignInNowMouseExited
        // TODO add your handling code here:
        btnSignInNow.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnSignInNowMouseExited

    private void btnCreateAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateAccountMouseEntered
        // TODO add your handling code here:
        btnCreateAccount.setBackground(new Color(255, 204, 204));
    }//GEN-LAST:event_btnCreateAccountMouseEntered

    private void btnSignInNowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignInNowMouseEntered
        // TODO add your handling code here:
        btnSignInNow.setBackground(new Color(255, 255, 204));
    }//GEN-LAST:event_btnSignInNowMouseEntered

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        // TODO add your handling code here:
        if(checkNull()) return;
        else if(checkPassword()) return;
        else if(checkConfirmPassword()) return;
        else if(checkRole()) return;
        
        for(TaiKhoan x: listTK){
            if(x.getUsername().equals(txtUsername.getText())){
                JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!");
                txtUsername.requestFocus();
                return;
            }
        }
        
        add();
        
        JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công!");
        check = 1;
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void btnSignInNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInNowActionPerformed
        // TODO add your handling code here:
        if(check != 1){
            JOptionPane.showMessageDialog(this, "Chưa thể đăng nhập");
            return;
        }
        
        FrmDangNhap FrmDN = new FrmDangNhap();
        FrmDN.show();
        this.dispose();
    }//GEN-LAST:event_btnSignInNowActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        FrmDangNhap FrmDN = new FrmDangNhap();
        FrmDN.show();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(checkNull()) return;
            else if(checkPassword()) return;
            else if(checkConfirmPassword()) return;
            else if(checkRole()) return;

            for(TaiKhoan x: listTK){
                if(x.getUsername().equals(txtUsername.getText())){
                    JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!");
                    txtUsername.requestFocus();
                    return;
                }
            }

            add();

            JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công!");
            check = 1;
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(checkNull()) return;
            else if(checkPassword()) return;
            else if(checkConfirmPassword()) return;
            else if(checkRole()) return;

            for(TaiKhoan x: listTK){
                if(x.getUsername().equals(txtUsername.getText())){
                    JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!");
                    txtUsername.requestFocus();
                    return;
                }
            }

            add();

            JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công!");
            check = 1;
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtConfirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(checkNull()) return;
            else if(checkPassword()) return;
            else if(checkConfirmPassword()) return;
            else if(checkRole()) return;

            for(TaiKhoan x: listTK){
                if(x.getUsername().equals(txtUsername.getText())){
                    JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!");
                    txtUsername.requestFocus();
                    return;
                }
            }

            add();

            JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công!");
            check = 1;
        }
    }//GEN-LAST:event_txtConfirmPasswordKeyPressed

    private void rdoAdminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdoAdminKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(checkNull()) return;
            else if(checkPassword()) return;
            else if(checkConfirmPassword()) return;
            else if(checkRole()) return;

            for(TaiKhoan x: listTK){
                if(x.getUsername().equals(txtUsername.getText())){
                    JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!");
                    txtUsername.requestFocus();
                    return;
                }
            }

            add();

            JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công!");
            check = 1;
        }
    }//GEN-LAST:event_rdoAdminKeyPressed

    private void rdoNhanVienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdoNhanVienKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(checkNull()) return;
            else if(checkPassword()) return;
            else if(checkConfirmPassword()) return;
            else if(checkRole()) return;

            for(TaiKhoan x: listTK){
                if(x.getUsername().equals(txtUsername.getText())){
                    JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!");
                    txtUsername.requestFocus();
                    return;
                }
            }

            add();

            JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công!");
            check = 1;
        }
    }//GEN-LAST:event_rdoNhanVienKeyPressed

    private void rdoUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdoUserKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(checkNull()) return;
            else if(checkPassword()) return;
            else if(checkConfirmPassword()) return;
            else if(checkRole()) return;

            for(TaiKhoan x: listTK){
                if(x.getUsername().equals(txtUsername.getText())){
                    JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!");
                    txtUsername.requestFocus();
                    return;
                }
            }

            add();

            JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công!");
            check = 1;
        }
    }//GEN-LAST:event_rdoUserKeyPressed

    private void add(){
        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();
        String role = null;
        if(rdoAdmin.isSelected() == true) role = "Admin";
        else if(rdoNhanVien.isSelected() == true) role = "Nhân Viên";
        else if(rdoUser.isSelected() == true) role = "Khách Hàng";

        TaiKhoan tk = new TaiKhoan(0, username, password, role);

        int id = this.insert(tk);
        tk.setId(id);
        this.listTK.add(tk);
    }
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
            java.util.logging.Logger.getLogger(FrmDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertConfirmPassword;
    private javax.swing.JLabel alertPassword;
    private javax.swing.JLabel alertRole;
    private javax.swing.JLabel alertUsername;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnSignInNow;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton rdoAdmin;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoUser;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
    private boolean checkNull(){
        if( txtUsername.getText().equals("") &&
            txtPassword.getText().equals("") &&
            txtConfirmPassword.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập gì!");
                txtUsername.requestFocus();
                txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                txtConfirmPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                alertUsername.setVisible(true);
                alertPassword.setVisible(true);
                alertConfirmPassword.setVisible(true);
                return true;
        }
        if(txtUsername.getText().equals("")){
            if(txtPassword.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Tên đăng nhập và mật khẩu đang bị trống!");
                txtUsername.requestFocus();
                txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                txtConfirmPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                alertUsername.setVisible(true);
                alertPassword.setVisible(true);
                alertConfirmPassword.setVisible(false);
                return true;
            }
            else if(txtConfirmPassword.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Tên đăng nhập và xác nhận mật khẩu không được để trống!");
                txtUsername.requestFocus();
                txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                txtConfirmPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                alertUsername.setVisible(true);
                alertPassword.setVisible(false);
                alertConfirmPassword.setVisible(true);
                return true;
            }
            else{
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên đăng nhập!");
                txtUsername.requestFocus();
                txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                txtConfirmPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                alertUsername.setVisible(true);
                alertPassword.setVisible(false);
                alertConfirmPassword.setVisible(false);
                return true;
            }
        }
        if(txtPassword.getText().equals("")){
            if(txtConfirmPassword.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Mật khẩu và xác nhận mật khẩu không được null!");
                txtPassword.requestFocus();
                txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                txtConfirmPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                alertUsername.setVisible(false);
                alertPassword.setVisible(true);
                alertConfirmPassword.setVisible(true);
                return true;
            }
            else{
               JOptionPane.showMessageDialog(this, "Mật khẩu đang rỗng!");
                txtPassword.requestFocus();
                txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
                txtConfirmPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                alertUsername.setVisible(false);
                alertPassword.setVisible(true);
                alertConfirmPassword.setVisible(false);
                return true;     
            }
        }
        else if(txtConfirmPassword.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Bạn chưa xác nhận mật khẩu!");
            txtConfirmPassword.requestFocus();
            txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
            txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
            txtConfirmPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
            alertUsername.setVisible(false);
            alertPassword.setVisible(false);
            alertConfirmPassword.setVisible(true);
            return true;
        }
        if( !txtUsername.getText().equals("") &&
            !txtPassword.getText().equals("") &&
            !txtConfirmPassword.getText().equals("")){
                txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                txtConfirmPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                alertUsername.setVisible(false);
                alertPassword.setVisible(false);
                alertConfirmPassword.setVisible(false);
        }
        return false;
    }
    private boolean checkPassword(){
        if(txtPassword.getText().length() < 8){
            JOptionPane.showMessageDialog(this, "Mật khẩu phải dài từ 8 kí tự trở lên!");
            txtPassword.requestFocus();
            txtUsername.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
            txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
            alertPassword.setVisible(true);
            return true;
        }
        return false;
    }
    private boolean checkConfirmPassword(){
        if(!txtPassword.getText().equals(txtConfirmPassword.getText())){
            JOptionPane.showMessageDialog(this, "Mật khẩu và xác nhận mật khẩu không trùng khớp!");
            txtPassword.requestFocus();
            txtPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
            txtConfirmPassword.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
            alertPassword.setVisible(true);
            alertConfirmPassword.setVisible(true);
            return true;
        }
        return false;
    }
    private boolean checkRole(){
        if(rdoAdmin.isSelected() == false && rdoNhanVien.isSelected() == false && rdoUser.isSelected() == false){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn chức vụ!");
            alertRole.setVisible(true);
            return true;
        }
        else{
            alertRole.setVisible(false);
        }
        return false;
    }
}
