package com.example.tank.tank;

import java.awt.*;
import java.util.Random;

/**
 * @author Y~chao
 * @create 2021/8/4 15:19
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 3;
    private boolean moving = true;
    private TankFrame tf = null;
    private boolean living = true;
    static final int WIDTH = ResourceMgr.tankD.getWidth(), HEIGTH = ResourceMgr.tankD.getHeight();
    private Group group = Group.BAD;
    private Random random = new Random();

    public Tank(int x, int y, Dir dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
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
        if(!living)tf.tanks.remove(this);
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

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
        if(random.nextInt(10) > 8) this.fire();
    }

    public void fire() {
        switch (dir) {
            case LEFT:
                tf.bullets.add(new Bullet(x, y + HEIGTH / 2 - 3, dir, tf, this.group));
                break;
            case UP:
                tf.bullets.add(new Bullet(x + WIDTH / 2 - 5, y, dir, tf, this.group));
                break;
            case RIGHT:
                tf.bullets.add(new Bullet(x + WIDTH, y + HEIGTH / 2 - 3, dir, tf, this.group));
                break;
            case DOWN:
                tf.bullets.add(new Bullet(x + WIDTH / 2 - 7, y + HEIGTH, dir, tf, this.group));
                break;
            default:
                break;
        }
    }

    public void die() {
        this.living = false;
    }
}
