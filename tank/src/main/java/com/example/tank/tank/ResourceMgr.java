package com.example.tank.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Y~chao
 * @create 2021/8/5 10:21
 */
public class ResourceMgr {
    public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    public static BufferedImage badTankL, badTankU, badTankR, badTankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            //加载坦克图片
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU, -90);
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);
            //加载炮弹图片
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL= ImageUtil.rotateImage(bulletU, -90);
            bulletR= ImageUtil.rotateImage(bulletU, 90);
            bulletD= ImageUtil.rotateImage(bulletU, 180);
            //加载爆炸图片
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
