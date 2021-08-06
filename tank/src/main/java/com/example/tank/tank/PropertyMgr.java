package com.example.tank.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Y~chao
 * @create 2021/8/6 12:04
 */
public class PropertyMgr {
    static Properties props = new Properties();
    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if (props == null){
            return null;
        }
        return props.get(key);
    }

    public static void main(String[] args) {
        System.out.println(props.get("initTankCount"));
    }
}
