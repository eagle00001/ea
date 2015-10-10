package com.ea.core.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 拦截处理注解类
 *@author:eagle.daiq
 *@company:iot.chinamobile
 *@date:2015年7月15日
 *@description:
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface InterceptorHandler {
	public String id() default "";
}

