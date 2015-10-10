package com.ea.core.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @comments
 * @author eagle.daiq
 * @date 2014-7-19
 */
public class MapUtils {
	public static final String DELIMITER_COMMA = ",";
	public static final String DELIMITER_DOT = ".";
	
	/**
	 * build array param pair to map.
	 * @param keyValPair
	 * @return
	 */
	public static Map<Object,Object> buildToMap(Object... keyValPair){
		if(keyValPair == null)
			throw new IllegalArgumentException("param must not be null.");
		
		int length = keyValPair.length;
		if(length%2!=0)
			throw new IllegalArgumentException("the length of Params must be multiple of 2.");
		Map<Object,Object> map = new HashMap<Object,Object>();
		Object key=null;
		for(int i=0;i<length;i++){
			if(i%2==0){
				key = keyValPair[i];
			}else{
				map.put(key, keyValPair[i]);
			}
		}
		return map;
	}
	
	/**
     * parse properties string group map key-val
     * @param p
     * @return
     */
    public static Map<String,Map<String,String>> getGroupByPrefixWithFirstDot(Properties p,String delimiter){
        if(p==null)
            return new HashMap<String, Map<String, String>>();
        Map<String,Map<String,String>> groupMap = new HashMap<String, Map<String, String>>();
        for(Map.Entry<Object,Object> entry:p.entrySet()){
            String key = (String)entry.getKey();
            int index = key.indexOf(delimiter);
            if(index>-1){
                String groupName = key.substring(0,index);
                String itemName = key.substring(index+1);
                if(itemName!=null && itemName.trim().length()>0){
                    Map<String,String> curGroupMap = groupMap.get(groupName);
                    if(curGroupMap==null){
                        curGroupMap = new HashMap<String, String>();
                        groupMap.put(groupName,curGroupMap);
                    }
                    curGroupMap.put(itemName,(String)entry.getValue());
                }
            }
        }
        return groupMap;
    }
	
	public static void main(String[] args){
//		System.out.println(buildToMap(null));
		System.out.println(buildToMap("key",1,"key2",2));
		System.out.println(buildToMap("name","开发"));
		System.out.println(buildToMap("name","开发","exception"));
	}

}
