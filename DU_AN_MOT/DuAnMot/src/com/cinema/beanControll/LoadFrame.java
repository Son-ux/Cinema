/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.beanControll;

import cinema.LichChieuView;
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
public class LoadFrame {

    private JPanel rt;
    private String kindSelected = "";
    private ArrayList<Bean> listItem = null;

    public LoadFrame(JPanel jpnroot) {
        this.rt = jpnroot;
    }

    public void setView(JLabel jlbItem) {
        kindSelected = "lich chieu";

        jlbItem.setBackground(new Color(204, 204, 204));

        rt.removeAll();
        rt.setLayout(new BorderLayout());
        rt.add(new LichChieuView());
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
                case "LichChieu":
                    node = new LichChieuView();
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
}
