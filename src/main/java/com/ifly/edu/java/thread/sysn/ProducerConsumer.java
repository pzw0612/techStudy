package com.ifly.edu.java.thread.sysn;

/**
 *
 * @author pangzhw
 * @date 2015年3月15日
 */
public class ProducerConsumer {  
    public static void main(String[] args) {  
        BasketBall basketBall=new BasketBall();  
        new Thread(new Producer(basketBall)).start();  
        new Thread(new Consumer(basketBall)).start();  
    }  
} 
//馒头的实例  
class ManTou {  
 private int id;// 馒头的id  

 public ManTou(int id) {  
     this.id = id;  
 }  
 public String toString(){  
     return "ManTou"+id;  
 }  
} 

class BasketBall {  
    private int index = 0;// 表示装到第几个了馒头  
    private ManTou[] manTous = new ManTou[6];// 可以放6个馒头  
  
    // 放进去一个馒头  
    public synchronized void push(ManTou manTou) {  
        while(index==manTous.length){  
            try {  
                System.out.println("篮子满了！");  
                this.wait();  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println(Thread.currentThread().getName()+"生产"+manTou.toString());  
        this.notify();  
        manTous[index] = manTou;  
        index++;  
    }  
  
    // 拿一个馒头  
    public synchronized ManTou pop() {  
        while (index==0) {  
            try {  
                System.out.println("篮子空了！");  
                this.wait();  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        ManTou manTou=manTous[--index];  
        System.out.println(Thread.currentThread().getName()+"吃了"+manTou.toString());  
        this.notify();  
        return manTou;  
    }  
}  

// 生产者，生产馒头  
class Producer implements Runnable {  
    private BasketBall basketBall;  
  
    public Producer(BasketBall basketBall) {  
        this.basketBall = basketBall;  
    }  
  

    public void run() {  
        for (int i = 0; i < 20; i++) {  
            ManTou manTou = new ManTou(i);// 生产馒头  
            basketBall.push(manTou);  
            try {  
                Thread.sleep(500);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  
// 消费者，拿馒头吃  
class Consumer implements Runnable {  
    private BasketBall basketBall;  
  
    public Consumer(BasketBall basketBall) {  
        this.basketBall = basketBall;  
    }  
  
 
    public void run() {  
        for (int i = 0; i < 20; i++) {  
            ManTou manTou=basketBall.pop();  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  