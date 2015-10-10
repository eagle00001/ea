package com.ea.core.aop.impl;

import com.ea.core.aop.InterceptorContext;
import com.ea.core.aop.InterceptorHandleProcessor;
import com.ea.core.utils.LogUtils;

/**
 * 方法执行时间处理类
 * @note 该方法非线程安全,在spring注入中请使用prototype
 * 
 * @author daiqiang
 *
 */
public class MethodHandleTimeLogProcessor implements InterceptorHandleProcessor{
	public long starttime=0; 
	public String invokeMethodName;
	
	@Override
	public void doPreHandleProcess(InterceptorContext ctx) {
		StringBuilder sb = new StringBuilder(ctx.getClassName()).append("#")
				.append(ctx.getMethodName());
		this.invokeMethodName = sb.toString();
		this.starttime = System.currentTimeMillis();
		LogUtils.info(getClass(), this.invokeMethodName+" prepare to invoke.----------");
	}

	@Override
	public void doPostHandleProcess(InterceptorContext ctx) {
		long endtime = System.currentTimeMillis();
		long durationTime = endtime - this.starttime;
		LogUtils.info(getClass(), this.invokeMethodName+" invoke end. Total waster time is "+durationTime+"ms.----------");
	}
	
}
