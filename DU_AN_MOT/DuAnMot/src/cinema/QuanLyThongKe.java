/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;


import com.cinema.helper.JdbcHelper;
import java.sql.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thanh
 */
public class QuanLyThongKe extends javax.swing.JPanel {

    public QuanLyThongKe() {
        initComponents();
        this.ThongKeTheoPhim();
        this.ThongKeTheoPhongChieu();
        this.ThongKeTheoGioChieu();
    }

    public List<Object[]> ThongKeTheoPhim() {
        DefaultTableModel modelTable1 = (DefaultTableModel) tblView.getModel();
        modelTable1.setRowCount(0);
        try {
            ResultSet rs = null;
            try {
                String sql = "SELECT PHIM.MaPhim, PHIM.TenPhim,\n"
                        + "			(SELECT COUNT(*) FROM LICHCHIEU WHERE MaPhim = PHIM.MaPhim) as SoluongXuatCHieu,\n"
                        + "			COUNT(PHIM.MaPhim) as soLuongVeBan,\n"
                        + "			SUM(VE.GiaVe) as DoanhThuCuaPhim from VE\n"
                        + "			Join LICHCHIEU on ve.MaLichChieu = LICHCHIEU.MaLichChieu\n"
                        + "			Join PHIM on LICHCHIEU.MaPhim = PHIM.MaPhim\n"
                        + "			GROUP BY PHIM.MaPhim, PHIM.TenPhim";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] row = {
                        rs.getInt("MaPhim"),
                        rs.getString("TenPhim"),
                        rs.getInt("SoLuongXuatChieu"),
                        rs.getInt("SoLuongVeBan"),
                        rs.getFloat("DoanhThuCuaPhim")
                    };
                    modelTable1.addRow(row);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object[]> ThongKeTheoPhongChieu() {
        DefaultTableModel modelTable2 = (DefaultTableModel) tblView2.getModel();
        modelTable2.setRowCount(0);
        try {
            ResultSet rs = null;
            try {
                String sql = "SELECT PHONGCHIEU.MaPhongChieu,\n"
                        + "		PHONGCHIEU.TenPhongChieu,\n"
                        + "		(select count(*) from LICHCHIEU where MaPhongChieu = PHONGCHIEU.MaPhongChieu) as SoLuongXuatChieu,\n"
                        + "		count(PHONGCHIEU.MaPhongChieu) as soLuongVeBan,\n"
                        + "		sum(VE.GiaVe) as DoanhThuCuaPhongChieu\n"
                        + "		from VE\n"
                        + "		join LICHCHIEU on VE.MaLichChieu = LICHCHIEU.MaLichChieu\n"
                        + "		join PHONGCHIEU on LICHCHIEU.MaPhongChieu = PHONGCHIEU.MaPhongChieu \n"
                        + "		group by PHONGCHIEU.MaPhongChieu, PHONGCHIEU.TenPhongChieu";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] row = {
                        rs.getInt("MaPhongChieu"),
                        rs.getString("TenPhongChieu"),
                        rs.getInt("SoLuongXuatChieu"),
                        rs.getInt("SoLuongVeBan"),
                        rs.getFloat("DoanhThuCuaPhongChieu")
                    };
                    modelTable2.addRow(row);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object[]> ThongKeTheoGioChieu() {
        DefaultTableModel modelTable3 = (DefaultTableModel) tblView3.getModel();
        modelTable3.setRowCount(0);
        try {
            ResultSet rs = null;
            try {
                String sql = "SELECT LICHCHIEU.GioChieu,\n"
                        + "			count(LICHCHIEU.GioChieu) as SoLuongVeBan,\n"
                        + "			sum(VE.GiaVe) as DoanhThuCuaGioChieu\n"
                        + "			from VE\n"
                        + "			join LICHCHIEU on VE.MaLichChieu = LICHCHIEU.MaLichChieu\n"
                        + "			group by LICHCHIEU.GioChieu";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] row = {
                        rs.getString("GioChieu"),
                        rs.getInt("SoLuongVeBan"),
                        rs.getFloat("DoanhThuCuaGioChieu")
                    };
                    modelTable3.addRow(row);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblView = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblView2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblView3 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1290, 770));

        jTabbedPane1.setBackground(new java.awt.Color(204, 0, 51));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N

        tblView.setBackground(new java.awt.Color(0, 102, 102));
        tblView.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tblView.setForeground(new java.awt.Color(255, 255, 255));
        tblView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ PHIM", "TÊN PHIM", "SỐ LƯỢNG XUẤT CHIẾU", "SỐ LƯỢNG VÉ BÁN", "DOANH THU"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblView.setRowHeight(29);
        jScrollPane1.setViewportView(tblView);

        jTabbedPane1.addTab("DOANH THU THEO PHIM", jScrollPane1);

        tblView2.setBackground(new java.awt.Color(0, 102, 102));
        tblView2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tblView2.setForeground(new java.awt.Color(255, 255, 255));
        tblView2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ PHÒNG CHIẾU", "TÊN PHÒNG CHIẾU", "SỐ LƯỢNG XUẤT CHIẾU", "LƯỢNG VÉ BÁN RA", "DOANH THU"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblView2.setRowHeight(37);
        jScrollPane2.setViewportView(tblView2);

        jTabbedPane1.addTab("DOANH THU THEO PHÒNG CHIẾU", jScrollPane2);

        tblView3.setBackground(new java.awt.Color(0, 102, 102));
        tblView3.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tblView3.setForeground(new java.awt.Color(255, 255, 255));
        tblView3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GIỜ CHIẾU", "LƯỢNG VÉ BÁN RA", "DOANH THU"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblView3.setRowHeight(37);
        jScrollPane3.setViewportView(tblView3);

        jTabbedPane1.addTab("DOANH THU THEO GIỜ CHIẾU", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblView;
    private javax.swing.JTable tblView2;
    private javax.swing.JTable tblView3;
    // End of variables declaration//GEN-END:variables
}
