package com.ifly.edu.java.generic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description: TODO
 * @author pangzhw
 * @date 2015年2月15日
 */
public class Util {
    public static void main(String[] args) {
		
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	map.put("key1", "abc");
    	map.put("key2", 111111);
    	map.put("key3", 23333.0f);
    	map.put("key4", 23333.0d);
    	
//    	System.out.println(getObject(String.class,map.get("key1")));
//    	System.out.println(getObject(Integer.class,map.get("key2")));
//    	System.out.println(getObject(Float.class,map.get("key3")));
//    	System.out.println(getObject(Double.class,map.get("key4")));
    	System.out.println(getObject2(Double.class,map.get("key4")));
    	System.out.println(getObject2(Float.class,map.get("key3")));
    	System.out.println(getObject2(Integer.class,map.get("key2")));
    	System.out.println(getObject2(String.class,map.get("key1")));
    	
    
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getObject( Object obj){
		if(obj==null){
			return null;
		}
		return (T)obj;
	}
	
	public static <T> T getObject2(Class<T> cls, Object obj){
		if(obj==null){
			return null;
		}
		return cls.cast(obj);
	}
}
