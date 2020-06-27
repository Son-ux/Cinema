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
public class Ghe {
    private String maGhe;
    private int maPhongChieu;

    public Ghe(String maGhe, int maPhongChieu) {
        this.maGhe = maGhe;
        this.maPhongChieu = maPhongChieu;
    }

    public Ghe() {
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public int getMaPhongChieu() {
        return maPhongChieu;
    }

    public void setMaPhongChieu(int maPhongChieu) {
        this.maPhongChieu = maPhongChieu;
    }
    
    
}
