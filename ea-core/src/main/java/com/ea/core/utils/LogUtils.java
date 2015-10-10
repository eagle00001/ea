package com.ea.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @comments
 * @author eagle.daiq
 * @date 2014-7-19
 */
public class LogUtils {
	
	public static Logger getLogger(Class clz){
		return LoggerFactory.getLogger(clz);
	}
	
	public static void error(Class clz,String msg, Throwable t){
		getLogger(clz).error(msg,t);
	}
	
	public static void error(Class clz,String msg){
		getLogger(clz).error(msg);
	}
	
	public static void warm(Class clz,String msg,Throwable t){
		getLogger(clz).warn(msg,t);
	}
	
	public static void warm(Class clz,String msg){
		getLogger(clz).warn(msg);
	}
	
	public static void info(Class clz,String msg,Throwable t){
		getLogger(clz).info(msg,t);
	}
	
	public static void info(Class clz,String msg){
		getLogger(clz).info(msg);
	}
	
}
