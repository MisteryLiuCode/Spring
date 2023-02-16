package com.liu.spring.aop.proxy2;

public class Car implements Vehicle{
    @Override
    public void run() {
//        System.out.println("车准备运行。。。");
        System.out.println("车正在运行。。。");
//        System.out.println("车结束运行。。。");
    }

    @Override
    public String fly(int height) {
        return "小汽车飞了"+height;
    }
}
