package com.ifly.edu.java.annotation;

/**
 *
 * @author pangzhw
 * @date 2015年3月29日
 */
public class Sample {

	@Test public static void m1() {
		
	}
	
	public static void m2(){
		
	}
	
	@Test public static void m3(){
		throw new RuntimeException("Boom");
	}
	public static void m4(){
		
	}
	
	@Test public void m5(){}
	
	public void m6(){
		
	}
	
	@Test public static void m7(){
		throw new RuntimeException("crash");
	}
    public static void m8(){}
	
}
