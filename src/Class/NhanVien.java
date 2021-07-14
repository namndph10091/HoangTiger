/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class NhanVien implements Serializable {
    public String maNV,name,date,phone,address,email,gender;

    public NhanVien(String maNV, String name, String date, String phone, String address, String email, String gender) {
        this.maNV = maNV;
        this.name = name;
        this.date = date;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.gender = gender;
    }

    public NhanVien() {
    }

    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "QLNV_Class{" + "maNV=" + maNV + ", name=" + name + ", date=" + date + ", phone=" + phone + ", address=" + address + ", email=" + email + ", gender=" + gender + '}';
    }

   
    
    
}
