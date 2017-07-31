package com.ifly.edu.java.thread.base;

/**
 *
 * @author pangzhw
 * @date 2015年3月15日
 */
public class InterruptTest2 {
	  public static void main(String[] args) throws InterruptedException {
      	   System.out.println(Thread.currentThread().getName() +" working start");

		    MyThread6 thread=new MyThread6();  
	        thread.start(); 
	        Thread.sleep(3000);
//	        
//	        boolean flg = false;
//	        for(int i=0; i<300000000; i++){
//	        	if(i==299999900){
//	        		flg= true;
//	        	}
//	        	//@计算
//	        }
//	        if(flg){
//	        	 thread.interrupt();  
//	        }
	        thread.interrupt(); 
	       System.out.println(Thread.currentThread().getName() +" working end");
	    }  
	}  
	  
	class MyThread6 extends Thread {  
	    int i=0;  
	    @Override  
	    public void run() {  
	        while (true) {  
	            System.out.println(i);  
	            try {  
	            	System.out.println(Thread.currentThread().getName() +" working start");
	                Thread.sleep(1000);  
	                
	                System.out.println(Thread.currentThread().getName() +" working end");
	            } catch (InterruptedException e) {  
	                System.out.println("中断异常被捕获了");  
	                return;  
	            }  
	            i++;  
	        }  
	    }  
	}  