package com.ifly.edu.java.thread.concurrent;

import java.util.concurrent.Semaphore;

/**
 *
 * @author pangzhw
 * @date 2015年3月14日
 */
public class SemaphoreThread extends Thread {
	private Semaphore current;
	private Semaphore next;

	public SemaphoreThread(String name, Semaphore current, Semaphore next) {
		super(name);
		this.current = current;
		this.next = next;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				current.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(this.getName());
			next.release();
		}
	}

	public static void main(String[] args) {
		Semaphore a = new Semaphore(1);
		Semaphore b = new Semaphore(0);
		Semaphore c = new Semaphore(0);
		new SemaphoreThread("A", a, b).start();
		new SemaphoreThread("B", b, c).start();
		new SemaphoreThread("C", c, a).start();
	}
}
