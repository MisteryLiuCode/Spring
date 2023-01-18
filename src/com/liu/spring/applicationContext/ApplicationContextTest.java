package com.liu.spring.applicationContext;

import com.liu.spring.bean.Monster;
import org.dom4j.DocumentException;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现简单spring的一个简单容器
 * 主要是看一下流程,比较简单
 * 主要实现如何将beans.xml文件进行解析,并生成对象,放入容器中
 * 并提供一个方法,返回对应的对象
 * @author liushuaibiao
 */
public class ApplicationContextTest {
    public static void main(String[] args) throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ApplicationContext ioc = new ApplicationContext("beans.xml");
        Monster monster = (Monster) ioc.getBean("monster01");
        System.out.println(monster.getMonsterId());
        System.out.println(monster.getName());
        System.out.println("ok");
    }


}
