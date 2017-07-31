package com.ifly.edu.java.cls;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Description: TODO
 * @author pangzhw
 * @date 2015年2月15日
 */
public class Test<T> extends ClassA<T> {

	  private List<String> list;     
	  
	    public void testA() throws NoSuchFieldException, SecurityException{  
	        Type t = Test.class.getDeclaredField("list").getGenericType();  
	        if (ParameterizedType.class.isAssignableFrom(t.getClass())) {              
	            for (Type t1:((ParameterizedType)t).getActualTypeArguments()) {          
	                System.out.print(t1 + ",");          
	            }          
	            System.out.println();          
	        }   
	   }  
	   public static void main(String args[]) throws Exception{       
	            System.out.println("======getSuperclass======:");      
	            System.out.println(Test.class.getSuperclass().getName());     
	            System.out.println("======getGenericSuperclass======:");     
	            Type t = Test.class.getGenericSuperclass();      
	            System.out.println(t);       
	            if (ParameterizedType.class.isAssignableFrom(t.getClass())) {    
	                     System.out.print("----------->getActualTypeArguments:");       
	                     for (Type t1:((ParameterizedType)t).getActualTypeArguments()) {       
	                                    System.out.print(t1 + ",");       
	                      }       
	                     System.out.println();       
	            }   
	            
	            List<String> list = new ArrayList<String>();  
	            System.out.println(list instanceof List);  
	            System.out.println(list instanceof ArrayList);  
	
	              
	            System.out.println(list.getClass().isAssignableFrom(List.class));  
	            System.out.println(list.getClass());
	            System.out.println(List.class.isAssignableFrom(list.getClass()));  
	   }     
	  
	   
}
