package com.ea.core.cache;

import com.ea.core.cache.impl.MemcacheProxyImpl;
import com.ea.core.utils.LogUtils;

/**
 * @comments
 * @author eagle.daiq
 * @date 2013-4-5
 */
public class MemcacheProxyFactory {
	private static CacheProxy cache;
	
	private MemcacheProxyFactory(){
		
	}
	
	public synchronized static CacheProxy initMemcacheProxy(String filePath,CacheListener listener){
		cache = new MemcacheProxyImpl(filePath,listener);
		return cache;
	}
	
	public synchronized static CacheProxy initMemcacheProxy(MemcacheProxyImpl memcacheProxyImpl){
		LogUtils.info(MemcacheProxyFactory.class, "Begin to initialize memcacheProxy...");
		
		if(memcacheProxyImpl!=null){
			cache = memcacheProxyImpl;
		}
		
		LogUtils.info(MemcacheProxyFactory.class, "Initialize memcacheProxy success...");
		
		return cache;
	}
	
	public static CacheProxy getMemcache(){
		if(cache==null)
			initMemcacheProxy(MemcacheProxyImpl.DEFAULT_MEMCACHE_PROPERTIES,null);
		return cache;
	}
}
