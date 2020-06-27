/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.dao;

import com.cinema.helper.JdbcHelper;
import com.cinema.model.LichChieu;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haivo
 */
public class LichChieuDAO {
    public void insert(){
        String sql = "INSERT INTO LICHCHIEU (MaLichChieu, NgayChieu, GioChieu, MaPhim, MaPhongChieu) VALUES (?, ?, ?, ?, ?)";
    }
    
    public void update(){
        String sql = "UPDATE LICHCHIEU SET NgayChieu=?, GioChieu=?, MaPhim=?, MaPhongChieu=? WHERE MaLichChieu=?";
    }
    
    public void delete(String MaLichChieu){
        String sql = "DELETE FROM LICHCHIEU WHERE MaLichChieu=?";
        JdbcHelper.executeUpdate(sql, MaLichChieu);
    }
    
    public List<LichChieu> select(){
        String sql = "SELECT * FROM LICHCHIEU";
        return select(sql);
    }

    private List<LichChieu> select(String sql, Object... args) {
        List<LichChieu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
                rs = JdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    LichChieu model = ReadFormResultSet(rs);
                    list.add(model);
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    private LichChieu ReadFormResultSet(ResultSet rs) throws SQLException{
        LichChieu lc = new LichChieu();
        lc.setMaLichChieu(rs.getInt("MaLichChieu"));
        lc.setNgayChieu(rs.getString("NgayChieu"));
        lc.setGioChieu(rs.getString("GioChieu"));
        lc.setMaPhim(rs.getInt("MaPhim"));
        lc.setMaPhongChieu(rs.getInt("MaPhongChieu"));
        return lc;
    }
}
