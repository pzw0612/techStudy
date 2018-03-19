package com.ifly.edu.disruptor.longEvent;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.ThreadFactory;

public class LongEventMain {
    public static void main(String[] args) throws Exception {
        // Executor that will be used to construct new threads for consumers
        //Executor executor = Executors.newCachedThreadPool();
        //Executor executor = Executors.newSingleThreadExecutor();

        // The factory for the event
        LongEventFactory factory = new LongEventFactory();

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;

        // Construct the Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, bufferSize, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });

        // Connect the handler
        disruptor.handleEventsWith(new LongEventHandler());

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        //ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            // bb.putLong(0, l);

            LongEvent longEvent = new LongEvent();
            longEvent.set(l);
            longEvent.set("test" + l);

            producer.onData(longEvent);
            //Thread.sleep(1000);
        }
    }
}
