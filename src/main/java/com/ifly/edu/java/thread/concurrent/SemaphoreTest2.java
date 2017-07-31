package com.ifly.edu.java.thread.concurrent;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import java.util.concurrent.Semaphore;

/**
 *
 * @author pangzhw
 * @date 2015年3月14日
 */
public class SemaphoreTest2 {
	public static void main(String[] args) {

		// 线程池

		ExecutorService exec = Executors.newCachedThreadPool();

		// 只能5个线程同时访问

		final Semaphore semp = new Semaphore(1,true);

		// 模拟20个客户端访问

		for (int index = 0; index < 20; index++) {

			final int NO = index;

			Runnable run = new Runnable() {

				public void run() {

					try {

						// 获取许可

						semp.acquire();

						System.out.println("Accessing: " + NO);

						Thread.sleep((long) (Math.random() * 20));

						// 访问完后，释放
						
						semp.release();
						
						System.out.println(NO+" Thread out------"+ semp.availablePermits());

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

				}

			};

			exec.execute(run);
			
			

		}

		// 退出线程池

		exec.shutdown();

	}
}
