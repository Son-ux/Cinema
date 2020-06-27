/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.dao;

import com.cinema.helper.JdbcHelper;
import com.cinema.model.Phim;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haivo
 */
public class PhimDAO {

    public void insert(Phim model) {
        String sql = "INSERT INTO PHIM (TenPhim, NhaSanXuat, DoTuoi, ThoiLuong, NgayCongChieu, Poster, MaLoaiPhim) VALUES (?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getTenPhim(),
                model.getNhaSanXuat(),
                model.getDoTuoi(),
                model.getThoiLuong(),
                model.getNgayCongChieu(),
                model.getPoster(),
                model.getMaLoaiPhim());
    }

    public void update(Phim model) {
        String sql = "UPDATE PHIM SET TenPhim=?, NhaSanXuat=?, DoTuoi=?, ThoiLuong=?, NgayCongChieu=?, Poster=?, MaLoaiPhim=? WHERE MaPhim=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenPhim(),
                model.getNhaSanXuat(),
                model.getDoTuoi(),
                model.getTenPhim(),
                model.getNgayCongChieu(),
                model.getPoster(),
                model.getMaLoaiPhim());
    }

    public void delete(String MaP) {
        String sql = "DELETE FROM PHIM WHERE maPhim=?";
        JdbcHelper.executeUpdate(sql, MaP);
    }

    public List<Phim> select() {
        String sql = "SELECT * FROM PHIM";
        return select(sql);
    }

    private List<Phim> select(String sql, Object... args) {
        List<Phim> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Phim model = readFroResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Phim readFroResultSet(ResultSet rs) throws SQLException {
        Phim pm = new Phim();
        pm.setMaPhim(rs.getInt("MaPhim"));
        pm.setTenPhim(rs.getString("TenPhim"));
        pm.setNhaSanXuat(rs.getString("NhaSanXuat"));
        pm.setDoTuoi(rs.getInt("Dotuoi"));
        pm.setThoiLuong(rs.getInt("ThoiLuong"));
        pm.setNgayCongChieu(rs.getString("NgayCongChieu"));
        pm.setPoster(rs.getString("Poster"));
        pm.setMaLoaiPhim(rs.getInt("MaLoaiPhim"));
        return pm;
    }
}
