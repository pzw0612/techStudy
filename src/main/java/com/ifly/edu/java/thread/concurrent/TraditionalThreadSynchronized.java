package com.ifly.edu.java.thread.concurrent;

/**
 *
 * @author pangzhw
 * @date 2015年3月7日
 */
public class TraditionalThreadSynchronized {
	public static void main(String[] args) {
		new TraditionalThreadSynchronized().init();
		}

	private void init() {
		final Printer printer = new Printer();
		new Thread(new Runnable() {

			public void run() {
				while (true) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					printer.print1("123456789");
				}
			}
		}).start();
		new Thread(new Runnable() {

			public void run() {
				while (true) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					printer.print2("987654321");
				}
			}
		}).start();
	}
		//内部类
		class Printer{
			public void print1(String name){ 
			int len = name.length();
			synchronized(this){
				for(int i=0;i<len;i++){
					System.out.print(name.charAt(i));
					}
				System.out.println();
			}
			
			}
			
			public void print2(String name){
				int len = name.length();
				synchronized (this){
				for(int i=0;i<len;i++){
				System.out.print(name.charAt(i));
				}
				System.out.println();
				}
		}
			
		}
}
