package com.liu.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//暂时注销演示环绕通知
@Order(value = 3)//值越小，优先级越高
@Aspect //表示是一个切面类,底层就会有切面编程的支持(动态代理+反射)
@Component
public class SmartAnimalAspectj3 {
//    定义一个切入点，可以达到一个表达式复用
    @Pointcut(value = "execution(public Float com.liu.spring.aop.aspectj.Cat.getSum(Float, Float))")
    public void myPoint(){
    }

    //    切面的一个方法,方法在哪执行,由程序员决定
//    希望将f1方法切入到Cat-getSum前执行,也就是前置通知
//    @Before(value = "execution(public Float com.liu.spring.aop.aspectj.Cat.getSum(Float, Float))")
//    复用切入点表达式
    @Before(value = "myPoint()")
    public static void f1(JoinPoint joinPoint) {
//        获取方法签名
        Signature signature = joinPoint.getSignature();
//        获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("切面类SmartAnimalAspectj3方法f1()-前置通知-方法名-" + signature.getName() + "-参数:" + Arrays.toString(args));
    }

    //    返回通知
//    @AfterReturning(value = "execution(public Float com.liu.spring.aop.aspectj.Cat.getSum(Float, Float))", returning = "res")
//    复用切入点
    @AfterReturning(value = "myPoint()",returning = "res")
    public void f2(JoinPoint joinPoint, Object res) {
//        获取方法签名
        Signature signature = joinPoint.getSignature();
//        获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("切面类SmartAnimalAspectj3方法f2()-返回通知-方法名-" + signature.getName() + "结果:" + res);
    }

    //    异常通知:即把f3方法切入到目标对象方法到发生异常的地方
    //只有发生异常的时候才会执行
    @AfterThrowing(value = "execution(public Float com.liu.spring.aop.aspectj.Cat.getSum(Float, Float))", throwing = "e")
    public void f3(JoinPoint joinPoint, Throwable e) {
//        获取方法签名
        Signature signature = joinPoint.getSignature();
//        获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("切面类SmartAnimalAspectj3方法f3()-异常通知-方法名-" + signature.getName() + "异常信息:" + e);
    }

    //最终通知,不管是否发生异常都要执行.
    @After(value = "execution(public Float com.liu.spring.aop.aspectj.Cat.getSum(Float, Float))")
    public void f4(JoinPoint joinPoint) {
//        获取方法签名
        Signature signature = joinPoint.getSignature();
//        获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("切面类SmartAnimalAspectj3方法f4()-最终通知-方法名-" + signature.getName() + "结果");
    }

    //    对没有实现接口的类使用切面编程
    @Before(value = "execution(public void Car.run())")
    public void carRun(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("切面类SmartAnimalAspectj3方法-" + signature.getName());
//        joinPoint常用方法
//        获取去方法名
        String name = joinPoint.getSignature().getName();
        System.out.println("joinPoint.getSignature().getName()获取方法名:" + name);
//        获取目标方法所属的简单的类名
        String simpleName = joinPoint.getSignature().getDeclaringType().getSimpleName();
        System.out.println("joinPoint.getSignature().getDeclaringType().getSimpleName()获取目标方法所属的简单的类名:" + simpleName);
//        获取目标方法所属类的类名
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println("joinPoint.getSignature().getDeclaringTypeName()获取目标方法所属类的类名:" + declaringTypeName);
//        获取目标方法声明类型(public,private...)
        int modifiers = joinPoint.getSignature().getModifiers();
        System.out.println("joinPoint.getSignature().getModifiers()获取目标方法声明类型:" + modifiers);
//        获取目标方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("joinPoint.getArgs()获取目标方法的参数:" + Arrays.toString(args));
//        获取被代理的对象
        Object target = joinPoint.getTarget();
        System.out.println("joinPoint.getTarget()获取被代理的对象:" + target);
//        获取代理对象本身
        Object aThis = joinPoint.getThis();
        System.out.println("joinPoint.getThis():" + aThis);
    }
}
