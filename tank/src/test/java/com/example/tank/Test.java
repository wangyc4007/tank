package com.example.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Y~chao
 * @create 2021/8/4 17:51
 */
public class Test {

    @org.junit.Test
    public void test01(){
        try {
            BufferedImage image1 = ImageIO.read(new File("E:\\aaa\\images\\tankL.gif"));
            BufferedImage image2 = ImageIO.read(Test.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            System.out.println(image1);
            System.out.println(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------");
    }
}
