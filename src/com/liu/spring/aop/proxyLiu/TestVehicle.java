package com.liu.spring.aop.proxyLiu;

import org.junit.jupiter.api.Test;

public class TestVehicle {
    @Test
    void test(){
//        要执行Ship时,就执行 new Ship()
        Vehicle vehicle=new Car();
//        动态绑定
        vehicle.run();
    }
}
