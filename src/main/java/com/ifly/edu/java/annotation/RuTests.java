package com.ifly.edu.java.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author pangzhw
 * @date 2015年3月29日
 */
public class RuTests {

	public static void main(String[] args) {

		int tests=0;
		int passed=0;
		Class<Sample2> testClass = Sample2.class;
		for(Method m: testClass.getDeclaredMethods()){
			if(m.isAnnotationPresent(Test.class)){
				tests++;
				try{
					m.invoke(null);
					passed++;
				}catch(InvocationTargetException e){
					Throwable exc = e.getCause();
					System.out.println(m+ "failed: " + exc);
				}catch(Exception exc){
					System.out.println("INVALID @Test: "+ exc);
				}
			}
			if(m.isAnnotationPresent(ExceptionTest.class)){
				tests++;
				try{
					m.invoke(null);
					System.out.printf("test %s failed: no exception %n",m);
				}catch(InvocationTargetException e){
					Throwable exc = e.getCause();
					Class<? extends Exception> excType = m.getAnnotation(ExceptionTest.class).value();
					if(excType.isInstance(exc)){
						passed++;
					}else{
						System.out.printf("Test %s failed: expected %s,got %s%n", m, excType.getName(),exc);
					}
				}catch(Exception exc){
					System.out.println("INVALID @Test: "+ exc);
				}
			}
		}
		System.out.printf("passed: %d, failed: %d%n" ,passed, tests-passed);;
		
	}
	
}
