package com.ifly.edu.java.thread.concurrent;

/**
 *
 * @author pangzhw
 * @date 2015年3月7日
 */
public class TestThread {
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("第一个线程  姓名："
							+ Thread.currentThread().getName());
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("第二个线程  姓名："
							+ Thread.currentThread().getName());
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("第三个线程  姓名："
							+ Thread.currentThread().getName());
				}
			}
		}.start();
		System.out.println("main线程  姓名:" + Thread.currentThread().getName());
	}
}
