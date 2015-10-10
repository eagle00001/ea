package com.ea.core.aop;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 拦截上下文对象
 * @author daiqiang
 *
 */
public class InterceptorContext {
	private String className;	//类名
	private String methodName;	//方法名
	private Object[] paramObjs;	//方法参数名
	private Object methodResultObj; //方法执行结果
	private Method method;
	
	public InterceptorContext(String className, String methodName,
			Object[] paramObjs, Method method) {
		super();
		this.className = className;
		this.methodName = methodName;
		this.paramObjs = paramObjs;
		this.method = method;
	}
	
	//扩展参数
	private Map<Object, Object> map = new HashMap<Object, Object>();
	
	public Object getMethodResultObj() {
		return methodResultObj;
	}

	public void setMethodResultObj(Object methodResultObj) {
		this.methodResultObj = methodResultObj;
	}

	public InterceptorContext putValue(Object key,Object val){
		this.map.put(key, val);
		return this;
	}
	
	public Object getValue(Object key){
		return this.map.get(key);
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Object[] getParamObjs() {
		return paramObjs;
	}
	public void setParamObjs(Object[] paramObjs) {
		this.paramObjs = paramObjs;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
}
