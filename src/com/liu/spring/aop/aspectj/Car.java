package com.liu.spring.aop.aspectj;

import org.springframework.stereotype.Component;

/**
 * @author liushuaibiao
 * @date 2023/2/17 16:24
 */
@Component
public class Car {
    public void run(){
        System.out.println("小汽车在running");
    }
}
