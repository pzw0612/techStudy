package com.ifly.edu.java.thread.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author pangzhw
 * @date 2015年5月10日
 */
public class ForjoinTest  extends RecursiveTask<Integer> {
    private int start;
    private int end;

    public ForjoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    //计算
    @Override
    protected Integer compute() {
        int sum = 0;
        if (start - end < 100) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
        } else {//间隔有100则拆分多个任务计算
            int middle = (start + end) / 2;
            ForjoinTest left = new ForjoinTest(start, middle);
            ForjoinTest right = new ForjoinTest(middle + 1, end);
            left.fork();
            right.fork();

            sum = left.join() + right.join();
        }
        return sum;
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	 ForkJoinPool forkJoinPool = new ForkJoinPool();//对线程池的扩展
         Future<Integer> result = forkJoinPool.submit(new ForjoinTest(1, 1000000));

         System.out.println(result.get());

         forkJoinPool.shutdown();
	}
}
