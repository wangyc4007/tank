package com.example.tank.factory_model.abstractfactory;

import com.example.tank.factory_model.CarFactory;

/**
 * @author Y~chao
 * @create 2021/8/9 16:24
 */
public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.go();
        AK47 ak47 = new AK47();
        ak47.shoot();
        Bread bread = new Bread();
        bread.printName();

    }
}
