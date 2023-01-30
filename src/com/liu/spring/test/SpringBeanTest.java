package com.liu.spring.test;


import com.liu.spring.bean.Monster;
import com.liu.spring.di.DiImpl;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanTest {
    @Test
    public void getMonster() {
        //创建容器 ApplicationContext,该容器和容器配置文件关联
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
//        编译类型是object,运行类型是Monster
        Object monster01 = ioc.getBean("monster01");
        System.out.println(monster01);
    }


    //    通过bean类型获取对象
    @Test
    public void getBeanType() throws DocumentException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
//        通过对象类型获取bean
        Monster bean = ioc.getBean(Monster.class);
        System.out.println("bean=" + bean);
    }

    //    通过构造器来设置属性
    @Test
    public void setBeanByConstructer() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
//        通过对象类型获取bean
        Monster bean = ioc.getBean(Monster.class);
        System.out.println("bean=" + bean);
    }

    //    依赖注入
    @Test
    public void setDi() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        //        编译类型是object,运行类型是Monster
        DiImpl diImpli = (DiImpl) ioc.getBean("diImpl");
        diImpli.diTest();
    }


}
