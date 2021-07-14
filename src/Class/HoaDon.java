
package Class;

import Frame.*;

public class HoaDon {
    public String MAHD,MASP,TENSP,TENKH,SDTKH,DIACHI,NGAYMUA;
    public int SOLUONG,TONGTIEN;

    public HoaDon() {
    }

    public HoaDon(String MAHD, String MASP, String TENSP, String TENKH, String SDTKH, String DIACHI, String NGAYMUA, int SOLUONG, int TONGTIEN) {
        this.MAHD = MAHD;
        this.MASP = MASP;
        this.TENSP = TENSP;
        this.TENKH = TENKH;
        this.SDTKH = SDTKH;
        this.DIACHI = DIACHI;
        this.NGAYMUA = NGAYMUA;
        this.SOLUONG = SOLUONG;
        this.TONGTIEN = TONGTIEN;
    }

    public String getMAHD() {
        return MAHD;
    }

    public void setMAHD(String MAHD) {
        this.MAHD = MAHD;
    }

    public String getMASP() {
        return MASP;
    }

    public void setMASP(String MASP) {
        this.MASP = MASP;
    }

    public String getTENSP() {
        return TENSP;
    }

    public void setTENSP(String TENSP) {
        this.TENSP = TENSP;
    }

    public String getTENKH() {
        return TENKH;
    }

    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }

    public String getSDTKH() {
        return SDTKH;
    }

    public void setSDTKH(String SDTKH) {
        this.SDTKH = SDTKH;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getNGAYMUA() {
        return NGAYMUA;
    }

    public void setNGAYMUA(String NGAYMUA) {
        this.NGAYMUA = NGAYMUA;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public int getTONGTIEN() {
        return TONGTIEN;
    }

    public void setTONGTIEN(int TONGTIEN) {
        this.TONGTIEN = TONGTIEN;
    }

    @Override
    public String toString() {
        return "DON_HANG{" + "MAHD=" + MAHD + ", MASP=" + MASP + ", TENSP=" + TENSP + ", TENKH=" + TENKH + ", SDTKH=" + SDTKH + ", DIACHI=" + DIACHI + ", NGAYMUA=" + NGAYMUA + ", SOLUONG=" + SOLUONG + ", TONGTIEN=" + TONGTIEN + '}';
    }
    
    
    
    
}
