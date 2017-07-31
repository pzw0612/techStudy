package com.ifly.edu.java.base.dataType;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pangzhw
 * @date 2015年5月13日
 */
public class Operator4Set {
	public static void main(String[] args) {
      Set set = new HashSet();
      
      set.add("apple");
      set.add("cab");
      set.add("banana");
      
      for(int i=0; i<100000; i++){
    	  
          for(Object obj: set){
        	  System.out.print(obj);
          }
          System.out.println();
      }

	}
}
