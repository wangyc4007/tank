package com.example.tank.tank;

/**
 * @author Y~chao
 * @create 2021/8/9 14:54
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGTH/2 - Bullet.HEIGTH/2;
        new Bullet(bX, bY, t.dir, t.group, t.gm);
        if(t.group == Group.GOOD){
            new Thread(()->new Audio("audio/tank_fire.wav"));
        }
    }
}
