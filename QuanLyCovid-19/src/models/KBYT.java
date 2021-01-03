/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Dell
 */
public class KBYT {
    private int id;
    private String bhyt, nuocngoai, dauhieu, tiepxuc, thai, benh;
    
    public KBYT(){
        
    }
    public KBYT(int id, String bhyt, String nuocngoai, String dauhieu, String tiepxuc, String thai, String benh) {
        this.id = id;
        this.bhyt = bhyt;
        this.nuocngoai = nuocngoai;
        this.dauhieu = dauhieu;
        this.tiepxuc = tiepxuc;
        this.thai = thai;
        this.benh = benh;
    }

    public String getBenh() {
        return benh;
    }

    public void setBenh(String benh) {
        this.benh = benh;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBhyt() {
        return bhyt;
    }

    public void setBhyt(String bhyt) {
        this.bhyt = bhyt;
    }

    public String getNuocngoai() {
        return nuocngoai;
    }

    public void setNuocngoai(String nuocngoai) {
        this.nuocngoai = nuocngoai;
    }

    public String getDauhieu() {
        return dauhieu;
    }

    public void setDauhieu(String dauhieu) {
        this.dauhieu = dauhieu;
    }

    public String getTiepxuc() {
        return tiepxuc;
    }

    public void setTiepxuc(String tiepxuc) {
        this.tiepxuc = tiepxuc;
    }

    public String getThai() {
        return thai;
    }

    public void setThai(String thai) {
        this.thai = thai;
    }
    
}
