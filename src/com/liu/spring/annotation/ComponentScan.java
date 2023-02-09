package com.liu.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @Target(ElementType.TYPE),表示这个注解作用在Class, interface (including annotation type), or enum declaration
 * @Retention(RetentionPolicy.RUNTIME) 表示作用在运行
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentScan {
//    表示可以给这个注解传入一个value属性
    String value() default "";
}
