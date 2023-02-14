package com.liu.spring.proxy2;

public class Ship implements Vehicle{
    @Override
    public void run() {
        System.out.println("船准备运行。。。");
        System.out.println("船正在运行。。。");
        System.out.println("船结束运行。。。");
    }

    @Override
    public String fly(int height) {
        return "";
    }
}
