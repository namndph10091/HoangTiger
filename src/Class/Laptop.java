/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author DELL
 */
public class Laptop {
    String masp, tensp;
    int soluong, dongia; 
    String hang, ngaynhap, mota;
    
    public String getStatus(int soluong){
        if(soluong <= 5) return "Cần Nhập Thêm";
        else return "";
    }
    
    public Laptop() {
    }

    public Laptop(String masp, String tensp, int soluong, int dongia, String hang, String ngaynhap, String mota) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.hang = hang;
        this.ngaynhap = ngaynhap;
        this.mota = mota;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return "laptop{" + "masp=" + masp + ", tensp=" + tensp + ", soluong=" + soluong + ", dongia=" + dongia + ", hang=" + hang + ", ngaynhap=" + ngaynhap + ", mota=" + mota + '}';
    }
    
    
    
}
