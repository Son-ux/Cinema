/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.dao;

import com.cinema.helper.JdbcHelper;
import com.cinema.model.GiaVe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haivo
 */
public class GiaVeDAO {

    public void insert() {
        String sql = "INSERT INTO GIAVE (MaGiaVe, GiaVe) VALUES (?, ?)";
    }

    public void update() {
        String sql = "UPDATE GIAVE SET GiaVe=? WHERE MaGiaVe=?";
    }

    public void delete(String MaGV) {
        String sql = "DELETE FROM GIAVE WHERE MaGiaVe=?";
        JdbcHelper.executeUpdate(sql, MaGV);
    }

    public List<GiaVe> select() {
        String sql = "SELECT * FROM GIAVE";
        return select(sql);
    }

    private List<GiaVe> select(String sql, Object... args) {
        List<GiaVe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    GiaVe model = ReadFormResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close(); 
            }
        } catch (Exception e) {
        }
        return list;
    }

    private GiaVe ReadFormResultSet(ResultSet rs) throws SQLException {
        GiaVe gv = new GiaVe();
        gv.setMaGiaVe(rs.getInt("MaGiaVe"));
        gv.setGiaVe(rs.getFloat("GiaVe"));
        gv.setMoTa(rs.getString("MoTa"));
        return gv;    }
}
