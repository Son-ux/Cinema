/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.helper;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author thanh
 */
public class DateHelper extends Thread {

    private JLabel timer;

    public DateHelper(JLabel timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        super.run();
        try {
            int i = 0;
            while (true) {
                Calendar cd = new GregorianCalendar();

                int hour = cd.get(Calendar.HOUR);
                String h = String.valueOf(hour);
                if (hour < 10) {
                    h = "0" + h;
                }
                int minute = cd.get(Calendar.MINUTE);
                String min = String.valueOf(minute);
                if (minute < 10) {
                    min = "0" + min;
                }

                int second = cd.get(Calendar.SECOND);
                String sc = String.valueOf(second);
                if (second < 10) {
                    sc = "0" + sc;
                }

                String partDay = "AM";
                if (cd.get(Calendar.AM_PM) == 1) {
                    partDay = "PM";
                }
                
                int date = cd.get(Calendar.DAY_OF_YEAR);
                String daTe = String.valueOf(date);
                
                String time = h + ":" + min + ":" + sc + " " + partDay;
                this.timer.setText(time);
                this.sleep(1000);
            }
        } catch (Exception e) {
        }
    }
}
