package com.ifly.edu.java.thread.concurrency.threadmgr;

/**
 * 线程的中断 Java提供中断机制来通知线程表明我们想要结束它。 
 * 中断机制的特性是线程需要检查是否被中断，而且还可以决定是否响应结束的请求。
 * 所以，线程可以忽略中断请求并且继续运行。
 * 
 * @author pangzhw
 * @date 2015年5月9日
 */
public class PrimeGenerator extends Thread {

	@Override
	public void run() {
		long number = 1L;
		System.out.printf("Number test");
		while (true) {
			if (isPrime(number)) {
				System.out.printf("Number %d is Prime", number);
			}
			if (isInterrupted()) {
				System.out.printf("The Prime Generator has been Interrupted");
				return;
			}
			number++;
		}
	}

	private boolean isPrime(long number) {
		if (number <= 2) {
			return true;
		}

		for (long i = 2; i < number; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		Thread task=new PrimeGenerator();
		task.start();
		
		try {
			   Thread.sleep(5000);
			} catch (InterruptedException e) {
			   e.printStackTrace();
			}
			task.interrupt();
	}
}
