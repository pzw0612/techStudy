package com.ifly.edu.java.thread.base;

/**
 * 前台线程是保证执行完毕的，后台线程还没有执行完毕就退出了
 * 
 * 守护线程的用途：
    守护线程通常用于执行一些后台作业，例如在你的应用程序运行时播放背景音乐，在文字编辑器里做自动语法检查、自动保存等功能。Java的垃圾回收也是一个守护线程。
    守护线 的好处就是你不需要关心它的结束问题

 * @author pangzhw
 * @date 2015年3月15日
 */
public class DaemonTest {
	public static void main(String[] args) {
		Thread t1 = new MyCommon();
		Thread t2 = new Thread(new MyDaemon());
		t2.setDaemon(true); // 设置为守护线程

		t2.start();
		t1.start();
	}
}

class MyCommon extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("线程1第" + i + "次执行！");
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyDaemon implements Runnable {
	public void run() {
		for (long i = 0; i < 9999999L; i++) {
			System.out.println("后台线程第" + i + "次执行！");
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}