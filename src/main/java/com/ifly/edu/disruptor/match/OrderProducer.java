package com.ifly.edu.disruptor.match;

import com.ifly.edu.disruptor.longEvent.LongEvent;
import com.lmax.disruptor.RingBuffer;

public class OrderProducer
{
    private final RingBuffer<Order> ringBuffer;

    public OrderProducer(RingBuffer<Order> ringBuffer)
    {
        this.ringBuffer = ringBuffer;
    }

    //public void onData(ByteBuffer bb)
    public void onData(Order order)
    {
        long sequence = ringBuffer.next();  // Grab the next sequence
        try
        {
            Order event = ringBuffer.get(sequence); // Get the entry in the Disruptor

            event.setAmount(order.getAmount());
            event.setAssetCode(order.getAssetCode());
            event.setUuid(order.getUuid());
            event.setPrice(order.getPrice());
            event.setOrderStatus(order.getOrderStatus());
            event.setOrderTime(order.getOrderTime());
            event.setTradeType(order.getTradeType());
        }
        finally
        {
            ringBuffer.publish(sequence);
        }
    }
}
