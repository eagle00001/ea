package com.ea.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ea.core.AbstractBaseTest;
import com.ea.core.cache.impl.MemcacheProxyImpl;

public class CacheProxyTest extends AbstractBaseTest {

	public static void main(String[] args) {
		CacheProxyTest testCase = new CacheProxyTest();
		testCase.loadAppContextXmlCfg(null);
		
		System.out.println("memcach cache test...");
		MemcacheProxyImpl proxy = (MemcacheProxyImpl)testCase.appllicationContext.getBean("memcacheProxy");
		testCase.testCacheProxy(proxy);
		
		System.out.println("local cache test...");
		testCase.testCacheProxy(LocalCacheFactory.getLocalCache());
	}
	
	public void testCacheProxy(CacheProxy proxy){
		
		proxy.putInCache("test111", 111, 5);
		System.out.println(String.format("get cache key=%s, value=%s.", "test111",proxy.getFromCache("test111")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(String.format("get cache expire key=%s, value=%s.", "test111",proxy.getFromCache("test111")));
		
		String key = "englishName";
		proxy.putInCachWithReply(key, "eagle", 50);
		System.out.println(String.format("get cache  key=%s, value=%s.", key,proxy.getFromCache(key)));
		
		
		String key2 = "chinaName";
		proxy.putInCache(key2, "daiqiang", 50);
		
		List<String> keys = new ArrayList<String>();
		keys.add(key);
		keys.add(key2);
		Map<String,Object> keyValMap = MemcacheProxyFactory.getMemcache().multiGet(keys);
		
		for(Entry<String, Object> entry:keyValMap.entrySet()){
			System.out.println(String.format(" multiGet key=%s, value=%s.", entry.getKey(),entry.getValue()));
		}
		
		proxy.removeEntry(key);
		System.out.println(String.format("get cache remove key=%s, value=%s.", key,proxy.getFromCache(key)));
		
	}

}
