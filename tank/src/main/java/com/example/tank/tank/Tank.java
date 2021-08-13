package com.example.tank.tank;

import java.awt.*;
import java.util.Random;

/**
 * @author Y~chao
 * @create 2021/8/4 15:19
 */
public class Tank {
    int x, y;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 3;
    private boolean moving = true;
    GameModel gm = null;
    private boolean living = true;
    static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    static final int HEIGTH = ResourceMgr.goodTankU.getHeight();
    Group group = Group.BAD;
    private Random random = new Random();
    Rectangle rect = new Rectangle();

    FireStrategy fs = new FourDirFireStrategy();
    FireStrategy fs1 = new DefaultFireStrategy();

    public Tank(int x, int y, Dir dir, GameModel gm, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGTH;

    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
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

    public static int getSpeed() {
        return SPEED;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living) {
            gm.tanks.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    //坦克移动方法
    private void move() {
        if (!moving) {
            return;
        }
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
        rect.x = this.x;
        rect.y = this.y;

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        //随机变换方向
        randomDir();
        //边界检测，防止坦克跑出去
        boundsCheck();
    }

    private void boundsCheck() {
        if (x < 0) {
            x = 2;
        }
        if (y < 30) {
            y = 30;
        }
        if (x > TankFrame.GAME_WIDTH - Tank.WIDTH) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }
        if (y > TankFrame.GAME_HEIGHT - Tank.HEIGTH) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGTH - 2;
        }
    }

    private void randomDir() {
        if (this.group == Group.BAD && random.nextInt(100) > 90) {
            //Dir.values()可以获取到枚举的数组
            this.dir = Dir.values()[random.nextInt(4)];
        }

    }

    public void fire() {
        if(this.group == Group.GOOD){
            fs.fire(this);
        }else{
            fs1.fire(this);
        }
//        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
//        int bY = this.y + Tank.HEIGTH/2 - Bullet.HEIGTH/2;
//        new Bullet(bX, bY, this.dir, this.group, this.tf);
//        if(this.group == Group.GOOD){
//            new Thread(()->new Audio("audio/tank_fire.wav"));
//        }
//        switch (dir) {
//            case LEFT:
//                tf.bullets.add(new Bullet(x, y + HEIGTH / 2 - (ResourceMgr.bulletL.getHeight()) / 2, dir, tf, this.group));
//                break;
//            case UP:
//                tf.bullets.add(new Bullet(x + WIDTH / 2 - (ResourceMgr.bulletU.getWidth()) / 2, y, dir, tf, this.group));
//                break;
//            case RIGHT:
//                tf.bullets.add(new Bullet(x + WIDTH, y + HEIGTH / 2 - (ResourceMgr.bulletR.getHeight()) / 2, dir, tf, this.group));
//                break;
//            case DOWN:
//                tf.bullets.add(new Bullet(x + WIDTH / 2 - (ResourceMgr.bulletD.getWidth()) / 2, y + HEIGTH, dir, tf, this.group));
//                break;
//            default:
//                break;
//        }
    }

    public void die() {
        this.living = false;
    }
}
