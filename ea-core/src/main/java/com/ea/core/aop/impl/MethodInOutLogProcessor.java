package com.ea.core.aop.impl;

import org.apache.commons.lang3.ArrayUtils;

import com.ea.core.aop.InterceptorContext;
import com.ea.core.aop.InterceptorHandleProcessor;
import com.ea.core.utils.LogUtils;

public class MethodInOutLogProcessor implements InterceptorHandleProcessor {

	@Override
	public void doPreHandleProcess(InterceptorContext ctx) {
		Object params = ctx.getParamObjs()==null?null:ArrayUtils.toString(ctx.getParamObjs());
		LogUtils.info(getClass(), ctx.getMethod().getDeclaringClass().toString()+" params : "+params);
	}

	@Override
	public void doPostHandleProcess(InterceptorContext ctx) {
		LogUtils.info(getClass(), ctx.getMethod().getDeclaringClass().toString()+" result : "+ctx.getMethodResultObj());
	}

}
