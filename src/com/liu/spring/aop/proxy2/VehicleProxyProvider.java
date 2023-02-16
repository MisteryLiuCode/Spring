package com.liu.spring.aop.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class VehicleProxyProvider {

    //定义一个属性
    //target_vehicle 表示真正要执行的对象
    //该对象实现了Vehicle接口
    private Vehicle target_vehicle;
    public VehicleProxyProvider(Vehicle target_vehicle) {
        this.target_vehicle = target_vehicle;
    }

    //    编写一个对象，返回一个代理对象
    public Vehicle getProxy() {
        /*
            public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
         */
        /*
         Proxy.newProxyInstance()可以返回一个代理对象，ClassLoader loader：类加载器
         Class<?>[] interfaces，就是将来要代理的对象的接口信息
         InvocationHandler 调用处理器/对象，有一个非常重要的方法invoke
         */
//        得到类加载器
        ClassLoader classLoader = target_vehicle.getClass().getClassLoader();
//        得到代理的对象，被执行的对象的接口信息，底层通过接口来完成调用
        Class<?>[] interfaces = target_vehicle.getClass().getInterfaces();
//        创建InvocationHandler 对象，因为他是接口，所以可以通过匿名对象的方式创建该对象
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             *
             * @param proxy 表示代理的对象
             *
             * @param method 通过代理对象要调用的方法
             *
             * @param args 调用方法传入的参数
             *
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("交通工具开始运行了");
//                反射，可以通过方法.对象调用方法。
//                method:com.liu.spring.aop.proxy2.Vehicle
//                当返回值=null,invoke=null
                Object invoke = method.invoke(target_vehicle, args);
                System.out.println("交通工具停止运行了");
                return invoke;
            }
        };
        Vehicle proxy = (Vehicle) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }
}
