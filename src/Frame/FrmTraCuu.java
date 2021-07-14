/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Class.Hang;
import Class.SanPham;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class FrmTraCuu extends javax.swing.JInternalFrame {

    ArrayList<Hang> listHang;
    ArrayList<SanPham> listSP;
    ArrayList<SanPham> listSP2;
    protected Connection conn;
    public FrmTraCuu() {
        initComponents();
        
        this.listHang = new ArrayList<Hang>();
        this.listSP = new ArrayList<SanPham>();
        this.listSP2 = new ArrayList<SanPham>();
        
        this.conn = this.initConnection();
        
        this.listHang = this.fetListHang();
        this.loadHang(this.listHang);
        
        String hangDuocChon = this.cboHangFilter.getSelectedItem().toString();
        
        Hang hang = this.timHangTheoTen(hangDuocChon);
        
        this.listSP = this.fetchListSanPham(hang.getTenHang());
        this.listSP2 = this.fetchListSanPham2(hang.getTenHang());
        
        this.renderJTable(this.listSP);
    }

    protected Connection initConnection(){
        Connection conn = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String url = "jdbc:sqlserver://localhost:1433;databaseName=LAPTOP",
                   dbUsername = "lnd",
                   dbPassword = "abc";
            
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return conn;
    }
    protected ArrayList<Hang> fetListHang(){
        ArrayList<Hang> data = new ArrayList<Hang>();
        
        String query = "SELECT * FROM HANG";
        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("ID");
                String tenHang = rs.getString("TENHANG");
                
                data.add(new Hang(id, tenHang));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return data;
    }
    protected ArrayList<SanPham> fetchListSanPham(String HANG)
    {
        ArrayList<SanPham> data = new ArrayList<>();
        String hang = cboHangFilter.getSelectedItem()+"";
        String query = "SELECT * FROM SANPHAM WHERE HANG = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setString(1, hang);

            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                String maSP = rs.getString("MASP");
                String tenSP = rs.getString("TENSP");
                int tonKho = rs.getInt("TONKHO");
                int donGia = rs.getInt("DONGIA");
                String hangx = rs.getString("HANG");
                String ngayNhap = rs.getString("NGAYNHAP");
                String moTa = rs.getString("MOTA");
                
                
                SanPham sp = new SanPham(maSP, tenSP, hangx, ngayNhap, moTa, tonKho, donGia);
                
                data.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return data;
    }
    private void renderJTable(ArrayList<SanPham> data) {
        DefaultTableModel model = (DefaultTableModel) this.tblListSP.getModel();
        model.setRowCount(0);
        for (int i = 0; i < data.size(); i++) {
            SanPham sp = data.get(i);
            model.addRow(new Object[] {
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getTonKho(),
                sp.getDonGia(),
                sp.getHang(),
                sp.getNgayNhap(),
                sp.getMoTa()
            });
        }
    }
    protected void loadHang(ArrayList<Hang> listHang){
        for (int i = 0; i < listHang.size(); i++) {
            Hang hang = listHang.get(i);
            
            this.cboHangFilter.addItem(hang.getTenHang());
        }
    }
    protected Hang timHangTheoTen(String tenHang){
        Hang hang = null;
        
        for (int i = 0; i < this.listHang.size(); i++) {
            if (this.listHang.get(i).getTenHang().equals(tenHang)) {
                hang = this.listHang.get(i);
                break;
            }
        }
        
        return hang;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboHangFilter = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListSP = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();

        setTitle("Tra cứu");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Tìm kiếm sản phẩm");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 204, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSearchMousePressed(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Hãng");

        cboHangFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboHangFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHangFilterActionPerformed(evt);
            }
        });

        tblListSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Tồn kho", "Đơn giá", "Hãng", "Ngày nhập", "Cấu hình"
            }
        ));
        jScrollPane1.setViewportView(tblListSP);

        btnClose.setBackground(new java.awt.Color(255, 153, 153));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnClose.setText("x");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cboHangFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addComponent(btnClose))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel2)
                    .addComponent(cboHangFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSearch, cboHangFilter, txtSearch});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if(txtSearch.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm cần tìm kiếm!");
            return;
        }
        boolean check = false;
        for (int i = 0; i < listSP2.size(); i++) {
            if(txtSearch.getText().equalsIgnoreCase(listSP2.get(i).getTenSP())){
                JOptionPane.showMessageDialog(this, "Mã sản phẩm: " + listSP2.get(i).getMaSP()
                                                        + "\nTên sản phẩm: " + listSP2.get(i).getTenSP()
                                                        + "\nTồn kho: " + listSP2.get(i).getTonKho()
                                                        + "\nĐơn Giá: " + listSP2.get(i).getDonGia() + " VND"
                                                        + "\nHãng: " + listSP2.get(i).getHang()
                                                        + "\nNgày nhập: " + listSP2.get(i).getNgayNhap()
                                                        + "\nCấu hình: " + listSP2.get(i).getMoTa());
                check = true;
                break;
            }
        }
        if(check == false) JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm!");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        // TODO add your handling code here:
        btnSearch.setBackground(new java.awt.Color(255, 153, 255));
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMousePressed
        // TODO add your handling code here:
        btnSearch.setBackground(new java.awt.Color(255, 102, 255));
    }//GEN-LAST:event_btnSearchMousePressed

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        // TODO add your handling code here:
        btnSearch.setBackground(new java.awt.Color(255, 204, 255));
    }//GEN-LAST:event_btnSearchMouseExited

    private void cboHangFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHangFilterActionPerformed
        // TODO add your handling code here:
        String tenHang = this.cboHangFilter.getSelectedItem().toString();
        Hang hang = this.timHangTheoTen(tenHang);
        ArrayList<SanPham> data = this.fetchListSanPham(hang.getTenHang());
        this.renderJTable(data);
    }//GEN-LAST:event_cboHangFilterActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txtSearch.getText().length() == 0){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm cần tìm kiếm!");
                return;
            }
            boolean check = false;
            for (int i = 0; i < listSP2.size(); i++) {
                if(txtSearch.getText().equalsIgnoreCase(listSP2.get(i).getTenSP())){
                    JOptionPane.showMessageDialog(this, "Mã sản phẩm: " + listSP2.get(i).getMaSP()
                                                            + "\nTên sản phẩm: " + listSP2.get(i).getTenSP()
                                                            + "\nTồn kho: " + listSP2.get(i).getTonKho()
                                                            + "\nĐơn Giá: " + listSP2.get(i).getDonGia() + " VND"
                                                            + "\nHãng: " + listSP2.get(i).getHang()
                                                            + "\nNgày nhập: " + listSP2.get(i).getNgayNhap()
                                                            + "\nCấu hình: " + listSP2.get(i).getMoTa());
                    check = true;
                    break;
                }
            }
            if(check == false) JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm!");
        }
    }//GEN-LAST:event_txtSearchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboHangFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListSP;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
    protected ArrayList<SanPham> fetchListSanPham2(String HANG)
    {
        ArrayList<SanPham> data = new ArrayList<>();
        String query = "SELECT * FROM SANPHAM";

        try {
            PreparedStatement ps = this.conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                String maSP = rs.getString("MASP");
                String tenSP = rs.getString("TENSP");
                int tonKho = rs.getInt("TONKHO");
                int donGia = rs.getInt("DONGIA");
                String hangx = rs.getString("HANG");
                String ngayNhap = rs.getString("NGAYNHAP");
                String moTa = rs.getString("MOTA");
                
                
                SanPham sp = new SanPham(maSP, tenSP, hangx, ngayNhap, moTa, tonKho, donGia);
                
                data.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return data;
    }
}
