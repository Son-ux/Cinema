/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.beanControll;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author thanh
 */
public class Bean {

    private String kind;
    private JLabel jlb;

    public Bean() {
    }

    public Bean(String kind, JLabel jlb) {
        this.kind = kind;
        this.jlb = jlb;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }


    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

}
