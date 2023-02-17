package com.liu.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect //表示是一个切面类,底层就会有切面编程的支持(动态代理+反射)
@Component
public class SmartAnimalAspectj2 {
    //=====环绕通知 start=====
//@Around(value = "execution(* *.*(..))")
    @Around(value = "execution(public Float com.liu.spring.aop.aspectj.Cat.getSum(Float, Float))")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object result = null;
        String methodName = joinPoint.getSignature().getName();
        try {
//1.相当于前置通知完成的事情
            Object[] args = joinPoint.getArgs();
            List<Object> argList = Arrays.asList(args);
            System.out.println("AOP 环绕通知--" + methodName + "方法开始了--参数有： " + argList);
//在环绕通知中一定要调用 joinPoint.proceed()来执行目标方法
            result = joinPoint.proceed();
//2.相当于返回通知完成的事情
            System.out.println("AOP 环绕通知" + methodName + "方法结束了--结果是：" + result);
        } catch (Throwable throwable) {
//3.相当于异常通知完成的事情
            System.out.println("AOP 环绕通知" + methodName + "方法抛异常了--异常对象：" + throwable);
        } finally {
//4.相当于最终通知完成的事情
            System.out.println("AOP 后置通知" + methodName + "方法最终结束了...");
        }
        return result;
    }
//=====环绕通知 end=====
}
