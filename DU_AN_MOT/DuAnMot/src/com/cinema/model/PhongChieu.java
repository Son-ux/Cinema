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
public class PhongChieu {
    private int maPhongChieu;
    private String tenPhongChieu;

    public PhongChieu(int maPhongChieu, String tenPhongChieu) {
        this.maPhongChieu = maPhongChieu;
        this.tenPhongChieu = tenPhongChieu;
    }

    public PhongChieu() {
    }

    public int getMaPhongChieu() {
        return maPhongChieu;
    }

    public void setMaPhongChieu(int maPhongChieu) {
        this.maPhongChieu = maPhongChieu;
    }

    public String getTenPhongChieu() {
        return tenPhongChieu;
    }

    public void setTenPhongChieu(String tenPhongChieu) {
        this.tenPhongChieu = tenPhongChieu;
    }
    
    
}
