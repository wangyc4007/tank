package com.example.tank.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Y~chao
 * @create 2021/8/10 17:28
 */
public class GameModel {

    Tank myTank = new Tank(300, 550, Dir.UP, this, Group.GOOD);

    List<Tank> tanks = new ArrayList<>();
    List<Bullet> bullets = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    public GameModel(){
//        //初始化敌方坦克
        for (int i = 0; i < Integer.valueOf((String) PropertyMgr.get("initTankCount")); i++) {
            tanks.add(new Tank(50 + i*50, 200, Dir.DOWN, this, Group.BAD));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("坦克的数量：" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(c);
        //画图用的   相对于左上角定位坐标，前两个参数为xy轴，后两个为生成的画框的值
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }
}
