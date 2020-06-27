/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.dao;


/**
 *
 * @author haivo
 */
public class GheDAO {
    public void insert(){
        String sql = "INSERT INTO GHE (MaGhe, MaPhongChieu) VALUES (?, ?)";
    }
    
    public void update(){
        String sql = "UPDATE GHE SET MaPhongChieu=? WHERE MaGhe=?";
    }
    
    public void delect(){
        String sql = "DELETE FROM GHE WHERE MaGhe=?";
    }
    
    
}
