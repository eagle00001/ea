/**
 * 
 */
package com.ea.core.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ea.core.cache.impl.LocalCacheProxyImpl;


/**
 * @author daiqiang
 * 本地缓存工厂类
 */
public class LocalCacheFactory {
	private static final Logger log = LoggerFactory.getLogger(LocalCacheFactory.class);
	private static CacheProxy cache = null;
	
	private LocalCacheFactory(){
	}
	
	public synchronized static CacheProxy initLocalCache(String filePath,CacheListener listener){
		log.info("Begin to initialize the localCache...");
		
		cache = new LocalCacheProxyImpl(filePath,listener);
		
		log.info("The localCache initialized successful.");
		return cache;
	}
	
	public synchronized static CacheProxy initLocalCache(LocalCacheProxyImpl localCacheProxyImpl){
		log.info("Begin to initialize the localCache...");
		
		if(localCacheProxyImpl!=null)
			cache = localCacheProxyImpl;
		
		log.info("The localCache initialized successful.");
		return cache;
	}
	
	public static CacheProxy getLocalCache(){
		if(cache==null){
			initLocalCache(LocalCacheProxyImpl.DEFAULT_OSCACHE_PROPERTIES,null);
		}
		return cache;
	}
}
