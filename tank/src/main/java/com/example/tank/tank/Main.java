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
        //初始化敌方坦克
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(50 + i*50, 200, Dir.DOWN, tf, Group.BAD));
        }
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
