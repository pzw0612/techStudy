package com.ifly.edu.java.thread.concurrent;

/**
 *
 * @author pangzhw
 * @date 2015年3月7日
 */
public class CreateThread {
	public static void main(String[] args) {
		// 第一种创建方式(继承类)
		new Thread() {
			@Override
			public void run() {
				System.out.println("线程1  姓名："
						+ Thread.currentThread().getName());
			}
		}.start();
		// 第二种创建方式(实现接口)
		new Thread(new Runnable() {
			public void run() {
				System.out.println("线程2  姓名："
						+ Thread.currentThread().getName());
			}
		}).start();
	}
}
