/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.model;

/**
 *
 * @author HuyPham
 */
public class GiaVe {
    private int maGiaVe;
    private Float giaVe;
    private String moTa;

    public GiaVe() {
    }

    public GiaVe(int maGiaVe, Float giaVe, String moTa) {
        this.maGiaVe = maGiaVe;
        this.giaVe = giaVe;
        this.moTa = moTa;
    }

    public int getMaGiaVe() {
        return maGiaVe;
    }

    public void setMaGiaVe(int maGiaVe) {
        this.maGiaVe = maGiaVe;
    }

    public Float getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(Float giaVe) {
        this.giaVe = giaVe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
