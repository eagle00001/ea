package com.ea.apps.beans;
/**
 * 系统服务返回code静态常量类
 * 要求所有返回code不要相同,便于统一规范服务代码
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月14日
@description:
 **/
public interface AppServiceCodeConstants {
	/*------公共code 定义, 格式两位, start---------*/
	public final static String SUCCESS = "00";
	public final static String PARAM_INVALID = "01";
	public final static String UNKNOW_ERROR = "99";
	/*------公共code 定义, 格式两位, end---------*/
	
	/*------业务相关code定义，格式4-6位, start--------*/
	
	/*------业务相关code定义，格式4-6位, end--------*/
}

