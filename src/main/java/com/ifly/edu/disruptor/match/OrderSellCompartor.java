package com.ifly.edu.disruptor.match;

import java.util.Comparator;

/**
 * 卖单比较器
 */
public class OrderSellCompartor implements Comparator<Order> {

    //价格优先,然后时间优先
    public int compare(Order o1, Order o2) {
        if (o1.getPrice().compareTo(o2.getPrice()) > 0) {
            return 1;
        } else if (o1.getPrice().compareTo(o2.getPrice()) < 0) {
            return -1;
        } else {
            if (o1.getOrderTime() > o2.getOrderTime()) {
                return 1;
            } else if (o1.getOrderTime().equals(o2.getOrderTime())) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
