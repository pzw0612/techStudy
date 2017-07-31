package com.ifly.edu.java.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *线程池
 * @author pangzhw
 * @date 2015年3月14日
 */
public class ExecutorServiceTest {
	public static void main(String[] args) {
		//缓冲线程池
		ExecutorService threadPool =   Executors.newCachedThreadPool();
		//单一线程池
//		ExecutorService threadPool =   Executors.newSingleThreadExecutor();
		//固定大小的线程池
//		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for(int i=1;i<=10;i++){
			final int task = i;
			threadPool.execute(new Runnable() {

				public void run() {
					for (int j = 1; j <= 10; j++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ " has complete " + j * 10 + "% for task of "
								+ task);
					}
				}
			});
		}
		System.out.println(Thread.currentThread().getName()+"is working");
		System.out.println("all of 10 tasks have committed! ");
		}
}
