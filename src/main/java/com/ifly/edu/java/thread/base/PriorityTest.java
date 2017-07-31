package com.ifly.edu.java.thread.base;

/**
 *
	 *每个线程执行时都有一个优先级的属性，优先级高的线程可以获得较多的执行机会，
	 *而优先级低的线程则获得较少的执行机会。与线程休眠类似，线程的优先级仍然无法保障线程的执行次序。
	 *只不过，优先级高的线程获取CPU资源的概率较大，优先级低的也并非没机会执行。
	每个线程默认的优先级都与创建它的父线程具有相同的优先级，在默认情况下，main线程具有普通优先级。
	Thread类提供了setPriority(int newPriority)和getPriority()方法来设置和返回一个指定线程的优先级，
	其中setPriority方法的参数是一个整数，范围是1~·0之间，也可以使用Thread类提供的三个静态常量：
	MAX_PRIORITY   =10
	MIN_PRIORITY   =1
	NORM_PRIORITY   =5

 * @author pangzhw
 * @date 2015年3月15日
 */
public class PriorityTest {
    public static void main(String[] args) throws InterruptedException {  
        new MyThread4("高级", 10).start();  
        new MyThread4("低级", 1).start();  
    }  
}  
  
class MyThread4 extends Thread {  
    public MyThread4(String name,int pro) {  
        super(name);//设置线程的名称  
        setPriority(pro);//设置线程的优先级  
    }  
    @Override  
    public void run() {  
        for (int i = 0; i < 100; i++) {  
            System.out.println(this.getName() + "线程第" + i + "次执行！");  
        }  
    }  
}
