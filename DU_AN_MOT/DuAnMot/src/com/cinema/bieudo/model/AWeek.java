/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.bieudo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author thanh
 */
public class AWeek {

    private Date NgayTao;
    private float DoanhThu;

    public AWeek() {
    }

    public AWeek(Date NgayTao, float DoanhThu) {
        this.NgayTao = NgayTao;
        this.DoanhThu = DoanhThu;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public float getDoanhThu() {
        return DoanhThu;
    }

    public void setDoanhThu(float DoanhThu) {
        this.DoanhThu = DoanhThu;
    }
    
    public String getNgayTaoParseString(){
        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");        
        return fm.format(this.NgayTao);
    }

}
