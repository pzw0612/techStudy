package com.ifly.edu.disruptor.match;

import com.lmax.disruptor.EventHandler;
import org.apache.commons.lang3.time.StopWatch;

import java.math.BigDecimal;
import java.util.concurrent.PriorityBlockingQueue;


public class OrderHandler  implements EventHandler<Order>
{

    //买单队列
    private PriorityBlockingQueue<Order> buyQueue =  null;
    //卖单队列
    private PriorityBlockingQueue<Order> sellQueue = null;

    private StopWatch stopWatch;

    public OrderHandler( StopWatch stopWatch){
        buyQueue = new PriorityBlockingQueue<Order>(100000000,new OrderBuyCompartor());
        //卖单队列
        sellQueue = new PriorityBlockingQueue<Order>(100000000,new OrderSellCompartor());
        this.stopWatch= stopWatch;
    }

    public PriorityBlockingQueue<Order> getBuyQueue() {
        return buyQueue;
    }

    public PriorityBlockingQueue<Order> getSellQueue() {
        return sellQueue;
    }

    @Override
    public void onEvent(Order order, long l, boolean b) throws Exception {
        match(order);
    }

    //撮合逻辑
    public void match(Order order) {

         if(order!=null && "end".equals(order.getUuid())){
             stopWatch.stop();
             System.out.println("耗时："+ stopWatch.getTime()/1000);

             System.out.println("--------buy---------");
             for (Order order2 : buyQueue) {
                 System.out.println(order.toString());
             }

             System.out.println("---------sell----------");
             for (Order order3 : sellQueue) {
                 System.out.println(order.toString());
             }
             return;
         }

        //首先判断订单类型,如果是买单则与卖单进行匹配，匹配成功生成
        if ("buy".equals(order.getTradeType())) {
            //如果卖单队列为空,则将订单加入买单队列中(按照价格优先,时间优先)
            if (sellQueue.size() == 0) {
                //需判断是否已经存在与买对列中
                if (!buyQueue.contains(order)) {
                    buyQueue.offer(order);
                }
            } else {
                //将卖单队列中的订单取出进行撮合
                Order orderSell = sellQueue.poll();

                if (orderSell != null) {
                    if (order.getPrice().compareTo(orderSell.getPrice()) >= 0) {
                        //满足撮合条件则进行撮合,撮合的数量进行确定
                        //计算剩余额度
                        BigDecimal volume = order.getAmount().subtract(orderSell.getAmount()).setScale(8, BigDecimal.ROUND_HALF_UP);
                        //买单量大与等于卖单数量
                        if (volume.compareTo(BigDecimal.ZERO) >= 0) {
                            BigDecimal dealVolumePrice = orderSell.getPrice().multiply(orderSell.getAmount()).setScale(8, BigDecimal.ROUND_HALF_UP);
                            //完全成交
                            if (BigDecimal.ZERO.compareTo(volume) == 0) {
                                Tx tx = new Tx("buy", order.getUuid(), orderSell.getUuid(), BigDecimal.ZERO, volume, dealVolumePrice, orderSell.getPrice(), orderSell.getAmount(), 2);
                                System.out.println(tx);
                            } else {
                                //部分成交 重新设置买单队列中的数量和状态,删除原有的队列，防止重复加入
                                if (buyQueue.contains(order)) {
                                    System.out.println("buy:" + buyQueue.remove(order) + ":" + order.getUuid());
                                }
                                order.setAmount(volume);
                                order.setOrderStatus(1);
                                buyQueue.offer(order);
                                Tx tx = new Tx("buy", order.getUuid(), orderSell.getUuid(), BigDecimal.ZERO, volume, dealVolumePrice, orderSell.getPrice(), orderSell.getAmount(), 1);
                                System.out.println(tx);
                                match(order);
                            }
                        } else {
                            //卖单量大,买单移除掉
                            buyQueue.remove(order);
                            BigDecimal dealVolumePrice = order.getPrice().multiply(order.getAmount()).setScale(8, BigDecimal.ROUND_HALF_UP);
                            BigDecimal sellVolume = BigDecimal.ZERO.subtract(volume).setScale(8, BigDecimal.ROUND_HALF_UP);
                            Tx tx = new Tx("buy", order.getUuid(), orderSell.getUuid(), sellVolume, BigDecimal.ZERO, dealVolumePrice, order.getPrice(), order.getAmount(), 2);
                            System.out.println(tx);
                            if (sellQueue.contains(orderSell)) {
                                System.out.println("buy:" + sellQueue.remove(orderSell) + ":" + orderSell.getUuid());
                            }
                            orderSell.setAmount(sellVolume);
                            orderSell.setOrderStatus(1);
                            sellQueue.offer(orderSell);
                            match(orderSell);
                        }
                    } else {
                        if (buyQueue.contains(order)) {
                            System.out.println("buy:" + buyQueue.remove(order) + ":" + order.getUuid());
                        }
                        buyQueue.offer(order);
                    }
                }
            }
        }

        //同买单逻辑
        if ("sell".equals(order.getTradeType())) {
            //如果买单队列为空,则将订单加入卖单队列中(按照价格优先,时间优先)
            if (buyQueue.size() == 0) {
                if (!sellQueue.contains(order)) {
                    sellQueue.offer(order);
                }
            } else {
                //从队列中取出买单进行撮合
                Order orderBuy = buyQueue.poll();
                if (orderBuy != null) {
                    if (orderBuy.getPrice().compareTo(order.getPrice()) >= 0) {
                        BigDecimal volume = orderBuy.getAmount().subtract(order.getAmount()).setScale(8, BigDecimal.ROUND_HALF_UP);
                        //买单量大
                        if (volume.compareTo(BigDecimal.ZERO) >= 0) {
                            sellQueue.remove(order);
                            //生成订单 成交额进行计算
                            BigDecimal dealVolumePrice = order.getPrice().multiply(order.getAmount()).setScale(8, BigDecimal.ROUND_HALF_UP);
                            //完全成交
                            if (BigDecimal.ZERO.compareTo(volume) == 0) {
                                Tx tx = new Tx("sell", orderBuy.getUuid(), order.getUuid(), BigDecimal.ZERO, volume, dealVolumePrice, order.getPrice(), order.getAmount(), 2);
                                System.out.println(tx);
                            } else {
                                //完全成交
                                if (buyQueue.contains(orderBuy)) {
                                    System.out.println("sell:" + buyQueue.remove(orderBuy) + ":" + orderBuy.getUuid());
                                }
                                orderBuy.setAmount(volume);
                                orderBuy.setOrderStatus(1);
                                buyQueue.offer(orderBuy);
                                Tx tx = new Tx("sell", orderBuy.getUuid(), order.getUuid(), BigDecimal.ZERO, volume, dealVolumePrice, order.getPrice(), order.getAmount(), 2);
                                System.out.println(tx);
                                match(orderBuy);
                            }
                        } else {
                            System.out.println(buyQueue.remove(orderBuy) + ":" + orderBuy.getUuid());
                            //生成订单 成交额进行计算
                            BigDecimal dealVolumePrice = orderBuy.getPrice().multiply(orderBuy.getAmount()).setScale(8, BigDecimal.ROUND_HALF_UP);
                            BigDecimal sellVolume = BigDecimal.ZERO.subtract(volume).setScale(8, BigDecimal.ROUND_HALF_UP);
                            Tx tx = new Tx("sell", orderBuy.getUuid(), order.getUuid(), sellVolume, BigDecimal.ZERO, dealVolumePrice, orderBuy.getPrice(), orderBuy.getAmount(), 1);
                            System.out.println(tx);
                            if (sellQueue.contains(order)) {
                                System.out.println("sell:" + sellQueue.remove(order) + ":" + order.getUuid());
                            }
                            order.setAmount(sellVolume);
                            order.setOrderStatus(1);
                            sellQueue.offer(order);
                            match(order);
                        }
                    } else {
                        if (sellQueue.contains(order)) {
                            System.out.println("sell:" + sellQueue.remove(order) + ":" + order.getUuid());
                        }
                        sellQueue.offer(order);
                    }
                }
            }
        }
    }
}
