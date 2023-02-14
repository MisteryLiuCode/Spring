package com.liu.spring.proxy2Depth;

import com.liu.spring.proxy2.Vehicle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class VehicleAnimalProvider {

    //定义一个属性
    //target_vehicle 表示真正要执行的对象
    //该对象实现了Vehicle接口
    private SmartAnimal target_vehicle;

    public VehicleAnimalProvider(SmartAnimal target_vehicle) {
        this.target_vehicle = target_vehicle;
    }

    //    编写一个对象，返回一个代理对象
    public SmartAnimal getProxy() {
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
                try {
//                从Aop的角度来看,这个叫做横切关注点,叫做前置通知
                    System.out.println("日志-方法名-" + method.getName() + "-参数:" + Arrays.toString(args));
                    Object invoke = method.invoke(target_vehicle, args);
                    System.out.println("方法内部打印res=" + invoke);
//                这个也是横切关注点,叫做后置通知
                    System.out.println("日志-方法名" + method.getName() + "-结果res=" + invoke);
                    return invoke;
                } catch (Exception e) {
                    e.printStackTrace();
//                    从Aop的角度看,这也是一个横切关注点,异常通知
                    System.out.println("方法执行异常了-日志-方法名+" + method.getName() + "-异常类型-" + e.getClass().getName());
                } finally {
//                    不管知否出现异常,方法最终结束
//                    从aop的角度看,也是一个横切关注点
                    System.out.println("方法最终结束+"+method.getName());
                }
                return null;
            }
        };
        SmartAnimal proxy = (SmartAnimal) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }
}
