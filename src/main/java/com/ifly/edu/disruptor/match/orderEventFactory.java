package com.ifly.edu.disruptor.match;

import com.ifly.edu.disruptor.longEvent.LongEvent;
import com.lmax.disruptor.EventFactory;

public class orderEventFactory implements EventFactory<Order>
{
    public Order newInstance()
    {
        return new Order();
    }
}
