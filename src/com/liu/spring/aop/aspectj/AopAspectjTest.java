package com.liu.spring.aop.aspectj;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAspectjTest {
    @Test
    public void testBefore(){
//        获取容器
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans08.xml");
//        通过接口类型来获取注入的对象,就是代理对象
        SmartAnimal smartAnimal = ioc.getBean(SmartAnimal.class);
//        SmartAnimal cat = (SmartAnimal)ioc.getBean("cat");
//        Cat cat = (Cat)ioc.getBean("cat");
        System.out.println("smartAnimal类型"+smartAnimal.getClass());
//        模拟异常通知
//        System.out.println("cat类型"+cat.getClass());
        smartAnimal.getSum(1F, 1F);
    }



//    测试没有实现接口的类使用切面编程
    @Test
    public void test3(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans08.xml");
        Car car = (Car)ioc.getBean("car");
        System.out.println("car对象运行类型"+car.getClass());
        car.run();
    }
}
