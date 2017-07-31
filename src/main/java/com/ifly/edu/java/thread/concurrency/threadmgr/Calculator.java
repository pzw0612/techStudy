package com.ifly.edu.java.thread.concurrency.threadmgr;

/**
 *  线程怎么工作

每个Java程序最少有一个执行线程。当你运行程序的时候, JVM运行负责调用main()方法的执行线程。

当调用Thread对象的start()方法时, 我们创建了另一个执行线程。
在这些start()方法调出后，我们的程序就有了多个执行线程。

当全部的线程执行结束时（更具体点，所有非守护线程结束时），Java程序就结束了。
如果初始线程（执行main()方法的主线程）运行结束，其他的线程还是会继续执行直到执行完成。
但是如果某个线程调用System.exit()指示终结程序，那么全部的线程都会结束执行。

创建一个Thread类的对象不会创建新的执行线程。
同样，调用实现Runnable接口的 run()方法也不会创建一个新的执行线程。
只有调用start()方法才能创建一个新的执行线程。

 * @author pangzhw
 * @date 2015年5月8日
 */
public class Calculator implements Runnable {
	private int number;

	public Calculator(int number) {
		this.number = number;
	}
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
		}
		
	}
}
