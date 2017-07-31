package com.ifly.edu.java.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * vm args: -Xms20M -Xmx20M -Xmn10M -XX:+HeapDumpOnOutOfMemoryError
 * -verbose.gc
 * @author pangzhw
 * @date 2015年5月16日
 */
public class HeapOOM {
  
	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
