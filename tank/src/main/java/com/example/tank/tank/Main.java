package com.example.tank.tank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Y~chao
 * @create 2021/8/3 17:01
 */
public class Main {

    public static void main(String[] args) {
        TankFrame tf = new TankFrame();
//        System.out.println("===" + PropertyMgr.get("initTankCount"));

//        new Thread(()->new Audio("audio/war1.wav").loop());
        while (true) {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tf.repaint();
        }
    }
}
