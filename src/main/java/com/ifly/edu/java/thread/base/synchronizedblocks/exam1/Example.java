package com.ifly.edu.java.thread.base.synchronizedblocks.exam1;

/**
 *
 * @author pangzhw
 * @date 2015年5月9日
 */
class Counter{
    long count = 0;

    public synchronized void add(long value){
      this.count += value;
      
    }
 }
  class CounterThread extends Thread{

    protected Counter counter = null;

    public CounterThread(Counter counter){
       this.counter = counter;
    }

    public void run() {
	for(int i=0; i<10; i++){
          counter.add(i);
          System.out.println(counter.count);
       }
    }
 }
 public class Example {

   public static void main(String[] args){
     Counter counter = new Counter();
    // Counter counter2 = new Counter();
     Thread  threadA = new CounterThread(counter);
     Thread  threadB = new CounterThread(counter);

     threadA.start();
     threadB.start();
     
     

   }
 }
