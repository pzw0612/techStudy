package com.ifly.edu.java.thread.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决多线程之间相互协调工作
 * 
 *子线程循环10次，接着主线程循环10次，接着又回到子线程循环10次，接着再回到主线程循环10次
 * @author pangzhw
 * @date 2015年3月14日
 */
public class ThreadCommunication {
	public static void main(String[] args) throws InterruptedException {
		final Business business = new Business();
		
			new Thread(new Runnable() {
				public void run() {
					try {
						for (;;)
							try {
								business.sub();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					} catch (RuntimeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		

		for (;;)
			business.main();
	}
}

class Business {
	private boolean bShouldSub = false;

	public synchronized void sub() throws InterruptedException {
		while (!bShouldSub) {
			this.wait();
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println(Thread.currentThread().getName()+" sub thread sequence of " + j);
		}
		bShouldSub = false;
		this.notifyAll();
	}

	public synchronized void main() throws InterruptedException {
		while (bShouldSub) {
			this.wait();
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("main thread sequence of " + j);
		}
		bShouldSub = true;
		this.notifyAll();
	}
}

//
//class Business {
//	Lock lock = new ReentrantLock();
//	Condition condition = lock.newCondition();
//	private boolean bShouldSub = true;
//
//	public void sub() {
//		lock.lock();
//		try {
//			while (!bShouldSub) {
//				try {
//					condition.await();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			for (int j = 1; j <= 10; j++) {
//				System.out.println("sub thread sequence of " + j);
//			}
//			bShouldSub = false;
//			condition.signal();
//		} finally {
//			lock.unlock();
//		}
//	}
//
//	public void main() {
//		lock.lock();
//		try {
//			while (bShouldSub) {
//				try {
//					condition.await();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			for (int j = 1; j <= 10; j++) {
//				System.out.println("main thread sequence of " + j);
//			}
//			bShouldSub = true;
//			condition.signal();
//		} finally {
//			lock.unlock();
//		}
//	}
//}
