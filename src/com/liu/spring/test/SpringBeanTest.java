package com.liu.spring.test;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanTest {
    @Test
    public void getMonster(){
        //创建容器 ApplicationContext,该容器和容器配置文件关联
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
//        编译类型是object,运行类型是Monster
        Object monster01 = ioc.getBean("monster01");
        System.out.println(monster01);
    }
}
