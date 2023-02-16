package com.liu.spring.aop.proxy3;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LAOP {
    public static void before(Object proxy, Method method, Object[] args){
        System.out.println("LAOP日志-方法名-" + method.getName() + "-参数:" + Arrays.toString(args));
    }
    public static void after(Method method,Object invoke){
        System.out.println("LAOP日志-方法名" + method.getName() + "-结果res=" + invoke);
    }
}
