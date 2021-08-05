package com.example.tank.tank;

import java.awt.*;

/**
 * @author Y~chao
 * @create 2021/8/4 15:53
 */
public class Bullet {

    private static final int SPEED = 10;
    private static final int WIDTH = ResourceMgr.bulletD.getWidth(), HEIGTH = ResourceMgr.bulletD.getHeight();
    private int x, y;
    private Dir dir;
    private boolean living = true;
    private TankFrame tf;
    private Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if(!living){
            tf.bullets.remove(this);
        }
//        Color color = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x, y, WIDTH, HEIGTH);
//        g.setColor(color);
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
    }

    //碰撞检测
    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()) return;
        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGTH);
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGTH);
        if(rect1.intersects(rect2)){
            tank.die();
            this.dir();
        }
    }

    private void dir() {
        this.living = false;
    }
}
