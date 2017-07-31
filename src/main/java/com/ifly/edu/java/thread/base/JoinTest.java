package com.ifly.edu.java.thread.base;

/**
 *
 * @author pangzhw
 * @date 2015年3月15日
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {  
    	MyThread3 thread=new MyThread3();  
        thread.start();  
        thread.join(100);//将主线程加入到子线程后面，不过如果子线程在1毫秒时间内没执行完，则主线程便不再等待它执行完，进入就绪状态，等待cpu调度  
        for(int i=0;i<30;i++){  
            System.out.println(Thread.currentThread().getName() + "线程第" + i + "次执行！");  
        }  
    }  
}  
  
class MyThread3 extends Thread {  
    @Override  
    public void run() {  
        for (int i = 0; i < 1000; i++) {  
            System.out.println(this.getName() + "线程第" + i + "次执行！");  
        }  
    }  
}
