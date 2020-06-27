/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.dao;

import com.cinema.helper.JdbcHelper;
import com.cinema.model.Ve;
import com.cinema.bieudo.model.AWeek;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author thanh
 */
public class BieuDoDAO {

    private static final String AWEEK = "SELECT NgayTao, SUM(GiaVe) as DoanhThu FROM VE WHERE (NgayTao between CAST(? as date) and CAST(? as date)) GROUP BY NgayTao";

    public List<AWeek> getAWeekChart(){
        List<AWeek> list = new ArrayList<>();
        
        
        long now = new Date().getTime();
        long sevenDays = 7 * 24 * 60 * 60 * 1000;
        long sevenDaysBf = now - sevenDays;

        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");

        String firstParam = fm.format(new Date(sevenDaysBf));
        String secondParam = fm.format(new Date(now));
        
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(BieuDoDAO.AWEEK, firstParam, secondParam);
                while (rs.next()){
                    list.add(new AWeek(rs.getDate("NgayTao"), rs.getFloat("DoanhThu")));
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
