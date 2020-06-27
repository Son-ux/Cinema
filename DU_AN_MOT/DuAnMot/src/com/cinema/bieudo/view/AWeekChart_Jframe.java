/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.bieudo.view;

import com.cinema.bieudo.model.AWeek;
import com.cinema.dao.BieuDoDAO;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author thanh
 */
public class AWeekChart_Jframe extends JFrame {

    private static final String TITLE = "THỐNG KÊ DOANH THU 7 NGÀY GẦN NHẤT";
    private static final String MONTH = "Ngày";
    private static final String DOANHTHU = "Doanh Thu";
    private static final String DONVI = "VNĐ";

    public AWeekChart_Jframe() {
        init();
    }

    public JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                TITLE,
                MONTH, DOANHTHU,
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        BieuDoDAO bdDAO = new BieuDoDAO();
        List<AWeek> list = bdDAO.getAWeekChart();
        list.forEach(elm -> {
            dataset.addValue(elm.getDoanhThu(), DONVI, elm.getNgayTaoParseString());
        });

//        for(AWeek elm : list){
//            dataset.addValue(elm.getDoanhThu(), DONVI, elm.getNgayTaoParseString());
//        }         
        return dataset;
    }

    private void init() {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        this.add(chartPanel);
        this.setTitle(TITLE);
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AWeekChart_Jframe().setVisible(true);
            }
        });
    }
}
