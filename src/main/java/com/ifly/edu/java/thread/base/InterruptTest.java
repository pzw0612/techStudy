package com.ifly.edu.java.thread.base;

/**
 *
 * @author pangzhw
 * @date 2015年3月15日
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {  
    	MyThread5 thread=new MyThread5();  
        thread.start();  
    }  
}  
  
class MyThread5 extends Thread {  
    int i=1;  
    @Override  
    public void run() {  
        while (true) {  
            System.out.println(i);  
            System.out.println(this.isInterrupted());  
            try {  
                System.out.println("我马上去sleep了");  
                this.sleep(3000);  
                this.interrupt();  
            } catch (InterruptedException e) {  
                System.out.println("异常捕获了"+this.isInterrupted());  
                return;  
            }  
            i++;  
        }  
    }  
} 
