package com.ifly.edu.java.thread.base;

/**
 *
 * @author pangzhw
 * @date 2015年3月15日
 */
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {  
        new MyThread2().start();  
        new MyThread2().start();  
    }  
    
   
}  
  
class MyThread2 extends Thread {  
    @Override  
    public void run() {  
        for (int i = 0; i < 3; i++) {  
            System.out.println(this.getName()+"线程" + i + "次执行！");  
            try {  
                Thread.sleep(50);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
} 
