package com.example.tank.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Y~chao
 * @create 2021/8/3 17:01
 */
public class Main {
    public static void main(String[] args) {
        TankFrame tf = new TankFrame();
        while (true) {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tf.repaint();
        }
    }
}
