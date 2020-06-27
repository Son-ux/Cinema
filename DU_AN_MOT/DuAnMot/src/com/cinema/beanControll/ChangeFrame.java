package com.cinema.beanControll;

import cinema.BieuDo;
import cinema.LichChieuView;
import cinema.QuanLyGiaVe;
import cinema.QuanLyLichChieu;
import cinema.QuanLyNhanVien;
import cinema.QuanLyPhim;
import cinema.QuanLyThongKe;
import cinema.QuanLyVe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author thanh
 */
public class ChangeFrame {

    private JPanel rt;
    private String kindSelected = "";
    private ArrayList<Bean> listItem = null;

    public ChangeFrame(JPanel jpnroot) {
        this.rt = jpnroot;
    }

    public void setView(JLabel jlbItem) {
        kindSelected = "quan ly phim";

        jlbItem.setBackground(new Color(204, 204, 204));

        rt.removeAll();
        rt.setLayout(new BorderLayout());
        rt.add(new QuanLyPhim());
        rt.validate();
        rt.repaint();
    }

    public void setEvent(ArrayList<Bean> listItem) {
        this.listItem = listItem;
        for (Bean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JLabel jlbItem;

        public LabelEvent(String kind, JLabel jlbItem) {
            this.kind = kind;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "QuanLyPhim":
                    node = new QuanLyPhim();
                    break;
                case "QuanLyVe":
                    node = new QuanLyVe();
                    break;
                case "QuanLyLichChieu":
                    node = new QuanLyLichChieu();
                    break;
                case "QuanLyGiaVe":
                    node = new QuanLyGiaVe();
                    break;
                case "QuanLyNhanVien":
                    node = new QuanLyNhanVien();
                    break;
                case "QuanLyThongKe":
                    node = new QuanLyThongKe();
                    break;
                case "BieuDoThongKe":
                    node = new BieuDo();
                    break;
                default:
            }
            rt.removeAll();
            rt.setLayout(new BorderLayout());
            rt.add(node);
            rt.validate();
            rt.repaint();
            setChangeBackGround(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            kindSelected = kind;
//            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            if (kindSelected.equalsIgnoreCase(kind)) {
//                jlbItem.setBackground(new Color(76, 175, 80));
//            }
        }
    }

    private void setChangeBackGround(String kind) {
        for (Bean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJlb().setBackground(new Color(204, 204, 204));
            } else {
                item.getJlb().setBackground(new Color(0, 102, 102));
            }
        }
    }
}
