package com.ifly.edu.java.thread.sysn;

/**
 *
 * @author pangzhw
 * @date 2015年3月15日
 */
public class WaitNotifyTest {
	public static void main(String[] args) {
		RunnableTest myRunnanle = new RunnableTest();
		new Thread(myRunnanle).start();
		synchronized (myRunnanle) {
			try {
				System.out.println("第一步");
				myRunnanle.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("第四步");
		}

	}
}

class RunnableTest implements Runnable {
	public void run() {
		 try {
		 Thread.sleep(1);
		
		 } catch (InterruptedException e) {
		 e.printStackTrace();
		 }
		synchronized (this) {
			System.out.println("第二步");
			notify();
			System.out.println("第三步");
		}
	}
}
