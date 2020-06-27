/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.dao;

import com.cinema.helper.JdbcHelper;
import com.cinema.model.TaiKhoan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thanh
 */
public class TaiKhoanDAO {

    public List<TaiKhoan> select() {
        String sql = "SELECT * FROM TAIKHOAN";
        return select(sql);
    }

    public List <TaiKhoan> findByRole() {
        String sql = "SELECT TenDangNhap, HoTen, GioiTinh, SDT, Email FROM TAIKHOAN WHERE VaiTro = 1";
        return selectStaff(sql);
    }
    
    private TaiKhoan readFromStaff(ResultSet rs) throws SQLException {
        TaiKhoan tk = new TaiKhoan();
        tk.setTenDangNhap(rs.getString("TenDangNhap"));
        tk.setHoTen(rs.getString("HoTen"));
        tk.setGioiTinh(rs.getBoolean("GioiTinh"));
        tk.setSDT(rs.getString("SDT"));
        tk.setEmail(rs.getString("Email"));
        return tk;
    }
    
    private List<TaiKhoan> selectStaff(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromStaff(rs);
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
    
    public TaiKhoan findById(String tenNV) {
        String sql = "SELECT * FROM TAIKHOAN WHERE TenDangNhap=?";
        List<TaiKhoan> list = select(sql, tenNV);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<TaiKhoan> select(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromResultSet(rs);
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

    private TaiKhoan readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoan tk = new TaiKhoan();
        tk.setMaTaiKhoan(rs.getString("MaTaiKhoan"));
        tk.setTenDangNhap(rs.getString("TenDangNhap"));
        tk.setMatKhau(rs.getString("Matkhau"));
        tk.setHoTen(rs.getString("HoTen"));
        tk.setGioiTinh(rs.getBoolean("GioiTinh"));
        tk.setSDT(rs.getString("SDT"));
        tk.setHinh(rs.getString("Hinh"));
        tk.setVaiTro(rs.getInt("VaiTro"));
        return tk;
    }
    
    public void delete(String TenDN) {
        String sql = "DELETE FROM TaiKhoan WHERE TenDangNhap=?";
        JdbcHelper.executeUpdate(sql, TenDN);
    }
}
