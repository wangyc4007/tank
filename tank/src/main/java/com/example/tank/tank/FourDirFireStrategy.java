package com.example.tank.tank;

import java.util.LinkedList;

/**
 * @author Y~chao
 * @create 2021/8/9 14:54
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGTH/2 - Bullet.HEIGTH/2;
        Dir[] values = Dir.values();
        for(Dir dir : values){
            new Bullet(bX, bY, dir, t.group, t.gm);
        }
        if(t.group == Group.GOOD){
            new Thread(()->new Audio("audio/tank_fire.wav"));
        }
    }
}
