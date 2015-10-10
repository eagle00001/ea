package com.ea.core.aop;

import java.lang.reflect.Method;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;

import com.ea.core.utils.ApplicationContextHelper;

/**
 *@author:eagle.daiq
 *@company:iot.chinamobile
 *@date:2015年7月15日
 *@description:
 **/
public class InterceptorHandlerAdvice implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Method method = invocation.getMethod();
		//find annotation class.
		InterceptorHandler ann = AnnotationUtils.findAnnotation(method, InterceptorHandler.class);
		if(ann==null)
			return invocation.proceed();
		
		//pross the interception chain 
		String id = ann.id();
		if(StringUtils.isBlank(id)){
			return invocation.proceed();
		}
		
		InterceptorHandleManager interceptorMgr = (InterceptorHandleManager)ApplicationContextHelper.getBeanObject(id);
		if(interceptorMgr==null)
			return invocation.proceed();
		
		List<InterceptorHandleProcessor> handleProcessors = interceptorMgr.getHandleProcessors();
		if(CollectionUtils.isEmpty(handleProcessors))
			return invocation.proceed();
		
		//init context.
		
		Object[] params = invocation.getArguments();
		String classname = method.getDeclaringClass().toString();
		String methodname = invocation.getMethod().getName();
		InterceptorContext ctx = new InterceptorContext(classname,methodname,params,method);
		
		// pre handle process.
		for(InterceptorHandleProcessor processor:handleProcessors){
			processor.doPreHandleProcess(ctx);
		}
		
		//invoke method.
		Object revBoj = invocation.proceed();
		
		ctx.setMethodResultObj(revBoj);
		
		// post handle process.
		for(int i=handleProcessors.size()-1;i>=0;i--){
			handleProcessors.get(i).doPostHandleProcess(ctx);
		}
		
		return revBoj;
	}

}

