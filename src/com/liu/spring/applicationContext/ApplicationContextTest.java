package com.liu.spring.applicationContext;

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
    public static void main(String[] args) throws DocumentException {
        ApplicationContext applicationContext = new ApplicationContext("beans.xml");
        System.out.println("ok");
    }


}
