package com.example.tank.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Y~chao
 * @create 2021/8/3 17:16
 */
public class TankFrame extends Frame {

    public TankFrame() {
        setVisible(true);
        setBackground(Color.darkGray);
        setTitle("坦克大战");
        setSize(800, 600);
        setResizable(false);

        this.addKeyListener(new MyKeyListener());

        //匿名内部类   主要关闭窗口
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//关闭窗口
            }
        });
    }

    int x = 200, y = 200;

    @Override
    public void paint(Graphics g) {
        System.out.println("1111");
        //画图用的   相对于左上角定位坐标，前两个参数为xy轴，后两个为生成的画框的值
        g.fillRect(x, y, 50, 50);
        x += 10;
        y += 10;
    }

    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed");
            super.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
            super.keyReleased(e);
        }
    }
}
