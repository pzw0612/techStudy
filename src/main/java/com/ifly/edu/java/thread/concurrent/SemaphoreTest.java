package com.ifly.edu.java.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 可以维护当前访问自身的线程个数，并提供了同步机制。使用他可以控制同时访问资源的线程个数
 * @author pangzhw
 * @date 2015年3月14日
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore sp = new Semaphore(3);
		for (int i = 0; i < 10; i++) {// 往线程池里扔10个任务
			Runnable runnable = new Runnable() {
				public void run() {
					
					try {
						sp.acquire();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println(sp.availablePermits());
					sp.release();
				}
			};
			service.execute(runnable);
		}
	}
}