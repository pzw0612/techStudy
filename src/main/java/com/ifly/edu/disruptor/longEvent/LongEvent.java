package com.ifly.edu.disruptor.longEvent;

public class LongEvent
{
    public long getValue() {
        return value;
    }

    private long value;

    public String getMsg() {
        return msg;
    }

    private String msg;

    public void set(long value)
    {
        this.value = value;
    }

    public void set(String value){
        this.msg=value;
    }

    @Override
    public String toString() {
        return "LongEvent{" +
                "value=" + value +
                ", msg='" + msg + '\'' +
                '}';
    }
}