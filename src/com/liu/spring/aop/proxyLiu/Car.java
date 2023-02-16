package com.liu.spring.aop.proxyLiu;

public class Car implements Vehicle{
    @Override
    public void run() {
        System.out.println("小汽车准备跑....");
        System.out.println("小汽车正在跑....");
        System.out.println("小汽车停止跑....");
    }
}
