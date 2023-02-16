package com.liu.spring.aop.aspectj;

import org.springframework.stereotype.Component;

@Component //使用@Component 当spring容器启动时,将对象注入到容器中
public class Cat implements SmartAnimal {
    @Override
    public Float getSum(Float a, Float b) {
//        传统方法,直接在每个方法上输出日志
//        System.out.println("日志-方法名-getSum-参数"+a+" "+b);
//        模拟异常通知
//        int i=10/0;
        float res=a+b;
        System.out.println("方法内执行结果"+res);
//        System.out.println("方法内部打印res="+res);
//        System.out.println("日志-方法名-getSum-结果res="+res);
        return res;
    }

    @Override
    public Float getSub(Float a, Float b) {
        return a-b;
    }
}
