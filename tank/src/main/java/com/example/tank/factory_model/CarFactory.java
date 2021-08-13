package com.example.tank.factory_model;

/**
 * @author Y~chao
 * @create 2021/8/9 16:35
 */
public class CarFactory {

    public Moveable create(){
        System.out.println("a car created!!!");
        return new Car();
    }
}
