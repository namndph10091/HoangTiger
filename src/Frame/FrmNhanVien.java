/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Class.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrmNhanVien extends javax.swing.JInternalFrame {

  
    ArrayList<NhanVien> listNhanVien;
    Connection conn;    
    DefaultTableModel model;
    int index;
    public FrmNhanVien() throws SQLException {
        initComponents();
        
//      listNhanVien = new ArrayList<>();
        listNhanVien = fetchlist();
         model = (DefaultTableModel) tblList.getModel();
        this.initConnection();
        
        this.render(listNhanVien);
        listNhanVien = fetchlist();
        render(listNhanVien);
      //  this.loadTable();
    }


  protected void initConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=LAPTOP", dbuser = "lnd", dbpass = "abc";

            conn = DriverManager.getConnection(url, dbuser, dbpass);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

 protected ArrayList<NhanVien> fetchlist() throws SQLException {
        ArrayList<NhanVien> list = new ArrayList<NhanVien>();
        String url = "jdbc:sqlserver://localhost:1433;databaseName=LAPTOP", dboUserName = "lnd", dboPassword = "abc";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, dboUserName, dboPassword);
            String query = "Select * from NHANVIEN";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                String manv = rs.getString("MANV");
                String tennv = rs.getString("TENNV");
                String ngaysinh = rs.getString("NGAYSINH");
                String sdt = rs.getString("SDT");
                String diachi = rs.getString("DIACHI");
                String email = rs.getString("EMAIL");
                String gioitinh = rs.getString("GIOITINH");
                

                list.add(new NhanVien(manv, tennv, ngaysinh, sdt,diachi, email, gioitinh));
            }
        } catch (ClassNotFoundException ex) {
             ex.printStackTrace();
        }
        return list;
    }
 
  private void render(ArrayList<NhanVien> list) {
        DefaultTableModel model = (DefaultTableModel) tblList.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            NhanVien nv = list.get(i);
            model.addRow(new Object[]{nv.maNV, nv.name, nv.date, nv.phone, nv.address, nv.email, nv.gender});
        }
    }

//    public void fill(QLNV_Class nv) {
//        txtId.setText(nv.getMaNV());
//        txtIDNV.setText(nv.getId()+"");
//        txtName.setText(nv.getName());
//        txtDate.setText(nv.getDate());
//        txtPhone.setText(nv.getPhone());
//        txtAddress.setText(nv.getAddress());
//        txtEmail.setText(nv.getEmail());
//       
//    }
//      public void loadTable() {
//        String query = "select * from NHANVIEN";
//
//        try {
//            PreparedStatement ps = conn.prepareStatement(query);
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                String ma = rs.getString("MaTheLoai");
//                String ten = rs.getString("TenTheLoai");
//                TheLoai theLoai = new TheLoai(ma, ten);
//                listTheLoai.add(theLoai);
//
//                cboTheLoai.addItem(ten);
//                cboTheLoaiFire.addItem(ten);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(QLNV_Swing.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }


public void clear(){
    txtId.setText("");
    txtName.setText("");
    txtDate.setText("");
    txtPhone.setText("");
    txtAddress.setText("");
    txtEmail.setText("");
    cbogender.setSelectedItem(0);
    
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDeleete = new javax.swing.JButton();
        cbogender = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        setTitle("Nhân Viên");

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên NV", "Ngày Sinh", "Số Điện Thoại", "Địa Chỉ", "Email", "Giới Tính"
            }
        ));
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setText("Mã NV");

        jLabel2.setText("Tên NV");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Ngày sinh");

        jLabel4.setText("Email");

        jLabel5.setText("Giới tính");

        jLabel6.setText("SDT");

        jLabel7.setText("Địa chỉ");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/news.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/graphic-design.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDeleete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete (1).png"))); // NOI18N
        btnDeleete.setText("Delete");
        btnDeleete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleeteActionPerformed(evt);
            }
        });

        cbogender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Nhân Viên");

        btnClose.setBackground(new java.awt.Color(255, 153, 153));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnClose.setText("x");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbogender, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDate)
                    .addComponent(txtEmail)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addComponent(btnClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbogender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(40, 40, 40)))
                .addGap(35, 35, 35))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbogender, txtName});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
this.clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
      String manv = this.txtId.getText();
        String tennv = this.txtName.getText();
        String ngaysinh = this.txtDate.getText();
        String sdt = this.txtPhone.getText();
        String diachi = this.txtAddress.getText();
        String email = this.txtEmail.getText();
        String gioitinh = cbogender.getSelectedItem()+"";
        
        if(manv.length() == 0 || tennv.length() == 0 || ngaysinh.length() == 0 || sdt.length() == 0 || diachi.length() == 0 || email.length() == 0){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            return;
        }
        
     
        
