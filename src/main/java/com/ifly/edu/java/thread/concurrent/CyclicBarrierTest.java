package com.ifly.edu.java.thread.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author pangzhw
 * @date 2015年3月14日
 */
public class CyclicBarrierTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final CyclicBarrier cb = new CyclicBarrier(3);
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						System.out.println("begin now");
						System.out.println(cb.getNumberWaiting());// 有一个等待，结果为0(即得到的结果为实际数减1)
						if (cb.getNumberWaiting() < 2)
							cb.await();
						System.out.println("end once");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			service.execute(runnable);
		}
		service.shutdown();
	}
}
