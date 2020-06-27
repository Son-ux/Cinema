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
public class LichChieu {
    private int maLichChieu;
    private String ngayChieu;
    private String gioChieu;
    private int maPhim;
    private int maPhongChieu;

    public LichChieu(int maLichChieu, String ngayChieu, String gioChieu, int maPhim, int maPhongChieu) {
        this.maLichChieu = maLichChieu;
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
        this.maPhim = maPhim;
        this.maPhongChieu = maPhongChieu;
    }

    public LichChieu() {
    }

    public int getMaLichChieu() {
        return maLichChieu;
    }

    public void setMaLichChieu(int maLichChieu) {
        this.maLichChieu = maLichChieu;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public String getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(String gioChieu) {
        this.gioChieu = gioChieu;
    }

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public int getMaPhongChieu() {
        return maPhongChieu;
    }

    public void setMaPhongChieu(int maPhongChieu) {
        this.maPhongChieu = maPhongChieu;
    }
}
