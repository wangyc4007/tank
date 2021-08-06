package com.example.tank.tank;

import java.awt.*;

/**
 * @author Y~chao
 * @create 2021/8/5 16:31
 */
public class Explode {

    static final int WIDTH = ResourceMgr.explodes[0].getWidth(), HEIGTH = ResourceMgr.explodes[0].getHeight();
    private int x, y;
    private TankFrame tf;

    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
//        new Audio("audio/explode.wav").loop();
    }

    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if(step >= ResourceMgr.explodes.length){
            tf.explodes.remove(this);
        }
    }

}
