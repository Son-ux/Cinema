/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.dao;

import com.cinema.helper.JdbcHelper;
import com.cinema.model.GiaVe;
import com.cinema.model.LoaiPhim;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haivo
 */
public class LoaiPhimDAO {

    public void insert() {
        String sql = "INSERT INTO LOAIPHIM (MaLoaiPhim, TenTheLoai) VALUES (?, ?)";
    }

    public void update() {
        String sql = "UPDATE LOAIPHIM SET TenTheLoai=? WHERE MaLoaiPhim=?";
    }

    public void delect() {
        String sql = "DELETE FROM LOAIPHIM WHERE MaLoaiPhim=?";
    }

    public List<LoaiPhim> fillAll() {
        String sql = "SELECT * FROM LOAIPHIM";
        return select(sql);
    }

    private List<LoaiPhim> select(String sql, Object... args) {
        List<LoaiPhim> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    LoaiPhim model = ReadFormResultSet(rs);
                    list.add(model);
                }
            } finally {

            }
        } catch (Exception e) {
        }
        return list;
    }

    private LoaiPhim ReadFormResultSet(ResultSet rs) throws SQLException {
        LoaiPhim lp = new LoaiPhim();
        lp.setMaLoaiPhim(rs.getInt("MaLoaiPhim"));
        lp.setTenTheLoai(rs.getString("TenTheLoai"));
        return lp;
    }
}
