package com.ifly.edu.java.thread.sysn;

/**
 *
 * @author pangzhw
 * @date 2015年3月15日
 */
public class DeadLockTest {
	  public static void main(String[] args) {  
	        Object object1=new Object();  
	        Object object2=new Object();  
	        new Thread(new T(object1,object2)).start();  
	        new Thread(new T(object2,object1)).start();  
	    }  
	}  
	class T implements Runnable{  
	    private Object object1;  
	    private Object object2;  
	    public T(Object object1,Object object2) {  
	        this.object1=object1;  
	        this.object2=object2;  
	    }  
	    public void run() {  
	        synchronized (object1) {  
	            try {  
	            	 System.out.println(Thread.currentThread().getName());
	                Thread.sleep(1000);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            }  
	            synchronized (object2) {  
	                System.out.println("无法执行到这一步");  
	            }
	           
	        }  
	    };  
	}  