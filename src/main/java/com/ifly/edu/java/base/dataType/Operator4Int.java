package com.ifly.edu.java.base.dataType;

/**
 *
 * @author pangzhw
 * @date 2015年5月13日
 */
public class Operator4Int {
	public static void main(String[] args) {
		int i = 0;
		long s = System.nanoTime();
		i++;
		System.out.println("i++=" + (System.nanoTime() - s));

		s = System.nanoTime();
		i = i + 1;
		System.out.println("i=i+1=" + (System.nanoTime() - s));

		s = System.nanoTime();
		i += 1;
		System.out.println("i+=1=" + (System.nanoTime() - s));

		s = System.nanoTime();
		++i;
		System.out.println("++i=" + (System.nanoTime() - s));
	}
}
