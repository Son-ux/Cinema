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
public class Phim {
    private int maPhim;
    private String tenPhim;
    private String nhaSanXuat;
    private int doTuoi;
    private int thoiLuong;
    private String ngayCongChieu;
    private String poster;
    private int maLoaiPhim;

    public Phim(int maPhim, String tenPhim, String nhaSanXuat, int doTuoi, int thoiLuong, String ngayCongChieu, String poster, int maLoaiPhim) {
        this.maPhim = maPhim;
        this.tenPhim = tenPhim;
        this.nhaSanXuat = nhaSanXuat;
        this.doTuoi = doTuoi;
        this.thoiLuong = thoiLuong;
        this.ngayCongChieu = ngayCongChieu;
        this.poster = poster;
        this.maLoaiPhim = maLoaiPhim;
    }

    public Phim() {
    }

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getDoTuoi() {
        return doTuoi;
    }

    public void setDoTuoi(int doTuoi) {
        this.doTuoi = doTuoi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getNgayCongChieu() {
        return ngayCongChieu;
    }

    public void setNgayCongChieu(String ngayCongChieu) {
        this.ngayCongChieu = ngayCongChieu;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getMaLoaiPhim() {
        return maLoaiPhim;
    }

    public void setMaLoaiPhim(int maLoaiPhim) {
        this.maLoaiPhim = maLoaiPhim;
    }
}
