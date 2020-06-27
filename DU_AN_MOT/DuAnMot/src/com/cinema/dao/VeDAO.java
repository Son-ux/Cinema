/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.dao;

import com.cinema.helper.JdbcHelper;
import com.cinema.model.Ve;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haivo
 */
public class VeDAO {
    public void insert(){
        String sql = "INSERT INTO VE (MaVe, NgayTao, MaLichChieu, MaGhe, MaGiaVe, MaTaiKhoan) VALUES (?, ?, ?, ?, ?, ?)";
    }
    
    public void update(){
        String sql = "UPDATE VE SET NgayTao=?, MaLichChieu=?, MaGhe=?, MaGiaVe=?, MaTaiKhoan=? WHERE MaVe=?";
    }
    
    public void delect(){
        String sql = "DELETE FROM VE WHERE MaVe=?";
    }
    
    public List<Ve> select() {
        String sql = "SELECT * FROM VE";
        return select(sql);
    }
    
    private List<Ve> select(String sql, Object...args) {
        List<Ve> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()){
                    Ve model = readFroResultSet(rs);
                    list.add(model);
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Ve readFroResultSet(ResultSet rs) throws SQLException {
        Ve v = new Ve();
        v.setMaVe(rs.getString("MaVe"));
        v.setNgayTao(rs.getString("NgayTao"));
        v.setMaLichChieu(rs.getInt("MaLichChieu"));
        v.setMaGhe(rs.getString("MaGhe"));
        v.setMaGiaVe(rs.getInt("MaGiaVe"));
        v.setMaTaiKhoan(rs.getString("MaTaiKhoan"));
        v.setGiaVe(rs.getFloat("GiaVe"));
        return v;
    }
}
