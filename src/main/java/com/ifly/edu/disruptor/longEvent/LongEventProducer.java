package com.ifly.edu.disruptor.longEvent;

import com.lmax.disruptor.RingBuffer;

public class LongEventProducer
{
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer)
    {
        this.ringBuffer = ringBuffer;
    }

    //public void onData(ByteBuffer bb)
    public void onData(LongEvent bb)
    {
        long sequence = ringBuffer.next();  // Grab the next sequence
        try
        {
            LongEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
            // for the sequence
            //event.set(bb.getLong(0));  // Fill with data


            event.set(bb.getValue());  // Fill with data
            event.set(bb.getMsg());

        }
        finally
        {
            ringBuffer.publish(sequence);
        }
    }
}
