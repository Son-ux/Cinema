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
public class Ve {
    private String maVe;
    private String ngayTao;
    private int maLichChieu;
    private String maGhe;
    private int maGiaVe;
    private String maTaiKhoan;
    private Float giaVe;

    public Ve(String maVe, String ngayTao, int maLichChieu, String maGhe, int maGiaVe, String maTaiKhoan, float giaVe) {
        this.maVe = maVe;
        this.ngayTao = ngayTao;
        this.maLichChieu = maLichChieu;
        this.maGhe = maGhe;
        this.maGiaVe = maGiaVe;
        this.maTaiKhoan = maTaiKhoan;
        this.giaVe = giaVe;
    }

    public Ve() {
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getMaLichChieu() {
        return maLichChieu;
    }

    public void setMaLichChieu(int maLichChieu) {
        this.maLichChieu = maLichChieu;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public int getMaGiaVe() {
        return maGiaVe;
    }

    public void setMaGiaVe(int maGiaVe) {
        this.maGiaVe = maGiaVe;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public Float getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(Float giaVe) {
        this.giaVe = giaVe;
    }
    
    
    
    
}
