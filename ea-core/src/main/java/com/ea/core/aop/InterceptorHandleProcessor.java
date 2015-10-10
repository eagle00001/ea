package com.ea.core.aop;
/**
 * 
 * 拦截处理接口
 * @author daiqiang
 *
 */
public interface InterceptorHandleProcessor {
	/**
	 * 前置处理方法
	 * @param ctx
	 */
	public void doPreHandleProcess(InterceptorContext ctx);
	
	/**
	 * 后置处理方法
	 * @param ctx
	 */
	public void doPostHandleProcess(InterceptorContext ctx);
	
}
