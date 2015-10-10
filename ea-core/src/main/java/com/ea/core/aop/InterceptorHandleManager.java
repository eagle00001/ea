package com.ea.core.aop;

import java.util.List;

/**
 * 拦截处理管理类
 * @author daiqiang
 *
 */
public class InterceptorHandleManager {
	
	List<InterceptorHandleProcessor> handleProcessors;

	public List<InterceptorHandleProcessor> getHandleProcessors() {
		return handleProcessors;
	}

	public void setHandleProcessors(
			List<InterceptorHandleProcessor> handleProcessors) {
		this.handleProcessors = handleProcessors;
	}
}
