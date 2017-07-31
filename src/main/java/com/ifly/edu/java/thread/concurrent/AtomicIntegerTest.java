package com.ifly.edu.java.thread.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author pangzhw
 * @date 2015年3月29日
 */
public class AtomicIntegerTest {
	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger(0);
		int i1 = ai.get();
		v(i1);
		int i2 = ai.getAndSet(5);
		v(i2);
		int i3 = ai.get();
		v(i3);
		int i4 = ai.getAndIncrement();
		v(i4);
		v(ai.get());
		
		int i5 = ai.getAndAdd(2);
		v(i5);
		System.out.println(ai.incrementAndGet());
		System.out.println(ai.getAndIncrement());
		System.out.println(ai.getAndAdd(2));
		System.out.println(ai.get());
      
	}

	static void v(int i) {
		System.out.println("i : " + i);
	}
}
