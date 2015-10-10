package com.ea.core.cache;

import java.util.Collection;
import java.util.Map;


/**
 * 
 * @author daiqiang
 *
 */
public interface CacheProxy {
	/**
	 * 加入缓存(某些缓存考虑性能可能是异步实现,不返回操作结果)
	 * 要确认结果可以参加@see#putInCachWithReply
	 * @param key
	 * @param content
	 * @param expairTime
	 */
	public void putInCache(String key, Object content,int expairTime);
	/**
	 * 加入缓存，并返回确认
	 * @see#putInCache
	 * @param key
	 * @param val
	 * @param expiredTime
	 * @return
	 */
	public boolean putInCachWithReply(String key,Object val,int expiredTime);
	
	/**
	 * 取缓存对象
	 * @param key
	 * @return
	 */
	public Object getFromCache(String key);
	
	/**
	* @param keys
    * @param <T>
    * @return
    */
   public <T> Map<String,T> multiGet(Collection<String> keys);

	/**
	 * 删除缓存
	 * @see#removeEntryWithReply
	 * @param key
	 */
	public void removeEntry(String key);
	
	/**
	 * 删除缓存并返回确认
	 * @see#removeEntry
	 * @param key
	 * @return
	 */
	public boolean removeEntryWithReply(String key);
	
	/**
	 * 清空所有缓存
	 */
	public void flushAll();
	
	/**
	 * 清除指定缓存
	 * @param key
	 */
	public void flushEntry(String key);
	
	
}
