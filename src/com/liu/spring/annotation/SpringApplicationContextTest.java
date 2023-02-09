package com.liu.spring.annotation;

import com.liu.spring.component.MyComponent;

public class SpringApplicationContextTest {
    public static void main(String[] args) {
        SpringApplicationContext ioc = new SpringApplicationContext(SpringConfig.class);
        MyComponent component = (MyComponent) ioc.getBean("myComponent");
        System.out.println(component);
    }
}
