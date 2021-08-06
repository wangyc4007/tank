package com.example.tank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Y~chao
 * @create 2021/8/4 17:51
 */
@Configuration
public class Test {

    @Value("${initTankCount}")
    private String tankNum;

    @org.junit.Test
    public void test02(){
        System.out.println("===" + tankNum);
    }
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
