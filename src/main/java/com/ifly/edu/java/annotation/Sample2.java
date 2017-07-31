package com.ifly.edu.java.annotation;

/**
 *
 * @author pangzhw
 * @date 2015年3月29日
 */
public class Sample2 {

	@ExceptionTest(ArithmeticException.class)
	public static void m1(){
		int i=0;
		i = i/i;
	}
	@ExceptionTest(ArithmeticException.class)
	public static void m2(){
		int[] a= new int[0];
		int i = a[1];
	}
	@ExceptionTest(ArithmeticException.class)
	public static void m3(){}
	
	@ExceptionTest(ArithmeticException.class)
	public  void m4(){}
	
	
	
}
