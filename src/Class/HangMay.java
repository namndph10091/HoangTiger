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
public class HangMay {
    String tenhang;

    public HangMay() {
    }

    public HangMay(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    @Override
    public String toString() {
        return "hangmay{" + "tenhang=" + tenhang + '}';
    }
    
    
}
