/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.dao;

import java.util.List;

/**
 *
 * @author haivo
 */
public class PhongChieuDAO {
    public void insert(){
        String sql = "INSERT INTO PHONGCHIEU (MaPhongChieu, TenPhongChieu) VALUES (?, ?)";
    }
    
    public void update(){
        String sql = "UPDATE PHONGCHIEU SET TenPhongChieu=? WHERE MaPhongChieu=?";
    }
    
    public void delect(){
        String sql = "DELETE FROM PHONGCHIEU WHERE MaPhongChieu=?";
    }
}
