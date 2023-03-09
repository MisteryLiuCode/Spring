package com.liu.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
Scope可以指定bean的作用范围，singleton是单例的，prototype是多实例的。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Scope {
    //    通过value指定singleton，还是prototype
    String value() default "";
}
