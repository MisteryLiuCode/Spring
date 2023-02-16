package com.liu.spring.aop.proxyLiu;

public class Ship implements Vehicle {
    @Override
    public void run() {
        System.out.println("船在海上准备前进");
        System.out.println("船在海上前进");
        System.out.println("船在海上结束");
    }
}
