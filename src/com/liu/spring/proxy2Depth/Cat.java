package com.liu.spring.proxy2Depth;

public class Cat implements SmartAnimal {
    @Override
    public Float getSum(Float a, Float b) {
//        传统方法,直接在每个方法上输出日志
//        System.out.println("日志-方法名-getSum-参数"+a+" "+b);
        float res=a+b;
//        System.out.println("方法内部打印res="+res);
//        System.out.println("日志-方法名-getSum-结果res="+res);
        return res;
    }

    @Override
    public Float getSub(Float a, Float b) {
        return a-b;
    }
}
