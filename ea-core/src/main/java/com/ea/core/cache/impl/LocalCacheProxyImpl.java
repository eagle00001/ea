package com.ea.core.cache.impl;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.ea.core.cache.CacheListener;
import com.ea.core.cache.CacheProxy;
import com.ea.core.utils.FileLoadUtils;
import com.ea.core.utils.LogUtils;
import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.web.filter.ExpiresRefreshPolicy;
/**
 * 
 * @author daiqiang
 *
 */
public class LocalCacheProxyImpl extends DefaultCacheProxyAdapter implements CacheProxy {
	
	private GeneralCacheAdministrator instance;
	private CacheListener cacheListener;
	
	public static final String DEFAULT_OSCACHE_PROPERTIES = "oscache.properties";
	
	public LocalCacheProxyImpl(String filePath,CacheListener listener){
		Properties p = null;
		
		if(StringUtils.isNotBlank(filePath)){
			p = FileLoadUtils.loadFileWithProperties(filePath);
		}
		
		GeneralCacheAdministrator osCacheAdmin = new GeneralCacheAdministrator(p);
		this.instance = osCacheAdmin;
		this.cacheListener = listener;
	}
	
	public LocalCacheProxyImpl(String filePath){
		this(filePath,null);
	}
	
	@Override
	public void putInCache(String key, Object content,int expairTime) {
		paramNullCheck(key,"The localCache key is not allowed null.");
		paramNullCheck(content,"The localCache value is not allowed null.");
		
		if(this.cacheListener!=null){
			if(this.cacheListener.beforePutInCache(key, content, expairTime))
				instance.putInCache(key, content, new ExpiresRefreshPolicy(expairTime));
		}else{
			instance.putInCache(key, content, new ExpiresRefreshPolicy(expairTime));
		}
		
	}

	@Override
	public Object getFromCache(String key) {
		try {
			Object obj = this.instance.getFromCache(key);
			
			if(this.cacheListener!=null){
				obj = this.cacheListener.afterGetFromCache(key, obj);
			}
			
			return obj;
		} catch (NeedsRefreshException e) {
			this.instance.cancelUpdate(key);
//			log.error("The key["+key+"] from cache is null.",e);
			return null;
		}
	}
	
	


	/* (non-Javadoc)
	 * @see com.ea.bl.core.cache.impl.DefaultCacheProxyAdapter#putInCachWithReply(java.lang.String, java.lang.Object, int)
	 */
	@Override
	public boolean putInCachWithReply(String key, Object val, int expiredTime) {
		try {
			this.putInCache(key, val, expiredTime);
			return true;
		} catch (Exception e) {
			LogUtils.error(LocalCacheProxyImpl.class,"putInCachWithReply error:",e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ea.bl.core.cache.impl.DefaultCacheProxyAdapter#multiGet(java.util.Collection)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> Map<String, T> multiGet(Collection<String> keys) {
		if(CollectionUtils.isEmpty(keys))
			return null;
		Map<String,T> multiKeyMap = new HashMap<String, T>();
		for(String key:keys){
			Object obj = this.getFromCache(key);
			multiKeyMap.put(key, (T)obj);
		}
		return multiKeyMap;
	}

	/* (non-Javadoc)
	 * @see com.ea.bl.core.cache.impl.DefaultCacheProxyAdapter#removeEntryWithReply(java.lang.String)
	 */
	@Override
	public boolean removeEntryWithReply(String key) {
		try {
			this.removeEntry(key);
			return true;
		} catch (Exception e) {
			LogUtils.error(LocalCacheProxyImpl.class,"removeEntryWithReply error:",e);
			return false;
		}
	}

	@Override
	public void removeEntry(String key) {
		this.instance.removeEntry(key);
		if(this.cacheListener!=null){
			this.cacheListener.afterRemoveEntry(key);
		}
	}

	@Override
	public void flushAll() {
		this.instance.flushAll();
		if(this.cacheListener!=null){
			this.cacheListener.afterFlushAll();
		}
	}

	@Override
	public void flushEntry(String key) {
		this.instance.flushEntry(key);
		if(this.cacheListener!=null){
			this.cacheListener.afterRemoveEntry(key);
		}
	}

}
