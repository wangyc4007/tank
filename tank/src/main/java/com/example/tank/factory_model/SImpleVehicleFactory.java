package com.example.tank.factory_model;

/**
 * @author Y~chao
 * @create 2021/8/9 16:31
 * 简单工厂的可扩展性不好
 */
public class SImpleVehicleFactory {

    public Car createCar(){
        //前置操作
        return new Car();
    }
    public Broom createBroom(){
        return new Broom();
    }
    public Plane createPlane(){
        return new Plane();
    }
}
