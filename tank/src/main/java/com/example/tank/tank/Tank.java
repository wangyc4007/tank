package com.example.tank.tank;

import java.awt.*;

/**
 * @author Y~chao
 * @create 2021/8/4 15:19
 */
public class Tank {
    private int x,y;
    private Dir dir = Dir.DOWN;
    private static final int tankSppeed = 10;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
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

    public static int getTankSppeed() {
        return tankSppeed;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "x=" + x +
                ", y=" + y +
                ", dir=" + dir +
                '}';
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        switch (dir) {
            case LEFT:
                x -= tankSppeed;
                break;
            case UP:
                y -= tankSppeed;
                break;
            case RIGHT:
                x += tankSppeed;
                break;
            case DOWN:
                y += tankSppeed;
                break;
            default:
                break;
        }
    }
}
