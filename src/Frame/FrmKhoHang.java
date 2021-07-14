/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Class.HangMay;
import Class.Laptop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class FrmKhoHang extends javax.swing.JInternalFrame {
    int index;
    protected ArrayList<Laptop> laptop;
    protected ArrayList<HangMay> hangmay;
    protected Connection conn;
    DefaultTableModel model;
    String hang34;
    
    public FrmKhoHang() {
        initComponents();
        
        laptop = new ArrayList();
        
        model = (DefaultTableModel) tblLaptop.getModel();
        
        initConnection();
        
        laptop = fetchlist();
        render(laptop);
        hangmay = fetchListHM();
        this.loadhangmay(hangmay);
    }

    protected void initConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=LAPTOP", dboUserName = "lnd", dboPassword="abc";
            
            conn = DriverManager.getConnection(url, dboUserName, dboPassword);       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmKhoHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmKhoHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected ArrayList<Laptop> fetchlist(){
        ArrayList<Laptop> ll = new ArrayList<Laptop>();
        String url = "jdbc:sqlserver://localhost:1433;databaseName=LAPTOP", dboUserName = "lnd", dboPassword="abc";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, dboUserName, dboPassword);
            String query = "Select * from SANPHAM";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(query);
            while(rs.next()){
                String ma = rs.getString("MASP");
                String ten = rs.getString("TENSP");
                int soluong = rs.getInt("TONKHO");
                int dongia = rs.getInt("DONGIA");
                String hang = rs.getString("HANG");
                String ngay = rs.getString("NGAYNHAP");
                String mota = rs.getString("MOTA");
                Laptop qq = new Laptop(ma, ten, soluong, dongia, hang, ngay, mota);
                ll.add(qq);
                model.addRow(new Object[]{ma, ten, soluong, dongia, hang, ngay, mota, qq.getStatus(soluong)});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmKhoHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmKhoHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ll;
    }
    
    private void render(ArrayList<Laptop> ll){
        DefaultTableModel model = (DefaultTableModel) tblLaptop.getModel();
        model.setRowCount(0);
        for(int i = 0; i < ll.size(); i++){
            Laptop qq = ll.get(i);
            model.addRow(new Object[]{qq.getMasp(), qq.getTensp(), qq.getSoluong(), qq.getDongia(), qq.getHang(), qq.getNgaynhap(), qq.getMota(), qq.getStatus(qq.getSoluong())});
        }
    }
    
    
    protected ArrayList<HangMay> fetchListHM(){
        ArrayList<HangMay> nn = new ArrayList<>();
        String query = "Select * from SANPHAM";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                String hangmay = rs.getString("HANG");
                
                HangMay hm = new HangMay(hangmay);
                nn.add(hm);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmKhoHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nn;
    }
    
    protected void loadhangmay(ArrayList<HangMay> mm){
        for(int i = 0; i < mm.size(); i++){
            HangMay hangmay = mm.get(i);
            
            cboHang.addItem(hangmay.getTenhang());
        }
    }
    
    public void fill(Laptop tt){
        txtMaSP.setText(tt.getMasp());
        txtTenSP.setText(tt.getTensp());
        txtSoLuonh.setText(tt.getSoluong()+"");
        txtDonGai.setText(tt.getDongia()+"");
        txtCauHinh.setText(tt.getMota());
        txtNgay.setText(tt.getNgaynhap());
    }

    
    
    private void clear(){
        txtCauHinh.setText("");
        txtCauHinh.setText("");
        txtDonGai.setText("");
        txtMaSP.setText("");
        txtNgay.setText("");
        txtSoLuonh.setText("");
        txtTenSP.setText("");
        cboHang.setSelectedItem(0);
        txtChuThich.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaptop = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuonh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        txtDonGai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboHang = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCauHinh = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtChuThich = new javax.swing.JTextArea();
        btnClose = new javax.swing.JButton();

        setTitle("Kho Hàng");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Kho Hàng");

        tblLaptop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Hãng", "Ngày Nhập", "Cấu hình ", "Chú Thích"
            }
        ));
        tblLaptop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLaptopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLaptop);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Mã SP");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Tên SP");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Số Lượng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Đơn Giá");

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/remove.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/update.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Cấu hình máy");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Hãng");

        cboHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHangActionPerformed(evt);
            }
        });

        txtCauHinh.setColumns(20);
        txtCauHinh.setRows(5);
        jScrollPane4.setViewportView(txtCauHinh);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Chú Thích");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Ngày Nhập");

        jScrollPane5.setFocusable(false);

        txtChuThich.setEditable(false);
        txtChuThich.setColumns(20);
        txtChuThich.setRows(5);
        jScrollPane5.setViewportView(txtChuThich);

        btnClose.setBackground(new java.awt.Color(255, 153, 153));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnClose.setText("x");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel1))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTenSP)
                                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDonGai, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                .addComponent(txtSoLuonh)
                                .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCapNhat, btnThem, btnXoa});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addComponent(btnClose))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtDonGai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtSoLuonh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnCapNhat))
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCapNhat, btnThem, btnXoa});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboHang, txtDonGai, txtMaSP, txtNgay, txtSoLuonh, txtTenSP});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblLaptopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLaptopMouseClicked
        int row = tblLaptop.getSelectedRow();
            if(row == -1){
                return;
            }
            String ma = tblLaptop.getValueAt(row, 0).toString();
            String ten = tblLaptop.getValueAt(row, 1).toString();
            String sl = tblLaptop.getValueAt(row, 2).toString();
            String dg = tblLaptop.getValueAt(row, 3).toString();
            String h = tblLaptop.getValueAt(row, 4).toString();
            String nn = tblLaptop.getValueAt(row, 5).toString();
            String mota = tblLaptop.getValueAt(row, 6).toString();
            String chuthich = tblLaptop.getValueAt(row, 7).toString();
            
            txtMaSP.setText(ma);
            txtTenSP.setText(ten);
            txtSoLuonh.setText(sl);
            txtDonGai.setText(dg);
            txtNgay.setText(nn);
            txtCauHinh.setText(mota);
            txtChuThich.setText(chuthich);
            cboHang.setSelectedItem(h);
       
    }//GEN-LAST:event_tblLaptopMouseClicked

    private void cboHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHangActionPerformed

    }//GEN-LAST:event_cboHangActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        //check
        String m = txtMaSP.getText();
        String t = txtTenSP.getText();
        int sl = Integer.parseInt(txtSoLuonh.getText()+"");
        String dg = txtDonGai.getText();
        String nn = txtNgay.getText();
        String ch = txtCauHinh.getText();
        String hang = cboHang.getSelectedItem()+"";
        Date ngaynhap1 = null;
        
        
        if(m.length() == 0 || t.length() == 0 || dg.length() == 0 || nn.length() == 0 || ch.length() == 0){
            JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin");
            return;
        }
        
        int s = Integer.parseInt(txtSoLuonh.getText());
        try {
            if(s < 1){
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                txtSoLuonh.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng là số");
            txtSoLuonh.requestFocus();
            return;
        }
        
        int d = Integer.parseInt(txtDonGai.getText());
        try {
            if(d < 1000000 || d > 1000000000){
                JOptionPane.showMessageDialog(this, "Giá từ 1 triệu đến 1 tỷ");
                txtDonGai.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đơn Giá là số");
            txtDonGai.requestFocus();
            return;
        }
        
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd");
            java.util.Date date = sdf.parse(nn);
            ngaynhap1 = new java.sql.Date(date.getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đúng định dạng ngày tháng");
            return;            
        }
        
        String query = "INSERT INTO SANPHAM(MASP, TENSP, TONKHO, DONGIA, HANG, NGAYNHAP, MOTA) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement psa = conn.prepareStatement(query);
            psa.setString(1, m);
            psa.setString(2, t);
            psa.setInt(3, sl);
            psa.setString(4, dg);
            psa.setString(5, hang);
            psa.setString(6, nn);
            psa.setString(7, ch);
            
            psa.execute();
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            
            Laptop oo = new Laptop(m, t, s, d, hang, nn, ch);
            laptop.add(oo);
            model.addRow(new Object[]{m, t, sl, dg, hang, nn, ch, oo.getStatus(s)});
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmKhoHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = this.tblLaptop.getSelectedRow();
        String query = "DELETE FROM SANPHAM WHERE MASP=?";
        String masp = tblLaptop.getValueAt(row, 0).toString();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, masp);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Xóa thành công");
               
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmKhoHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        laptop = fetchlist();
        this.render(laptop);
        
        clear();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int in = tblLaptop.getSelectedRow();
        
        String m = txtMaSP.getText();
        String t = txtTenSP.getText();
        String sl = txtSoLuonh.getText();
        String dg = txtDonGai.getText();
        String nn = txtNgay.getText();
        String ch = txtCauHinh.getText();
        String hang = cboHang.getSelectedItem()+"";
        Date ngaynhap1 = null;
        
        
        if(m.length() == 0 || t.length() == 0 || sl.length() == 0 || dg.length() == 0 || nn.length() == 0 || ch.length() == 0){
            JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin");
            return;
        }
        
        int s = Integer.parseInt(txtSoLuonh.getText());
        try {
            if(s < 1){
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                txtSoLuonh.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng là số");
            txtSoLuonh.requestFocus();
            return;
        }
        
        int d = Integer.parseInt(txtDonGai.getText());
        try {
            if(d < 1000000 || d > 1000000000){
                JOptionPane.showMessageDialog(this, "Giá từ 1 triệu đến 1 tỷ");
                txtDonGai.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đơn Giá là số");
            txtDonGai.requestFocus();
            return;
        }
        
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd");
            java.util.Date date = sdf.parse(nn);
            ngaynhap1 = new java.sql.Date(date.getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đúng định dạng ngày tháng");
            return;            
        }
        
        String query = "UPDATE SANPHAM SET TENSP=?, TONKHO=?, DONGIA=?, HANG=?, NGAYNHAP=?, MOTA=? " + "WHERE MASP=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, t);
            ps.setInt(2, s);
            ps.setString(3, dg);
            ps.setString(4, hang);
            ps.setString(5, nn);
            ps.setString(6, ch);
            ps.setString(7, m);

            
            ps.execute();
            JOptionPane.showMessageDialog(this, "Update thành công!");
            Laptop rt = new Laptop(m, t, s, d, hang, nn, ch);
            this.laptop.set(in, rt);
            this.render(this.laptop);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblLaptop;
    private javax.swing.JTextArea txtCauHinh;
    private javax.swing.JTextArea txtChuThich;
    private javax.swing.JTextField txtDonGai;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtSoLuonh;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
