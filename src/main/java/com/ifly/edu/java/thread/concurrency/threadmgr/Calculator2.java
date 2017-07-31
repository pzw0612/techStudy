package com.ifly.edu.java.thread.concurrency.threadmgr;

/**
 *获取和设置线程信息
    ID: 每个线程的独特标识。
    Name: 线程的名称。
    Priority: 线程对象的优先级。优先级别在1-10之间，1是最低级，10是最高级。不建议改变它们的优先级，但是你想的话也是可以的。
    Status: 线程的状态。在Java中，线程只能有这6种中的一种状态： new, runnable, blocked, waiting, time waiting, 或 terminated.

 * @author pangzhw
 * @date 2015年5月8日
 */
public class Calculator2 implements Runnable {
	private int number;

	public Calculator2(int number) {
		this.number = number;
	}
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
		}
		
	}
}
