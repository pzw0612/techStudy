package com.ifly.edu.java.cls;

/**
 *
 * @Description: TODO
 * @author pangzhw
 * @date 2015年2月15日
 */
public class ClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println( Object.class.isAssignableFrom(Object.class) );         
		System.out.println( Object.class.isAssignableFrom(String.class) );          
		System.out.println(String.class.isAssignableFrom(Object.class));   
		 Class<?> parent = java.io.InputStream.class;  
	     Class<?> child = java.io.FileInputStream.class;  
	     System.out.println(parent.isAssignableFrom(child));  
	}

}
