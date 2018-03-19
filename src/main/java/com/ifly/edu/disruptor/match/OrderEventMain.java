package com.ifly.edu.disruptor.match;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.aspectj.weaver.ast.Or;

import java.math.BigDecimal;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class OrderEventMain {

    //买单队列
    private static PriorityQueue<Order> buyQueue = new PriorityQueue<Order>(new OrderBuyCompartor());
    //卖单队列
    private static PriorityQueue<Order> sellQueue = new PriorityQueue<Order>(new OrderSellCompartor());

    public static void main(String[] args) throws Exception {
        // Executor that will be used to construct new threads for consumers
        //Executor executor = Executors.newCachedThreadPool();
        Executor executor = Executors.newSingleThreadExecutor();

        // The factory for the event
        orderEventFactory factory = new orderEventFactory();

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;

        // Construct the Disruptor
        Disruptor<Order> disruptor = new Disruptor<Order>(factory, bufferSize, new SimpeThreadFactory(), ProducerType.SINGLE,
                new BlockingWaitStrategy());

        // Connect the handler
        disruptor.handleEventsWith(new OrderHandler(buyQueue, sellQueue));

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<Order> ringBuffer = disruptor.getRingBuffer();

        OrderProducer producer = new OrderProducer(ringBuffer);

        for (int i = 0; i < 100000; i++) {
            String tradeType = random() == 1 ? "buy" : "sell";
            Order order1 = new Order(UUID.randomUUID().toString(), new BigDecimal(randomPrice()), new BigDecimal(randomAmount()), tradeType, System.currentTimeMillis(), 0, "btc");
            producer.onData(order1);
        }

        Thread.sleep(1000);

        System.out.println("--------buy---------");
        for (Order order : buyQueue) {
            System.out.println(order.toString());
        }

        System.out.println("---------sell----------");
        for (Order order : sellQueue) {
            System.out.println(order.toString());
        }
    }


    //随机价格
    public static int randomPrice() {
        Random rand = new Random();
        int randNum = rand.nextInt(5000) + 10000;
        return randNum;
    }

    //随机数量
    public static int randomAmount() {
        Random rand = new Random();
        int randNum = rand.nextInt(100);
        return randNum;
    }

    public static int random() {
        Random rand = new Random();
        int randNum = rand.nextInt(2);
        return randNum;
    }



}

class SimpeThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
