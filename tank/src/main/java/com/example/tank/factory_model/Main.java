package com.example.tank.factory_model;

/**
 * @author Y~chao
 * @create 2021/8/9 16:24
 */
public class Main {

    public static void main(String[] args) {
//        Moveable car = new Car();
//        Moveable plane = new Plane();
//        Moveable broom = new Broom();
        Moveable car = new CarFactory().create();
        car.go();

    }
}
