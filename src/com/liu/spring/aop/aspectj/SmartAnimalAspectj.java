package com.liu.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect //表示是一个切面类,底层就会有切面编程的支持(动态代理+反射)
@Component
public class SmartAnimalAspectj {
//    切面的一个方法,方法在哪执行,由程序员决定
//    希望将f1方法切入到Cat-getSum前执行,也就是前置通知
    @Before(value = "execution(public Float com.liu.spring.aop.aspectj.Cat.getSum(Float, Float))")
    public static void f1(JoinPoint joinPoint){
//        获取方法签名
        Signature signature = joinPoint.getSignature();
//        获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("切面类方法f1()-前置通知-方法名-" + signature.getName() + "-参数:" + Arrays.toString(args));
    }

//    返回通知
    @AfterReturning(value = "execution(public Float com.liu.spring.aop.aspectj.Cat.getSum(Float, Float))")
    public void f2(JoinPoint joinPoint){
//        获取方法签名
        Signature signature = joinPoint.getSignature();
//        获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("切面类方法f2()-返回通知-方法名-" + signature.getName() + "结果");
    }

    //    异常通知:即把f3方法切入到目标对象方法到发生异常的地方
    //只有发生异常的时候才会执行
    @AfterThrowing(value = "execution(public Float com.liu.spring.aop.aspectj.Cat.getSum(Float, Float))")
    public void f3(JoinPoint joinPoint){
//        获取方法签名
        Signature signature = joinPoint.getSignature();
//        获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("切面类方法f3()-异常通知-方法名-" + signature.getName() + "结果");
    }

    //最终通知,不管是否发生异常都要执行.
    @After(value = "execution(public Float com.liu.spring.aop.aspectj.Cat.getSum(Float, Float))")
    public void f4(JoinPoint joinPoint){
//        获取方法签名
        Signature signature = joinPoint.getSignature();
//        获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("切面类方法f4()-最终通知-方法名-" + signature.getName() + "结果");
    }
}
