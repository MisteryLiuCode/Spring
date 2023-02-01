package com.liu.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    /*
    什么时候调用:在bean的init方法前被调用
    传入的ioc容器中配置的bean的id号
    入参:bean传入的对象,beanNamebean名称
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization方法被调用..bean+"+bean+"beanName="+beanName);
//        instanceof判断的是运行类型
        if (bean instanceof House){
            ((House) bean).setName("上海豪宅");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization方法被调用..bean+"+bean+"beanName="+beanName);
        return bean;
    }
}