try{       
        if (txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã Nhân Viên");
            txtId.requestFocus();
            return;
        } 
        else if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Tên Nhân Viên");
            txtName.requestFocus();
            return;
        }   else if (txtDate.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập Ngày Sinh");
                txtDate.requestFocus();
                return;
            }
        else if (txtPhone.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Số điện thoại");
            txtPhone.requestFocus();
            return;
        } else if (txtAddress.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Địa chỉ");
            txtAddress.requestFocus();
            return;
        }
         else if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Email");
            txtEmail.requestFocus();
            return;
        }
         String Email;
        Email = "\\w+@\\w+(\\.\\w+){1,2}";
        String FormatEmail = txtEmail.getText();
        if (!FormatEmail.matches(Email)) {
            JOptionPane.showMessageDialog(this, "Email đúng định dạng");
            txtEmail.requestFocus();
            return;
        }
           java.util.Date ngaySinh = null;
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        try {
            ngaySinh = sdf.parse(ngaysinh);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ngày nhập không hợp lệ!");
            return;
        }
        

}catch(Exception ex){
    JOptionPane.showMessageDialog(this, "Lỗi");
}

   String query = "INSERT INTO NHANVIEN(MANV,TENNV,NGAYSINH,SDT,DIACHI,EMAIL,GIOITINH) VALUES (?,?,?,?,?,?,?)";
        try {
       PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, manv);  
            ps.setString(2, tennv);
            ps.setString(3, ngaysinh);
            ps.setString(4, sdt);
            ps.setString(5, diachi);
            ps.setString(6, email);
            ps.setString(7, gioitinh);
            
            ps.execute();
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            listNhanVien.add(new NhanVien(manv, ngaysinh, sdt, tennv, query, email, tennv));
            model.addRow(new Object[]{manv , tennv, ngaysinh, sdt, diachi, email, gioitinh});
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

//String query = "INSERT INTO NHANVIEN(MANV,IDNV,TENNV,NGAYSINH,SDT,DIACHI,EMAIL) VALUES (?,?,?,?,?,?,?)";
//    
//        try {
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, manv);  
//            ps.setString(2, idnv);
//            ps.setString(3, tennv);
//            ps.setString(4, ngaysinh);
//            ps.setString(5, sdt);
//            ps.setString(6, diachi);
//            ps.setString(7, email);
//            
//            ps.execute();
//          //  ResultSet rs = ps.getResultSet();
//            JOptionPane.showMessageDialog(this, "Thêm thành công");
//
//            model.addRow(new Object[]{
//                manv,idnv , tennv, ngaysinh, sdt, diachi, email
//
//            });
//
//        } catch (SQLException ex) {
//            Logger.getLogger(QLNV_Class.class.getName()).log(Level.SEVERE, null, ex);
//        }

//String query = "INSERT INTO NHANVIEN(MANV,IDNV,TENNV,NGAYSINH,SDT,DIACHI,EMAIL) VALUES (?,?,?,?,?,?,?)";
//    
//        try {
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, manv);  
//            ps.setString(2, idnv);
//            ps.setString(3, tennv);
//            ps.setString(4, ngaysinh);
//            ps.setString(5, sdt);
//            ps.setString(6, diachi);
//            ps.setString(7, email);
//            
//            ps.execute();
//          //  ResultSet rs = ps.getResultSet();
//            JOptionPane.showMessageDialog(this, "Thêm thành công");
//
//            model.addRow(new Object[]{
//                manv,idnv , tennv, ngaysinh, sdt, diachi, email
//
//            });
//
//        } catch (SQLException ex) {
//            Logger.getLogger(QLNV_Class.class.getName()).log(Level.SEVERE, null, ex);
//        }
        

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String manv = this.txtId.getText();
        String tennv = this.txtName.getText();
        String ngaysinh = this.txtDate.getText();
        String sdt = this.txtPhone.getText();
        String diachi = this.txtAddress.getText();
        String email = this.txtEmail.getText();
        String gioitinh = cbogender.getSelectedItem()+"";
        int in = tblList.getSelectedRow();
        
        
        
        String query = "UPDATE NHANVIEN SET TENNV=?, NGAYSINH=?, SDT=?, DIACHI=?, EMAIL=?, GIOITINH=? WHERE MANV=?";
        try {
             PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, tennv);
            ps.setString(2, ngaysinh);
            ps.setString(3, sdt);
            ps.setString(4, diachi);
            ps.setString(5, email);
            ps.setString(6, gioitinh);
            ps.setString(7, manv);

            ps.execute();
            JOptionPane.showMessageDialog(this, "Update thành công!");
            NhanVien nv = new NhanVien(manv, tennv, ngaysinh, sdt, diachi, email, gioitinh);
            this.listNhanVien.set(in, nv);
            this.render(this.listNhanVien);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleeteActionPerformed
        int cf = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không!");
        if(cf == 0){
            int row= tblList.getSelectedRow();
            if(row == -1){
                return;
            }

            String query = "delete from NHANVIEN where MANV=? ";
            String manv = tblList.getValueAt(row,0).toString();

            try {
                PreparedStatement ps= conn.prepareStatement(query);
                ps.setString(1, manv);
                ps.execute();

                this.model.removeRow(row);
                this.listNhanVien.remove(row);
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                clear();
            } catch (SQLException ex) {
                Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleeteActionPerformed

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        int row= tblList.getSelectedRow();
        if(row == -1){
            return;
        }
        
        String ma= tblList.getValueAt(row, 0).toString();
        String ten= tblList.getValueAt(row, 1).toString();
        String ngaysinh= tblList.getValueAt(row, 2).toString();
        String sdt= tblList.getValueAt(row,3).toString();
        String diachi= tblList.getValueAt(row,4).toString();
        String email= tblList.getValueAt(row, 5).toString();
        String gender = tblList.getValueAt(row, 6).toString();
    
        
        txtId.setText(ma);
        txtName.setText(ten);
        txtDate.setText(ngaysinh);
        txtPhone.setText(sdt);
        txtAddress.setText(diachi);
        txtEmail.setText(email);
        cbogender.setSelectedItem(gender);
      
    }//GEN-LAST:event_tblListMouseClicked

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        
    }//GEN-LAST:event_txtNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDeleete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbogender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblList;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

    
}
