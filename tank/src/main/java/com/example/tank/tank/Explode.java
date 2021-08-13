package com.example.tank.tank;

import java.awt.*;

/**
 * @author Y~chao
 * @create 2021/8/5 16:31
 */
public class Explode {

    static final int WIDTH = ResourceMgr.explodes[0].getWidth(), HEIGTH = ResourceMgr.explodes[0].getHeight();
    private int x, y;
    private GameModel gm;

    private int step = 0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
//        new Audio("audio/explode.wav").loop();
    }

    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if(step >= ResourceMgr.explodes.length){
            gm.explodes.remove(this);
        }
    }

}
